package PeakIndexInAMountainArray;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Peak Index in a Mountain Array")
class PeakIndexInAMountainArrayTest {
    PeakIndexInAMountainArray solution = new PeakIndexInAMountainArray();
    @Test
    @DisplayName("case 1")
    void case1() {
        assertEquals(1, solution.peakIndexInMountainArray(new int[] {0,1,0}));
    }

    @Test
    @DisplayName("case 2")
    void cas21() {
        assertEquals(1, solution.peakIndexInMountainArray(new int[] {0,2,1,0}));
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        assertEquals(1, solution.peakIndexInMountainArray(new int[] {0,10,5,2}));
    }
}