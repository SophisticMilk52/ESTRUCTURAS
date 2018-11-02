package arboles;

import java.io.Serializable;

enum Color{
	BLACK,RED
}

public class NodoRojoNegro<K extends Comparable,V> extends NodoBST implements Serializable{
	
	private Color color;
	public NodoRojoNegro(K llave, V valor){
		super(llave,valor);
		color=Color.RED;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void recorrerSubArbol(String string, NodoBST<K,V> nil) {

		if(Left!=nil)
			((NodoRojoNegro)Left).recorrerSubArbol(string+"L",nil);
		if(right!=nil)
			((NodoRojoNegro)right).recorrerSubArbol(string+"R",nil);
	}
	public Color getColor() {
		return color;
	}
	
	
}