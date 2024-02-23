package TopKFrequentElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
                (a, b) -> count.get(a) - count.get(b)
        );
        for (int key : count.keySet()) {
            heap.add(key);
            if (heap.size() > k) heap.poll();
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            result[i] = heap.poll();
        }
        return result;
    }
}
