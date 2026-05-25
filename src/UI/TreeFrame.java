package UI;

import Task.BinaryTree;
import Task.TreeNode;

import javax.swing.*;
import java.awt.*;

public class TreeFrame extends JFrame {

    public TreeFrame(BinaryTree tree1, BinaryTree tree2) {
        setTitle("Compare Trees");
        setSize(1920 / 3, 1080 / 3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(1, 2));

        JPanel leftPanel = createPanel(tree1, "Исходное дерево");
        JPanel rightPanel = createPanel(tree2, "Исправленное дерево");

        add(leftPanel);
        add(rightPanel);

        setVisible(true);
    }

    private JPanel createPanel(BinaryTree tree, String title) {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(label, BorderLayout.NORTH);
        panel.add(new TreePanel(tree), BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        TreeNode root = new TreeNode(6); // должно быть 4
        root.left = new TreeNode(2);
        root.right = new TreeNode(4); // должно быть 6

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        tree.root = root;

        BinaryTree treeForFix = tree.copy();
        treeForFix.fixTree();
        new TreeFrame(tree, treeForFix);
    }
}