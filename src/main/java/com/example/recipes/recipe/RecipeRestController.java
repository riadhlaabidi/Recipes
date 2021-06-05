package com.example.recipes.recipe;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/api/recipe")
@Validated
public class RecipeRestController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeRestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @JsonView(RecipeJsonViews.IdOnlyView.class)
    @PostMapping(value = "/new", consumes = APPLICATION_JSON_VALUE)
    public Recipe newRecipe(@Valid @JsonView(RecipeJsonViews.InfoView.class)
                            @RequestBody Recipe recipe) {
        return recipeService.add(recipe);
    }

    @GetMapping("/{id}")
    @JsonView(RecipeJsonViews.InfoView.class)
    public Recipe getRecipe(@Min(1L) @PathVariable long id) {
        return recipeService.get(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecipe(@Min(1L) @PathVariable long id) {
        recipeService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRecipe(@PathVariable long id,
                             @Valid @RequestBody Recipe recipe) {
        recipeService.update(id, recipe);
    }

    @GetMapping("/search")
    @JsonView(RecipeJsonViews.InfoView.class)
    public ResponseEntity<List<Recipe>> search(@RequestParam(required = false) String name,
                                               @RequestParam(required = false) String category) {
        if (name == null && category == null) {
            return ResponseEntity.badRequest().build();
        }
        List<Recipe> result;
        if (name == null) {
            result = recipeService.searchByCategory(category);
        } else if (category == null) {
            result = recipeService.searchByName(name);
        } else {
            result = recipeService.searchByNameAndCategory(name, category);
        }
        return ResponseEntity.ok(result);
    }
}
