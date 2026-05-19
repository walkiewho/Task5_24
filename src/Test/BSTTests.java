package Test;

import Task.BinaryTree;
import Task.Solution;
import Task.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTests {

    @Test
    void alreadyBST() {
        BinaryTree tree = new BinaryTree();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        tree.root = root;

        boolean result = Solution.solve(tree);

        assertTrue(result);
    }

    @Test
    void oneSwapNeeded() {
        BinaryTree tree = new BinaryTree();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(7); // должно быть 3
        root.right = new TreeNode(3); // должно быть 7
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        tree.root = root;

        boolean result = Solution.solve(tree);

        assertTrue(result);

        assertEquals(3, tree.root.left.value);
        assertEquals(7, tree.root.right.value);
    }

    @Test
    void impossibleWithOneSwap() {
        BinaryTree tree = new BinaryTree();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);

        tree.root = root;

        boolean result = Solution.solve(tree);

        assertFalse(result);
    }

    @Test
    void swapLeafNodes() {
        BinaryTree tree = new BinaryTree();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5); // должно быть 3

        root.right.left = new TreeNode(3); // должно быть 5
        root.right.right = new TreeNode(7);

        tree.root = root;

        boolean result = Solution.solve(tree);

        assertTrue(result);

        assertEquals(3, tree.root.left.right.value);
        assertEquals(5, tree.root.right.left.value);
    }

    @Test
    void emptyTree() {
        BinaryTree tree = new BinaryTree();

        boolean result = Solution.solve(tree);

        assertTrue(result);
    }

    @Test
    void singleNodeTree() {
        BinaryTree tree = new BinaryTree();

        tree.root = new TreeNode(0);

        boolean result = Solution.solve(tree);

        assertTrue(result);
    }

    @Test
    void twoNodesCorrect() {
        BinaryTree tree = new BinaryTree();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        tree.root = root;

        boolean result = Solution.solve(tree);

        assertTrue(result);
    }

    @Test
    void twoNodesNeedSwap() {
        BinaryTree tree = new BinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        tree.root = root;

        boolean result = Solution.solve(tree);

        assertTrue(result);

        assertEquals(2, tree.root.value);
        assertEquals(1, tree.root.left.value);
    }

    @Test
    void rootSwapNeeded() {
        BinaryTree tree = new BinaryTree();

        TreeNode root = new TreeNode(6); // должно быть 4
        root.left = new TreeNode(2);
        root.right = new TreeNode(4); // должно быть 6

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        tree.root = root;

        boolean result = Solution.solve(tree);

        assertTrue(result);

        assertEquals(4, tree.root.value);
        assertEquals(6, tree.root.right.value);
    }
}
