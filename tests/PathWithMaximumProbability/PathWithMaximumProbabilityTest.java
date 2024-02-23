package PathWithMaximumProbability;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Path with Maximum Probability")
class PathWithMaximumProbabilityTest {
    PathWithMaximumProbability solution = new PathWithMaximumProbability();

    @Test
    @DisplayName("case 1")
    void case1() {
        double result = solution.maxProbability(3,
                new int[][]{{0, 1}, {1, 2}, {0, 2}},
                new double[]{0.5, 0.5, 0.2},
                0,
                2);
        assertEquals(.25, result, 1e-5);
    }

    @Test
    @DisplayName("case 2")
    void case2() {
        double result = solution.maxProbability(3,
                new int[][]{{0, 1}, {1, 2}, {0, 2}},
                new double[]{0.5, 0.5, 0.3},
                0,
                2);
        assertEquals(.3, result, 1e-5);
    }

    @Test
    @DisplayName("case 3")
    void case3() {
        double result = solution.maxProbability(3,
                new int[][]{{0, 1}},
                new double[]{0.5},
                0,
                2);
        assertEquals(0, result, 1e-5);
    }

    @Test
    @DisplayName("case 4")
    void case4() {
        double result = solution.maxProbability(5,
                new int[][]{{1, 4}, {2, 4}, {0, 4}, {0, 3}, {0, 2}, {2, 3}},
                new double[]{0.37, 0.17, 0.93, 0.23, 0.39, 0.04},
                3,
                4);
        assertEquals(0.21390, result, 1e-5);
    }
}