package UI;

import Task.BinaryTree;
import Task.TreeNode;

import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel {
    private final BinaryTree tree;

    public TreePanel(BinaryTree tree) {
        this.tree = tree;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (tree.root != null) {
            drawTree(g, tree.root, getWidth() / 2, 50, getWidth() / 4);
        }
    }

    private void drawTree(Graphics g, TreeNode node, int x, int y, int offset) {
        if (node == null) return;

        int radius = 20;

        // Линия к левому ребенку
        if (node.left != null) {
            int childX = x - offset;
            int childY = y + 80;

            g.drawLine(x, y, childX, childY);

            drawTree(g, node.left, childX, childY, offset / 2);
        }

        // Линия к правому ребенку
        if (node.right != null) {
            int childX = x + offset;
            int childY = y + 80;

            g.drawLine(x, y, childX, childY);

            drawTree(g, node.right, childX, childY, offset / 2);
        }

        // Узел
        g.setColor(new Color(120, 170, 255));
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);

        g.setColor(Color.BLACK);
        g.drawOval(x - radius, y - radius, radius * 2, radius * 2);

        // Значение
        String text = String.valueOf(node.value);
        FontMetrics fm = g.getFontMetrics();

        int textX = x - fm.stringWidth(text) / 2;
        int textY = y + fm.getAscent() / 2;

        g.drawString(text, textX, textY);
    }
}