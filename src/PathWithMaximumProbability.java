import javafx.util.Pair;

import java.util.*;

public class PathWithMaximumProbability {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        for (int i = 0; i < succProb.length; i++)
            succProb[i] = Math.log(succProb[i]);

        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, succProb[i]));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, succProb[i]));
        }

        double[] maxProb = new double[n];
        Arrays.fill(maxProb, Double.MIN_EXPONENT);
        maxProb[start] = 0; // Math.log(1) == 0

        Queue<Pair<Double, Integer>> heap = new PriorityQueue<>((a, b) -> -Double.compare(a.getKey(), b.getKey()));
        heap.offer(new Pair<>(0.0, start));

        while (!heap.isEmpty()) {

            Pair<Double, Integer> current = heap.poll();
            double cProb = current.getKey();
            int cNode = current.getValue();

            if (cNode == end) return Math.pow(Math.E, cProb);

            if (graph.containsKey(cNode))
                for (Pair<Integer, Double> nxt : graph.get(cNode)) {
                    int nxtNode = nxt.getKey();
                    double pathProb = nxt.getValue();
                    double altProb = cProb + pathProb;
                    if (altProb > maxProb[nxtNode]) {
                        maxProb[nxtNode] = altProb;
                        heap.add(new Pair<>(altProb, nxtNode));
                    }
                }
        }
        return 0;
    }
}