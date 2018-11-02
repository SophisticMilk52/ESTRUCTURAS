package cola;

import ListaHash.NodoHash;
import ListaSimple.Nodo;

public class Cola <V> implements InterfaceCola <V> {
	private int size;
	private Nodo<V> root,end;

	public Cola() {
		super();
		size=0;
		root=null;
	}

	@Override
	public void add(V v) {
	    Nodo<V> nuevo;
        nuevo = new Nodo();
        nuevo.setValor(v);
        nuevo.setSiguiente(null);
        if (this.IsEmpty()) {
            root = nuevo;
            end = nuevo;
            size++;
        } else {
        	Nodo aux=  (Nodo) root.getSiguiente();
        	while (aux!=null) {
        		if(aux.getSiguiente()==null) {
        			aux.setSiguiente(nuevo);
        		     end = nuevo;
        		     size++;
        		}
				aux=(Nodo) aux.getSiguiente();
			}
        }
	}



	@Override
	public void removeFisrt(){
		  if (!this.IsEmpty())
	        {
	        root= (Nodo<V>) root.getSiguiente();
	        size--;
	        }
	}



	@Override
	public Nodo<V> peek() {
		return root;
	}

	@Override
	public boolean IsEmpty() {
		if (root == null)
			return true;
		else
			return false;
	}
	public int getSize() {
		return size;
	}

}
