package easy.array;

import java.util.HashSet;
import java.util.StringJoiner;

public class TwoNumberSum {

    public static void main(String[] args) {
        int[] numbers = new int[] {3, 5, -4, 8, 11, 1, -1, 6};
        System.out.println(printable(twoNumberSum(numbers, 10)));
    }

    private static String printable(int[] array) {
        var joiner = new StringJoiner(",", "[", "]");
        for (int number: array) {
            joiner.add(String.valueOf(number));
        }
        return joiner.toString();
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        var integers = new HashSet<Integer>();
        for (int number: array) {
            integers.add(number);
        }
        for (int number: array) {
            int complement = targetSum - number;
            if (complement != number && integers.contains(complement)) {
                return new int[]{number, complement};
            }
        }
        return new int[0];
    }
}
