package easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClassPhotos {

    public static void main(String[] args) {
        int[] red = {5, 8, 1, 3, 4};
        int[] blue = {6, 9, 2, 4, 5};
        var redList = new ArrayList<Integer>();
        redList.addAll(IntStream.of(red).boxed().collect(Collectors.toList()));
        var blueList = new ArrayList<Integer>();
        blueList.addAll(IntStream.of(blue).boxed().collect(Collectors.toList()));
        System.out.println(classPhotos(redList, blueList));
    }

    public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        int maxRed = max(redShirtHeights);
        int maxBlue = max(blueShirtHeights);
        var backRow = maxRed > maxBlue ? redShirtHeights : blueShirtHeights;
        var frontRow = maxRed < maxBlue ? redShirtHeights : blueShirtHeights;
        backRow.sort(Integer::compareTo);
        frontRow.sort(Integer::compareTo);
        System.out.println(backRow);
        System.out.println(frontRow);
        for (int index = 0; index < backRow.size(); index++) {
            if (frontRow.get(index) >= backRow.get(index)) {
                return false;
            }
        }
        return true;
    }

    private static int max(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int num: list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
