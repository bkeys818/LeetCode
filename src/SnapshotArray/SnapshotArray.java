package SnapshotArray;

import java.util.TreeMap;

class SnapshotArray {
    private int i = 0;
    private final TreeMap<Integer,Integer>[] history;
    public SnapshotArray(int length) {
        this.history = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            history[i] = new TreeMap<Integer,Integer>();
            history[i].put(0,0);
        }
    }

    public void set(int index, int val) {
        history[index].put(i, val);
    }

    public int snap() {
        return i++;
    }

    public int get(int index, int snap_id) {
        return history[index].floorEntry(snap_id).getValue();
    }
}