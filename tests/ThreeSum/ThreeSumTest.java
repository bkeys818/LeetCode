package ThreeSum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("3Sum")
class ThreeSumTest {
    ThreeSum solution = new ThreeSum();

    @Test
    @DisplayName("case 1")
    void case1() {
        int[][] converted = convert(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        int[][] expect = {{-1, -1, 2}, {-1, 0, 1}};
        assertArrayEquals(expect, converted);
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        int[][] converted = convert(solution.threeSum(new int[]{0, 1, 1}));
        int[][] expect = new int[0][];
        assertArrayEquals(expect, converted);
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        int[][] converted = convert(solution.threeSum(new int[]{0, 0, 0}));
        int[][] expect = {{0, 0, 0}};
        assertArrayEquals(expect, converted);
    }

    @Test
    @DisplayName("case 4")
    void case4() {
        int[][] converted = convert(solution.threeSum(new int[]{-2, 0, 0, 2, 2}));
        int[][] expect = {{-2, 0, 2}};
        assertArrayEquals(expect, converted);
    }

    private int[][] convert(List<List<Integer>> list) {
        return list.stream()
                .map(arr -> arr.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}