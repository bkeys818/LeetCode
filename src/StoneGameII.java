public class StoneGameII {
    public int stoneGameII(int[] piles) {
        int[][][] memory = new int[2][piles.length + 1][piles.length + 1];
        for (int playerI = 0; playerI < 2; playerI++) {
            for (int i = 0; i < piles.length; i++) {
                for (int m = 0; m < piles.length; m++) {
                    memory[playerI][i][m] = -1;
                }
            }
        }
        return f(piles, memory, 0, 0, 1);
    }

    /**
     * Finds the number of stones Alice can get in the following state of the game.
     * @param i How many piles are already taken. Only {@code n-i} piles are taken into account.
     * @param m A player must take {@code 1≤x≤2m} piles
     */
    private int f(int[] piles, int[][][] memory, int playerI, int i, int m) {
        if (i == piles.length) {
            return 0; // base case
        }
        if (memory[playerI][i][m] != -1) {
            return memory[playerI][i][m];
        }

        int res = playerI == 0 ? -1 : 1_000_000; // return value of the current state
        int s = 0; // number of stones the player takes during the current move

        // for all possible number of piles that can be taken
        for (int x  = 1; x <= Math.min(2 * m, piles.length - i); x++) {
            s += piles[i + x - 1];
            if (playerI == 0) {
                int aliceNextSum = f(piles, memory, 1, i + x, Math.max(m, x));
                res = Math.max(res, s + aliceNextSum);
            } else {
                int aliceNextSum = f(piles, memory, 0, i + x, Math.max(m, x));
                // Bob want's to minimize the number of stones Alice can take.
                res = Math.min(res, aliceNextSum);
            }
        }
        return memory[playerI][i][m] = res;
    }
}