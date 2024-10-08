package guru.framework.spring5_recipe_app.repository;

import guru.framework.spring5_recipe_app.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
