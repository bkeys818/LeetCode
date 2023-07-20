import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean addToStack = true;
            while (!stack.empty() && stack.peek() >= 0 && asteroid < 0) {
                int diff = stack.peek() - Math.abs(asteroid);
                if (diff <= 0) stack.pop();
                if (diff >= 0) {
                    addToStack = false;
                    break;
                }
            }
            if (addToStack) stack.push(asteroid);
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}