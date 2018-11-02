package arboles;

import java.io.Serializable;
import java.util.ArrayList;


public class ArbolRojoNegro<K extends Comparable,V> extends ArbolBST<K,V> implements Serializable{
	
	public ArbolRojoNegro(){
		super();
		nil=new NodoRojoNegro<>(null,null);
		nil.setFather(nil);
		nil.setRight(nil);
		nil.setLeft(nil);
		((NodoRojoNegro<K, V>) nil).setColor(Color.BLACK);
		root=nil;
	}
	
	private void deleteFixeUp(NodoRojoNegro<K,V> x) {
		while(x!=root && x.getColor()==Color.BLACK) {
			if(x==x.getFather().getLeft()) {
				NodoRojoNegro<K, V> w=(NodoRojoNegro<K, V>)x.getFather().getRight();
				if(w.getColor()==Color.RED) {
					w.setColor(Color.BLACK);
					((NodoRojoNegro<K,V>)x.getFather()).setColor(Color.RED);
					LeftRotate(x.getFather());
					w=((NodoRojoNegro<K,V>)x.getFather().getRight());
				}
				if(((NodoRojoNegro<K,V>)w.getLeft()).getColor()==Color.BLACK &&
						((NodoRojoNegro<K,V>)w.getRight()).getColor()==Color.BLACK) {
					w.setColor(Color.RED);
					x=(NodoRojoNegro<K,V>)x.getFather();
				}else{
					if(((NodoRojoNegro<K,V>)w.getRight()).getColor()==Color.BLACK) {
						((NodoRojoNegro<K,V>)w.getLeft()).setColor(Color.BLACK);
						w.setColor(Color.RED);
						rightRotate(w);
						w=(NodoRojoNegro<K, V>) x.getFather().getRight();
					}
					w.setColor(((NodoRojoNegro<K, V>)x.getFather()).getColor());
					((NodoRojoNegro<K, V>)x.getFather()).setColor(Color.BLACK);
					((NodoRojoNegro<K, V>)w.getRight()).setColor(Color.BLACK);
					LeftRotate(x.getFather());
					x=(NodoRojoNegro<K, V>) root;
				}
			}else {
				NodoRojoNegro<K, V> w=(NodoRojoNegro<K, V>)x.getFather().getLeft();
				if(w.getColor()==Color.RED) {
					w.setColor(Color.BLACK);
					((NodoRojoNegro<K,V>)x.getFather()).setColor(Color.RED);
					rightRotate(x.getFather());
					w=((NodoRojoNegro<K,V>)x.getFather().getLeft());
				}
				if(((NodoRojoNegro<K,V>)w.getRight()).getColor()==Color.BLACK &&
						((NodoRojoNegro<K,V>)w.getLeft()).getColor()==Color.BLACK) {
					w.setColor(Color.RED);
					x=(NodoRojoNegro<K,V>)x.getFather();
				}else {
					if(((NodoRojoNegro<K,V>)w.getLeft()).getColor()==Color.BLACK) {
						((NodoRojoNegro<K,V>)w.getRight()).setColor(Color.BLACK);
						w.setColor(Color.RED);
						LeftRotate(w);
						w=(NodoRojoNegro<K, V>) x.getFather().getLeft();
					}
					w.setColor(((NodoRojoNegro<K, V>)x.getFather()).getColor());
					((NodoRojoNegro<K, V>)x.getFather()).setColor(Color.BLACK);
					((NodoRojoNegro<K, V>) w.getLeft()).setColor(Color.BLACK);
					rightRotate(x.getFather());
					x=(NodoRojoNegro<K, V>) root;
				}
			}
		}
		x.setColor(Color.BLACK);
	}
	
	private void insertFixeUp(NodoRojoNegro<K, V> z) {
		while(((NodoRojoNegro<K, V>) z.getFather()).getColor()==Color.RED){
			if(z.getFather()==z.getFather().getFather().getLeft()){
				NodoRojoNegro<K,V> y =(NodoRojoNegro<K, V>) z.getFather().getFather().getRight();
				if(y.getColor()==Color.RED){
					((NodoRojoNegro<K, V>) z.getFather()).setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					((NodoRojoNegro<K, V>) z.getFather().getFather()).setColor(Color.RED);
					z=(NodoRojoNegro<K, V>) z.getFather().getFather();
				}else if(z==z.getFather().getRight()){
					z=(NodoRojoNegro<K, V>) z.getFather();
					LeftRotate(z);
				}else{
					((NodoRojoNegro<K, V>) z.getFather()).setColor(Color.BLACK);
					((NodoRojoNegro<K, V>) z.getFather().getFather()).setColor(Color.RED);
					rightRotate(z.getFather().getFather());
				}
			}else{
				NodoRojoNegro<K,V> y =(NodoRojoNegro<K, V>) z.getFather().getFather().getLeft();
				if(y.getColor()==Color.RED){
					((NodoRojoNegro<K, V>) z.getFather()).setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					((NodoRojoNegro<K, V>) z.getFather().getFather()).setColor(Color.RED);
					z=(NodoRojoNegro<K, V>) z.getFather().getFather();
				}else if(z==z.getFather().getLeft()){
					z=(NodoRojoNegro<K, V>) z.getFather();
					rightRotate(z);
				}else{
					((NodoRojoNegro<K, V>) z.getFather()).setColor(Color.BLACK);
					((NodoRojoNegro<K, V>) z.getFather().getFather()).setColor(Color.RED);
					LeftRotate(z.getFather().getFather());
				}
			}
		}
		((NodoRojoNegro<K, V>) root).setColor(Color.BLACK);
	}
	@Override
	public void insert(K key, V value) {
		if(key!=null && value!=null) {
			NodoRojoNegro<K,V> z =new NodoRojoNegro<K,V>(key,value);
			insert(z);
			insertFixeUp(z);
		}
	}
	public ArrayList<V> getElements() {
		if(root == null) {
			return null;
		}else {
			ArrayList<V> elements = new ArrayList<V>();
			root.Preorder(elements);
			return elements;
		}
	}

	@Override
	public NodoBST<K, V> delete(K key) {
		NodoBST<K,V>z=consultar(key);
		NodoBST[] params=null;
		if(z!=null) {
			params=delete(z);
		}else {
			return null;
		}
		if(((NodoRojoNegro)params[1]).getColor()==Color.BLACK) {
			deleteFixeUp((NodoRojoNegro)params[0]);
		}
		return params[1];
	}

	
}