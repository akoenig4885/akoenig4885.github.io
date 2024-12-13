// Adam Koenig		CS 300		Project One		8/13/2023
#include <iostream>
#include <vector>
#include <fstream>
#include <string>
using namespace std;


// Struct for a linked list node to hold prerequisite data
struct ListNode {
	string prerequisite;
	ListNode* next = nullptr;
};

// Struct to hold course information
struct Course {
	string courseNumber;
	string name;
	ListNode* prereq = nullptr;
};

// Struct for Nodes of the binary search tree 
struct TreeNode {
	Course course;
	TreeNode* left = nullptr;
	TreeNode* right = nullptr;

};

// Prints the course number and name of a given course
void printCourse(Course course) {
	cout << course.courseNumber << ", " << course.name << endl; 
}

// Prints the list of prerequisites for a given course
void printPrerequisites(Course course) {
	// First Print the course information
	printCourse(course);
	cout << "Prerequisites: ";
	// Iterate through the prerequisites printing them, until the current node is null
	ListNode* currentNode = course.prereq;
	while (currentNode != nullptr) {
		cout << currentNode->prerequisite << ", ";
		currentNode = currentNode->next;
	}
}

// Binary Search Tree Data Structure
class BinaryTree {
private:
	TreeNode* root;
	void addNode(TreeNode* node, Course course);
	void inOrder(TreeNode* node);
	void nodeDeleter(TreeNode* node);
public:
	BinaryTree();
	virtual ~BinaryTree();
	void InOrder();
	void Insert(Course course);
	void Remove(string courseID);
	Course Search(string courseID);
};

// Constructor for Binary Tree
BinaryTree::BinaryTree() {
	root = nullptr;
}

// Destructor for Binary Tree
BinaryTree::~BinaryTree() {
	nodeDeleter(root);
}

// A function to recursively delete nodes in the binary search tree
void BinaryTree::nodeDeleter(TreeNode* node) {
	if (node != nullptr) {
		nodeDeleter(node->left);
		nodeDeleter(node->right);
		delete node;
	}
}

// Traverse the tree in order
void BinaryTree::InOrder() {
	inOrder(root);
}

// Insert a course into the tree
void BinaryTree::Insert(Course course) {
	// If the tree is empty
	if (root == nullptr) {
		// Create a new node assigned with the course information
		TreeNode* newNode = new TreeNode;
		newNode->course = course;
		// Assign the root to the new node
		root = newNode;
	}
	else {
		// Call the add node function using the root and course
		addNode(root, course);
	}
}

// Remove a course from the tree
void BinaryTree::Remove(string courseId) {
	// remove node root courseID
	TreeNode* parent = nullptr;
	TreeNode* currentNode = root;
	// Iterate through the tree until the Node to be removed is found
	while (currentNode != nullptr) {
		//If the match is found
		if (currentNode->course.courseNumber == courseId) {
			// If the Node to be removed has no children
			if (currentNode->left == nullptr && currentNode->right == nullptr) {
				//If the node to be removed is the root
				if (parent == nullptr) {
					root = nullptr;
				}
				// If the Node to be removed is to the left of the parent Node
				else if (parent->left == currentNode) {
					parent->left = nullptr;
				}
				//If the Node to be removed is to the right of the parent Node
				else {
					parent->right = nullptr;
				}
			}
			// If the node to be removed only has children on the left
			else if (currentNode->right == nullptr) {
				//If the root is the Node to be removed
				if (parent == nullptr) {
					root = currentNode->left;
				}
				//If the Node to be removed is to the left of the parent Node
				else if (parent->left == currentNode) {
					parent->left = currentNode->left;
				}
				//If the Node to be removed is to the right of the parent Node
				else {
					parent->right = currentNode->left;
				}
			}
			// If the node to be removed only has right children
			else if (currentNode->left == nullptr) {
				//If the root is the Node to be removed
				if (parent == nullptr) {
					root = currentNode->right;
				}
				// If the Node to be removed is to the left of the parent Node
				else if (parent->left == currentNode) {
					parent->left = currentNode->right;
				}
				// If the Node to be removed is to the right of the parent Node
				else {
					parent->right = currentNode->right;
				}
			}
			// If the Node to be removed has two children
			else {
				//Find the successor to the current Node
				TreeNode* successor = currentNode->right; 
				while (successor->left != nullptr) {
					successor = successor->left;
				}
				// Save the Course information from the successor
				Course successorCourse = successor->course;
				// Remove the successor from the subtree
				Remove(successor->course.courseNumber);
				// Set the current course with the successor's information
				currentNode->course = successorCourse; 
			}
			//Return if the Node has been found
			return;
		}
		// If the course is smaller, search the left side
		else if (courseId < currentNode->course.courseNumber) {
			parent = currentNode;
			currentNode = currentNode->left;
		}
		// If the course is larger, search the right side
		else {
			parent = currentNode;
			currentNode = currentNode->right;
		}
	}
}

