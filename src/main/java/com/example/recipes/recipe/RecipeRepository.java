package com.example.recipes.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Transactional(readOnly = true)
    List<Recipe> findAllByCategoryIgnoreCaseOrderByDateDesc(String category);

    @Transactional(readOnly = true)
    List<Recipe> findAllByNameContainingIgnoreCaseOrderByDateDesc(String name);

    @Transactional(readOnly = true)
    List<Recipe> findAllByNameContainingIgnoreCaseAndCategoryIgnoreCaseOrderByDateDesc(String name, String category);
}
