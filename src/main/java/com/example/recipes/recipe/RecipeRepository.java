package com.example.recipes.recipe;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
