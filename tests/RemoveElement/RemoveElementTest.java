package RemoveElement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.sort;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Remove Element")
class RemoveElementTest {
    RemoveElement solution = new RemoveElement();

    @Test
    @DisplayName("case 1")
    void case1() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int[] expectedNums = {2, 2};
        int k = solution.removeElement(nums, val);
        assertEquals(expectedNums.length, k);
        sort(nums, 0, k);
        for (int i = 0; i < expectedNums.length; i++) {
            assertEquals(nums[i], expectedNums[i]);
        }
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int[] expectedNums = {0, 0, 1, 3, 4};
        int k = solution.removeElement(nums, val);
        assertEquals(expectedNums.length, k);
        sort(nums, 0, k);
        for (int i = 0; i < expectedNums.length; i++) {
            assertEquals(nums[i], expectedNums[i]);
        }
    }
}