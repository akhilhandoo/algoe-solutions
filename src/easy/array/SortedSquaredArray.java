package easy.array;

import java.util.StringJoiner;

public class SortedSquaredArray {

    public static void main(String[] args) {
        int[] input = {-4, -3, -2, -1, 0, 2, 3, 6};
        //System.out.println(binarySearchForLargestNonPositiveNumber(input, 0, input.length - 1, -1));
        System.out.println(printable(sortedSquaredArray(input)));
    }

    private static String printable(int[] array) {
        var joiner = new StringJoiner(",", "[", "]");
        for (int number: array) {
            joiner.add(String.valueOf(number));
        }
        return joiner.toString();
    }

    public static int[] sortedSquaredArray(int[] array) {
        int[] toReturn = new int[array.length];
        int index = binarySearchForLargestNonPositiveNumber(array, 0, array.length - 1, -1);
        if (index == -1) {
            int ind = 0;
            for (int num: array) {
                toReturn[ind++] = num * num;
            }
        } else {
            int leftPointer = index;
            int rightPointer = index + 1;
            int ind = 0;
            while (leftPointer >= 0 && rightPointer < array.length) {
                if (Math.abs(array[leftPointer]) < Math.abs(array[rightPointer])) {
                    toReturn[ind++] = array[leftPointer] * array[leftPointer];
                    leftPointer--;
                } else {
                    toReturn[ind++] = array[rightPointer] * array[rightPointer];
                    rightPointer++;
                }
            }
            if (leftPointer < 0) {
                while (rightPointer < array.length) {
                    toReturn[ind++] = array[rightPointer] * array[rightPointer];
                    rightPointer++;
                }
            } else {
                while (leftPointer >= 0) {
                    toReturn[ind++] = array[leftPointer] * array[leftPointer];
                    leftPointer--;
                }
            }
        }
        return toReturn;
    }

    private static int binarySearchForLargestNonPositiveNumber(int[] input, int left, int right, int currentIndex) {
        if (right < left) {
            return currentIndex;
        }
        int middle = (left + ((right - left) / 2));
        if (input[middle] < 0) {
            return binarySearchForLargestNonPositiveNumber(input, middle + 1, right, middle);
        } else if (input[middle] == 0) {
            return middle;
        } else {
            return binarySearchForLargestNonPositiveNumber(input, left, middle - 1, currentIndex);
        }
    }
}
