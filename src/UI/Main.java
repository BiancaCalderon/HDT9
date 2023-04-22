package UI;

import Controller.Dictionary;
import Controller.ReadFile;
import Model.AVLTree;
import Model.RedBlackTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al traductor Inglés-Español");
        System.out.println("Seleccione la implementación del mapeo que desea utilizar: ");
        System.out.println("1. Red Black Tree");
        System.out.println("2. AVL Tree");
        int option = scanner.nextInt();

        // Crear factory y diccionario según la opción seleccionada
        Dictionary dictionary;
        switch (option) {
            case 1:
                dictionary = new Dictionary("RBT");
                break;
            case 2:
                dictionary = new Dictionary("AVL");
                break;
            default:
                System.out.println("Opción inválida");
                return;
        }

        // Leer archivo Spanish.txt y cargar diccionario
        try {
            ReadFile fileReader = new ReadFile("Spanish.txt");
            for (String line : fileReader.readLines()) {
                String[] parts = line.split("\\t");
                String word = parts[0].toLowerCase();
                String translation = parts[1].toLowerCase();
                dictionary.put(word, translation);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Pedir frase al usuario
        System.out.println("Ingrese la frase que desea traducir: ");
        scanner.nextLine();
        String phrase = scanner.nextLine();

        // Traducir la frase
        String[] words = phrase.split("\\s+");
        StringBuilder translation = new StringBuilder();
        for (String word : words) {
            String translatedWord = dictionary.get(word.toLowerCase());
            if (translatedWord == null) {
                translation.append("*").append(word).append("* ");
            } else {
                translation.append(translatedWord).append(" ");
            }
        }

        // Imprimir la traducción
        System.out.println("Traducción: " + translation.toString().trim());
    }
}