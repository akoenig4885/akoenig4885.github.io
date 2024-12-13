package CourseListBinaryTree;

enum MenuChoices {
	LOAD,
	PRINTLIST,
	PRINTONE,
	REMOVE,
	EXIT,
	ERROR
}


public class Menu {
	// The lowest number menu option
	private int MIN_MENU_CHOICE = 1;
	// The highest number menu option
	private int MAX_MENU_CHOICE = 5;
	/**Outputs the menu to the console */
	public void printMenu() {
		System.out.print("\n\n");
		System.out.println("1. Load Data Structure");
		System.out.println("2. Print Course List");
		System.out.println("3. Print Course");
		System.out.println("4. Remove Course");
		System.out.println("5. Exit");
		System.out.println("What would you like to do?");
	}
	
	/**Receives user input and returns menu selection*/
	public MenuChoices menuSelection() {
		int userChoice = 0;
		printMenu();
		//Continue to receive user input until valid choice is entered
		while(userChoice < MIN_MENU_CHOICE || userChoice > MAX_MENU_CHOICE) {
			//Ensure that the user has entered an integer
			while(!Driver.scanner.hasNextInt()) {
				System.out.println("Please enter an integer corresponding to a menu choice");
				Driver.scanner.next();
			}
			userChoice = Driver.scanner.nextInt();
			Driver.scanner.nextLine();
			if(userChoice < MIN_MENU_CHOICE || userChoice > MAX_MENU_CHOICE) {
				System.out.println(userChoice + " is not a valid menu number.");
			}
		}
		switch (userChoice) {
		case 1:
			return MenuChoices.LOAD;
		case 2:
			return MenuChoices.PRINTLIST;
		case 3:
			return MenuChoices.PRINTONE;
		case 4:
			return MenuChoices.REMOVE;
		case 5:
			return MenuChoices.EXIT;
		default:
			return MenuChoices.ERROR;	
		}
	}

}
