import javafx.util.Pair;

import java.util.*;

public class ShortestPathToGetAllKeys {
    public int shortestPathAllKeys(String[] grid) {
        int h = grid.length, w = grid[0].length();
        Set<Character> keySet = new HashSet<>();
        Set<Character> lockSet = new HashSet<>();
        /*
           Using the bit value to represent what keys exist.
           Ex: '001010' means 'b' and 'd' exist.
         */
        int allKeys = 0;
        int startR = -1, startC = -1;
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                char cell = grid[r].charAt(c);
                if ('a' <= cell && cell <= 'f') {
                    keySet.add(cell);
                    allKeys += 1 << (cell - 'a');
                } else if ('A' <= cell && cell <= 'F') {
                    lockSet.add(cell);
                } else if (cell == '@') {
                    startR = r;
                    startC = c;
                }
            }
        }

        Set<Character> myKeys = new HashSet<>();
        Set<Character> lockedLocks = new HashSet<>(lockSet);


        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>(); // [row, column, keyState, dist]
        Map<Integer, Set<Pair<Integer, Integer>>> seen = new HashMap<>(); // use keyState as keys

        queue.offer(new int[]{startR, startC, 0, 0});
        seen.put(0, new HashSet<>());
        seen.get(0).add(new Pair<>(startR, startC));

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1], keyState = current[2], dist = current[3];
            for (int[] dir : dirs) {
                int nR = r + dir[0], nC = c + dir[1];
                if (0 <= nR && nR < h && 0 <= nC && nC < w && grid[nR].charAt(nC) != '#') {
                    char cell = grid[nR].charAt(nC);

                    // If cell is a key.
                    if (keySet.contains(cell)) {
                        // If the keys already been collected, no need to visit this cell.
                        if (((1 << (cell - 'a')) & keyState) != 0)
                            continue;
                        // Otherwise, we'll pick up the key.
                        int newKeyState = (keyState | (1 << (cell - 'a')));
                        // If all the keys have been collected, return distance.
                        if (newKeyState == allKeys) return dist + 1;
                        // Otherwise, add this state to seen and queue.
                        seen.putIfAbsent(newKeyState, new HashSet<>());
                        seen.get(newKeyState).add(new Pair<>(nR, nC));
                        queue.offer(new int[]{nR, nC, newKeyState, dist + 1});

                        myKeys.add(cell); // delete me
                    }

                    // If cell is a lock we don't have the key to.
                    if (lockSet.contains(cell) && (keyState & (1 << (cell - 'A'))) == 0)
                        continue;

                        // If we haven't been here (with this keyState)
                    else if (!seen.get(keyState).contains(new Pair<>(nR, nC))) {
                        seen.get(keyState).add(new Pair<>(nR, nC));
                        queue.offer(new int[]{nR, nC, keyState, dist + 1});

                        // delete me
                        if ('A' <= cell && cell <= 'F')
                            lockedLocks.remove(cell);
                    }
                }
            }
        }

        return -1;
    }
}