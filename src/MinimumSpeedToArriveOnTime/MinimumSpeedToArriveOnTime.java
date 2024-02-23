package MinimumSpeedToArriveOnTime;

import java.util.stream.IntStream;

public class MinimumSpeedToArriveOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        int min = 1;
        int max = 10_000_000;
        if (hoursAtSpeed(max, dist) > hour) return -1;
        while (min < max) {
            int mid = (min + max) / 2;
            if (hoursAtSpeed(mid, dist) <= hour)
                max = mid;
            else
                min = mid + 1;
        }
        return max;
    }

    private double hoursAtSpeed(int speed, int[] dist) {
        double total = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            total += Math.ceil((double) dist[i] / speed);
        }
        total += (double) dist[dist.length - 1] / speed;
        return total;
    }
}