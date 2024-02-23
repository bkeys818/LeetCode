package AllNodesDistanceKInBinaryTree;

import utils.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        addToGraph(root, null);
        List<Integer> list = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        list.add(target.val);
        visited.add(target.val);
        for (int distance = 0; distance < k; distance++) {
            List<Integer> nextList = new ArrayList<>();
            for (int num : list) {
                for (int next : graph.getOrDefault(num, new ArrayList<>())) {
                    if (!visited.contains(next))
                        nextList.add(next);
                }
                visited.add(num);
            }
            list = nextList;
        }
        return list;
    }

    private void addToGraph(TreeNode node, TreeNode parent) {
        if (node != null && parent != null) {
            graph.computeIfAbsent(node.val, k -> new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val, k -> new ArrayList<>()).add(node.val);
        }
        if (node.left != null)
            addToGraph(node.left, node);
        if (node.right != null)
            addToGraph(node.right, node);
    }
}