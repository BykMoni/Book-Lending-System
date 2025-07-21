package structure;

public class MyArrayList<T> {
    private Object[] data;
    private int size = 0;

    public MyArrayList() {
        data = new Object[10];
    }

    public void add(T item) {
        if (size == data.length) resize();
        data[size++] = item;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public int size() {
        return size;
    }

    private void resize() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
}
