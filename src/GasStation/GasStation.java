package GasStation;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = gas[0] - cost[n - 1], max = 0, maxCost = sum;
        for (int i = 1; i < n; i++) {
            int thisCost = gas[i] - cost[i - 1];
            if (thisCost > maxCost) max = i;
            sum += thisCost;
        }
        return sum < 0 ? -1 : max - 1;
    }
}