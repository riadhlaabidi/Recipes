package com.example.recipe;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Api {
    private Map<Long, Recipe> recipes = new HashMap<>();

    @PostMapping(value = "/recipe/new", consumes = "application/json")
    public ResponseEntity<Map<String, Long>> newRecipe(@RequestBody Recipe recipe) {
        recipes.put(recipe.getId(), recipe);
        return ResponseEntity.ok(Map.of("id", recipe.getId()));
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) {
        if (recipes.containsKey(id)) {
            return ResponseEntity.ok(recipes.get(id));
        }
        return ResponseEntity.notFound().build();
    }
}
