package com.example.recipes.recipe;

import com.example.recipes.user.User;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "RECIPES")
@JsonView(RecipeJsonViews.InfoView.class)
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(RecipeJsonViews.IdOnlyView.class)
    private long id;

    @NotBlank
    @JsonView(RecipeJsonViews.CreateView.class)
    private String name;

    @NotBlank
    @JsonView(RecipeJsonViews.CreateView.class)
    private String description;

    @NotBlank
    @JsonView(RecipeJsonViews.CreateView.class)
    private String category;

    @LastModifiedDate
    private LocalDateTime date;

    @NotEmpty
    @ElementCollection
    @Column(name = "INGREDIENT")
    @JsonView(RecipeJsonViews.CreateView.class)
    private List<String> ingredients;

    @NotEmpty
    @ElementCollection
    @Column(name = "DIRECTION")
    @JsonView(RecipeJsonViews.CreateView.class)
    private List<String> directions;

    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonView(RecipeJsonViews.PrivateView.class)
    private User user;
}
