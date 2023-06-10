public class MinStack {
    private class Node {
        int value;
        Node next, min;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node head = null;

    public void push(int val) {
        Node newNode = new Node(val, head);
        newNode.min = head != null && head.min.value < val ? head.min : newNode;
        head = newNode;
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min.value;
    }
}