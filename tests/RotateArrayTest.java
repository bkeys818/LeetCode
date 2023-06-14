import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Rotate Array")
class RotateArrayTest {
    RotateArray solution = new RotateArray();
    @Test
    @DisplayName("case 1")
    void case1() {
        int[] nums = {1,2,3,4,5,6,7};
        solution.rotate(nums, 3);
        assertArrayEquals(new int[] {5,6,7,1,2,3,4}, nums);
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        int[] nums = {1,2,3,4};
        solution.rotate(nums, 6);
        assertArrayEquals(new int[] {3,4,1,2}, nums);
    }
}