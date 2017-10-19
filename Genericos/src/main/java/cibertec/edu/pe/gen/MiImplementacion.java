package cibertec.edu.pe.gen;

public class MiImplementacion<K, V> implements MiMap<K, V> {

	@Override
	public void put(K k, V v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V get(K k) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static <U, K> MiImplementacion<U, K> imprimir(U u){
		return new MiImplementacion<>();
	}
}
