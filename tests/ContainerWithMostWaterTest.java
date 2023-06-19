import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Container With Most Water")
class ContainerWithMostWaterTest {
    ContainerWithMostWater solution = new ContainerWithMostWater();

    @Test
    @DisplayName("case 1")
    void case1() {
        assertEquals(49, solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        assertEquals(1, solution.maxArea(new int[]{1, 1}));
    }
}