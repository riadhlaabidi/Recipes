package com.example.recipe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class Recipe {

    private static long ID_GENERATOR = 1L;

    @JsonIgnore
    private long id = ID_GENERATOR++;
    private String name;
    private String description;
    private List<String> ingredients;
    private List<String> directions;
}
