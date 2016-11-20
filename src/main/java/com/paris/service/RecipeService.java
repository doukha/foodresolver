package com.paris.service;

import com.paris.dao.RecipeDao;
import com.paris.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by samyboukhris on 11/11/2016.
 */
@Service
public class RecipeService {


    private RecipeDao recipeDao;

    @Autowired
    public RecipeService(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    public void save(Recipe recipe) {
        recipeDao.save(recipe);
    }

    public Recipe findById(String id) {
        return recipeDao.findById(id);
    }

    public List<Recipe> findByIngredients(String ing1, String ing2, String ing3, String ing4, String ing5, String ing6) {
        return recipeDao.findByIngredients(ing1, ing2, ing3, ing4, ing5, ing6);
    }
}
