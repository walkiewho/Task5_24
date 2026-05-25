package Task;


import java.util.ArrayList;

public class BinaryTree {
    public TreeNode root;
    private TreeNode prev;

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


    public boolean canTreeBeFixed() {
        System.out.print("Default:              ");
        inorder();

        ArrayList<TreeNode> mistakes = new ArrayList<>();
        mistakes.add(null);
        mistakes.add(null);

        prev = null;
        findMistakes(root, mistakes);

        if (mistakes.get(0) == null) {
            System.out.println("Уже BST");
            return true;
        }

        int temp = mistakes.get(0).value;
        mistakes.get(0).value = mistakes.get(1).value;
        mistakes.get(1).value = temp;

        boolean result = isSearchTree();
        if (result) {
            System.out.print("Можно привести к BST: ");
            inorder();
        } else {
            System.out.println("Нельзя привести к BST");
        }

        if (!result) {
            temp = mistakes.get(0).value;
            mistakes.get(0).value = mistakes.get(1).value;
            mistakes.get(1).value = temp;
        }

        return result;
    }


    public BinaryTree fixTree() {
        ArrayList<TreeNode> mistakes = new ArrayList<>();
        mistakes.add(null);
        mistakes.add(null);

        prev = null;
        findMistakes(root, mistakes);

        if (mistakes.get(0) == null) {
            return this;
        }

        int temp = mistakes.get(0).value;
        mistakes.get(0).value = mistakes.get(1).value;
        mistakes.get(1).value = temp;

        if (isSearchTree()) {
            return this;
        } else {
            temp = mistakes.get(0).value;
            mistakes.get(0).value = mistakes.get(1).value;
            mistakes.get(1).value = temp;
            return null;
        }
    }

    private void findMistakes(TreeNode node, ArrayList<TreeNode> mistakes) {
        if (node == null) return;

        findMistakes(node.left, mistakes);

        if (prev != null && prev.value > node.value) {
            if (mistakes.get(0) == null) {
                mistakes.set(0, prev);
            }
            mistakes.set(1, node);
        }
        prev = node;

        findMistakes(node.right, mistakes);
    }

    public BinaryTree copy() {
        BinaryTree newTree = new BinaryTree();
        newTree.root = copyRec(this.root);
        return newTree;
    }

    private TreeNode copyRec(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode newNode = new TreeNode(node.value);

        newNode.left = copyRec(node.left);
        newNode.right = copyRec(node.right);

        return newNode;
    }
}