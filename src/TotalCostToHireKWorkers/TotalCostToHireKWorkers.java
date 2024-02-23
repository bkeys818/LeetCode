package TotalCostToHireKWorkers;

import java.util.PriorityQueue;
import java.util.Queue;

public class TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        Queue<Integer> heapLeft = new PriorityQueue<>();
        Queue<Integer> heapRight = new PriorityQueue<>();
        int left, right;
        for (left = 0; left < candidates; left++)
            heapLeft.add(costs[left]);
        for (right = costs.length - 1; right >= Math.max(candidates, costs.length - candidates); right--)
            heapRight.add(costs[right]);
        long cost = 0;
        for (int i = 0; i < k; i++) {
            if (heapRight.isEmpty() || !heapLeft.isEmpty() && heapLeft.peek() <= heapRight.peek()) {
                cost += heapLeft.poll();
                if (left <= right) heapLeft.add(costs[left++]);
            } else {
                cost += heapRight.poll();
                if (left <= right) heapRight.add(costs[right--]);
            }
        }
        return cost;
    }
}