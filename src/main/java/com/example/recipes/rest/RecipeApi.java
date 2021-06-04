package com.example.recipes.rest;

import com.example.recipes.recipe.Recipe;
import com.example.recipes.recipe.RecipeDto;
import com.example.recipes.recipe.RecipeJsonViews;
import com.example.recipes.recipe.RecipeService;
import com.example.recipes.util.RecipeUtils;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/api")
@Validated
public class RecipeApi {
    private final RecipeService recipeService;

    @Autowired
    public RecipeApi(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @JsonView(RecipeJsonViews.IdOnlyView.class)
    @PostMapping(value = "/recipe/new", consumes = APPLICATION_JSON_VALUE)
    public Recipe newRecipe(@Valid @RequestBody RecipeDto recipeDto) {
        return recipeService.add(RecipeUtils.convertToEntity(recipeDto));
    }

    @GetMapping("/recipe/{id}")
    public RecipeDto getRecipe(@Min(1L) @PathVariable long id) {
        return RecipeUtils.convertToDto(recipeService.get(id));
    }

    @DeleteMapping(value = "/recipe/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecipe(@Min(1L) @PathVariable long id) {
        recipeService.delete(id);
    }
}
