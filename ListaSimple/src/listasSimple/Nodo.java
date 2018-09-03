package listasSimple;

public class Nodo<K, V> {
	private K siguiente;

	private V valor;

	public Nodo() {
		super();
		this.valor = null;
		this.siguiente = null;
	}

	public V getValor() {
		return valor;
	}

	public void setValor(V valor) {
		this.valor = valor;
	}

	public K getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(K siguiente) {
		this.siguiente = siguiente;
	}
}