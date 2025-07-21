package structure;

import java.util.HashMap;

public class MyHashMap<K, V> {
    private HashMap<K, V> map = new HashMap<>();

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public void displayAll() {
        for (K key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
