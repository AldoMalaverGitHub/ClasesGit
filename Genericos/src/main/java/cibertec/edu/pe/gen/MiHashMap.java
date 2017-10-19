package cibertec.edu.pe.gen;

import java.util.ArrayList;
import java.util.List;

public class MiHashMap<K, V> {
	
	private List<K> listaLLaves = new ArrayList<>();
	private List<V> listaValores = new ArrayList<>();
	
	public void put(K k, V v) {
		int posicion = 0;
		if((posicion = buscarLlave(k)) == -1) {
			listaLLaves.add(k);
			listaValores.add(v);
		}else {
			listaValores.set(posicion, v);
		}
	}
	
	public V get(K k) {
		int posicion = buscarLlave(k);
		if(posicion == -1) {
			return null;
		}
		return listaValores.get(posicion);
	}
	
	private int buscarLlave(K k) {
		
		for(int i = 0; i < listaLLaves.size(); i++) {
			if(listaLLaves.get(i) == k) {
				return i;
			}
		}
		
		return -1;
	}
}

