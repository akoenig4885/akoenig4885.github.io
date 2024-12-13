package CourseListBinaryTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BinaryTree {
	private BinaryTreeNode root = null;
	private ArrayList<String> prerequisites = new ArrayList<String>();
	
	/**Function that runs recursively to add node to binary tree.
	 * The passed course object's course number is compared to the course number present
	 * in the current node. If it is less than and the current node has no left children, the 
	 * course object is added as the current node's left child. If greater than, the course object
	 * is added as the right child. If the current node has children, the function is called recursively
	 * with either the left or right child as the new current node.
	 * @param node The current node of the tree that is compared to the course object
	 * @param course The course object that is being added into the tree*/
	private	void addNode(BinaryTreeNode node, Course course) {

			if(node.course.courseNumber.compareTo(course.courseNumber) > 0) {
				if(node.left == null) {
					BinaryTreeNode newNode = new BinaryTreeNode(course);
					node.left = newNode;
				}
				else {
					addNode(node.left, course);
				}
			}
			
			else {
				if(node.right == null) {
					BinaryTreeNode newNode = new BinaryTreeNode(course);
					node.right = newNode;
				}
				else {
					addNode(node.right, course);
				}
			}
		}
	
	/**Recursively traverse the tree in order, printing course information*/
	private void inOrder(BinaryTreeNode node) {
		if(node != null) {
			inOrder(node.left);
			
			node.course.printCourse();
			
			inOrder(node.right);
		}
	}
	
	public BinaryTree() {
		this.root = null;
	}
	
	public BinaryTreeNode getRoot() {
		return this.root;
	}
	
	/**Calls the private inOrder function starting with the root*/
	public void InOrder() {
		inOrder(root);
	}
	
	/**Inserts a course object into the binary tree
	 * @param course Course object to be inserted into the tree*/
	public void Insert(Course course) {
		if(this.root == null) {
			BinaryTreeNode newNode = new BinaryTreeNode(course);
			this.root = newNode;
		}
		else {
			addNode(this.root, course);
		}
	}
	
	/**Finds a course by ID and removes it from the tree
	 * @param courseID String containing course ID of course to remove*/
	public void Remove(String courseID) {
		BinaryTreeNode parent = null;
		BinaryTreeNode currentNode = root;
		
		while(currentNode != null) {
			if(currentNode.course.courseNumber.equals(courseID)) {
				// If the node has no children
				if(currentNode.left == null && currentNode.right == null) {
					if(parent == null) {
						root = null;
					}
					else if(parent.left == currentNode) {
						parent.left = null;
					}
					else {
						parent.right = null;
					}
				}
				// If the node only has children to the left
				else if(currentNode.right == null) {
					if(parent == null) {
						root = currentNode.left;
					}
					else if(parent.left == currentNode) {
						parent.left = currentNode.left;
					}
					else {
						parent.right = currentNode.left;
					}
				}
				// If the node only has children to the right
				else if(currentNode.left == null) {
					if(parent == null) {
						root = currentNode.right;
					}
					else if(parent.left == currentNode) {
						parent.left = currentNode.right;
					}
					else {
						parent.right = currentNode.right;
					}
				}
				//If the node has two children, find successor
				else {
					BinaryTreeNode successor = currentNode.right;
					while(successor.left != null) {
						successor = successor.left;
					}
					
					Course successorCourse = successor.course;
					Remove(successor.course.courseNumber);
					currentNode.course = successorCourse;
				}
				
				return;
			}
			else if(currentNode.course.courseNumber.compareTo(courseID) > 0) {
				parent = currentNode;
				currentNode = currentNode.left;
			}
			else {
				parent = currentNode;
				currentNode = currentNode.right;
			}
		}
	}
	
	/**Finds and returns a course by ID
	 * @param courseID String containing course ID to search
	 * @return Course object that matches the courseID. 
	 * If no match is found course number will be nonexistent*/
	public Course Search(String courseID) {
		BinaryTreeNode currentNode = this.root;
		
		while(currentNode != null) {
			if(currentNode.course.courseNumber.equals(courseID)) {
				return currentNode.course;
			}
			
			else if(currentNode.course.courseNumber.compareTo(courseID) > 0) {
				currentNode = currentNode.left;
			}
			else {
				currentNode = currentNode.right;
			}
		}
		
		//If no course is found, return course number nonexistent
		Course course = new Course();
		course.courseNumber = "nonexistent";
		return course;
	}
	
	
	/*Loads courses from the csv file into the binary tree*/
	public void LoadCourses() {
		String filename;
		String fileLine;
		// Gets the filename from the user
		System.out.println("Enter filename: ");
		filename = Driver.scanner.nextLine();
		// Attempts to open the file
		try {
			File csvFile = new File("./src/CourseListBinaryTree/" + filename);
			Scanner fileScanner = new Scanner(csvFile);
			// If the file exists, scan every line of the file and add convert it to a course object
			while(fileScanner.hasNextLine()) {
				fileLine = fileScanner.nextLine();
				Course course = new Course();
				course.StringToCourse(fileLine);
				
				if(course.name.equals("INVALID")) {
					System.out.println("File formatting error. Please ensure every course in file contains both a course number and course name.");
					break;
				}
				//Insert the new course object into the binary tree
				this.Insert(course);
				for (int i = 0; i < course.prerequisites.size(); i++) {
					if(course.prerequisites.get(i) != null) {
						this.prerequisites.add(course.prerequisites.get(i));
				}
				}
			}
			fileScanner.close();
		// Catch the exception if the file does not exist
		} catch(FileNotFoundException e) {
			System.out.println("File: " + filename + " not found.");
		}
	}
	
	/** This function verifies that every course in the prerequisite list exists
	 * as a course in the Binary Tree
	 * @return True if every prerequisite is valid and false if an invalid prerequisite is found*/
	public boolean verifyPrerequisites() {
		for(int i = 0; i < this.prerequisites.size(); i++) {
			if(this.Search(this.prerequisites.get(i)).name.equals("INVALID")) {
				return false;
			}
		}
		return true;
	}
	
		

}
