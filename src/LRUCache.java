import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class ListNode {
        int key = -1;
        int val = -1;
        ListNode next = null;
        ListNode prev = null;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public ListNode() {
        }
    }

    private final ListNode head = new ListNode(), tail = new ListNode();
    private final Map<Integer, ListNode> nodes = new HashMap<>();
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = nodes.get(key);
        if (node == null) return -1;
        this.refresh(node);
        return node.val;
    }

    public void put(int key, int value) {
        ListNode node = nodes.get(key);
        if (node != null) {
            node.val = value;
            this.refresh(node);
        } else {
            node = new ListNode(key, value);
            nodes.put(key, node);
            add(node);
            if (nodes.size() > capacity) {
                nodes.remove(tail.prev.key);
                remove(tail.prev);
            }
        }
    }

    private void add(ListNode curr) {
        curr.next = head.next;
        head.next.prev = curr;
        head.next = curr;
        curr.prev = head;
    }

    private void remove(ListNode curr) {
        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;
    }

    private void refresh(ListNode curr) {
        remove(curr);
        add(curr);
    }
}