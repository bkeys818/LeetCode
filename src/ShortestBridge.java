import java.util.ArrayList;
import java.util.List;

public class ShortestBridge {
    private List<int[]> bfsQueue;

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int firstX = -1, firstY = -1;
        rowLoop:
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == 1) {
                    firstX = x;
                    firstY = y;
                    break rowLoop;
                }
            }
        }

        bfsQueue = new ArrayList<>();
        dfsSearch(grid, firstX, firstY, n);

        /*
          Starting with cells of islandA (2), search every cells' neighbor.
          If cell is ocean (0), set it to -1 to mark it as visited and add it to `nextBfs`.
          If cell is islandB (1), we've found the shortest path (as we are using BFS).
          If islandB isn't found, replace `bsfQueue` with `nextBfs` and increase distance.
         */
        int distance = 0;
        while (!bfsQueue.isEmpty()) {
            List<int[]> next_bfs = new ArrayList<>();
            for (int[] pair : bfsQueue) {
                // for each neighbor
                int x = pair[0], y = pair[1];
                for (int[] neighbor : new int[][]{{x, y + 1}, {x + 1, y}, {x, y - 1}, {x - 1, y}}) {
                    int nX = neighbor[0], nY = neighbor[1];
                    if (0 <= nX && nX < n && 0 <= nY && nY < n) {
                        if (grid[nX][nY] == 1) { // reached other island
                            return distance;
                        } else if (grid[nX][nY] == 0) {
                            grid[nX][nY] = -1; // mark as visited
                            next_bfs.add(new int[]{nX, nY});
                        }
                    }
                }
            }
            bfsQueue = next_bfs;
            distance++;
        }
        return -1;
    }


    /**
     * Start from a single land cell and use DFS to find all connected land cells.
     * All these cells are changed to 2, so we can differentiate the two islands.
     */
    private void dfsSearch(int[][] grid, int x, int y, int n) {
        grid[x][y] = 2;
        bfsQueue.add(new int[]{x, y});
        // for each neighbor
        for (int[] neighbor : new int[][]{{x, y + 1}, {x + 1, y}, {x, y - 1}, {x - 1, y}}) {
            int nX = neighbor[0], nY = neighbor[1];
            if (0 <= nX && nX < n && 0 <= nY && nY < n && grid[nX][nY] == 1) {
                dfsSearch(grid, nX, nY, n);
            }
        }
    }
}
