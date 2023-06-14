import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rows = new HashMap<>();
        for (int[] row : grid) {
            StringBuilder builder = new StringBuilder();
            for (int cell : row) {
                builder.append(cell).append(" ");
            }
            String key = builder.toString();
            rows.put(key, rows.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for (int x = 0; x < grid.length; x++) {
            StringBuilder builder = new StringBuilder();
            for (int y = 0; y < grid[x].length; y++) {
                builder.append(grid[y][x]).append(" ");
            }
            String key = builder.toString();
            count += rows.getOrDefault(key, 0);
        }
        return count;
    }
}