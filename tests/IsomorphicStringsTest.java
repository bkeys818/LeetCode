import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Isomorphic Strings")
class IsomorphicStringsTest {
    IsomorphicStrings solution = new IsomorphicStrings();

    @Test
    @DisplayName("case 1")
    void case1() {
        assertTrue(solution.isIsomorphic("egg", "add"));
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        assertFalse(solution.isIsomorphic("foo", "bar"));
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        assertTrue(solution.isIsomorphic("paper", "title"));
    }

    @Test
    @DisplayName("case 4")
    void case4() {
        assertFalse(solution.isIsomorphic("badc", "baba"));
    }
}