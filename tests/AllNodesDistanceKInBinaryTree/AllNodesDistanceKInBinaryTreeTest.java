package AllNodesDistanceKInBinaryTree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("All Nodes Distance K in Binary Tree")
class AllNodesDistanceKInBinaryTreeTest {
    AllNodesDistanceKInBinaryTree solution = new AllNodesDistanceKInBinaryTree();

    @Test
    @DisplayName("case 1")
    void case1() {
        TreeNode root = TreeNode.fromArray(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        List<Integer> response = solution.distanceK(root, root.left, 2);
        response.sort(Integer::compareTo);
        assertArrayEquals(new int[]{1, 4, 7},
                response.stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        TreeNode root = TreeNode.fromArray(new Integer[]{1});
        List<Integer> response = solution.distanceK(root, root, 3);
        assertArrayEquals(new int[0],
                response.stream().mapToInt(Integer::intValue).toArray());
    }
}