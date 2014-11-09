package hashing;

public class TableClient {

	public static void main(String[] args) {
		
		Table<Integer,String> table = new Table<Integer,String>();
		
		table.put(1, "Something");
		table.put(2, "what the hell");
		table.put(52, "Is this for real");
		
		
		System.out.println(table.get(1));
		System.out.println(table.get(2));
		System.out.println(table.get(3));
		
		System.out.println(table.get(52));
		table.remove(52);
		System.out.println(table.get(52));
	}

}
