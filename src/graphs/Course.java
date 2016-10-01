package graphs;

import java.util.ArrayList;
import java.util.List;

public class Course {
	
	private String name;
	private List<Course> preReq = new ArrayList<Course>();
	
	public Course(String string) {
		this.name = string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Course> getPreReq() {
		return preReq;
	}
	public void setPreReq(List<Course> preReq) {
		this.preReq = preReq;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Course other = (Course) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}
	
	

}
