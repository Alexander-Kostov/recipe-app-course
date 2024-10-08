package guru.framework.spring5_recipe_app.converters;

import guru.framework.spring5_recipe_app.command.UnitOfMeasureCommand;
import guru.framework.spring5_recipe_app.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {
    static final String DESCRIPTION = "description";
    static final Long LONG_VALUE = 1L;
    UnitOfMeasureToUnitOfMeasureCommand command;
    @Before
    public void setUp() throws Exception {
        command = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullParameter() {
        assertNull(command.convert(null));
    }

    @Test
    public void TestEmptyObject() {
        assertNotNull(command.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(LONG_VALUE);
        uom.setDescription(DESCRIPTION);

        UnitOfMeasureCommand converted = command.convert(uom);
        assertNotNull(converted);
        assertEquals(LONG_VALUE, converted.getId());
        assertEquals(DESCRIPTION, converted.getDescription());
    }
}