package com.example.recipes.recipe;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Data
public class RecipeDto {

    @NotBlank(message = "Recipe must have a name")
    private String name;

    @NotBlank(message = "Recipe must have a description")
    private String description;

    @NotEmpty(message = "Recipe must have at least 1 ingredient")
    private List<String> ingredients;

    @NotEmpty(message = "Recipe must have at least 1 direction")
    private List<String> directions;
}
