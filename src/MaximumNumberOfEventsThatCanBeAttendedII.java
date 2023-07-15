import java.util.Arrays;

public class MaximumNumberOfEventsThatCanBeAttendedII {
    private int[][] memory;
    private int[] nextIndices;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        memory = new int[k + 1][events.length];
        for (int[] nums : memory)
            Arrays.fill(nums, -1);
        nextIndices = new int[events.length];
        for (int i = 0; i < events.length; i++)
            nextIndices[i] = bsRight(events, events[i][1]);
        return dfs(events, 0, k);
    }

    private int dfs(int[][] events, int curI, int count) {
        if (count == 0 || curI == events.length) return 0;
        if (memory[count][curI] != -1) return memory[count][curI];
        memory[count][curI] = Math.max(
                // if event is attended
                events[curI][2] + dfs(events, nextIndices[curI], count - 1),
                // if event is skipped
                dfs(events, curI + 1, count)
        );
        return memory[count][curI];
    }

    private int bsRight(int[][] events, int target) {
        int start = 0, end = events.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (events[mid][0] <= target) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}