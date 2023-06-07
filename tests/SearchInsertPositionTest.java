import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Search Insert Position")
class SearchInsertPositionTest {
    SearchInsertPosition solution = new SearchInsertPosition();

    @Test
    @DisplayName("case 1")
    void case1() {
        assertEquals(2, solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        assertEquals(1, solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        assertEquals(4, solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}