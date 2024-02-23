package ShortestBridge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestBridgeTest {
    ShortestBridge solution = new ShortestBridge();

    @Test
    void shortestBridge() {
        assertEquals(1, solution.shortestBridge(new int[][]{
                {0, 1, 1},
                {1, 1, 0},
                {0, 0, 1}
        }));
        assertEquals(2, solution.shortestBridge(new int[][]{
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 1}
        }));
        assertEquals(4, solution.shortestBridge(new int[][]{
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}
        }));
    }
}