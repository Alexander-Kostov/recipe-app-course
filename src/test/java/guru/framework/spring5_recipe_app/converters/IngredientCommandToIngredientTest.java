package guru.framework.spring5_recipe_app.converters;

import guru.framework.spring5_recipe_app.command.IngredientCommand;
import guru.framework.spring5_recipe_app.command.UnitOfMeasureCommand;
import guru.framework.spring5_recipe_app.domain.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCommandToIngredientTest {

    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long ID_VALUE = 1L;
    public static final Long UOM_ID =2L;

    IngredientCommandToIngredient converter;

    @BeforeEach
    void setUp() {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    void convert() {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ID_VALUE);
        ingredientCommand.setDescription(DESCRIPTION);
        ingredientCommand.setAmount(AMOUNT);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM_ID);
        ingredientCommand.setUom(unitOfMeasureCommand);

        Ingredient ingredient = new Ingredient();

        Ingredient converted = converter.convert(ingredientCommand);
        assertNotNull(converted);
        assertNotNull(converted.getUom());
        assertEquals(ID_VALUE, converted.getId());
        assertEquals(DESCRIPTION, converted.getDescription());
        assertEquals(AMOUNT, converted.getAmount());
        assertEquals(UOM_ID, converted.getUom().getId());
    }

    @Test
    public void convertWithNullUOM() {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ID_VALUE);
        ingredientCommand.setAmount(AMOUNT);
        ingredientCommand.setDescription(DESCRIPTION);

        Ingredient converted = converter.convert(ingredientCommand);

        assertNotNull(converted);
        assertNull(converted.getUom());
        assertEquals(ID_VALUE, converted.getId());
        assertEquals(DESCRIPTION, converted.getDescription());
        assertEquals(AMOUNT, converted.getAmount());
    }
}