package RemoveDuplicatesFromSortedArrayII;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.sort;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Remove Duplicates from Sorted Array II")
class RemoveDuplicatesFromSortedArrayIITest {
    RemoveDuplicatesFromSortedArrayII solution = new RemoveDuplicatesFromSortedArrayII();

    @Test
    @DisplayName("case 1")
    void case1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] expectedNums = {1, 1, 2, 2, 3};
        int k = solution.removeDuplicates(nums);
        assertEquals(expectedNums.length, k);
        for (int i = 0; i < expectedNums.length; i++) {
            assertEquals(nums[i], expectedNums[i]);
        }
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] expectedNums = {0, 0, 1, 1, 2, 3, 3};
        int k = solution.removeDuplicates(nums);
        assertEquals(expectedNums.length, k);
        for (int i = 0; i < expectedNums.length; i++) {
            assertEquals(nums[i], expectedNums[i]);
        }
    }
}