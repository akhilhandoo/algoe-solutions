package easy.array;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringJoiner;

public class TopThree {

    public static void main(String[] args) {
        int[] input = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        System.out.println(printable(findThreeLargestNumbersAlternate(input)));
    }

    private static String printable(int[] array) {
        var joiner = new StringJoiner(",", "[", "]");
        for (int number: array) {
            joiner.add(String.valueOf(number));
        }
        return joiner.toString();
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(3);
        for (int i: array) {
            priorityQueue.add(i);
            if (priorityQueue.size() > 3) {
                priorityQueue.remove();
            }
        }
        return new int[]{priorityQueue.remove(), priorityQueue.remove(), priorityQueue.remove()};
    }

    public static int[] findThreeLargestNumbersAlternate(int[] array) {
        int max = Integer.MIN_VALUE;
        int maxButOne = Integer.MIN_VALUE;
        int maxButTwo = Integer.MIN_VALUE;

        for (int i: array) {
            if (i > max) {
                maxButTwo = maxButOne;
                maxButOne = max;
                max = i;
            } else if (i > maxButOne) {
                maxButTwo = maxButOne;
                maxButOne = i;
            } else if (i > maxButTwo) {
                maxButTwo = i;
            }
        }
        return new int[]{maxButTwo, maxButOne, max};
    }
}
