package ListaSimple;

public class Lista<V> {

	private Nodo<V> inicio;

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
		Nodo novo = new Nodo< V>();
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


	public Nodo<V> buscar(V referencia) {

		Nodo<V> aux = inicio;

		boolean encontrado = false;

		while (aux != null && encontrado != true) {

			if (referencia == aux.getValor()) {

				encontrado = true;
			} else {
//guarda un null en el ultimo caso
				aux = (Nodo<V>) aux.getSiguiente();
			}
		}

		return aux;
	}

	public void Eliminar(V v) {
		boolean encontre= false;
		if (inicio.getValor() == v) {
			inicio = (Nodo<V>) inicio.getSiguiente();
			encontre=true;
		} else {
			Nodo<V> aux = (Nodo< V>) inicio.getSiguiente();
			Nodo<V> aux2 = (Nodo< V>) inicio;
			while (aux != null && !encontre) {
				if (aux.getValor() == v) {
					aux2.setSiguiente(aux.getSiguiente());
					encontre=true;
				}else {
					//guarda un null en el ultimo caso
					aux2 = (Nodo<V>) aux;
					aux = (Nodo<V>) aux.getSiguiente();
				}
			}
		}
		if(encontre) {
			tamanio--;
		}
	}
}