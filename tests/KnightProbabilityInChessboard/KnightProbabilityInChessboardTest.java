package KnightProbabilityInChessboard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Knight Probability in Chessboard")
class KnightProbabilityInChessboardTest {
    KnightProbabilityInChessboard solution = new KnightProbabilityInChessboard();
    @Test
    @DisplayName("case 1")
    void case1() {
        assertEquals(0.06250, solution.knightProbability(3,2,0,0));
    }
}