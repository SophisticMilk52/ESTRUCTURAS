package ListaHash;

public class NodoHash<K,V> {
	private NodoHash siguiente;
	
	private V valor;
	private K key;
	
	public NodoHash(K k,V val) {
		super();
		valor=val;
		key=k;
	}
	public NodoHash() {
		super();
	}

	public V getValor() {
		return valor;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValor(V valor) {
		this.valor = valor;
	}

	public NodoHash getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoHash siguiente) {
		this.siguiente = siguiente;
	}
}