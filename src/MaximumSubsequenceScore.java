import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        // Combine arrays into a single array of pairs
        // Ex: [0, 2] & [1, 3] => [[0,1], [2,3]]
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++){
            pairs[i] = new int[] { nums1[i], nums2[i] };
        }
        // Sort pairs in reverse by the second value (from nums2)
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> a- b);
        long heapSum = 0; // sum of k-1 values from nums1 (which has been sorted by num2)
        for (int i = 0; i < k; i++) {
            heap.add(pairs[i][0]);
            heapSum += pairs[i][0];
        }
        // Start value: heapSum * (lowest value from nums2)
        long sum = heapSum * pairs[k-1][1];
        // Check every other possible value from nums2.
        // Can't be highest k values -> min(nums2[n-k],...,nums2[n-1]) = nums2[n-k]
        for (int i = k; i < n; i++) {
            // Replace the lowest selection from nums1 with a new one
            heapSum += pairs[i][0] - heap.poll();
            heap.add(pairs[i][0]);
            // Reassign sum if this combination is greater
            sum = Math.max(sum, heapSum * pairs[i][1]);
        }
        return sum;
    }
}
