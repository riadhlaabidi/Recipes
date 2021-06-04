package com.example.recipes.recipe;

import com.example.recipes.model.IndexedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ingredients")
public class Ingredient extends IndexedEntity {
    private String name;
}
