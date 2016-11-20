package com.paris.dao;

/**
 * Created by sboukhris on 11/10/16.
 */

import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.paris.exception.DatabaseException;
import org.bson.types.ObjectId;
import org.jongo.Find;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.marshall.jackson.oid.MongoId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public abstract class DefaultDao<T> {
    private final Jongo jongo;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final Validator validator;



    public DefaultDao(Jongo jongo, Validator validator) {
        this.jongo = jongo;
        this.validator = validator;
    }

    public long count() {
        return getCollection().count();
    }

    public void delete(String id) {
        getCollection().remove(new ObjectId(id));
    }

    public T findById(String id) {
        return getCollection().findOne("{_id: #}", new ObjectId(id)).as(getClazz());
    }

    protected abstract Class<T> getClazz();

    protected MongoCollection getCollection() {
        return jongo.getCollection(getCollectionName());
    }

    protected abstract String getCollectionName();

    private Object getId(T pojo) {
        try {
            for (Field f : pojo.getClass().getDeclaredFields()) {
                if (f.isAnnotationPresent(MongoId.class)) {
                    boolean oldValue = f.isAccessible();
                    f.setAccessible(true);
                    Object result = f.get(pojo);
                    f.setAccessible(oldValue);
                    return result;
                }
            }
        } catch (SecurityException | IllegalAccessException e) {
            logger.error("Cannot access to id field for class " + pojo.getClass(), e);
        }
        return null;
    }

    public void save(T pojo) {
        Set<ConstraintViolation<T>> validate = validator.validate(pojo);
        if (validate.isEmpty()) {
            Object id = getId(pojo);
            if (id == null) {
                try {
                    getCollection().withWriteConcern(WriteConcern.JOURNALED);
                    getCollection().save(pojo);
                } catch (MongoException e) {
                    throw new DatabaseException("Error while saving the document", e);
                }
            } else {
                getCollection().update("{_id : #}", new ObjectId(id.toString())).upsert().with(pojo);
            }
        } else {
            throw new DatabaseException("Validation issue: " + validate);
        }
    }

    public Stream<T> streamParallel() {
        return streamParallel(0, 0);
    }

    public Stream<T> streamParallel(int skip, int limit) {

        final Find query = getCollection().find().sort("{'_id': 1}").with(cursor -> cursor.addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT)).skip(skip);
        if (limit > 0) {
            query.limit(limit);
        }
        Iterable<T> allDrvs = query.as(getClazz());
        return StreamSupport.stream(allDrvs.spliterator(), true);
    }


}
