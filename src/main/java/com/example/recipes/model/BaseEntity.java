package com.example.recipes.model;

import com.example.recipes.recipe.RecipeJsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -4725689578172361007L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(RecipeJsonViews.IdOnlyView.class)
    private long id;
}
