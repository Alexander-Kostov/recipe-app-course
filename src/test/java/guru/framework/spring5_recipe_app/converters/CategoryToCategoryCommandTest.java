package guru.framework.spring5_recipe_app.converters;

import guru.framework.spring5_recipe_app.command.CategoryCommand;
import guru.framework.spring5_recipe_app.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryToCategoryCommandTest {

    CategoryToCategoryCommand command;
    final static Long LONG_VALUE = 1L;
    final static String DESCRIPTION = "description";

    @BeforeEach
    void setUp() {
        command = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullParameters() {
        assertNull(command.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(command.convert(new Category()));
    }

    @Test
    void convert() {
        Category category = new Category();
        category.setId(LONG_VALUE);
        category.setDescription(DESCRIPTION);

        CategoryCommand converted = command.convert(category);
        assertNotNull(converted);
        assertEquals(LONG_VALUE, converted.getId());
        assertEquals(DESCRIPTION, converted.getDescription());
    }
}