// Search for a course
Course BinaryTree::Search(string courseID) {
	// Set current Node equal to root
	TreeNode* currentNode = root;
	// Keep looping down the tree until a match is found or the end is reached
	while (currentNode != nullptr) {
		// If match is found, return matching course
		if (currentNode->course.courseNumber == courseID) {
			return currentNode->course;
		}
		// If the target course is smaller than the current course traverse left
		else if (courseID < currentNode->course.courseNumber) {
			currentNode = currentNode->left;
		}
		// If the target course is larger, traverse right
		else {
			currentNode = currentNode->right;
		}
	}
	// If no match is found, return a course with course number indicating the target does not exist
	Course course;
	course.courseNumber = "NONEXISTENT";
	return course;
}

// Add a course node to the tree
void BinaryTree::addNode(TreeNode* node, Course course) {
	// If the course is smaller than the node, check the left
	if (course.courseNumber < node->course.courseNumber) {
		// If the left node is empty, add the node to the left
		if (node->left == nullptr) {
			TreeNode* newNode = new TreeNode;
			newNode->course = course;
			node->left = newNode;
		}
		// If the left node is not empty, recursively run addNode on the left node
		else {
			addNode(node->left, course);
		}
	}
	//If the course is greater than or equal to the node, check the right
	else {
		// If the right node is empty, add the new node to the right
		if (node->right == nullptr) {
			TreeNode* newNode = new TreeNode;
			newNode->course = course;
			node->right = newNode;
		}
		// If the right node is not empty, recursively runn addNode on the right node
		else {
			addNode(node->right, course);
		}
	}
}

// Recursively traverse the tree in order, printing course information
void BinaryTree::inOrder(TreeNode* node) {
	// If node is not a null pointer
	if (node != nullptr) {
		// Search the left hand side
		inOrder(node->left);
		// Print course information
		printCourse(node->course);
		// Search the right hand side
		inOrder(node->right);
	}
}

// Splits a line of a csv file and creates a course object
Course stringToCourse(string str) {
	Course course;
	// If the string is not split, the course name will be invalid
	course.name = "INVALID";
	// Create an empty string
	string temp = "";
	// Track the number of strings
	int numStrings = 0;
	for (int i = 0; i < str.size();  ++i) {
		// If the current character is not a comma, add the character to the temp string
		if (str.at(i) != ','){
			temp = temp + str.at(i);
		}
		// Once a comma is hit or the end of the string is reached, add the substring to its location
		if ( (str.at(i) == ',') || (i == str.size() -1) ){
			// If it is the first substring, make it the courseNumber
			if (numStrings == 0) {
				course.courseNumber = temp;
				// Reset the temporary string to empty and increment numStrings
				temp = "";
				numStrings++; 
			}
			// If it is the second substring, make it the course name
			else if (numStrings == 1) {
				course.name = temp;
				// Reset the temporary string to empty and increment numStrings
				temp = "";
				numStrings++;
			}
			// Otherwise, add it to the list of prerequisites
			else {
				// If the prerequisite list is empty, make the string the first prerequisite
				if (course.prereq == nullptr) {
					// Create a new node assigned with the string
					ListNode* newNode = new ListNode;
					newNode->prerequisite = temp;
					newNode->next = nullptr;
					// Set the first node in the linked list of the course to the new node
					course.prereq = newNode;
					// Reset the temporary string to empty and increment numStrings
					temp = "";
					numStrings++;
				}
				// Otherwise itterate through the list and add the string to the end
				else {
					// Find the last node in the prerequisite list
					ListNode* currentNode = course.prereq;
					while (currentNode->next != nullptr) {
						currentNode = currentNode->next;
					}
					// Create a new Node with the string and assign it to the last node's next pointer
					ListNode* newNode = new ListNode;
					newNode->prerequisite = temp;
					newNode->next = nullptr;
					currentNode->next = newNode;
					// Reset the temporary string and increment numStrings
					temp = "";
					numStrings++;
				}
			}
		}
	}
	// Return the course object
	return course;
}

