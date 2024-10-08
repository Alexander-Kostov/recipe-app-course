package guru.framework.spring5_recipe_app.converters;

import guru.framework.spring5_recipe_app.command.CategoryCommand;
import guru.framework.spring5_recipe_app.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryCommandToCategoryTest {

    CategoryCommandToCategory command;
    final static Long LONG_VALUE = 1L;
    final static String DESCRIPTION = "description";

    @BeforeEach
    void setUp() {
        command = new CategoryCommandToCategory();
    }

    @Test
    public void testNullParameter() {
        assertNull(command.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(command.convert(new CategoryCommand()));
    }

    @Test
    void convert() {
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(LONG_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        Category converted = command.convert(categoryCommand);

        assertNotNull(converted);
        assertEquals(LONG_VALUE, converted.getId());
        assertEquals(DESCRIPTION, converted.getDescription());
    }
}