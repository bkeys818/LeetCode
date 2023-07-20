import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Asteroid Collision")
class AsteroidCollisionTest {
    AsteroidCollision solution = new AsteroidCollision();

    @Test
    @DisplayName("case 1")
    void case1() {
        assertArrayEquals(new int[]{5, 10}, solution.asteroidCollision(new int[]{5, 10, -5}));
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        assertArrayEquals(new int[]{5, 10}, solution.asteroidCollision(new int[]{5, 10, -5}));
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        assertArrayEquals(new int[0], solution.asteroidCollision(new int[]{8, -8}));
    }

    @Test
    @DisplayName("case 4")
    void case4() {
        assertArrayEquals(new int[]{10}, solution.asteroidCollision(new int[]{10, 2, -5}));
    }

    @Test
    @DisplayName("case 5")
    void case5() {
        assertArrayEquals(new int[]{-2, -2, -2}, solution.asteroidCollision(new int[]{-2, -2, 1, -2}));
    }

    @Test
    @DisplayName("case 6")
    void case6() {
        assertArrayEquals(new int[]{-2, 1}, solution.asteroidCollision(new int[]{-2, 1, 1, -1}));
    }
}