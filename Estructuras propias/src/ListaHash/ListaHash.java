package ListaHash;

public class ListaHash<K,V> {

	private NodoHash<K,V> inicio;

	private int tamanio;

	public void Lista() {
		inicio = null;
		tamanio = 0;
	}

	public boolean esVacia() {
		return inicio == null;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void agregarAlInicio(K k,V v) {

		NodoHash novo = new NodoHash<K,V>(k,v);
		
		if (esVacia()) {
			inicio = novo;
		} else {
			novo.setSiguiente(inicio);
			inicio = novo;
		}
		tamanio++;
	}

	public NodoHash<K,V> buscar(K key) {

		NodoHash<K,V> aux = inicio;

		boolean encontrado = false;

		while (aux != null && encontrado != true) {

			if (key.equals(aux.getKey())) {
				encontrado = true;
			} else {
				aux = (NodoHash<K,V>) aux.getSiguiente();
			}
		}
		if(!encontrado) {
			aux=new NodoHash<K,V>();
			return aux;
		}else {
			return aux;			
		}
	}

	public void Eliminar(V v) {
		if (inicio.getValor() == v) {
			inicio = (NodoHash<K,V>) inicio.getSiguiente();

		} else {
			NodoHash<K,V> aux = (NodoHash<K,V>) inicio.getSiguiente();
			NodoHash<K,V> aux2 = (NodoHash<K,V>) inicio;

			while (aux.getSiguiente() != null) {
				if (aux.getValor() == v) {
					aux2.setSiguiente(aux.getSiguiente());
				}
				aux2 = (NodoHash<K,V>) aux;
				aux = (NodoHash<K,V>) aux.getSiguiente();
			}
		}
	}

}
