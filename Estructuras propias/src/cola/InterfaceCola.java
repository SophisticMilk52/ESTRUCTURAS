package cola;

import ListaHash.NodoHash;
import ListaSimple.Nodo;

public interface InterfaceCola <V> {
	//insertar
public void add(V v);

//extraer
public void removeFisrt();

//consultar el frente
public Nodo<V> peek();

public boolean IsEmpty();
}
