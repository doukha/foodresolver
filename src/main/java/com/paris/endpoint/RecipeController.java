package com.paris.endpoint;

import com.paris.model.Recipe;
import com.paris.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by samyboukhris on 11/11/2016.
 */
@RestController
@RequestMapping(value = "/api/recipe")
public class RecipeController {


    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @RequestMapping(value = "{/:id}", method = RequestMethod.GET)
    public Recipe find(@RequestParam("id") String id) {
        return this.recipeService.findById(id);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public List<Recipe> findRecipe(@RequestParam("ing1") String ing1, @RequestParam("ing2") String ing2, @RequestParam("ing3") String ing3,
                                   @RequestParam("ing4") String ing4, @RequestParam("ing5") String ing5, @RequestParam("ing6") String ing6) {
        return this.recipeService.findByIngredients(ing1, ing2, ing3, ing4, ing5, ing6);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody Recipe recipe) {
        this.recipeService.save(recipe);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        System.out.println("=============== TEST ============");
        return "OK";
    }


}
