package easy.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Semordnilap {

    public static void main(String[] args) {
        String[] words = new String[] {
                "diaper",
                "abc",
                "test",
                "cba",
                "repaid"
        };
        System.out.println(semordnilap(words));
    }

    public static ArrayList<ArrayList<String>> semordnilap(String[] words) {
        ArrayList<ArrayList<String>> toReturn = new ArrayList<>();
        Map<Map<Character, Integer>, List<String>> analysis = analyseInput(words);
        for (Map<Character, Integer> entry: analysis.keySet()) {
            List<String> wordsWithSameFrequencyMap = analysis.get(entry);
            if (wordsWithSameFrequencyMap.size() > 1) {
                ArrayList<String> palindromes = findSemordnilaps(wordsWithSameFrequencyMap);
                if (!palindromes.isEmpty()) {
                    toReturn.add(palindromes);
                }
            }
        }
        return toReturn;
    }

    private static ArrayList<String> findSemordnilaps(List<String> words) {
        ArrayList<String> toReturn = new ArrayList<>();
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (areMutualPalindromes(words.get(i), words.get(j))) {
                    toReturn.add(words.get(i));
                    toReturn.add(words.get(j));
                    return toReturn;
                }
            }
        }
        return toReturn;
    }

    private static boolean areMutualPalindromes(String first, String second) {
        for (int offset = 0; offset < first.length() / 2; offset++) {
            if (first.charAt(offset) != second.charAt(second.length() - offset - 1)) {
                return false;
            }
        }
        return true;
    }

    private static Map<Map<Character, Integer>, List<String>> analyseInput(String[] words) {
        Map<Map<Character, Integer>, List<String>> toReturn = new HashMap<>();
        for (String word: words) {
            Map<Character, Integer> characterFrequencyMap = makeCharacterFrequencyMap(word);
            List<String> wordsWithSameFrequencyMap = toReturn.get(characterFrequencyMap);
            if (null == wordsWithSameFrequencyMap) {
                wordsWithSameFrequencyMap = new ArrayList<>();
            }
            wordsWithSameFrequencyMap.add(word);
            toReturn.put(characterFrequencyMap, wordsWithSameFrequencyMap);
        }
        return toReturn;
    }

    private static Map<Character, Integer> makeCharacterFrequencyMap(String word) {
        Map<Character, Integer> toReturn = new HashMap<>();
        for (char ch: word.toCharArray()) {
            toReturn.put(ch, toReturn.getOrDefault(ch, 0) + 1);
        }
        return toReturn;
    }
}
