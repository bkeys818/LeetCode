import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Equal Row and Column Pairs")
class EqualRowAndColumnPairsTest {
    EqualRowAndColumnPairs solution = new EqualRowAndColumnPairs();
    @Test
    @DisplayName("case 1")
    void case1() {
        assertEquals(3, solution.equalPairs(new int[][] {
                {3,1,2,2},
                {1,4,4,5},
                {2,4,2,2},
                {2,4,2,2}
        }));
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        assertEquals(1, solution.equalPairs(new int[][]{
                {3,2,1},
                {1,7,6},
                {2,7,7}
        }));
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        assertEquals(2, solution.equalPairs(new int[][] {
                {11,1},
                {1,11},
        }));
    }
}