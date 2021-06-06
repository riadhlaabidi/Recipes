package com.example.recipes.recipe;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    @Transactional
    public void update(long id, Recipe recipe) {
        Recipe toUpdate = get(id);
        toUpdate.setName(recipe.getName());
        toUpdate.setDescription(recipe.getDescription());
        toUpdate.setCategory(recipe.getCategory());
        toUpdate.setIngredients(recipe.getIngredients());
        toUpdate.setDirections(recipe.getDirections());
    }

    public List<Recipe> searchByName(String name) {
        return recipes.findAllByNameContainingIgnoreCaseOrderByDateDesc(name);
    }

    public List<Recipe> searchByCategory(String category) {
        return recipes.findAllByCategoryIgnoreCaseOrderByDateDesc(category);
    }

    public List<Recipe> searchByNameAndCategory(String name, String category) {
        return recipes.findAllByNameContainingIgnoreCaseAndCategoryIgnoreCaseOrderByDateDesc(name, category);
    }
}
