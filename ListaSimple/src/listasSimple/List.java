package listasSimple;

public class List<K, V> {

	private Nodo<K, V> inicio;

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

	
	public void agregarAlFinal(V v) {
		Nodo novo = new Nodo<K, V>();
		if (esVacia()) {
			inicio = novo;
		} else {
			Nodo aux = inicio;

			while (aux.getSiguiente() != null) {
				aux = (Nodo) aux.getSiguiente();
			}

			aux.setSiguiente(novo);
		}

		tamanio++;
	}

	public void agregarAlInicio(V v) {

		Nodo novo = new Nodo<K, V>();
Nodo aux= null;
		if (esVacia()) {

			inicio = novo;

		} else {

			inicio.setSiguiente((K) inicio);

			inicio = novo;
		}

		tamanio++;
	}

	public Nodo<K, V> buscar(V referencia) {

		Nodo<K, V> aux = inicio;

		boolean encontrado = false;

		while (aux != null && encontrado != true) {

			if (referencia == aux.getValor()) {

				encontrado = true;
			} else {

				aux = (Nodo<K, V>) aux.getSiguiente();
			}
		}

		return aux;
	}

	public void Eliminar(V v) {
		if (inicio.getValor() == v) {
			inicio = (Nodo<K, V>) inicio.getSiguiente();

		} else {
			Nodo<K, V> aux = (Nodo<K, V>) inicio.getSiguiente();
			Nodo<K, V> aux2 = (Nodo<K, V>) inicio;

			while (aux.getSiguiente() != null) {
				if (aux.getValor() == v) {
					aux2.setSiguiente(aux.getSiguiente());
				}
				aux2 = (Nodo<K, V>) aux;
				aux = (Nodo<K, V>) aux.getSiguiente();
			}
		}
	}

}
