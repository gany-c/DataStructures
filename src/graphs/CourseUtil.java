package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Ramanan
 * 
 * 1. Create a map of course to down stream courses
 * 2. Create a list of starting courses i.e. have no prerequisites
 * 
 *  iterate until - all course are covered, i.e. the course list becomes empty,
 * 3. If the starting courses are empty, and list has uncovered courses, then return false; 
 * 4. -- Cover, the starting courses i.e. remove them from the list of courses,
 * 5. -- identify their immediate descendants using the map and remove the covered courses from their pre-req
 * 6. -- if the above step creates courses without prereq, they become new starting courses for the next iteration of the loop
 * 
 * 
 *
 */
public class CourseUtil {
	
	public boolean isCourseStructureValid(List<Course> courses){
		
		if(courses == null || courses.isEmpty())
			return false;
		
		List<Course> temp = new ArrayList<Course>();
		temp.addAll(courses);
		
		List<Course> startingCourses = getStartingCourses(temp);		
		Map<Course,List<Course>> downStream = getDownStream(temp);
		
		while(!temp.isEmpty()){			
			
			//System.out.println("Starting courses = "+startingCourses);
			
			if(startingCourses.isEmpty())
				return false;			
			
			temp.removeAll(startingCourses);
			
			List<Course> newStartingCourses = new ArrayList<Course>();
			
			for(Course stCourse:startingCourses){
				
				List<Course> nextGen = downStream.get(stCourse);
				
				if(nextGen!=null)
					for(Course nextGenCourse: nextGen){
						nextGenCourse.getPreReq().remove(stCourse);
						if(nextGenCourse.getPreReq().isEmpty())
							newStartingCourses.add(nextGenCourse);
					}
			}
			
			startingCourses = newStartingCourses;
		}
		
		
		return true;
	}

	private Map<Course, List<Course>> getDownStream(List<Course> input) {
		
		Map<Course, List<Course>> output = new HashMap<>(); 
		
		for(Course course:input){
			
			if(course.getPreReq()==null||course.getPreReq().isEmpty())
				continue;
			
			for(Course preReqCourse:course.getPreReq()){
				
				 List<Course> downList = output.get(preReqCourse);
				 if(downList == null){
					 downList = new ArrayList<>();
					 output.put(preReqCourse, downList);
				 }
				 
				 downList.add(course);				 
				
			}
			
		}
		
		
		return output;
	}

	private List<Course> getStartingCourses(List<Course> input) {
		
		List<Course> output = new ArrayList<Course>();
		
		if(input!=null){
			
			for(Course course:input){
				
				if(course.getPreReq()==null||course.getPreReq().isEmpty())
					output.add(course);
			}
		}
		
		return output;
	}
	
	/**
	 * Test cases below here, 
	 * -- Has a lot of copy and paste
	 * -- Will be refactored in the real world
	 * @param args
	 */
	
	public static void main(String[] args){
		
		boolean result = testLinearTopology();
		System.out.println("linear = "+result);
		
		result = testCyclicSquareTopology();
		System.out.println("cyclic square = "+result);
		
		result = testAcyclicSquareTopology();
		System.out.println("acyclic square = "+result);
		
		result = testCyclicBigDipper();
		System.out.println("cyclic big dipper = "+result);
		
		result = testAcyclicBigDipper();
		System.out.println("acyclic big dipper = "+result);	
		
		result = testStarTopology();
		System.out.println("star = "+result);	
		
		result = testBinarySpindle();
		System.out.println("binary spindle = "+result);	
	}

	private static boolean testLinearTopology() {
		
		List<Course> courses = new ArrayList<>();
		
		Course a = new Course("A");
		Course b = new Course("B");
		Course c = new Course("C");
		Course d = new Course("D");
		
		a.getPreReq().add(b);
		b.getPreReq().add(c);
		c.getPreReq().add(d);
		
		courses.add(a);
		courses.add(b);
		courses.add(c);
		courses.add(d);
		
		CourseUtil util = new CourseUtil();
		return util.isCourseStructureValid(courses);
	}
	
