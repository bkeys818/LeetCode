package StoneGameII;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StoneGameIITest {
    StoneGameII solution = new StoneGameII();
    @Test
    void stoneGameII() {
        assertEquals(10, solution.stoneGameII(new int[] {2,7,9,4,4}));
        assertEquals(104, solution.stoneGameII(new int[] {1,2,3,4,5,100}));
    }
}