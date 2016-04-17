package geometry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CollinearityUtil {
	
	public static class Point{
		public double x;
		public double y;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (x);			
			result = prime * result + (int) (y);
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
			Point other = (Point) obj;
			if (x !=other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
		Point(double x, double y){
			this.x = x;
			this.y = y;
		}
		
		
	}
	/**
	 * 1. Find the maximum number of collinear points for each point in the list
	 * 2. return the maximum
	 * 
	 * 1.findMaxNumForPoint: Given one target point and the rest, 
	 * 1.1 --- Calculate the slope of the target with every other point
	 * 1.2. --- store the result in a slope to count map
	 * 2. Return the max count slope plus 1; (first slope, encompasses 2 points)
	 * 
	 * 1. getSlope
	 * 1.1. Check for division by 0
	 * 1.2. In Java, there is something called negative 0.0
	 * 1.3. In general geometry, slope can be negative; 
	 * but the slope between 2 points will remain the same regardless of which point is used first
	 * @param points
	 * @return
	 */
	
	public int findMaxNum(List<Point> points){
		
		if(points == null || points.size()<=1)
			return 0;
		else if(points.size()==2)
			return 2;
		
		int maxNum = 0;
		
		for(int i =0;i<points.size();i++){
			
			Point target = points.remove(i);			
			int maxNumForPoint = findMaxNumForPoint(target,points);
			if(maxNumForPoint > maxNum){
				maxNum = maxNumForPoint;
			}	
			
		}
		
		return maxNum;		
	}

	private int findMaxNumForPoint(Point target, List<Point> points) {
		
		Map<Double, Integer> slopeMap = new HashMap<>();

		for(Point p:points){
			
			Double slope = getSlope(target,p);
			if(slopeMap.containsKey(slope))
				slopeMap.put(slope, slopeMap.get(slope) +1);
			else
				slopeMap.put(slope,1);
		}
		
		int maxForPoint = 0;
		
		System.out.println("DEBUG:-slopeMap = "+slopeMap);
		
		for(Entry<Double, Integer> entry:slopeMap.entrySet()){
			if(entry.getValue() > maxForPoint)
				maxForPoint = entry.getValue();
		}
		
		//Number of collinear points = slope count +1
		return maxForPoint+1;
	}

	private Double getSlope(Point target, Point p) {
		
		if(target.x == p.x)
			return Double.MAX_VALUE;
		else {
			Double slope = (p.y - target.y)/(p.x - target.x);
			if(slope == -0.0)
				slope = 0.0;
			return slope;
		}
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CollinearityUtil cu = new CollinearityUtil();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1,1));
		points.add(new Point(2,2));
		points.add(new Point(6,1));
		points.add(new Point(4,4));
		points.add(new Point(6,2));
		points.add(new Point(6,1000));
		points.add(new Point(6,10000));
		
		System.out.println("RESULT="+cu.findMaxNum(points));
		
		List<Point> points2 = new ArrayList<Point>();
		
		points2.add(new Point(19000, 10000));
		points2.add(new Point(18000, 10000));
		points2.add(new Point(32000, 10000));
		points2.add(new Point(21000, 10000));
		points2.add(new Point(1234, 5678));
		points2.add(new Point(14000, 10000));
		System.out.println("RESULT 2 ="+cu.findMaxNum(points2));
		
	}

}