// Loads course information from csv file
void LoadCourses(BinaryTree& tree, vector<string>& prerequisites, string filename) { 
	ifstream csvFile;
	string fileLine;
	Course course;
	// Open the csv file
	csvFile.open(filename);
	// If the file opened successfully
	if (csvFile.is_open()) {
		// Get a line from the file
		while (getline(csvFile, fileLine)) {
			// Convert the line to a course object
			course = stringToCourse(fileLine);
			// If the line had only one element, the course object will be invalid
			if (course.name == "INVALID") {
				// Output that the file was incorrectly formated and exit the loop
				cout << "There was an error reading the file. Course " << course.courseNumber << " has no associated name" << endl;
				break;
			}
			// Add the course to the tree
			tree.Insert(course);
			// Add the prerequisites to the prerequisite list
			ListNode* currentNode = course.prereq;
			while (currentNode != nullptr) {
				prerequisites.push_back(currentNode->prerequisite);
				currentNode = currentNode->next;
			}
		}
		csvFile.close();
	}
}

// Displays the menu and returns the user selection
int menu() {
	int userChoice = 0;
	while (userChoice < 1 || userChoice > 4) {
		cout << endl << endl;
		cout << "1. Load Data Structure" << endl;
		cout << "2. Print Course List" << endl;
		cout << "3. Print Course" << endl;
		cout << "4. Exit" << endl;
		cout << "What would you like to do? ";
		cin >> userChoice;
		if (userChoice < 1 || userChoice > 4) {
			cout << endl << userChoice << "is not a valid option.";
		}
	}
	cout << endl;
	return userChoice;
}

int main() {
	int menuSelection = 0;
	BinaryTree tree;
	vector<string> prerequisites;
	string courseID;
	Course courseSelection;
	while (menuSelection != 4) {
		menuSelection = menu();
		switch (menuSelection) {
		case 1:
			// Load the Data Structure
			LoadCourses(tree, prerequisites, "ABCUAdvisingProgramInput.csv");
			// Check that every prerequisite is in the course list
			for (int i = 0; i < prerequisites.size(); i++) {
				courseSelection = tree.Search(prerequisites.at(i));
				// If a prerequisite is not in the course list
				if (courseSelection.courseNumber == "NONEXISTENT") {
					// Output that the file was invalid
					cout << "The prerequisite " << prerequisites.at(i) << " does not exist in the course list." << endl;
					cout << "The csv file is not valid" << endl;
				}
			}
			break;
		case 2:
			// Print the course list in alphanumeric order
			tree.InOrder();
			break;
		case 3:
			// Obtain user input for course number
			cout << "What course would you like to know about? ";
			cin >> courseID;
			cout << endl;
			// Search for the course
			courseSelection = tree.Search(courseID);
			// If the course does not exist inform the user
			if (courseSelection.courseNumber == "NONEXISTENT") {
				cout << "The selected course does not exist" << endl;
			}
			// Otherwise print the list of prerequisites
			else {
				printPrerequisites(courseSelection);
			}
			break;
		case 4:
			// Exit the program
			cout << "Thank you for using the course planner!";
			break;
		default:
			cout << "ERROR";
			break;
		}
	}
	return 0;
}