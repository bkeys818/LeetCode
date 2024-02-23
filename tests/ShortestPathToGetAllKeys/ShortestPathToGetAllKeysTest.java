package ShortestPathToGetAllKeys;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Shortest Path to Get All Keys")
class ShortestPathToGetAllKeysTest {
    ShortestPathToGetAllKeys solution = new ShortestPathToGetAllKeys();

    @Test
    @DisplayName("case 1")
    void case1() {
        assertEquals(8, solution.shortestPathAllKeys(new String[]{"@.a..", "###.#", "b.A.B"}));
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        assertEquals(6, solution.shortestPathAllKeys(new String[]{"@..aA", "..B#.", "....b"}));
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        assertEquals(-1, solution.shortestPathAllKeys(new String[]{"@Aa"}));
    }

    @Test
    @DisplayName("case 4")
    void case4() {
        assertEquals(14, solution.shortestPathAllKeys(new String[]{"Dd#b@", ".fE.e", "##.B.", "#.cA.", "aF.#C"}));
    }

    // D d # b @
    // . f E . e
    // # # . B .
    // # . c A .
    // a F . # C
}