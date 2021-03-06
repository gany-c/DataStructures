package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class Node{
	
	public int id;
	 
	public  List<Edge> edges = new ArrayList<Edge>();
	
	

	@Override
	public String toString() {
		return "Node [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (id != other.id)
			return false;
		return true;
	}

}

