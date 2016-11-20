package com.paris.dao;

import com.paris.model.Recipe;
import org.jongo.Jongo;
import org.springframework.stereotype.Repository;

import javax.validation.Validator;
import java.util.Collections;
import java.util.List;

/**
 * Created by samyboukhris on 11/11/2016.
 */
@Repository
public class RecipeDao extends DefaultDao<Recipe> {


    public RecipeDao(Jongo jongo, Validator validator) {
        super(jongo, validator);
    }

    @Override
    protected Class<Recipe> getClazz() {
        return Recipe.class;
    }

    @Override
    protected String getCollectionName() {
        return "recipe-dataset";
    }

    // TODO: 12/11/2016 Query to implement 
    public List<Recipe> findByIngredients(String ing1, String ing2, String ing3, String ing4, String ing5, String ing6) {
        return Collections.emptyList();
    }
}
