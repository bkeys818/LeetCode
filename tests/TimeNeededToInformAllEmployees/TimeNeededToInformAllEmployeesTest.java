package TimeNeededToInformAllEmployees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Time Needed to Inform All Employees")
class TimeNeededToInformAllEmployeesTest {
    @Test
    @DisplayName("case 1")
    void case1() {
        TimeNeededToInformAllEmployees solution = new TimeNeededToInformAllEmployees();
        assertEquals(0, solution.numOfMinutes(
                1,
                0,
                new int[]{-1},
                new int[]{0}
        ));
    }

    @Test
    @DisplayName("case 1")
    void case2() {
        TimeNeededToInformAllEmployees solution = new TimeNeededToInformAllEmployees();
        assertEquals(1, solution.numOfMinutes(
                6,
                2,
                new int[]{2, 2, -1, 2, 2, 2},
                new int[]{0, 0, 1, 0, 0, 0}
        ));
    }
}