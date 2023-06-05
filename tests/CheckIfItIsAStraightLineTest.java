import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


@DisplayName("Check If It Is a Straight Line")
class CheckIfItIsAStraightLineTest {
    CheckIfItIsAStraightLine solution = new CheckIfItIsAStraightLine();

    @Test
    @DisplayName("case 1")
    void case1() {
        assertTrue(solution.checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        assertFalse(solution.checkStraightLine(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        assertTrue(solution.checkStraightLine(new int[][]{{0, 0}, {0, 1}, {0, -1}}));
    }
}