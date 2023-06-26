import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Total Cost to Hire K Workers")
class TotalCostToHireKWorkersTest {
    TotalCostToHireKWorkers solution = new TotalCostToHireKWorkers();

    @Test
    @DisplayName("case 1")
    void case1() {
        assertEquals(11, solution.totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        assertEquals(4, solution.totalCost(new int[]{1, 2, 4, 1}, 3, 3));
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        assertEquals(526, solution.totalCost(new int[]{57, 33, 26, 76, 14, 67, 24, 90, 72, 37, 30}, 11, 2));
    }
}