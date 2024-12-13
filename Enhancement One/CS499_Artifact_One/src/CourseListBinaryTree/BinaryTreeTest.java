package CourseListBinaryTree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {

	@Test
	void testConstuctor() {
		BinaryTree tree = new BinaryTree();
		assertTrue(tree.getRoot() == null);
	}
	
	@Test
	void testSingleInsert() {
		BinaryTree tree = new BinaryTree();
		Course course = new Course();
		course.StringToCourse("1234,Test");
		tree.Insert(course);
		assertTrue(tree.getRoot().course.courseNumber.equals("1234"));
		assertTrue(tree.getRoot().course.name.equals("Test"));
	}
	
	@Test
	void testLeftAndRightInsert() {
		BinaryTree tree = new BinaryTree();
		Course course = new Course();
		Course leftCourse = new Course();
		Course rightCourse = new Course();
		course.StringToCourse("1234,Test");
		leftCourse.StringToCourse("0123,Left");
		rightCourse.StringToCourse("234,Right");
		tree.Insert(course);
		tree.Insert(leftCourse);
		tree.Insert(rightCourse);
		assertTrue(tree.getRoot().left.course.name.equals("Left"));
		assertTrue(tree.getRoot().right.course.name.equals("Right"));
	}
	
	@Test
	void testMultipleInserts() {
		BinaryTree tree = new BinaryTree();
		for(int i = 0; i < 20; i++) {
			Course course = new Course();
			course.StringToCourse(i+"," + i + "name");
			tree.Insert(course);
		}
		tree.InOrder();
		assertTrue(tree.getRoot().left == null);
		assertTrue(tree.getRoot().right.course.courseNumber.equals("1"));	
	}
	
	@Test
	void testSearchFunction() {
		BinaryTree tree = new BinaryTree();
		for(int i = 0; i < 200; i++) {
			Course course = new Course();
			course.StringToCourse(i+"," + i + "name");
			tree.Insert(course);
		}
		Course course = tree.Search("42");
		assertTrue(course.courseNumber.equals("42"));
		assertTrue(course.name.equals("42name"));
		course = tree.Search("207");
		assertTrue(course.courseNumber.equals("NONEXISTENT"));
		assertTrue(course.name.equals("INVALID"));
	}
	
	@Test
	void testRemoveFunction() {
		BinaryTree tree = new BinaryTree();
		for(int i = 0; i < 200; i++) {
			Course course = new Course();
			course.StringToCourse(i+"," + i + "name");
			tree.Insert(course);
		}
		Course course = tree.Search("42");
		assertTrue(course.courseNumber.equals("42"));
		assertTrue(course.name.equals("42name"));
		tree.Remove("42");
		course = tree.Search("42");
		assertTrue(course.courseNumber.equals("NONEXISTENT"));
		assertTrue(course.name.equals("INVALID"));
	}

}
