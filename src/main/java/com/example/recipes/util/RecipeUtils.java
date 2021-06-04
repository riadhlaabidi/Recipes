package com.example.recipes.util;

import com.example.recipes.recipe.Direction;
import com.example.recipes.recipe.Ingredient;
import com.example.recipes.recipe.Recipe;
import com.example.recipes.recipe.RecipeDto;

import java.util.ArrayList;
import java.util.List;


public final class RecipeUtils {

    private RecipeUtils() { }

    public static Recipe convertToEntity(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDto.getName());
        recipe.setDescription(recipeDto.getDescription());
        List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < recipeDto.getIngredients().size(); i++) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(recipeDto.getIngredients().get(i));
            ingredient.setIndex(i + 1);
            ingredients.add(ingredient);
        }
        recipe.setIngredients(ingredients);

        List<Direction> directions = new ArrayList<>();
        for (int i = 0; i < recipeDto.getDirections().size(); i++) {
            Direction direction = new Direction();
            direction.setDescription(recipeDto.getDirections().get(i));
            direction.setIndex(i + 1);
            directions.add(direction);
        }
        recipe.setDirections(directions);

        return recipe;
    }

    public static RecipeDto convertToDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setName(recipe.getName());
        recipeDto.setDescription(recipe.getDescription());
        List<String> ingredients = new ArrayList<>();
        recipe.getIngredients().forEach(ingredient -> {
            ingredients.add(ingredient.getName());
        });
        recipeDto.setIngredients(ingredients);
        List<String> directions = new ArrayList<>();
        recipe.getDirections().forEach(direction -> {
            directions.add(direction.getDescription());
        });
        recipeDto.setDirections(directions);
        return recipeDto;
    }
}
