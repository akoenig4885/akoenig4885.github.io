package grazioso;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Driver {
	private static ArrayList<String> countryList = new ArrayList<String>(); 
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    private static HashTable hashTable = new HashTable();
    // Instance variables (if needed)

    public static void main(String[] args) {

    	Scanner scnr =  new Scanner(System.in);
    	char userChoice = ' ';
    	initializeCountryList();
        initializeDogList();
        initializeMonkeyList();

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
        while (userChoice != 'q') {
        	displayMenu();
        	userChoice = scnr.next().charAt(0);
        	// input validation loop
        	while (!(userChoice == 'q' || (userChoice > 48 && userChoice <= 55))) {
        		System.out.println("That is not a valid menu choice.");
        		System.out.println();
        		System.out.println("Enter a menu selection");
        		userChoice = scnr.next().charAt(0);
     
        	}
        	switch (userChoice) {
        		case '1':
        			intakeNewDog(scnr);
        			break;
        		case '2':
        			intakeNewMonkey(scnr);
        			break;
        		case '3':
        			reserveAnimal(scnr);
        			break;
        		case '4' :
        			printAnimals("dog");
        			break;
        		case '5' :
        			printAnimals("monkey");
        			break;
        		case '6' :
        			printAnimals("available");
        			break;
        		case '7':
        			long startTime = System.nanoTime();
        			sortDogList(dogList, 0, dogList.size());
        			long endTime = System.nanoTime();
        			System.out.println("Dog list sorted in " + (endTime - startTime) + "ns.");
        			break;
        		default :
        			break;
        	}
        }
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[7] Sort the list of dogs");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }
    
    // Initializes the list of countries with the top 50 countries by population
    public static void initializeCountryList() {
    	countryList.add("India");
    	countryList.add("China");
    	countryList.add("United States");
    	countryList.add("Indonesia");
    	countryList.add("Pakistan");
    	countryList.add("Nigeria");
    	countryList.add("Brazil");
    	countryList.add("Bangladesh");
    	countryList.add("Russia");
    	countryList.add("Ethiopia");
    	countryList.add("Mexico");
    	countryList.add("Japan");
    	countryList.add("Egypt");
    	countryList.add("Philippines");
    	countryList.add("DR Congo");
    	countryList.add("Vietnam");
    	countryList.add("Iran");
    	countryList.add("Turkey");
    	countryList.add("Germany");
    	countryList.add("Thialand");
    	countryList.add("United Kingdom");
    	countryList.add("Tanzania");
    	countryList.add("France");
    	countryList.add("South Africa");
    	countryList.add("Italy");
    	countryList.add("Kenya");
    	countryList.add("Myanmar");
    	countryList.add("Colombia");
    	countryList.add("South Korea");
    	countryList.add("Sudan");
    	countryList.add("Uganda");
    	countryList.add("Spain");
    	countryList.add("Algeria");
    	countryList.add("Iraq");
    	countryList.add("Argentina");
    	countryList.add("Afghanistan");
    	countryList.add("Yemen");
    	countryList.add("Canada");
    	countryList.add("Poland");
    	countryList.add("Morocco");
    	countryList.add("Angola");
    	countryList.add("Ukraine");
    	countryList.add("Uzbekistan");
    	countryList.add("Malaysia");
    	countryList.add("Mozambique");
    	countryList.add("Ghana");
    	countryList.add("Peru");
    	countryList.add("Saudi Arabia");
    	countryList.add("Madagascar");
    	countryList.add("Nepal");
    }
    
    //Randomly generates a dog 
    public static Dog randomizeDog() {
    	Random random = new Random();
    	
    	String name = "";
    	String breed;
    	String gender;
    	String age;
    	String weight;
    	String acquisitionDate;
    	String acquisitionCountry;
    	String trainingStatus;
    	boolean reserved;
    	String inServiceCountry;
    	
    	// Randomly Generate a name
    	for(int i = 0; i < (random.nextInt(5) + 3); i++) {
    		char c = (char)(random.nextInt(26));
    		if(i == 0) {
    			c = (char) (c + 'A');
    		}
    		else {
    			c = (char) (c + 'a');
    		}
    		name = name + c;
    	}
    	
    	switch (random.nextInt(10)) {
    		case 0:
    			breed = "German Shepard";
    			break;
    		case 1:
    			breed = "Husky";
    			break;
    		case 2:
    			breed = "Beagle";
    			break;
    		case 3:
    			breed = "Labrador";
    			break;
    		case 4:
    			breed = "Poodle";
    			break;
    		case 5:
    			breed = "Bulldog";
    			break;
    		case 6:
    			breed = "Golden Retriever";
    			break;
    		case 7:
    			breed = "Dachsund";
    			break;
    		case 8:
    			breed = "Border Collie";
    			break;
    		case 9:
    			breed = "Chow Chow";
    			break;
    		default:
    			breed = "Dog";
    			break;
    	}
    	if(random.nextBoolean()) {
    		gender = "male";
    	}
    	else {
    		gender = "female";
    	}
    	age = String.valueOf(random.nextInt(15));
    	weight = String.valueOf(random.nextInt(100));
    	String month = String.valueOf(random.nextInt(12) + 1);
    	String day = String.valueOf(random.nextInt(31) + 1);
    	String year = String.valueOf(random.nextInt(15) + 2009);
    	acquisitionDate = month + "-" + day + "-" + year;
    	acquisitionCountry = countryList.get(random.nextInt(50));
    	switch(random.nextInt(4)) {
    	case 0:
    		trainingStatus = "intake";
    		break;
    	case 1:
    		trainingStatus = "Phase I";
    		break;
    	case 2:
    		trainingStatus = "Phase II";
    		break;
    	case 3:
    		trainingStatus = "In Service";
    		break;
    	default:
    		trainingStatus = "Status Unknown";
    		break;
    	}
    	reserved = random.nextBoolean();
    	inServiceCountry = countryList.get(random.nextInt(50));
    	
    	Dog dog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
    	return dog;
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        for(int i = 0; i < 50000; i++) {
        	Dog newDog = randomizeDog();
        	dogList.add(newDog);
        	hashTable.Insert(newDog);
        }
        	
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey();
    	Monkey monkey2 = new Monkey("Koko", "female", "46", "175", "07-31-2022", "United States", "in service", false, "United States", "0", "59cm", "59cm", "Gorilla");
    	
    	monkeyList.add(monkey1);
    	monkeyList.add(monkey2);
    }


    // Instantiate and add the new dog to the appropriate list
    public static void intakeNewDog(Scanner scanner) {
    	// Removes any extra data left in the scanner
    	scanner.nextLine();
    	// Prompt the user for input for all dog parameters, storing them in variables
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();
        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine();
        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();
        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine();
        System.out.println("When was the dog acquired?");
        String acquisitionDate = scanner.nextLine();
        System.out.println("In what country was the dog acquired?");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("What is the dog's training status?");
        String trainingStatus = scanner.nextLine();
        // A string variable to get input on whether the dog is reserved and a boolean to set the reserved status
        String reservedInput = " ";
        boolean reserved;
        // A loop to validate if the input for reserved was yes or no
        while(!(reservedInput.equals("yes") || reservedInput.equals("no"))) {
        	 System.out.println("Is the dog reserved?");
        	 reservedInput = scanner.nextLine();
        	 // If the input is invalid, the user is prompted with appropriate choices
        	 if(!(reservedInput.equals("yes") || reservedInput.equals("no"))) {
        		 System.out.println("Please enter \"yes\" or \"no\"");
        	 }
        }
        if(reservedInput.equals("no"))
        {
        	reserved = false;
        }
        else{
        	reserved = true;
        }
        System.out.println("What country is the dog is service in?");
        String serviceCountry = scanner.nextLine();
        Dog intakeDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, serviceCountry);
        dogList.add(intakeDog);
        System.out.println(name + " has been added to the list.");
    }

		//Instantiate and add the new monkey to the appropriate list
        public static void intakeNewMonkey(Scanner scanner) {
        	// Removes any whitespace left in the scanner
        	scanner.nextLine();
        	// List of monkey species eligible for training
           String monkeySpecies[] = {"Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel Monkey", "Tamarin"};
           // boolean to check if the species is eligible for training
           boolean validSpecies = false;
           System.out.println("What is the monkey's name?");
           String name = scanner.nextLine();
           // Check if there is already a monkey by that name
           for (Monkey monkey: monkeyList) {
        	   if(monkey.getName().equalsIgnoreCase(name)) {
        		   System.out.println("\n\nThis monkey is already in our system\n\n");
        		   return;
        	   }
           }
           System.out.println("What is the monkey's species?");
           String species = scanner.nextLine();
           // Loop to validate that the species is eligible for training
           for (int i = 0; i < monkeySpecies.length; ++i) {
        	   if (species.equals(monkeySpecies[i])) {
        		   validSpecies = true;
        		   break;
        	   }
           }
           // Return to the menu if the species is not eligible for training
           if (!validSpecies) {
        	   System.out.println("\n\nThis species is not eligible for training\n\n");
        	   return;
           }
           // instantiate the new monkey 
           Monkey intakeMonkey = new Monkey();
           intakeMonkey.setName(name);
           intakeMonkey.setSpecies(species);
           System.out.println("What is the monkey's age?");
           String age = scanner.nextLine();
           intakeMonkey.setAge(age);
           System.out.println("What is the monkey's gender?");
           String gender = scanner.nextLine();
           intakeMonkey.setGender(gender);
           System.out.println("What is the monkey's acquisition date?");
           String acquisitionDate = scanner.nextLine();
           intakeMonkey.setAcquisitionDate(acquisitionDate);
           System.out.println("What country was the monkey acquired in?");
           String acquistionCountry = scanner.nextLine();
           intakeMonkey.setAcquisitionLocation(acquistionCountry);
           System.out.println("What is the monkey's training status?");
           String trainingStatus = scanner.nextLine();
           intakeMonkey.setTrainingStatus(trainingStatus);
           System.out.println("Is the monkey reserved?");
           String reserved = scanner.nextLine();
           // Input validation for reserved status
           while (!(reserved.equals("yes") || reserved.equals("no"))) {
        	   System.out.println("Please enter either \"yes\" or \"no\". Is the monkey reserved?");
        	   reserved = scanner.nextLine();
           }
           if (reserved.equals("yes")){
        	   intakeMonkey.setReserved(true);
           }
           else {
        	   intakeMonkey.setReserved(false);
           }
           System.out.println("What country is the monkey in service in?");
           String serviceCountry = scanner.nextLine();
           intakeMonkey.setInServiceCountry(serviceCountry);
           System.out.println("How long is the monkey's tail?");
           String tailLength = scanner.nextLine();
           intakeMonkey.setTailLength(tailLength);
           System.out.println("What is the monkey's height?");
           String height = scanner.nextLine();
           intakeMonkey.setHeight(height);
           System.out.println("What is the monkey's body length?");
           String bodyLength = scanner.nextLine();
           intakeMonkey.setBodyLength(bodyLength);
           
           // Add the intake monkey to the list of monkeys
           monkeyList.add(intakeMonkey);
           System.out.println(name + " has been added to the list.");
           
        }


        // Finds animal by type and service country and reserves it. 
        public static void reserveAnimal(Scanner scanner) {
        	// Get rid of any extra input in the scanner
        	scanner.nextLine();
        	String animalType = " ";
        	long arrayStartTime;
        	long arrayEndTime;
        	long arrayDuration = 0;
        	long hashStartTime;
        	long hashEndTime;
        	long hashDuration;
        	boolean matchingAnimal = false;
        	// input validation loop
        	while (!(animalType.equals("monkey") || animalType.equals("dog"))) {
        		System.out.println("Please enter the desired animal type: ");
        		animalType = scanner.nextLine();
        		// If the entered type is not a dog or monkey, prompt the user for the correct type
        		if(!(animalType.equals("monkey") || animalType.equals("dog"))) {
        			System.out.println("The animal type must be either \"dog\" or \"monkey\".");
        		}
        	}
        	System.out.println("Please enter the desired service country: ");
            String country = scanner.nextLine();
            // Search the dog list for available dog
            if (animalType.equals("dog")) {
            	arrayStartTime = System.nanoTime();
            	for(Dog dog : dogList) {
            		// Check if the dog is available and in the selected country
            		if (!dog.getReserved() && dog.getInServiceLocation().equals(country)) {
            			// set matchingAnimal and the dogs reserved status to true
            			matchingAnimal = true;
            			dog.setReserved(true);
            			arrayEndTime = System.nanoTime();
            			arrayDuration = (arrayEndTime - arrayStartTime);
            			// Inform the user that the dog has been found and reserved
            			System.out.println(dog.getName() + " in " + country + " has been updated in arrayList in " + arrayDuration + "ns.");
            			
            			// end the for loop once a matching animal has been found
            			break;
            		}
            	}
            	arrayEndTime = System.nanoTime(); 
            	arrayDuration = (arrayEndTime - arrayStartTime);
            	hashStartTime = System.nanoTime();
            	RescueAnimal dog = hashTable.Search("dog", country);
            	hashEndTime = System.nanoTime();
            	hashDuration = (hashEndTime - hashStartTime);
            	if(!dog.getName().equals("NOT_FOUND")) {
            		System.out.println(dog.getName() +  " in " + country + " has been updated in hash table in " + hashDuration +  "ns.");
            	}
            	else {
            		System.out.println("No dog found in hash table. Search lasted " + hashDuration + "ns." );
            	}
            }
            // Search the monkey list for available monkey
            else if (animalType.equals("monkey")) {
            	for(Monkey monkey : monkeyList) {
            		// Check if the monkey is available and in the selected country
            		if (!monkey.getReserved() && monkey.getInServiceLocation().equals(country)) {
            			// set matchingAnimal and the monkey's reserved status to true
            			matchingAnimal = true;
            			monkey.setReserved(true);
            			// Inform the user that the dog has been found and reserved
            			System.out.println(monkey.getName() + " in " + country + " has been updated to reserved.");
            			// end the for loop once a matching animal has been found
            			break;
            		}
            	}
            	
            }
            // Error message prints if the animal type is neither dog or monkey. Input validation loop should ensure this doesn't happen.
            else {
            	System.out.println("Something went wrong");
            }
            // Inform the user if no matching animal could be found
            if (!matchingAnimal) {
            	System.out.println("There is no available " + animalType + " in " + country + ". Searched lasted " + arrayDuration + "ns.");
            }

        }


        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
        public static void printAnimals(String menuChoice) {
        	// The parameter menuChoice is the menu option the user selected. 
        	// Prints the header for the table
        	System.out.println("Name           Status         Loc County     Reserved");
        	System.out.println("_____________________________________________________");
        	// Prints the list of dogs
            if (menuChoice.equals("dog")) {
            	// Iterate through the list of dogs
            	for(Dog dog : dogList) {
            		System.out.printf("%-15s", dog.getName());
            		System.out.printf("%-15s", dog.getTrainingStatus());
            		System.out.printf("%-15s", dog.getInServiceLocation());
            		// Determine if the dog is reserved or not
            		if(dog.getReserved()) {
            			System.out.println("Reserved");
            		}
            		else {
            			System.out.println("Available");
            		}
            	}
            }
            // Prints the list of monkeys
            else if (menuChoice.equals("monkey")) {
            	// Iterate through the list of monkeys
            	for(Monkey monkey : monkeyList) {
            		System.out.printf("%-15s", monkey.getName());
            		System.out.printf("%-15s", monkey.getTrainingStatus());
            		System.out.printf("%-15s", monkey.getInServiceLocation());
            		// Determine if the monkey is reserved or not
            		if(monkey.getReserved()) {
            			System.out.println("Reserved");
            		}
            		else {
            			System.out.println("Available");
            		}
            	}
            	
            }
            // Prints the list of all available animals
            else if (menuChoice.equals("available")) {
            	// iterate through the dog list
            	for(Dog dog : dogList) {
            		// If the dog is available and in service, print the info
            		if(dog.getTrainingStatus().equals("In Service") && !dog.getReserved()) {
            			System.out.printf("%-15s", dog.getName());
                		System.out.printf("%-15s", dog.getTrainingStatus());
                		System.out.printf("%-15s", dog.getInServiceLocation());
                		System.out.println("Available");
            		}
            	}
            	// iterate through the monkey list
            	for(Monkey monkey : monkeyList) {
            		// If the monkey is available and in service, print the info
            		if(monkey.getTrainingStatus().equals("In Service") && !monkey.getReserved()) {
            			System.out.printf("%-15s", monkey.getName());
                		System.out.printf("%-15s", monkey.getTrainingStatus());
                		System.out.printf("%-15s", monkey.getInServiceLocation());
                		System.out.println("Available");
            		}
            	}
            	
            }
            else {
            	System.out.println("Something went wrong.");
            }

        }
        
        
        //Sorts the rescue dog list by country, then training status
        public static void sortDogList(ArrayList<Dog> list, int start, int end) {
        	if(start + 1 < end) {
        		int middle = (start + end)/2;
        		sortDogList(list, start, middle);
        		sortDogList(list, middle, end);
        		Merge(list, start, middle, end);
        	}
        	
        }
        
        
        
        // Merge algorithm for the MergeSort
        public static void Merge(ArrayList<Dog> list, int start, int middle, int end) {
        	ArrayList<Dog> left = new ArrayList<>(list.subList(start, middle));
        	ArrayList<Dog> right = new ArrayList<>(list.subList(middle, end));
        	
        	int i = 0;
        	int j = 0;
        	int k = start;
        	
        	while(i < left.size() && j < right.size()) {
        		if(left.get(i).getInServiceLocation().compareTo(right.get(j).getInServiceLocation()) < 0) {
        			list.set(k, left.get(i));
        			i++;
        		}
        		else if(left.get(i).getInServiceLocation().compareTo(right.get(j).getInServiceLocation()) > 0){
        			list.set(k, right.get(j));
        			j++;
        		}
        		// The case if each animal is from the same country, sort by training status
        		else {
        			if(left.get(i).getTrainingStatus().compareTo(right.get(j).getTrainingStatus()) <= 0) {
            			list.set(k, left.get(i));
            			i++;
            		}
            		else{
            			list.set(k, right.get(j));
            			j++;
            		}
        		}
        		k++;
        	}
        	
        	while(i < left.size()) {
        		dogList.set(k, left.get(i));
        		i++;
        		k++;
        	}
        	
        	while(j < right.size()) {
        		dogList.set(k, right.get(j));
        		j++;
        		k++;
        	}
        }
}

