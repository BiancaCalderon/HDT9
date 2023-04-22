package Controller;

import Model.AVLTree;
import Model.RedBlackTree;

import java.util.Map;

public class Dictionary {

    private Map<String, String> map;

    public Dictionary(String dictionaryType) throws IllegalArgumentException {
        if (dictionaryType.equalsIgnoreCase("AVL")) {
            map = (Map<String, String>) new AVLTree();
        } else if (dictionaryType.equalsIgnoreCase("RBT")) {
            map = (Map<String, String>) new RedBlackTree();
        } else {
            throw new IllegalArgumentException("Invalid dictionary type");
        }
    }

    public void put(String key, String value) {
        map.put(key, value);
    }

    public String get(String key) {
        return map.get(key);
    }
}