package CourseListBinaryTree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CourseTest {

	@Test
	void testConstructor() {
		Course course = new Course();
		assertTrue(course.name.equals("INVALID"));
		assertTrue(course.courseNumber.equals("NONEXISTENT"));
	}
	
	@Test
	void testValidStringtoCourse() {
		Course course = new Course();
		course.StringToCourse("1234,Name,Prereq");
		assertTrue(course.name.equals("Name"));
		assertTrue(course.courseNumber.equals("1234"));
		assertTrue(course.prerequisites.get(0).equals("Prereq"));
	}
	
	@Test
	void testInvalidStringtoCourse() {
		Course course = new Course();
		course.StringToCourse("Test String");
		assertTrue(course.name.equals("INVALID"));
	}

}
