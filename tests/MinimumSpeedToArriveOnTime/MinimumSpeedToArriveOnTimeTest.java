package MinimumSpeedToArriveOnTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Minimum Speed to Arrive on Time")
class MinimumSpeedToArriveOnTimeTest {
    MinimumSpeedToArriveOnTime solution = new MinimumSpeedToArriveOnTime();
    @Test
    @DisplayName("case 1")
    void case1() {
        assertEquals(1, solution.minSpeedOnTime(new int[] {1,3,2}, 6));
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        assertEquals(3, solution.minSpeedOnTime(new int[] {1,3,2}, 2.7));
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        assertEquals(-1, solution.minSpeedOnTime(new int[] {1,3,2}, 1.9));
    }

    @Test
    @DisplayName("case 4")
    void case4() {
        assertEquals(10000000, solution.minSpeedOnTime(new int[] {1,1,100000}, 2.01));
    }
}