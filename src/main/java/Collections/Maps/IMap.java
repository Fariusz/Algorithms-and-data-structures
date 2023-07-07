package Collections.Maps;

public interface IMap<K, V> {
    V get(K key);

    V delete(K key);

    void add(K key, V value);
}
