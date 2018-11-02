package abb;

public class Nodo<K extends Comparable<K>, V> {

	protected V valor;
	protected K clave;
	protected Nodo<K, V> padre;
	protected Nodo<K, V> derecha;
	protected Nodo<K, V> izquierda;

	public Nodo(K k, V v) {
		clave = k;
		valor = v;
		padre = null;
		derecha = null;
		izquierda = null;

	}

	private int cantidadHijos() {
		if (izquierda != null && derecha != null) {
			return 2;
		} else if (izquierda == null && derecha == null) {
			return 0;
		} else {
			return 1;
		}
	}

	protected void agregar(K clave, V valor) {
		if (clave.compareTo(this.clave) == 0) {
			this.valor = valor;
		} else if (clave.compareTo(this.clave) < 0) {
			if (izquierda == null) {
				izquierda = new Nodo<K, V>(clave, valor);
				izquierda.padre = this;
			} else {
				izquierda.agregar(clave, valor);
			}
		} else {
			if (derecha == null) {
				derecha = new Nodo<K, V>(clave, valor);
				derecha.padre = this;
			} else {
				derecha.agregar(clave, valor);
			}
		}
	}

	private Nodo<K, V> raiz() {
		if (padre == null) {
			return this;
		} else {
			return padre.raiz();
		}
	}

	protected V buscar(K clave) {
		Nodo<K, V> buscado = buscarNodo(clave);
		if (buscado != null) {
			return buscado.valor;
		} else {
			return null;
		}
	}

	protected Nodo<K, V> buscarNodo(K clave) {
		if (clave.compareTo(this.clave) == 0) {
			return this;
		} else if (clave.compareTo(this.clave) < 0) {
			if (izquierda != null) {
				return izquierda.buscarNodo(clave);

			} else {
				return null;
			}
		} else {
			if (derecha != null) {

				return derecha.buscarNodo(clave);
			} else {
				return null;
			}
		}
	}

	private Nodo<K, V> sucesor() {
		return derecha.minimo();
	}

	private Nodo<K, V> minimo() {
		if (izquierda == null) {
			return this;
		} else {
			return izquierda.minimo();
		}

	}

	protected Nodo<K, V> eliminar(K clave) {
		if (clave.compareTo(this.clave) == 0) {
			if (padre == null) {

				int hijos = cantidadHijos();
				if (hijos == 0) {
					return null;
				} else if (hijos == 1) {
					if (derecha != null) {
						derecha.padre = null;
						return derecha;
					} else {
						izquierda.padre = null;
						return izquierda;
					}
				} else {
					Nodo<K, V> sucesor = sucesor();
					this.clave = sucesor.clave;
					this.valor = sucesor.valor;
					sucesor.eliminar(sucesor.clave);
					return this;
				}
			} else {

				int hijos = cantidadHijos();
				if (hijos == 0) {
					if (padre.izquierda == this) {
						padre.izquierda = null;
					} else {
						padre.derecha = null;
					}
				} else if (hijos == 1) {

					if (padre.izquierda == this) {

						if (izquierda != null) {
							// Es hijo izquierdo y tiene hijo izquierdo
							izquierda.padre = padre;
							padre.izquierda = izquierda;

						} else {
							// Es hijo izquierdo y tiene hijo derecho
							derecha.padre = padre;
							padre.izquierda = derecha;

						}

					} else {

						if (izquierda != null) {
							// Es hijo derecho y tiene hijo izquierdo
							izquierda.padre = padre;
							padre.derecha = izquierda;

						} else {
							// Es hijo derecho y tiene hijo derecho
							derecha.padre = padre;
							padre.derecha = derecha;

						}

					}

				} else {
					Nodo<K, V> sucesor = sucesor();
					this.clave = sucesor.clave;
					this.valor = sucesor.valor;
					sucesor.eliminar(sucesor.clave);
				}
				return raiz();

			}
		} else if (clave.compareTo(this.clave) < 0) {
			if (izquierda != null) {
				izquierda.eliminar(clave);
			}
			return raiz();
		} else {
			if (derecha != null) {
				derecha.eliminar(clave);
			}
			return raiz();
		}

	}

}
