package com.example.recipes.recipe;

import com.example.recipes.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "recipes")
public class Recipe extends BaseEntity {
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("index")
    private List<Ingredient> ingredients;

    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("index")
    private List<Direction> directions;
}
