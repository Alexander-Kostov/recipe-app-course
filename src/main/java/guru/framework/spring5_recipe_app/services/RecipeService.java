package guru.framework.spring5_recipe_app.services;

import guru.framework.spring5_recipe_app.command.RecipeCommand;
import guru.framework.spring5_recipe_app.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long l);
}
