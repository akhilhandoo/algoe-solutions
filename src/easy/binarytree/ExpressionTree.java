package easy.binarytree;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExpressionTree {

    public static void main(String[] args) {

        BinaryTree minus1 = new BinaryTree(-1);
        BinaryTree minus2 = new BinaryTree(-2);
        BinaryTree minus3 = new BinaryTree(-3);
        BinaryTree minus4 = new BinaryTree(-4);
        BinaryTree two1 = new BinaryTree(2);
        BinaryTree two2 = new BinaryTree(2);
        BinaryTree eight = new BinaryTree(8);
        BinaryTree three1 = new BinaryTree(3);
        BinaryTree three2 = new BinaryTree(3);

        minus4.left = two1;
        minus4.right = three1;

        minus2.left = minus4;
        minus2.right = two2;

        minus3.left = eight;
        minus3.right = three2;

        minus1.left = minus2;
        minus1.right = minus3;

//        System.out.println(minus1);

        System.out.print(evaluateExpressionTree(minus1));

    }


    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
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

    public static int evaluateExpressionTree(BinaryTree tree) {
        if (tree.value >= 0) {
            return tree.value;
        }

        int left = evaluateExpressionTree(tree.left);
        int right = evaluateExpressionTree(tree.right);
        int returnValue = -1;
        switch (tree.value) {
            case -1:
                returnValue = left + right;
                break;
            case -2:
                returnValue = left - right;
                break;
            case -3:
                returnValue = roundTowardsZero((double)left / (double)right);
                break;
            case -4:
                returnValue = left * right;
                break;
        }
        return returnValue;
    }

    private static int roundTowardsZero(double d) {
        if (d < 0) {
            return (int)Math.ceil(d);
        } if (d == 0) {
            return 0;
        } else {
            return (int)Math.floor(d);
        }
    }

    private static boolean isLeaf(BinaryTree node) {
        return null == node.left && null == node.right;
    }
}
