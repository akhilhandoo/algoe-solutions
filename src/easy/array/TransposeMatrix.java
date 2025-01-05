package easy.array;

import java.util.StringJoiner;

public class TransposeMatrix {

    public static void main(String[] args) {
//        int[][] data = new int[][] {
//                {1, 2},
//                {3, 4},
//                {5, 6}
//        };

        int[][] data = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(toString(data));
        int[][] transpose = transposeMatrix(data);
        System.out.println("\n******************\n");
        System.out.println(toString(transpose));
    }


    private static String toString(int[][] matrix) {
        StringJoiner matrixJoiner = new StringJoiner(",\n", "[\n", "\n]");
        for (int row = 0; row < matrix.length; row++) {
            StringJoiner rowJoiner = new StringJoiner(", ", "\t[", "]");
            for (int col = 0; col < matrix[row].length; col++) {
                rowJoiner.add(String.valueOf(matrix[row][col]));
            }
            matrixJoiner.add(rowJoiner.toString());
        }
        return matrixJoiner.toString();
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] toReturn = new int[matrix[0].length][matrix.length];
        for (int row = 0; row < toReturn.length; row++) {
            for (int col = 0; col < toReturn[row].length; col++)
             {
                toReturn[row][col] = matrix[col][row];
             }
        }
        return toReturn;
    }
}
