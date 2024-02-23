package MergeIntervals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Merge Intervals")
class MergeIntervalsTest {
    MergeIntervals solution = new MergeIntervals();

    @Test
    @DisplayName("case 1")
    void case1() {
        assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}},
                solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        assertArrayEquals(new int[][]{{1, 5}},
                solution.merge(new int[][]{{1, 4}, {4, 5}}));
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        assertArrayEquals(new int[][]{{0, 4}},
                solution.merge(new int[][]{{1, 4}, {0, 4}}));
    }

    @Test
    @DisplayName("case 4")
    void case4() {
        assertArrayEquals(new int[][]{{0, 4}},
                solution.merge(new int[][]{{1, 4}, {0, 1}}));
    }

    @Test
    @DisplayName("case 5")
    void case5() {
        assertArrayEquals(new int[][]{{0, 0}, {1, 4}},
                solution.merge(new int[][]{{1, 4}, {0, 0}}));
    }
}
