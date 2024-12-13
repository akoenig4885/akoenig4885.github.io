package CourseListBinaryTree;

//Node object for the Binary Tree Data Structure
public class BinaryTreeNode {
	// Course information held in the node
	Course course;
	// Left and Right children of the node
	BinaryTreeNode left, right;
	
	public BinaryTreeNode(Course course) {
		this.course = course;
		left = null;
		right = null;
	}
}
