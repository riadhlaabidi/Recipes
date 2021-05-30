package com.example.recipe;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Api {

    private Recipe recipe;

    @PostMapping(value = "/recipe", consumes = "application/json")
    public void addRecipe(@RequestBody Recipe recipe) {
        this.recipe = recipe;
    }

    @GetMapping("/recipe")
    public Recipe getRecipe() {
        return recipe;
    }
}
