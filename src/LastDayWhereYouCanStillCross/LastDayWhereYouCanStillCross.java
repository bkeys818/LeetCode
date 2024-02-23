package LastDayWhereYouCanStillCross;

import java.util.LinkedList;
import java.util.Queue;

public class LastDayWhereYouCanStillCross {
    private final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int first = 1, last = cells.length;
        while (first < last) {
            int mid = last - (last - first) / 2;
            if (canCross(row, col, cells, mid)) first = mid;
            else last = mid - 1;
        }
        return first;
    }

    private boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < day; i++)
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < col; i++)
            if (grid[0][i] == 0) {
                queue.offer(new int[]{0, i});
                grid[0][i] = -1;
            }

        while (!queue.isEmpty()) {
            int[] coordinates = queue.poll();
            int r = coordinates[0], c = coordinates[1];

            if (r == row - 1) return true;

            for (int[] dir : dirs) {
                int nR = r + dir[0], nC = c + dir[1];
                if (0 <= nR && nR < row && 0 <= nC && nC < col && grid[nR][nC] == 0) {
                    queue.offer(new int[]{nR, nC});
                    grid[nR][nC] = -1;
                }
            }
        }

        return false;
    }
}