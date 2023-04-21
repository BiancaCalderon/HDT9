import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Seleccionar tipo de árbol
        System.out.println("Seleccione el tipo de árbol para el diccionario:");
        System.out.println("1. AVL");
        System.out.println("2. Red-Black");
        int treeType = scanner.nextInt();

        String dictionaryType;
        if (treeType == 1) {
            dictionaryType = "AVL";
        } else if (treeType == 2) {
            dictionaryType = "RBT";
        } else {
            System.out.println("Tipo de árbol inválido");
            return;
        }

        // Crear diccionario y cargar archivo
        Dictionary dictionary = new Dictionary(dictionaryType);
        try {
            dictionary.loadDictionary("Spanish.txt");
        } catch (IOException e) {
            System.out.println("Error al cargar el diccionario: " + e.getMessage());
            return;
        }

        // Pedir oración para traducir
        System.out.print("Ingrese la oración que desea traducir: ");
        scanner.nextLine(); // Consumir la línea en blanco después de nextInt()
        String sentence = scanner.nextLine();

        // Traducir oración
        String[] words = sentence.split("\\s+");
        StringBuilder translation = new StringBuilder();
        for (String word : words) {
            translation.append(dictionary.translate(word));
            translation.append(" ");
        }

        // Imprimir traducción
        System.out.println("Traducción: " + translation.toString().trim());
    }
}