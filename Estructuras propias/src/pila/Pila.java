package pila;


import ListaSimple.Nodo;

public class Pila<V> implements InterfacePila <V> {
	
	private int size;
	private Nodo<V> top;

	public Pila() {
		size = 0;
	}

	@Override
	public void Push(V v) {
		Nodo nuevo = new Nodo();
		nuevo.setValor(v);
		if (this.IsEmpty()) {
			top = nuevo;
		} else {
			nuevo.setSiguiente(top);
			top = nuevo;
		}
		size++;
	}

	@Override
	public V Pop() {
		V val=null;
		if (!this.IsEmpty()) {
			val=top.getValor();
			top = (Nodo) top.getSiguiente();
			size--;
		}
		return val;
	}

	@Override
	public V Top() {
		if (!this.IsEmpty()) {
			return top.getValor();
		} else {
			return null;
		}
	}

	@Override
	public boolean IsEmpty() {
		boolean control = false;
		if (this.getSize() == 0) {
			control = true;
		}
		return control;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}