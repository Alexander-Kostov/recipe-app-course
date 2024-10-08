package guru.framework.spring5_recipe_app.domain;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    private Category category;
    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void setId() {
        category.setId(4L);
        Long id = 4L;

        assertEquals(id, category.getId());
    }

    @Test
    public void setDescription() {
    }

    @Test
    public void setRecipes() {
    }
}