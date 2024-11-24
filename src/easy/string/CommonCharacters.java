package easy.string;

import java.util.*;

public class CommonCharacters {


    public static void main(String[] args) {
        System.out.print(printable(commonCharacters(new String[]{"abc", "bcd", "cbaccd"})));

//        System.out.print(printable(commonCharacters(new String[]{"a", "b", "c"})));
    }

    private static String printable(String[] array) {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (String s: array) {
            stringJoiner.add(s);
        }
        return stringJoiner.toString();
    }

    public static String[] commonCharacters(String[] strings) {

        Map<Character, Integer> analysis = new HashMap<>();

        for(String string: strings) {
            var uniques = uniqueChars(string);
            for (char ch: uniques) {
                analysis.put(ch, analysis.getOrDefault(ch, 0) + 1);
            }
        }

        Map<Integer, List<Character>> reverseAnalysis = new HashMap<>();
        for (Map.Entry<Character, Integer> entry: analysis.entrySet()) {
            int count = entry.getValue();
            List<Character> chars = reverseAnalysis.getOrDefault(count, new ArrayList<>());
            chars.add(entry.getKey());
            reverseAnalysis.put(count, chars);
        }

        var answerList = reverseAnalysis.get(strings.length);
        if (null == answerList) {
            return new String[]{};
        }

        String[] toReturn = new String[answerList.size()];
        int index = 0;
        for (char ch: answerList) {
            toReturn[index] = String.valueOf(ch);
            index++;
        }
        return toReturn;
    }

    private static Set<Character> uniqueChars(String source) {
        Set<Character> uniques = new HashSet<>();
        for (char ch: source.toCharArray()) {
            uniques.add(ch);
        }
        return uniques;
    }
}
