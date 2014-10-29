package lists;


public interface LinkedList<T> {
	

	public void add(T node);

	
	public void delete(int value);
	
	public void sort();
	
	public boolean hasLoops();

}
