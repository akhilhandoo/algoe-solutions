package easy.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BranchSums {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "BinaryTree{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        BinaryTree two = new BinaryTree(2);
        BinaryTree three = new BinaryTree(3);

        root.left = two;
        root.right = three;


        BinaryTree four = new BinaryTree(4);
        BinaryTree five = new BinaryTree(5);

        two.left = four;
        two.right = five;


        BinaryTree six = new BinaryTree(6);
        BinaryTree seven = new BinaryTree(7);

        three.left = six;
        three.right = seven;


        BinaryTree eight = new BinaryTree(8);
        BinaryTree nine = new BinaryTree(9);

        four.left = eight;
        four.right = nine;

        BinaryTree ten = new BinaryTree(10);
        five.left = ten;

        System.out.println(branchSums(root));
        //System.out.println(root);
    }

    public static List<Integer> branchSums(BinaryTree root) {
        Map<Integer, Integer> accumulator = new HashMap<>();
        travellingBranchSummer(root, 0, accumulator);
        System.out.println(accumulator);
        List<Integer> toReturn = new ArrayList<>();
        for (int index = 0; index < accumulator.size(); index++) {
            toReturn.add(accumulator.get(index));
        }
        return toReturn;
    }

    private static void travellingBranchSummer(BinaryTree node, int currentSummation, Map<Integer, Integer> accumulator) {
        if (isLeaf(node)) {
            accumulator.put(accumulator.size(), currentSummation + node.value);
            return;
        } else if (null != node.left) {
            travellingBranchSummer(node.left, currentSummation + node.value, accumulator);
            if (null != node.right) {
                travellingBranchSummer(node.right, currentSummation + node.value, accumulator);
            }
        } else {
            travellingBranchSummer(node.right, currentSummation + node.value, accumulator);
        }
    }


    private static boolean isLeaf(BinaryTree node) {
        return null == node.left && null == node.right;
    }
}
