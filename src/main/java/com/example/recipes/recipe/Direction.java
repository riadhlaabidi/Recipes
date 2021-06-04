package com.example.recipes.recipe;

import com.example.recipes.model.IndexedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "directions")
public class Direction extends IndexedEntity {
    private String description;
}
