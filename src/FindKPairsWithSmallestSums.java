import java.util.*;

import javafx.util.Pair;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        final List<List<Integer>> answers = new ArrayList<>();
        final Queue<int[]> heap = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        final Set<Pair<Integer, Integer>> visited = new HashSet<>();
        int[] indexes = {0, 0};
        while (answers.size() < k && indexes != null) {
            answers.add(Arrays.asList(nums1[indexes[0]], nums2[indexes[1]]));
            Pair<Integer, Integer> pair = new Pair<>(indexes[0] + 1, indexes[1]);
            if (indexes[0] + 1 < nums1.length && !visited.contains(pair)) {
                heap.offer(new int[]{indexes[0] + 1, indexes[1]});
                visited.add(pair);
            }
            pair = new Pair<>(indexes[0], indexes[1] + 1);
            if (indexes[1] + 1 < nums2.length && !visited.contains(pair)) {
                heap.offer(new int[]{indexes[0], indexes[1] + 1});
                visited.add(pair);
            }
            indexes = heap.poll();
        }
        return answers;
    }


}

