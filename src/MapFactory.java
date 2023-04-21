import java.util.Map;

public class MapFactory {
    public static Map<String, String> createDictionary(String dictionaryType) {
        if (dictionaryType.equalsIgnoreCase("AVL")) {
            return new AVLTree<String, String>();
        } else if (dictionaryType.equalsIgnoreCase("RBT")) {
            return new RedBlackTree<String, String>();
        } else {
            throw new IllegalArgumentException("Invalid dictionary type");
        }
    }
}
