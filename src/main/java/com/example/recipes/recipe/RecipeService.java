package com.example.recipes.recipe;

import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private final RecipeRepository recipes;

    public RecipeService(RecipeRepository recipes) {
        this.recipes = recipes;
    }

    public Recipe add(Recipe recipe) {
        return recipes.save(recipe);
    }

    public Recipe get(long id) {
        return recipes.findById(id).orElseThrow(RecipeNotFoundException::new);
    }

    public void delete(long id) {
        if (!recipes.existsById(id)) {
            throw new RecipeNotFoundException();
        }
        recipes.deleteById(id);
    }
}
