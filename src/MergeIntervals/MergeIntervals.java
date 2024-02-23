package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ranges = new ArrayList<>();
        ranges.add(intervals[0]);
        int i = 1;
        for (int[] curr : intervals) {
            int[] last = ranges.get(i - 1);
            if (last[1] >= curr[0]) {
                last[0] = Math.min(last[0], curr[0]);
                last[1] = Math.max(last[1], curr[1]);
                ranges.set(i - 1, last);
            } else {
                ranges.add(curr);
                i++;
            }
        }
        return ranges.toArray(new int[0][]);
    }
}