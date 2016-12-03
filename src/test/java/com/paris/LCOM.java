package com.paris;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by samyboukhris on 22/11/2016.
 */
public class LCOM {

    // ["MA","MB"] ["MB","AX"]
    // ["MC","AY"] ["MD","AY"] ["MD","ME"]

    // ["A","B","M"] ["B","X","A"]
    // ["MC","AY"] ["MD","AY"] ["MD","ME"]

    @Test
    public void name() throws Exception {
        Relation R1 = new Relation(Arrays.asList("A"), Arrays.asList("B"), false);
        Relation R2 = new Relation(Arrays.asList("B"), Arrays.asList("X"), true);

        Relation R3 = new Relation(Arrays.asList("C"), Arrays.asList("Y"), true);
        Relation R4 = new Relation(Arrays.asList("D"), Arrays.asList("Y"), true);
        Relation R5 = new Relation(Arrays.asList("D"), Arrays.asList("E"), false);

        List<Relation> relations = Arrays.asList(R1, R2, R3, R4, R5);
        List<Relation> onlyLeaf = relations.stream().filter(r -> r.isAttr()).collect(Collectors.toList());

        Set<Set<Relation>> relationOfRelation = new HashSet<>();

        for (Relation relation : onlyLeaf) {

            if (relation.isAttr()) {
                Set<Relation> relationRecipe = new HashSet<Relation>();
                crossParents(relations, relationRecipe, relation);
                assertNotNull(relations);
                relationOfRelation.add(relationRecipe);
            }
        }

        assertEquals(relationOfRelation.size(),2);
    }

    // x -- B -- A
    private void crossParents(List<Relation> relations, Set<Relation> relationRecipe, Relation relationRoot) {
        relationRecipe.add(relationRoot);
        for (String currentOrigin : relationRoot.getOrigins()) {
            Relation fetchedRelation = fetchRelationWithOrigin(currentOrigin, relations);
            if (fetchedRelation != null) {
                crossParents(relations, relationRecipe, fetchedRelation);
            } else {
            }
        }
    }

    @Test
    public void test_fetch() throws Exception {
        Relation R1 = new Relation(Arrays.asList("A"), Arrays.asList("B"), false);
        Relation R2 = new Relation(Arrays.asList("B"), Arrays.asList("X"), true);
        List<Relation> relations = Arrays.asList(R1, R2);
        Relation b = fetchRelationWithOrigin("B", relations);
        assertNotNull(b);
    }

    private Relation fetchRelationWithOrigin(String currentOrigin, List<Relation> relations) {
        return relations.stream().findFirst().filter(r -> r.getDests().contains(currentOrigin)).orElse(null);
    }

    class Relation {
        List<String> origin;
        List<String> dest;
        boolean isAttr;

        public Relation(List<String> origin, List<String> dest, boolean isAttr) {
            this.origin = origin;
            this.dest = dest;
            this.isAttr = isAttr;
        }

        public List<String> getOrigins() {
            return origin;
        }

        public void setOrigin(List<String> origin) {
            this.origin = origin;
        }

        public List<String> getDests() {
            return dest;
        }

        public void setDest(List<String> dest) {
            this.dest = dest;
        }

        public boolean isAttr() {
            return isAttr;
        }

        public void setAttr(boolean attr) {
            isAttr = attr;
        }
    }
}
