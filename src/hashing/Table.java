package hashing;

import java.util.LinkedList;
import java.util.List;


/**
 * 
 * @author gchidam
 *
 * @param <K>
 * @param <V>
 * 
 * 1. The easiest way is to implement this as an array of lists.
 * 2. Each list is a bucket
 * 3. The number of buckets is a prime number, to lower the number of hash collisions.
 * 4. Assign bucket using hashcode of the object being passed in (divide by number of buckets)
 * 5. Use the equals method to traverse the list of objects/ buckets.
 * 
 */
public class Table<K, V>  {
	
	private final int NUM_BUCKETS = 31;
	
	//create a custom key value internal class
	private static class MapNode<K, V>{
		public K key;
		public V value;
	}

	//create an array of list of MapNode, set the array size to 31.
	List<MapNode<K, V>>[] table = (List<MapNode<K, V>>[]) new LinkedList<?>[NUM_BUCKETS];


	public V get(K key) {
		//calculate index into the array based on key value
		int index = getIndex(key);
		
		//the bucket is the list a the index
		List<MapNode<K, V>> bucket = table[index];
		
		//if the list is null return
		if(bucket == null)
			return null;
		
		//traverse the list, locate the element within the list using equals method.
		for(MapNode<K, V> o:bucket){
			if(o.key.equals(key))
				return o.value;
		}
		
		//if not found within the bucket return null;
		return null;
	}


	/**
	 * Index is obtained by getting modulus 31, of the key object's hashcode
	 * @param key
	 * @return
	 */
	private int getIndex(K key) {
		
		return key.hashCode()%NUM_BUCKETS;
	}


	public V put(K key, V value) {
		
		//if an object for the key is already present, remove it
		V oldValue = remove(key);
		
		int index = getIndex(key);
		
		//locate the bucket
		List<MapNode<K, V>> bucket = table[index];
		
		//if the bucket i.e. the LinkedList is null, create an empty one
		if(bucket == null)
			bucket = table[index] = new LinkedList<MapNode<K,V>>();
		
		//create a new node with given key and value
		MapNode<K,V> node = new MapNode<K,V> ();
		node.key = key;
		node.value = value;
		
		//add it to the new list.
		bucket.add(0,node);
		
		return oldValue;
	}


	public V remove(K key) {
		
		//calculate index	
		int index = getIndex(key);
		
		//locate the bucket/list using the index
		List<MapNode<K, V>> bucket = table[index];
		
		//if the bucket is null return
		if(bucket == null)
			return null;

		//locate the object within the bucket using the key's equals method.
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
