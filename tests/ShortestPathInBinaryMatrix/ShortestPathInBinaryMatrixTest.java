package ShortestPathInBinaryMatrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Shortest Path in Binary Matrix")
class ShortestPathInBinaryMatrixTest {
    ShortestPathInBinaryMatrix solution = new ShortestPathInBinaryMatrix();
    @Test
    @DisplayName("case 1")
    void case1() {
        assertEquals(2, solution.shortestPathBinaryMatrix(new int[][] {{0,1},{1,0}}));
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        assertEquals(4, solution.shortestPathBinaryMatrix(new int[][] {{0,0,0},{1,1,0},{1,1,0}}));
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        assertEquals(-1, solution.shortestPathBinaryMatrix(new int[][] {{1,0,0},{1,1,0},{1,1,0}}));
    }
}