	private static boolean testCyclicSquareTopology() {
		
		List<Course> courses = new ArrayList<>();
		
		Course a = new Course("A");
		Course b = new Course("B");
		Course c = new Course("C");
		Course d = new Course("D");
		
		a.getPreReq().add(b);
		b.getPreReq().add(c);
		c.getPreReq().add(d);
		d.getPreReq().add(a);
		
		courses.add(a);
		courses.add(b);
		courses.add(c);
		courses.add(d);
		
		CourseUtil util = new CourseUtil();
		return util.isCourseStructureValid(courses);
	}	
	
	private static boolean testAcyclicSquareTopology() {
		
		List<Course> courses = new ArrayList<>();
		
		Course a = new Course("A");
		Course b = new Course("B");
		Course c = new Course("C");
		Course d = new Course("D");
		
		a.getPreReq().add(b);
		b.getPreReq().add(c);
		c.getPreReq().add(d);
		a.getPreReq().add(d);
		
		courses.add(a);
		courses.add(b);
		courses.add(c);
		courses.add(d);
		
		CourseUtil util = new CourseUtil();
		return util.isCourseStructureValid(courses);
	}	
	
	private static boolean testCyclicBigDipper() {
		
		List<Course> courses = new ArrayList<>();
		
		Course a = new Course("A");
		Course b = new Course("B");
		Course c = new Course("C");
		Course d = new Course("D");
		
		a.getPreReq().add(b);
		b.getPreReq().add(c);
		c.getPreReq().add(d);
		d.getPreReq().add(a);
		
		courses.add(a);
		courses.add(b);
		courses.add(c);
		courses.add(d);
		
		Course e = new Course("E");
		Course f = new Course("F");
		Course g = new Course("G");
		
		c.getPreReq().add(e);
		e.getPreReq().add(f);
		f.getPreReq().add(g);
		
		courses.add(e);
		courses.add(f);
		courses.add(g);		
		
		CourseUtil util = new CourseUtil();
		return util.isCourseStructureValid(courses);
	}	
	

	private static boolean testAcyclicBigDipper() {
		
		List<Course> courses = new ArrayList<>();
		
		Course a = new Course("A");
		Course b = new Course("B");
		Course c = new Course("C");
		Course d = new Course("D");
		
		a.getPreReq().add(b);
		b.getPreReq().add(c);
		c.getPreReq().add(d);
		a.getPreReq().add(d);
		
		courses.add(a);
		courses.add(b);
		courses.add(c);
		courses.add(d);
		
		Course e = new Course("E");
		Course f = new Course("F");
		Course g = new Course("G");
		
		c.getPreReq().add(e);
		e.getPreReq().add(f);
		f.getPreReq().add(g);
		
		courses.add(e);
		courses.add(f);
		courses.add(g);			
		
		CourseUtil util = new CourseUtil();
		return util.isCourseStructureValid(courses);
	}
	
	private static boolean testStarTopology() {
		
		List<Course> courses = new ArrayList<>();
		Course a = new Course("A");
		Course b = new Course("B");
		Course c = new Course("C");
		Course d = new Course("D");
		
		a.getPreReq().add(b);
		a.getPreReq().add(c);
		a.getPreReq().add(d);
		
		courses.add(a);
		courses.add(b);
		courses.add(c);
		courses.add(d);
		
		CourseUtil util = new CourseUtil();
		return util.isCourseStructureValid(courses);
		
		
	}
	
	private static boolean testBinarySpindle() {
		
		List<Course> courses = new ArrayList<>();
		Course a = new Course("A");
		Course b = new Course("B");

		
		a.getPreReq().add(b);
		b.getPreReq().add(a);

		courses.add(a);
		courses.add(b);

		
		CourseUtil util = new CourseUtil();
		return util.isCourseStructureValid(courses);
		
		
	}
	

}
