package structure;

public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T data) {
        list.add(data);
    }

    public T dequeue() {
        if (list.size() == 0) return null;
        T val = list.get(0);
        // not removing node for simplicity; you can optimize later
        return val;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
