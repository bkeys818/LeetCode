package MinimumCostToCutAStick;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumCostToCutAStickTest {
    MinimumCostToCutAStick solution = new MinimumCostToCutAStick();

    @Test
    void minimumCostToCutAStick() {
        assertEquals(16, solution.minCost(7, new int[]{1, 3, 4, 5}));
        assertEquals(22, solution.minCost(9, new int[]{5, 6, 1, 4, 2}));
    }
}