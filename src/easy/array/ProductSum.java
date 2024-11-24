package easy.array;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {

    public static void main(String[] args) {
        List<Object> input = new ArrayList<>();

        input.add(5);
        input.add(2);
        input.add(new ArrayList<>(List.of(7, -1)));
        input.add(3);
        input.add(new ArrayList<>(List.of(
                6,
                new ArrayList<>(List.of(-13, 8)),
                4))
        );
        System.out.println(productSum(input));
    }

    public static int productSum(List<Object> array) {
        return productSumHelper(array, 1);
    }

    private static int productSumHelper(List<Object> input, int depth) {
        int total = 0;
        for (Object object: input) {
            if (object instanceof ArrayList) {
                total += productSumHelper((List)object, depth + 1);
            } else {
                total += (Integer)object;
            }
        }
        return depth * total;
    }
}
