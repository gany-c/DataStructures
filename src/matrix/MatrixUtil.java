package matrix;

public class MatrixUtil {

	public static int findNumPathsToOrigin(int x, int y){
		
		if(x == 0)
			return y;
		else if(y==0)
			return x;
		else return(findNumPathsToOrigin(x-1, y)+findNumPathsToOrigin(x, y-1));
		
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(findNumPathsToOrigin(1,1));
		System.out.println(findNumPathsToOrigin(2,2));

	}

}
