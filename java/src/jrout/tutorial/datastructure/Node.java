package jrout.tutorial.datastructure;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        setNext(null);
    }

    public Node<T> getNext() {
        return this.next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
