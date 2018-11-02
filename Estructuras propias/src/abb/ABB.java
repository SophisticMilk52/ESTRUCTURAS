package abb;

public class ABB<K extends Comparable<K>, V> {

	protected Nodo<K, V> raiz;

	public ABB() {
		raiz = null;
	}

	public void agregar(K clave, V valor) {
		if (raiz != null) {

			raiz.agregar(clave, valor);

		} else {
			raiz = new Nodo<K, V>(clave, valor);
		}
	}

	public V buscar(K clave) {
		if (raiz != null) {
			return raiz.buscar(clave);
		} else {
			return null;
		}
	}

	public void eliminar(K clave) {
		if (raiz != null) {
			raiz = raiz.eliminar(clave);
		}

	}

}
