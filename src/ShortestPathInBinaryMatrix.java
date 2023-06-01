import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    final static int[][] neighborPairs ={
            {1,1}, // bottom right
            {1,0}, // right
            {0,1}, // bottom
            {1,-1}, // top right
            {-1,+1}, // bottom left
            {0,-1}, // top
            {-1,0}, // left
            {-1,-1}, // top left
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, 1 });
        while (!queue.isEmpty()) {
            int[] pair = queue.remove();
            int x = pair[0], y = pair[1], distance = pair[2];
            if (x == n-1 && y == n-1) {
                return distance;
            }
            if (x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 0) {
                grid[x][y] = 1;
                for (int[] neighborPair : neighborPairs) {
                    queue.add(new int[] {
                            x + neighborPair[0],
                            y + neighborPair[1],
                            distance + 1
                    });
                }
            }
        }
        return -1;
    }
}

