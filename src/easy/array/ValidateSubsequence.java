package easy.array;

import java.util.List;

public class ValidateSubsequence {

    public static void main(String[] args) {
        System.out.println(isValidSubsequence(List.of(5, 1, 22, 25, 6, -1, 8, 10, 9, 17, 23, 33, 43, 53), List.of(1, 6, -1, 9, 24)));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int index = 0;
        int foundCount = 0;
        for (int lookupIndex = 0; lookupIndex < sequence.size(); lookupIndex++) {
            int number = sequence.get(lookupIndex);
            while (index < array.size()) {
                if (array.get(index) == number) {
                    foundCount++;
                    index++;
                    break;
                }
                index++;
            }
            if (foundCount != sequence.size() && index >= array.size()) {
                return false;
            }
        }
        return true;
    }
}
