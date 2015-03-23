package fb;

public class FaultyCheckinFinder {
	
	
	public int getBadVersion(boolean[] checkins){
		
		
		if(checkins == null || checkins.length==0)
			return -1;
		
		if (checkins[checkins.length-1]==true)
			return -1;
		
		if(checkins[0] == false)
			return -1;
		
		
		
		return binSearch(checkins,0,checkins.length-1);
	}

	private int binSearch(boolean[] checkins, int start, int end) {
		
		int mid = (start + end)/2;
		
		if(!checkins[mid]){
		
			if(mid == start)
				return -1;			
			else if(checkins[mid-1])
				return mid;
			else 
				return binSearch(checkins,start,mid-1);
			
			
		}
		else
		{
			if(mid == end)
				return -1;
			else if(!checkins[mid+1])
				return mid+1;
			//made an error here returned mid instead of mid+1
			else
				return binSearch(checkins,mid+1,end);
		}
		
		
		
	}

	public static void main(String[] args) {
		
		FaultyCheckinFinder fc = new FaultyCheckinFinder();
		
		int i = fc.getBadVersion(new boolean[]{true,true,true,false});
		
		System.out.println("Index of bad checkin = "+i);
		
		i = fc.getBadVersion(new boolean[]{true,true,true,true,true,false,false,false,false});
		
		System.out.println("Index of bad checkin = "+i);
		
		i = fc.getBadVersion(new boolean[]{true,true,true,true,true,true,true,true,true,true});
		
		System.out.println("Index of bad checkin = "+i);	
		
		i = fc.getBadVersion(new boolean[]{false,false,false,false});
		
		System.out.println("Index of bad checkin = "+i);		

	}

}
