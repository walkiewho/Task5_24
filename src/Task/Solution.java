package Task;

import java.util.ArrayList;

public class Solution {
    public static boolean solve(BinaryTree tree) {
        System.out.print("Default:              ");
        tree.inorder();

        ArrayList<TreeNode> mistakes = new ArrayList<>();
        // First and Second mistake
        mistakes.add(null);
        mistakes.add(null);
        // previous
        mistakes.add(null);

        findMistakes(tree.root, mistakes);

        if (mistakes.getFirst() == null) {
            System.out.println("Уже BST");
            return true;
        }

        int temp = mistakes.get(0).value;
        mistakes.get(0).value = mistakes.get(1).value;
        mistakes.get(1).value = temp;

        boolean result = tree.isSearchTree();
        if (result) {
            System.out.print("Можно привести к BST: ");
            tree.inorder();
        } else {
            System.out.println("Нельзя привести к BST: ");
        }

        return result;
    }

    private static void findMistakes(TreeNode node, ArrayList<TreeNode> mistakes) {
        if (node == null) return;


        findMistakes(node.left, mistakes);

        if (mistakes.get(2) != null && mistakes.get(2).value > node.value) {
            if (mistakes.getFirst() == null) {
                mistakes.set(0, mistakes.get(2));
            }
            mistakes.set(1, node);
        }
        mistakes.set(2, node);

        findMistakes(node.right, mistakes);
    }
}
