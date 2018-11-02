package pila;

public interface  InterfacePila <V> {
public void Push(V v);
public V Pop()throws Exception;
public V Top() ;
public boolean IsEmpty();

}
