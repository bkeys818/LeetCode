package LastStoneWeight;

import java.util.Queue;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int n : stones) queue.add(n);
        while (queue.size() > 1) {
            int a = queue.poll(), b = queue.poll();
            if (a > b) queue.add(a - b);
            else if (a < b) queue.add(b - a);
        }
        return queue.poll();
    }
}