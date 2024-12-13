package CourseListBinaryTree;
import java.util.Scanner;



public class Driver {
	
	public static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		MenuChoices menuSelection = MenuChoices.ERROR;
		BinaryTree tree = new BinaryTree();
		String courseID;
		Menu menu = new Menu();
		while(menuSelection != MenuChoices.EXIT) {
			menuSelection = menu.menuSelection();
			switch(menuSelection) {
			//Load data structure
			case LOAD:
				tree.LoadCourses();
				break;
			//Print Course List
			case PRINTLIST:
				tree.InOrder();
				break;
			//Print Single Course
			case PRINTONE:
				System.out.println("Which course would you like to know about?");
				courseID = scanner.nextLine();
				if(tree.Search(courseID).name.equals("INVALID")) {
					System.out.println("The selected course does not exist");
				}
				else {
					tree.Search(courseID).printPrerequisites();
				}
				break;
			// Remove a Course From the Binary Tree
			case REMOVE:
				System.out.println("Which course would you like to remove?");
				courseID = scanner.nextLine();
				tree.Remove(courseID);
			//Exit
			case EXIT:
				System.out.println("Thank you for using the course planner!");
				if(scanner !=null) {
					scanner.close();
				}
				break;
			default:
				System.out.println("AN ERROR HAS OCCURED DURING MENU SELECTION. THIS CODE SHOULD NOT BE REACHABLE");
				break;
			}
		}
	}
}
