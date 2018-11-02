package arboles;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class NodoBST <K extends Comparable, V> implements Comparable, Serializable{

	protected K key;
	protected V value;
	protected int hight;
	protected NodoBST<K,V> Father;
	protected NodoBST<K,V> right;
	protected NodoBST<K,V> Left;
	protected NodoBST<K,V> clon;
	
	public NodoBST (K llave, V value) {
		this.key = llave;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public NodoBST<K, V> getFather() {
		return Father;
	}

	public void setFather(NodoBST<K, V> Father) {
		this.Father = Father;
	}

	public NodoBST<K, V> getRight() {
		return right;
	}

	public void setRight(NodoBST<K, V> right) {
		this.right = right;
	}

	public NodoBST<K, V> getLeft() {
		return Left;
	}

	public void setLeft(NodoBST<K, V> Left) {
		this.Left = Left;
	}

	public NodoBST<K, V> getClon() {
		return clon;
	}

	public void setClon(NodoBST<K, V> clon) {
		this.clon = clon;
	}
	
	public void actualizarhight() {
		if(right==null && Left==null) {
			hight=-1;
		}else if(right==null) {
			hight=Left.hight;
		}else if(Left==null) {
			hight=right.hight;
		}else {
			hight=Math.max(right.hight,Left.hight);
		}
		hight++;
	}
	
	public void Preorder(ArrayList<V> e) {
		e.add(getValue());
		if(Left.getValue() != null) {
			Left.Preorder(e);
		}
		if(right.getValue() != null) {
			right.Preorder(e); 
		}
	}
		
	@Override
	public int compareTo(Object o) {
		return key.compareTo(((NodoBST)o).key);
	}
	
}