import java.util.ArrayList;

public class TimeNeededToInformAllEmployees {
    private ArrayList<ArrayList<Integer>> subordinates;
    private int maxTime = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        subordinates = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            subordinates.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                subordinates.get(manager[i]).add(i);
            }
        }
        dfs(headID, informTime, 0);
        return maxTime;
    }

    /**
     * @param time How long it took the employee to be informed.
     */
    private void dfs(int managerId, int[] informTime, int time) {
        maxTime = Math.max(maxTime, time);
        for (int subordinateId : subordinates.get(managerId)) {
            dfs(subordinateId, informTime, time + informTime[managerId]);
        }
    }
}