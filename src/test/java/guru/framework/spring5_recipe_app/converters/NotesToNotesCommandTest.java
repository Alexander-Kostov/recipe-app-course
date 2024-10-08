package guru.framework.spring5_recipe_app.converters;

import guru.framework.spring5_recipe_app.command.NotesCommand;
import guru.framework.spring5_recipe_app.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesToNotesCommandTest {
    static final Long ID_VALUE = 1L;
    static final String RECIPE_NOTES = "Recipe Notes";
    NotesToNotesCommand converter;

    @BeforeEach
    void setUp() {
        converter = new NotesToNotesCommand();
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    void convert() {
        Notes notes = new Notes();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(RECIPE_NOTES);

        NotesCommand converted = converter.convert(notes);
        assertNotNull(converted);
        assertEquals(ID_VALUE, converted.getId());
        assertEquals(RECIPE_NOTES, converted.getRecipeNotes());
    }
}