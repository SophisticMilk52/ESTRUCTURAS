package arboles;

import java.io.Serializable;

public class NodoAVL<K, V> extends NodoBST implements Serializable {

	private int balanceFactor;

	public NodoAVL(K llave, V valor) {
		super((Comparable) llave, valor);
		balanceFactor = 0;
	}

	public void setBalanceFactor(int t) {
		balanceFactor = t;
	}

	public void UpdateFactorBalance() {
		if (right == null && Left == null) {
			balanceFactor = 0;
		} else if (right == null) {
			balanceFactor = Left.hight;
		} else if (Left == null) {
			balanceFactor = -right.hight;
		} else {
			balanceFactor = Left.hight - right.hight;
		}
	}

	public int balanceFactor() {
		if (right == null && Left == null) {

		}
		return balanceFactor;
	}

	public void recorrerSubArbol(String string, NodoAVL nil) {
		System.out.println(string + "color: " + getValue() + " " + key);
		if (Left != nil)
			((NodoAVL) Left).recorrerSubArbol(string + "L", nil);
		if (right != nil)
			((NodoAVL) right).recorrerSubArbol(string + "R", nil);
	}
}