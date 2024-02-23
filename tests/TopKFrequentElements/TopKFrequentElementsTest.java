package TopKFrequentElements;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TopKFrequentElementsTest {
    @Test
    void topKFrequent() {
        TopKFrequentElements solution = new TopKFrequentElements();
        assertArrayEquals(new int[] {1, 2}, solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
        assertArrayEquals(new int[] {1}, solution.topKFrequent(new int[]{1}, 1));
    }
}