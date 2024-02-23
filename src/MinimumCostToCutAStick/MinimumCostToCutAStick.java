package MinimumCostToCutAStick;

import java.util.Arrays;

public class MinimumCostToCutAStick {
    int[][] memory;
    int[] newCuts;
    public int minCost(int n, int[] cuts) {
        final int m = cuts.length; // number of cuts
        newCuts = new int[m + 2];
        System.arraycopy(cuts, 0, newCuts, 1, m);
        newCuts[m + 1] = n;
        Arrays.sort(newCuts);

        memory = new int[m + 2][m + 2];
        for (int[] arr : memory) {
            Arrays.fill(arr, -1);
        }

        return cost(0, newCuts.length - 1);
    }

    /** minimum cost of all the cuts on the stick fragment **/
    private int cost(int left, int right) {
        if (memory[left][right] != -1) {
            return memory[left][right];
        } else if (right - left == 1) {
            return 0;
        }
        int answer = Integer.MAX_VALUE;
        for (int mid = left + 1; mid < right; mid++) {
            int cost = cost(left, mid) + cost(mid, right) + newCuts[right] - newCuts[left];
            answer = Math.min(answer, cost);
        }
        return memory[left][right] = answer;
    }
}