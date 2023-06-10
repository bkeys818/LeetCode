public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (
                    invalidSection(board, 0, 8, i, i) ||
                            invalidSection(board, i, i, 0, 8)
            ) return false;
        }
        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                if (invalidSection(board, x, x + 2, y, y + 2)) return false;
            }
        }
        return true;
    }

    private boolean invalidSection(char[][] board, int x1, int x2, int y1, int y2) {
        boolean[] present = new boolean[9];
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                if (board[x][y] != '.') {
                    int i = Character.getNumericValue(board[x][y]) - 1;
                    if (present[i]) return true;
                    present[i] = true;
                }
            }
        }
        return false;
    }
}