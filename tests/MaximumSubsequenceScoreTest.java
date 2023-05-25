import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSubsequenceScoreTest {
    MaximumSubsequenceScore solution = new MaximumSubsequenceScore();
    int[] nums1, nums2;
    @Test
    void maxScore() {
        nums1 = new int[] {1,3,3,2};
        nums2 = new int[] {2,1,3,4};
        assertEquals(12, solution.maxScore(nums1, nums2, 3));
        nums1 = new int[] {4,2,3,1,1};
        nums2 = new int[] {7,5,10,9,6};
        assertEquals(30, solution.maxScore(nums1, nums2, 1));
    }
}