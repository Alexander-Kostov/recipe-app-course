package guru.framework.spring5_recipe_app.repository;

import guru.framework.spring5_recipe_app.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
