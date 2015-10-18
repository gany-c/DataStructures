package fb;

/**
 * 
 * @author Ramanan
 *
 *Given a boolean list of flags, representing checkins, find the first faulty check in.
 */
public class FaultyCheckinFinder {
	
	/*
	 * do the  null and size check. 
	 * If the last element is true, then all is well, return -1
	 * if the first element is false then return the first index, i.e. 0
	 * Otherwise, kick in the search process.
	 */
	public int getBadVersion(boolean[] checkins){
		
		
		if(checkins == null || checkins.length==0)
			return -1;
		
		if (checkins[checkins.length-1]==true)
			return -1;
		
		if(checkins[0] == false)
			return 0;
		
		
		
		return binSearch(checkins,0,checkins.length-1);
	}

	/*
	 * Do a binary search to find the transition
	 * 1. if you hit a false, then check if the previous element was true
	 * 2. if you hit a true, check if the succeeding element is false
	 * 3. Move the search index by treating "true" as a smaller value than "false"
	 */
	private int binSearch(boolean[] checkins, int start, int end) {
		
		int mid = (start + end)/2;
		
		//mid == false
		if(!checkins[mid]){
		
			if(mid == start)
				return 0;			
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
