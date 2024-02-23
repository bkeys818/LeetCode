package LongestIncreasingSubsequence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Longest Increasing Subsequence")
class LongestIncreasingSubsequenceTest {
    LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();

    @Test
    @DisplayName("case 1")
    void case1() {
        assertEquals(4, solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        assertEquals(4, solution.lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        assertEquals(1, solution.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}