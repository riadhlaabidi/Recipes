package com.example.recipes.user;

import com.example.recipes.recipe.Recipe;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User {

    private static final String emailRegex = "(?i)[\\w!#$%&'*+/=?`{|}~^-]+" +
            "(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-z0-9-]+\\.)+[a-z]{2,6}";

    @Id
    @Email(regexp = emailRegex)
    @NotBlank
    @JsonView(UserJsonViews.RegistrationView.class)
    private String email;

    @NotBlank
    @Size(min = 8, max = 255)
    @JsonView(UserJsonViews.RegistrationView.class)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Recipe> recipes;
}
