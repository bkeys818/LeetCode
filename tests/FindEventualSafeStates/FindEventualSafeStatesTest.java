package FindEventualSafeStates;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


@DisplayName("Find Eventual Safe States")
class FindEventualSafeStatesTest {
    FindEventualSafeStates solution = new FindEventualSafeStates();

    @Test
    @DisplayName("case 1")
    void case1() {
        List<Integer> response = solution.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}});
        assertArrayEquals(new int[]{2, 4, 5, 6}, response.stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        List<Integer> response = solution.eventualSafeNodes(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}});
        assertArrayEquals(new int[]{4}, response.stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        List<Integer> response = solution.eventualSafeNodes(new int[][]{{}, {0, 2, 3, 4}, {3}, {4}, {}});
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, response.stream().mapToInt(Integer::intValue).toArray());
    }
}
