import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Lectura del archivo Spanish.txt
        List<String> spanishLines = new ReadFile("Spanish.txt").readLines();

        // Construcción del diccionario
        Map<String, String> dictionary;
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué árbol desea utilizar para el diccionario? (1: Red-Black Tree, 2: AVL Tree)");
        int treeChoice = scanner.nextInt();
        switch (treeChoice) {
            case 1:
                dictionary = new RedBlackTree<>();
                break;
            case 2:
                dictionary = new AVLTree<>();
                break;
            default:
                System.out.println("Opción inválida. Se utilizará Red-Black Tree por defecto.");
                dictionary = new RedBlackTree<>();
        }

        for (String line : spanishLines) {
            String[] parts = line.split(" ");
            String englishWord = parts[0].toLowerCase();
            String spanishWord = parts[1].toLowerCase();
            dictionary.put(englishWord, spanishWord);
        }

        // Lectura del archivo texto.txt y traducción
        List<String> textLines = new ReadFile("texto.txt").readLines();
        for (String line : textLines) {
            String[] words = line.split(" ");
            for (String word : words) {
                String englishWord = word.toLowerCase();
                String spanishWord = dictionary.get(englishWord);
                if (spanishWord != null) {
                    System.out.print(spanishWord + " ");
                } else {
                    System.out.print("*" + word + "* ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}