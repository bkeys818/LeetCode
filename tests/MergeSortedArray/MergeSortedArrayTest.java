package MergeSortedArray;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Merge Sorted Array")
class MergeSortedArrayTest {
    MergeSortedArray solution = new MergeSortedArray();

    @Test
    @DisplayName("case 1")
    void case1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        solution.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        int[] nums1 = {1};
        solution.merge(nums1, 1, new int[0], 0);
        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        int[] nums1 = {0};
        solution.merge(nums1, 0, new int[]{1}, 1);
        assertArrayEquals(new int[]{1}, nums1);
    }
}