package easy.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GenerateDocument {

    public boolean generateDocument(String characters, String document) {
        var characterFrequencyMap = generateFrequencyMap(characters);
        var documentFrequencyMap = generateFrequencyMap(document);
        for (char ch: documentFrequencyMap.keySet()) {
            if (documentFrequencyMap.get(ch) > characterFrequencyMap.getOrDefault(ch, 0)) {
                return false;
            }
        }
        return true;
    }
    private static Map<Character, Integer> generateFrequencyMap(String source) {
        Map<Character, Integer> toReturn = new HashMap<>();
        for (char ch: source.toCharArray()) {
            toReturn.put(ch, toReturn.getOrDefault(ch, 0) + 1);
        }
        return toReturn;
    }
}
