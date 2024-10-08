package guru.framework.spring5_recipe_app.converters;

import guru.framework.spring5_recipe_app.command.NotesCommand;
import guru.framework.spring5_recipe_app.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesCommandToNotesTest {

    static final Long ID_VALUE = 1L;
    static final String RECIPE_NOTES = "Recipe Notes";
    NotesCommandToNotes converter;

    @BeforeEach
    void setUp() {
        converter = new NotesCommandToNotes();
    }

    @Test
    public void testNullObject() {
        converter.convert(null);
    }

    @Test
    public void testEmptyObject() {
        converter.convert(new NotesCommand());
    }

    @Test
    void convert() {
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNotes(RECIPE_NOTES);

        Notes converted = converter.convert(notesCommand);

        assertNotNull(converted);
        assertEquals(ID_VALUE, converted.getId());
        assertEquals(RECIPE_NOTES, converted.getRecipeNotes());
    }
}