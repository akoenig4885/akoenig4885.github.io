package CourseListBinaryTree;
import java.util.LinkedList;

public class Course {
	public String courseNumber;
	public String name;
	public LinkedList<String> prerequisites = new LinkedList<String>();
	
	public void printCourse() {
		System.out.println(this.courseNumber + ", " + this.name);
	}
	
	public void printPrerequisites() {
		System.out.println("Prerequisites: " + prerequisites.toString());
	}
	
	public Course() {
		this.courseNumber = "NONEXISTENT";
		this.name = "INVALID";
	}
	
	
	/**Converts line from csv file to course object
	* Returns INVALID for course name if string does not contain both number and name
	* @param str The string containing course information
	* @return Course object containing data from string.**/
	public void StringToCourse(String str) {
		this.courseNumber = "NONEXISTENT";
		this.name = "INVALID";
		prerequisites.clear();
		String temp = "";
		int numStrings = 0;
		for(int i = 0; i < str.length(); ++i) {
			if(str.charAt(i) != ',') {
				temp = temp + str.charAt(i);
			}
			
			if((str.charAt(i) == ',') || (i == str.length() -1 )) {
				if(numStrings == 0) {
					this.courseNumber = temp;
					temp = "";
					numStrings++;
				}
				
				else if(numStrings == 1) {
					this.name = temp;
					temp = "";
					numStrings++;
				}
				
				else {
					this.prerequisites.add(temp);
					temp = "";
					numStrings++;
				}
			}
		}
		
	}

}
