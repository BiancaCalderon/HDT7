package Controller;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private List<Association<String, String[]>> associations;

    public Dictionary() {
        associations = new ArrayList<>();
    }

    public void addAssociation(String englishWord, String spanishWord, String frenchWord) {
        String[] translations = new String[] {englishWord, spanishWord, frenchWord};
        Association<String, String[]> association = new Association<>(englishWord, translations);
        associations.add(association);
        Association<String, String[]> association1 = new Association<>(spanishWord, translations);
        associations.add(association1);
        Association<String, String[]> association2 = new Association<>(frenchWord, translations);
        associations.add(association2);
    }

    public String translate(String word, String targetLanguage) {
        for (Association<String, String[]> association : associations) {
            if (association.getKey().equals(word)) {
                String[] translations = association.getValue();
                switch (targetLanguage) {
                    case "english":
                        return translations[0];
                    case "spanish":
                        return translations[1];
                    case "french":
                        return translations[2];
                    default:
                        return "Invalid target language";
                }
            }
        }
        return "Word not found";
    }
}