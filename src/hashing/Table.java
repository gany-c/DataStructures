package hashing;

import java.util.LinkedList;
import java.util.List;



public class Table<K, V>  {
	
	private static class MapNode<K, V>{
		public K key;
		public V value;
	}

	List<MapNode<K, V>>[] table = (List<MapNode<K, V>>[]) new LinkedList<?>[31];


	public V get(K key) {
		
		int index = getIndex(key);
		
		List<MapNode<K, V>> bucket = table[index];
		
		if(bucket == null)
			return null;
		
		for(MapNode<K, V> o:bucket){
			if(o.key.equals(key))
				return o.value;
		}
		
		return null;
	}


	private int getIndex(K key) {
		
		return key.hashCode()%31;
	}


	public void put(K key, V value) {
		
		remove(key);
		
		int index = getIndex(key);
		
		List<MapNode<K, V>> bucket = table[index];
		
		if(bucket == null)
			bucket = table[index] = new LinkedList<MapNode<K,V>>();
		
		MapNode<K,V> node = new MapNode<K,V> ();
		node.key = key;
		node.value = value;
		
		bucket.add(0,node);
	}


	public V remove(K key) {
		
		int index = getIndex(key);
		
		List<MapNode<K, V>> bucket = table[index];
		
		if(bucket == null)
			return null;

		for(MapNode<K, V> o:bucket){
			if(o.key.equals(key))
			{
				bucket.remove(o);
				return o.value;
			}
		
		}
	
	return null;
		
	}



}
