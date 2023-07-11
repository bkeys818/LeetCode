package utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    static public TreeNode fromArray(Integer[] tree) {
        if (tree.length == 0) return null;
        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < tree.length; i++) {
            TreeNode node = q.peek();
            if (i % 2 == 1) {
                if (tree[i] == null)
                    node.left = null;
                else {
                    node.left = new TreeNode(tree[i]);
                    if (tree[i] != null) q.add(node.left);
                }
            } else {
                if (tree[i] == null)
                    node.right = null;
                else {
                    node.right = new TreeNode(tree[i]);
                    if (tree[i] != null) q.add(node.right);
                }
                q.remove();
            }
        }
        return root;
    }
}
