import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Jump Game")
class JumpGameTest {
    JumpGame solution = new JumpGame();

    @Test
    @DisplayName("case 1")
    void case1() {
        assertTrue(solution.canJump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        assertFalse(solution.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        assertTrue(solution.canJump(new int[]{2, 5, 0, 0}));
    }
}