package GasStation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Gas Station")
class GasStationTest {
    GasStation solution = new GasStation();

    @Test
    @DisplayName("case 1")
    void case1() {
        assertEquals(3, solution.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        assertEquals(-1, solution.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
