package KnightProbabilityInChessboard;

import java.util.Arrays;

public class KnightProbabilityInChessboard {
    private final int[][] dirs = {{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1}};
    private double[][][] memory;

    public double knightProbability(int n, int k, int row, int column) {
        memory = new double[k + 1][n][n];
        for (double[][] layer : memory)
            for (double[] columnArray : layer)
                Arrays.fill(columnArray, -1);

        double prob = 0;
        for (int x = 0; x < n; x++)
            for (int y = 0; y < n; y++)
                prob += calcMemory(x, y, k, n, row, column);
        return prob;
    }

    private double calcMemory(int x, int y, int move, int n, int row, int column) {
        // base case
        if (move == 0)
            // at starting cell or not
            return (x == row && y == column) ? 1 : 0;

        // already calculated
        if (memory[move][x][y] != -1)
            return memory[move][x][y];

        memory[move][x][y] = 0;
        for (int[] dir : dirs) {
            int nX = x + dir[0], nY = y + dir[1];
            if (0 <= nX && nX < n && 0 <= nY && nY < n)
                memory[move][x][y] += calcMemory(nX, nY, move - 1, n, row, column) / 8.0;
        }

        return memory[move][x][y];
    }
}