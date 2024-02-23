package FindEventualSafeStates;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> neighborsList = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            neighborsList.add(new ArrayList<>());
            for (int node : graph[i])
                neighborsList.get(i).add(node);
        }

        boolean[] visited = new boolean[graph.length];
        boolean[] inStack = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            isSafe(i, neighborsList, visited, inStack);
        }

        List<Integer> safe = new ArrayList<>();
        for (int i = 0; i < graph.length; i++)
            if (!inStack[i])
                safe.add(i);
        return safe;
    }

    private boolean isSafe(int i, List<List<Integer>> neighborsList, boolean[] visited, boolean[] inStack) {
        if (inStack[i]) return false;
        if (visited[i]) return true;
        inStack[i] = true;
        visited[i] = true;
        for (int neighbor : neighborsList.get(i))
            if (!isSafe(neighbor, neighborsList, visited, inStack))
                return false;
        inStack[i] = false;
        return true;
    }
}