package HashTable;

public interface InterfaceHashTable <K,V> {

public V get(K Key);
public boolean put(K key, V value);
public boolean IsEmpty();
public int elementsCount();
}
