package Task;


public class BinaryTree {
    public TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    public boolean isSearchTree() {
        return isSearchTreeRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isSearchTreeRec(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.value <= min || node.value >= max) {
            return false;
        }

        return isSearchTreeRec(node.left, min, node.value) && isSearchTreeRec(node.right, node.value, max);
    }


}