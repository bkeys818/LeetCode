import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Maximum Number of Events That Can Be Attended II")
class MaximumNumberOfEventsThatCanBeAttendedIITest {
    MaximumNumberOfEventsThatCanBeAttendedII solution = new MaximumNumberOfEventsThatCanBeAttendedII();

    @Test
    @DisplayName("case 1")
    void case1() {
        assertEquals(7, solution.maxValue(new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 1}}, 2));
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        assertEquals(10, solution.maxValue(new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 10}}, 2));
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        assertEquals(9, solution.maxValue(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}}, 3));
    }
}
