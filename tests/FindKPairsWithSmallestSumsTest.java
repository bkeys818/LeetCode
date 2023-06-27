import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

@DisplayName("Find K Pairs with Smallest Sums")
class FindKPairsWithSmallestSumsTest {
    FindKPairsWithSmallestSums solution = new FindKPairsWithSmallestSums();

    @Test
    @DisplayName("case 1")
    void case1() {
        List<List<Integer>> response = solution.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        int[][] arr = response.stream().map(a -> a.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        assertArrayEquals(new int[][]{{1, 2}, {1, 4}, {1, 6}}, arr);
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        List<List<Integer>> response = solution.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2);
        int[][] arr = response.stream().map(a -> a.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        assertArrayEquals(new int[][]{{1, 1}, {1, 1}}, arr);
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        List<List<Integer>> response = solution.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3);
        int[][] arr = response.stream().map(a -> a.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        assertArrayEquals(new int[][]{{1, 3}, {2, 3}}, arr);
    }

    @Test
    @DisplayName("case 4")
    void case4() {
        List<List<Integer>> response = solution.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10);
        int[][] arr = response.stream().map(a -> a.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        int[][] expected = {{1, 1}, {1, 1}, {2, 1}, {1, 2}, {1, 2}, {2, 2}, {1, 3}, {1, 3}, {2, 3}};
        Arrays.sort(arr, this::comparePairs);
        Arrays.sort(expected, this::comparePairs);
        assertArrayEquals(expected, arr);
    }

    private int comparePairs(int[] a, int[] b) {
        int diff = (a[0] + a[1]) - (b[0] + b[1]);
        if (diff == 0) return a[0] - b[0];
        else return diff;
    }
}