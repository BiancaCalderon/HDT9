import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class DictionaryTest {

    @Test
    public void testPutAndGetInAVLTree() {
        Map<String, String> dictionary = new AVLTree<>();

        dictionary.put("apple", "manzana");
        dictionary.put("banana", "plátano");
        dictionary.put("cherry", "cereza");

        Assertions.assertEquals("manzana", dictionary.get("apple"));
        Assertions.assertEquals("plátano", dictionary.get("banana"));
        Assertions.assertEquals("cereza", dictionary.get("cherry"));
        Assertions.assertNull(dictionary.get("grape"));
    }

    @Test
    public void testPutAndGetInRedBlackTree() {
        Map<String, String> dictionary = new RedBlackTree<>();

        dictionary.put("apple", "manzana");
        dictionary.put("banana", "plátano");
        dictionary.put("cherry", "cereza");

        Assertions.assertEquals("manzana", dictionary.get("apple"));
        Assertions.assertEquals("plátano", dictionary.get("banana"));
        Assertions.assertEquals("cereza", dictionary.get("cherry"));
        Assertions.assertNull(dictionary.get("grape"));
    }
}