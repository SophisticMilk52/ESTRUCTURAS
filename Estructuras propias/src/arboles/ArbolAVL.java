package arboles;

public class ArbolAVL<K extends Comparable,V> extends ArbolBST<K,V> {
	

	private void deleteFixeUp(NodoAVL N) {
		NodoAVL G=null;
		for (NodoAVL X = (NodoAVL) N.getFather(); X != null; X = G) { 
		    G = (NodoAVL) X.getFather(); 
		    if (N == X.getLeft()) {
		        if (X.balanceFactor() < 0) { 
		        	NodoAVL Z = (NodoAVL) X.getRight();
		            int b = Z.balanceFactor();
		            if (b > 0) {
		            	rightRotate(Z);
		            	Z.UpdateFactorBalance();
		            	LeftRotate(X);
		            	X.UpdateFactorBalance();
		            }else {
		            	System.out.println("HERE");
		            	LeftRotate(X);
		            	X.UpdateFactorBalance();
		            }
		        } else {
		            if (X.balanceFactor() == 0) {
		                X.setBalanceFactor(-1);
		                break; 
		            }
		            N = X;
		            N.setBalanceFactor(0);
		            continue;
		        }
		    } else { 
		        if (X.balanceFactor() > 0) {
		            NodoAVL Z = (NodoAVL) X.getLeft();
		            int b = Z.balanceFactor();
		            if (b < 0) {
		            	LeftRotate(Z);
		            	Z.UpdateFactorBalance();
		            	rightRotate(X);
		            	X.UpdateFactorBalance();
		            }else {
		            	rightRotate(X);
		            	X.UpdateFactorBalance();
		            }
		        } else {
		            if (X.balanceFactor() == 0) {
		            	X.setBalanceFactor(1);
		                break; 
		            }
		            N = X;
		            N.setBalanceFactor(0);
		            continue;
		        }
		    }
		}
	}
	private void FixeUpInsert(NodoAVL<K, V> z) {
		NodoAVL<K,V> N=z;
		NodoAVL<K,V> P=(NodoAVL<K, V>) z.getFather();
		if(P!=null) {
			do {
				
				NodoAVL<K,V> left=(NodoAVL<K, V>) P.getLeft();
				 if (left != null && N.compareTo(left)==0) {
					 if (P.balanceFactor() == 1) { 
						
						 if (N.balanceFactor() == -1) {
							 LeftRotate(N); 
							 N.UpdateFactorBalance();
							 ((NodoAVL)N.getFather()).UpdateFactorBalance();
						 }
				
						 rightRotate(P);
						 P.UpdateFactorBalance();
						 ((NodoAVL)P.getFather()).UpdateFactorBalance();
						 break; 
					 }
					 if (P.balanceFactor() == -1) {
						 P.setBalanceFactor(0); 
						 break;
					 }
					 P.setBalanceFactor(1); 
				 } else { 
					 if (P.balanceFactor() == -1) {
						
						 if (N.balanceFactor() == 1) { 
							 rightRotate(N);
							 N.UpdateFactorBalance();
							 ((NodoAVL)N.getFather()).UpdateFactorBalance();
						 }
					
						 LeftRotate(P);
						 P.UpdateFactorBalance();
						 ((NodoAVL)P.getFather()).UpdateFactorBalance();
						 break; 
					 }
					 if (P.balanceFactor() == 1) {
						 P.setBalanceFactor(0); 
						 break; 
					 }
					 P.setBalanceFactor(-1); 
				 }
				 N = P;
				 P = (NodoAVL<K, V>) N.getFather();
			}while(P!=null);
		}
	}
	@Override
	public void insert(K key, V value) {
		if(key!=null && value!=null) {
			NodoAVL<K,V> z=new NodoAVL<K,V>(key,value);
			insert(z);
			FixeUpInsert(z);
		}
	}
	@Override
	public NodoBST<K, V> delete(K key) {
		if(key==null) {
			return null;
		}
		NodoBST<K,V>z=consultar(key);
		NodoBST[] params=null;
		if(z!=null) {
			params=delete(z);
		}else {
			return null;
		}
		System.out.println(params[0].getKey());
		deleteFixeUp((NodoAVL)params[0]);
		return params[1];
	}

}