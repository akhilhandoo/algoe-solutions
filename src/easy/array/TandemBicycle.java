package easy.array;

import java.util.Arrays;

public class TandemBicycle {

    public static void main(String[] args) {
        int[] red = {5, 5, 3, 9, 2};
        int[] blue = {3, 6, 7, 2, 1};
        System.out.println(tandemBicycle(red, blue, false));
    }

    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        if (fastest) {
            reverse(redShirtSpeeds);
        }
        int total = 0;
        for (int index = 0; index < redShirtSpeeds.length; index++) {
            total += Math.max(redShirtSpeeds[index], blueShirtSpeeds[index]);
        }
        return total;
    }

    private static int[] reverse(int[] array) {
        for (int index = 0; index < array.length / 2; index++) {
            int temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return array;
    }
}
