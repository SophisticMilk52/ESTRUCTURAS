package HashTable;

import ListaHash.ListaHash;

public class MiPrimerHash<K, V> implements InterfaceHashTable<K, V> {

	private int size;
	private int elementsCount;
	private ListaHash<K,V>[] tabla;
	
	public MiPrimerHash(int s) {
		size=s;
		elementsCount=0;
		tabla=new ListaHash[size];
	}
	
	@Override
	public V get(K key) {
		int casilla=hash(key);
		ListaHash<K,V> lh=tabla[casilla];
		if(lh==null) {
			return null;
		}else {
			return lh.buscar(key).getValor();			
		}
	}

	@Override
	public boolean put(K key, V value) {
		V val=get(key);
		if(val!=null) {
			return false;
		}else {
			int casilla=hash(key);
			if(tabla[casilla]==null) {
				tabla[casilla]=new ListaHash<K,V>();
				tabla[casilla].agregarAlInicio(key,value);
			}else {
				tabla[casilla].agregarAlInicio(key,value);
			}
			return true;
		}
	}
	
	private int hash(K k) {
		return k.hashCode()%size;
	}
	
	@Override
	public boolean IsEmpty() {
		if (elementsCount == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int elementsCount() {
		return elementsCount;
	}

	public boolean containsKey(K k) {
		int casilla=hash(k);
		if(tabla[casilla]==null) {
			return false;
		}else {
			V val=tabla[casilla].buscar(k).getValor();
			if(val==null) {
				return false;
			}else {
				return true;
			}
		}
	}

}
