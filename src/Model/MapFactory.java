package Model;

import java.util.Map;
import java.util.HashMap;

public class MapFactory {
    public static Map<String, String> createDictionary(String dictionaryType) {
        switch (dictionaryType.toUpperCase()) {
            case "AVL":
                return (Map<String, String>) new AVLTree();
            case "RBT":
                return (Map<String, String>) new RedBlackTree();
            default:
                throw new IllegalArgumentException("Invalid dictionary type");
        }
    }
}