package Controller;

import java.util.ArrayList;

public class Dictionary {
    private BST<Association<String, String>> englishTree;
    private BST<Association<String, String>> spanishTree;
    private BST<Association<String, String>> frenchTree;

    public Dictionary() {
        englishTree = new BST<>();
        spanishTree = new BST<>();
        frenchTree = new BST<>();
    }

    public void addAssociation(String english, String spanish, String french) {
        Association<String, String> englishAssociation = new Association<>(english.toLowerCase(), spanish.toLowerCase() + ", " + french.toLowerCase());
        Association<String, String> spanishAssociation = new Association<>(spanish.toLowerCase(), english.toLowerCase() + ", " + french.toLowerCase());
        Association<String, String> frenchAssociation = new Association<>(french.toLowerCase(), english.toLowerCase() + ", " + spanish.toLowerCase());

        englishTree.insert(englishAssociation);
        spanishTree.insert(spanishAssociation);
        frenchTree.insert(frenchAssociation);
    }

    public ArrayList<String> getEnglishDictionary() {
        ArrayList<String> dictionary = new ArrayList<>();
        englishTree.inOrderTraversal((association -> dictionary.add(association.getKey())));
        return dictionary;
    }

    public ArrayList<String> getSpanishDictionary() {
        ArrayList<String> dictionary = new ArrayList<>();
        spanishTree.inOrderTraversal((association -> dictionary.add(association.getKey())));
        return dictionary;
    }

    public ArrayList<String> getFrenchDictionary() {
        ArrayList<String> dictionary = new ArrayList<>();
        frenchTree.inOrderTraversal((association -> dictionary.add(association.getKey())));
        return dictionary;
    }

    public String translate(String word, String language) {
        String result = "*" + word + "*";
        word = word.toLowerCase();
        if (language.equalsIgnoreCase("spanish")) {
            Association<String, String> spanishAssociation = new Association<>(word, "");
            spanishAssociation = spanishTree.search(spanishAssociation);
            if (spanishAssociation != null) {
                String[] translations = spanishAssociation.getValue().split(", ");
                result = translations[0];
            }
        } else if (language.equalsIgnoreCase("french")) {
            Association<String, String> frenchAssociation = new Association<>(word, "");
            frenchAssociation = frenchTree.search(frenchAssociation);
            if (frenchAssociation != null) {
                String[] translations = frenchAssociation.getValue().split(", ");
                result = translations[1];
            }
        } else {
            Association<String, String> englishAssociation = new Association<>(word, "");
            englishAssociation = englishTree.search(englishAssociation);
            if (englishAssociation != null) {
                String[] translations = englishAssociation.getValue().split(", ");
                result = translations[0];
            }
        }
        return result;
    }
}