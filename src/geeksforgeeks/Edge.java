package geeksforgeeks;

public class Edge implements Comparable<Edge>{
	
	public int weight;
	
	public Node v1;
	
	public Node v2;
	
	
	
	@Override
	public String toString() {
		return "Edge [weight=" + weight + ", v1=" + v1.id + ", v2=" + v2.id + "]";
	}

	public Edge clone()
	{
		Edge newEdge = new Edge();
		newEdge.weight = this.weight;
		newEdge.v1 = new Node();
		newEdge.v1.id = this.v1.id;
		newEdge.v2 = new Node();
		newEdge.v2.id = this.v2.id;
		return newEdge;
	}

	@Override
	public int compareTo(Edge o) {
		
		if(o==null)
			return 1;
		else
			return this.weight-o.weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
		result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
		result = prime * result + weight;
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
		Edge other = (Edge) obj;
		if (v1 == null) {
			if (other.v1 != null)
				return false;
		} else if (!v1.equals(other.v1))
			return false;
		if (v2 == null) {
			if (other.v2 != null)
				return false;
		} else if (!v2.equals(other.v2))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	
}