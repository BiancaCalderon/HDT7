package UI;

import Controller.Dictionary;
import Controller.ReadFile;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        try {
            ReadFile reader = new ReadFile("C:\\Users\\bianc\\IdeaProjects\\HDT7\\src\\diccionario.txt");
            List<String> lines = reader.readLines();

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String englishWord = parts[0].trim().toLowerCase();
                    String spanishWord = parts[1].trim().toLowerCase();
                    String frenchWord = parts[2].trim().toLowerCase();
                    dictionary.addAssociation(englishWord, spanishWord, frenchWord);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return;
        }

        System.out.println("Bienvenido a Dictionary!");
        System.out.println("-------------------------------------");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1 - Traducir una palabra u oración");
            System.out.println("2 - Imprimir el archivo de texto");
            System.out.println("3 - Salir");
            System.out.print("Ingrese el número de la opción elegida: ");
            String option = scanner.nextLine().trim().toLowerCase();
            switch (option) {
                case "1":
                    System.out.print("Ingresa una palabra u oración a traducir (o 'q' para salir): ");
                    String word = scanner.nextLine().trim().toLowerCase();
                    if (word.equals("q")) {
                        System.out.println("Saliendo...");
                        scanner.close();
                        return;
                    }
                    System.out.print("Ingresa el idioma a traducir (english/spanish/french): ");
                    String targetLanguage = scanner.nextLine().trim().toLowerCase();
                    String[] words = word.split(" ");
                    boolean found = false;
                    String finalTranslation = "";
                    for (String w : words) {
                        String translation = dictionary.translate(w, targetLanguage);
                        if (!translation.equals("Word not found")) {
                            finalTranslation += translation + " ";
                            found = true;
                        } else {
                            finalTranslation += "*" + w + "* ";
                        }
                    }
                    if (!found) {
                        System.out.println("Word not found");
                    } else {
                        System.out.println("Translation: " + finalTranslation);
                    }
                    break;
                case "2":
                    try {
                        ReadFile fileReader = new ReadFile("C:\\Users\\bianc\\IdeaProjects\\HDT7\\src\\diccionario.txt");
                        List<String> fileLines = fileReader.readLines();
                        System.out.println("Contenido del archivo de texto:");
                        System.out.println("-------------------------------------");
                        for (String line : fileLines) {
                            System.out.println(line);
                        }
                        System.out.println("-------------------------------------");
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + e.getMessage());
                    }
                    break;
                case "3":
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida, por favor intente de nuevo.");
            }
        }
    }
}