package com.paris.service;

import com.paris.model.Recipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * Created by samyboukhris on 11/11/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceTest {


    @Autowired
    private RecipeService recipeService;

    @Test
    public void saving_recipe_should_pass() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setDescription("doudou");
        recipe.setIngredients(Arrays.asList("poivron", "fromj"));
        recipeService.save(recipe);
    }

}