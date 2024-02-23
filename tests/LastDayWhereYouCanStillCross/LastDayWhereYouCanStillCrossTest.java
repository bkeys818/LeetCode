package LastDayWhereYouCanStillCross;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Last Day Where You Can Still Cross")
class LastDayWhereYouCanStillCrossTest {
    LastDayWhereYouCanStillCross solution = new LastDayWhereYouCanStillCross();

    @Test
    @DisplayName("case 1")
    void case1() {
        assertEquals(2, solution.latestDayToCross(2, 2, new int[][]{{1, 1}, {2, 1}, {1, 2}, {2, 2}}));
    }
}
