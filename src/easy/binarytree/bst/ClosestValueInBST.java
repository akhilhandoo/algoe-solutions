package easy.binarytree.bst;

public class ClosestValueInBST {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findClosestValueInBst(BST tree, int target) {
        return leastDiffSupportMethod(tree, target)[1];
    }

    private static int[] leastDiffSupportMethod(BST tree, int target) {
        if (null == tree) {
            return new int[]{-1, 0};
        }
        int currentDiff = Math.abs(tree.value - target);
        int[] subsequentDifferenceTuple = tree.value > target ? leastDiffSupportMethod(tree.left, target) : leastDiffSupportMethod(tree.right, target);
        if (subsequentDifferenceTuple[0] < 0 || currentDiff < subsequentDifferenceTuple[0]) {
            return new int[]{currentDiff, tree.value};
        } else {
            return subsequentDifferenceTuple;
        }
    }
}
