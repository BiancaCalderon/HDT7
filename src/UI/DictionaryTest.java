package UI;

import Controller.Dictionary;
import org.junit.Test;
import static org.junit.Assert.*;

public class DictionaryTest {

    @Test
    public void testAddAssociation() {
        Dictionary dict = new Dictionary();
        dict.addAssociation("apple", "manzana", "pomme");
        dict.addAssociation("book", "libro", "livre");
        dict.addAssociation("computer", "ordenador", "ordinateur");

        System.out.println(dict.getAssociations().size()); // Imprime el tamaño actual de la lista de asociaciones

        assertEquals(9, dict.getAssociations().size());
    }
    @Test
    public void testTranslate() {
        Dictionary dict = new Dictionary();
        dict.addAssociation("apple", "manzana", "pomme");
        dict.addAssociation("book", "libro", "livre");
        dict.addAssociation("computer", "ordenador", "ordinateur");

        assertEquals("manzana", dict.translate("apple", "spanish"));
        assertEquals("pomme", dict.translate("apple", "french"));
        assertEquals("libro", dict.translate("book", "spanish"));
        assertEquals("computer", dict.translate("ordenador", "english"));
        assertEquals("Word not found", dict.translate("chair", "english"));
        assertEquals("Invalid target language", dict.translate("apple", "german"));
    }
}
