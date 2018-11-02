package arboles;

import java.io.Serializable;

public abstract class ArbolBST<K extends Comparable, V> implements IBST<K, V>, Serializable{

	protected NodoBST<K, V> root;
	public NodoBST<K, V> nil;

	public ArbolBST() {
		nil = null;
		root = nil;
	}

	protected void insert(NodoBST<K, V> z) {
		NodoBST<K, V> y = null;
		if (nil != null)
			y = (NodoBST<K, V>) nil;
		NodoBST<K, V> x = root;
		while (x != nil) {
			y = x;
			if (x.compareTo(z) > 0) {           
				NodoBST<K, V> Father = x;
				x = x.getLeft();
				if (x != nil && Father.hight == x.hight + 1)
					Father.hight++;
				if (Father.getRight() == nil && x == nil) {
					Father.hight++;
				}
			} else if (x.compareTo(z) < 0) {
				NodoBST<K, V> Father = x;
				x = x.getRight();
				if (x != nil && Father.hight == x.hight + 1)
					Father.hight++;
				if (Father.getLeft() == nil && x == nil) {
					Father.hight++;
				}
			} else {
				NodoBST<K, V> w = x.getClon();
				while (w != null) {
					x = w;
					w = w.getClon();
				}
				x.setClon(z);
				NodoBST<K, V> p = null;
				if (nil != null)
					p = (NodoBST<K, V>) nil;
				z.setRight(p);
				z.setLeft(p);
				z.setFather(p);
				return;
			}
		}
		z.setFather(y);
		if (y == nil) {
			root = z;
		} else if (y.compareTo(z) > 0) {
			y.setLeft(z);
		} else {
			y.setRight(z);
		}
		NodoBST<K, V> p = null;
		if (nil != null)
			p = (NodoBST<K, V>) nil;
		z.setRight(p);
		z.setLeft(p);
	}

	public NodoBST<K, V> consultar(K key) {
		if(key==null) {
			return null;
		}
		if (nil != null) {
		}
		NodoBST<K, V> x = root;
		while (x != nil) {
			if (x.getKey().compareTo(key) > 0) {
				x = x.getLeft();
			} else if (x.getKey().compareTo(key) < 0) {
				x = x.getRight();
			} else {
				return x;
			}
		}
		return null;
	}

	protected void LeftRotate(NodoBST<K, V> x) {
		NodoBST<K, V> y = x.getRight();
		x.setRight(y.getLeft());
		if (y.getLeft() != nil) {
			y.getLeft().setFather(x);
		}
		y.setFather(x.getFather());
		if (x.getFather() == nil) {
			root = y;
		} else if (x == x.getFather().getLeft()) {
			x.getFather().setLeft(y);
		} else {
			x.getFather().setRight(y);
		}
		y.setLeft(x);
		x.setFather(y);
		x.actualizarhight();
		y.actualizarhight();
	}

	protected void rightRotate(NodoBST<K, V> x) {
		NodoBST<K, V> y = x.getLeft();
		x.setLeft(y.getRight());
		if (y.getRight() != nil) {
			y.getRight().setFather(x);
		}
		y.setFather(x.getFather());
		if (x.getFather() == nil) {
			root = y;
		} else if (x == x.getFather().getLeft()) {
			x.getFather().setLeft(y);
		} else {
			x.getFather().setRight(y);
		}
		y.setRight(x);
		x.setFather(y);
		x.actualizarhight();
		y.actualizarhight();
	}

	public boolean estaVacio() {
		if (root == null)
			return true;
		return false;
	}

	public NodoBST<K, V> getroot() {
		return root;
	}

	public void setroot(NodoBST<K, V> root) {
		this.root = root;
	}
	
	public abstract void insert(K key, V value);
	
	public abstract NodoBST<K,V> delete(K key);

	private NodoBST<K, V> sucesor(NodoBST<K,V> x) {
		if(x.getRight()!=nil) {
			return minimum(x.getRight());
		}
		NodoBST<K,V> y=x.getFather();
		while(y!=nil && x==y.getRight()) {
			x=y;
			y=y.getFather();
		}
		return y;
	}

	private NodoBST<K, V> minimum(NodoBST<K, V> d) {
		NodoBST<K,V>actual=d;
		while(actual.getLeft()!=nil) {
			actual=actual.getLeft();
		}
		return actual;
	}
	protected NodoBST[] delete(NodoBST<K, V> z) {
		NodoBST<K,V> y=nil;
		if (z.getRight()==nil || z.getLeft()==nil) {
			y=z;
		}else{
			y=sucesor(z);
		}
		NodoBST<K,V> x=nil;
		if(y.getLeft()!=nil) {
			x=y.getLeft();
		}else {
			x=y.getRight();
		}
		
		if(x!=null) {
			x.setFather(y.getFather());	
		}
		if(y.getFather()==nil) {
			root=x;
		}else {
			if(y==y.getFather().getLeft()) {
				y.getFather().setLeft(x);
			}else {
				y.getFather().setRight(x);
			}
		}
		if(nil==null && x==null) {
			x=y.getFather();
		}
		
		if(y!=z) {
			z.setKey(y.getKey());
			z.setValue(y.getValue());
		}
		NodoBST<K,V>[]ans=new NodoBST[2];
		ans[0]=x;
		ans[1]=y;
		return ans;
	}
	
}
