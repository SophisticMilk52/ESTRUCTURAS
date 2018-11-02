package arboles;

public interface IBST <K extends Comparable, V> {

	public void insert(K key, V value);
	public NodoBST<K,V> delete(K key);
	
}