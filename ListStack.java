import java.util.EmptyStackException;

public class ListStack implements BKStack {
    private Node top;
    private int size;

    private class Node {
        double data;
        Node next;

        Node(double data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int count() {
        return size;
    }

    @Override
    public void push(double d) {
        Node newNode = new Node(d);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public double pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        double poppedValue = top.data;
        top = top.next;
        size--;
        return poppedValue;
    }

    public double peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

}
