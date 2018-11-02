package ListaSimple;

	public class Nodo<V> {
		private V valor;
private Nodo siguiente;
		public Nodo() {
			super();
			this.valor = null;
		
		}

		public V getValor() {
			return valor;
		}

		public void setValor(V valor) {
			this.valor = valor;
		}

		public Nodo getSiguiente() {
			return siguiente;
		}

		public void setSiguiente(Nodo siguiente) {
			this.siguiente = siguiente;
		}
	

}
