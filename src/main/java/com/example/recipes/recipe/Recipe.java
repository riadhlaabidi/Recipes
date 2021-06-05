package com.example.recipes.recipe;

import com.example.recipes.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "recipes")
@JsonView(RecipeJsonViews.InfoView.class)
public class Recipe extends BaseEntity {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String category;

    @LastModifiedDate
    private LocalDateTime date;

    @NotEmpty
    @ElementCollection
    @Column(name = "ingredient")
    private List<String> ingredients;

    @NotEmpty
    @ElementCollection
    @Column(name = "direction")
    private List<String> directions;
}
