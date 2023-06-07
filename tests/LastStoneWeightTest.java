import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Last Stone Weight")
class LastStoneWeightTest {
    LastStoneWeight solution = new LastStoneWeight();

    @Test
    @DisplayName("case 1")
    void case1() {
        assertEquals(1, solution.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
}