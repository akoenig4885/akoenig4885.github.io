# **Adam Koenig ePortfolio**

## Professional Self Assessment
During my time at Southern New Hampshire University (SNHU), I pursued a Bachelor of Science in Computer Science. My experience with SNHU has taught me a great deal about the development of software. Not only have I learned the technical coding skills, but also the interpersonal skills required for the software development lifecycle. In every course at SNHU, I collaborated with other students during weekly discussions. In CS250, I learned about the software development lifecycle and participated in an agile sprint. In CS 255, I learned how to analyze requirements from stakeholders to design systems, creating documents for both the stakeholders and the development team. The coursework for CS 319 included holding interviews with potential users of an application, incorporating their feedback on prototypes into a finalized design. Throughout my time at SNHU, I have learned how to tailor my communication for stakeholders, colleagues, peers, and users.

I have also gained valuable technical skills through my coursework. I have developed projects in C, C++, Java, JavaScript, and Python. I created desktop software, android applications, embedded software, and full stack web applications. These projects have taught me skills such as object-oriented programming principles, design patterns, data structures and algorithms, unit testing, and working with frameworks. I have had to design and develop my own programs, as well as debug code written by others. Several times, the coursework contained code that had been depreciated. I learned to refactor the code I was given so it would run before adding the code I was required to write for the assignment. This experience has strengthened my ability to debug and fix errors.

Several of the courses I took at SNHU were related to databases. I gained skills in both SQL and NoSQL databases. In DAD220, I learned SQL and created complex queries for a MySQL database. I used SQLite for an Android application I developed in CS 360. The NoSQL database I have experience with is MongoDB. This was used in both CS 340 and CS 465 as the database for a web application. 

Secure coding was another important skill that I gained from SNHU. I learned how to prevent SQL injection through the use of parameterized inputs. I practiced input validation and preventing buffer overflow. I performed code analyses checking for vulnerabilities, employing both static and unit testing. I learned about encryption algorithms, and the tradeoffs when selecting an algorithm. I also learned secure coding design concepts, such as not leaving security until the end, defense in depth, and the principle of least privilege. 

The artifacts below showcase my talents as a software developer. They consist of three original projects created during my time at SNHU, and three enhancements made to these projects. The first artifact demonstrates my software design and engineering skills. The second exhibits my knowledge of data structures and algorithms. The final artifact is related to databases. All three enhancements are written in Java.




### Quick Links
|Category     | Original | Enhancement |
|--------------|----------|------------ |
|Software Design and Engineering  |[CS 300 Project Two](https://github.com/akoenig4885/CS300)|[Enhancement One](https://github.com/akoenig4885/akoenig4885.github.io/tree/main/Enhancement%20One/CS499_Artifact_One)|
|Data Structures and Algorithms  | [IT 145 Project](https://github.com/akoenig4885/IT145)|[Enhancement Two](https://github.com/akoenig4885/akoenig4885.github.io/tree/main/CS%20499%20Artifact%20Two/Enchancement_Two)|
|Databases| [CS 340 Project](https://github.com/akoenig4885/CS340)| [Enhancement Three](https://github.com/akoenig4885/akoenig4885.github.io/tree/main/Enhancement%203) |

## Artifact One - Software Design and Engineering

**[Original Artifact - CS 300 Project Two](https://github.com/akoenig4885/CS300)**

**[Enhancement One](https://github.com/akoenig4885/akoenig4885.github.io/tree/main/Enhancement%20One/CS499_Artifact_One)**

The artifact that I selected for this assignment was the final project for CS 300: Data Structures and Algorithms. It was created in August of 2023. The program opens and reads data from a formatted csv file. This file contains course numbers, names, and prerequisite course numbers. Each line of the file becomes a node of a binary tree, with the key of the node being the course number. The binary tree has functions for inserting nodes, removing nodes, searching the tree, and printing the tree in order. The user is presented with a menu, with the option to load data from a file, print the tree, search for a course, or exit the program.

I selected this artifact because I felt it both shows my skills as a programmer and has room for improvement. The binary tree is a complicated data structure. This artifact also has  sections where I thought ahead and added more than was required. For example, after loading the courses into the tree I check the prerequisites to ensure that their course numbers exist in the tree. This ensures that all the prerequisite courses actually exist. I added a function to remove courses from the binary tree, although this is not used by the actual program. I also had rudimentary input validation for the menu selection that checked for the value of user input, but did not verify that the user entered an integer. There were still areas to improve. 

For this enhancement, the main change was porting the code from C++ to Java. I also changed the structure of the code, splitting the classes into their own files. In the C++ code, the course object was a struct. In Java, I made it a class and added the methods to print the course and convert csv file lines to the class. In addition, the method for loading courses into the tree was moved into the binary tree class. This shows the object-oriented programming principles of encapsulation. The option to remove nodes from the tree was added to the menu. The input validation was enhanced to ensure that users could only enter a number for the menu selection. Unit tests were added for the course and binary tree classes. Rather than use a hardcoded value for the input file, the filename now takes user input, and if a file not found exception is thrown it is caught and handled. Additionally, I have added Javadoc notation to all methods containing a brief description and explaining their parameters and return types.

The course outcome that I had planned to meet with this enhancement was related to security. I do believe that the improvements I made to input validation, file reading, and the unit tests show progress toward a security mindset that mitigates design flaws and exploits. However, I had initially planned to add user profiles, authentication, and authorization to this artifact. After working with it, I realized authentication and authorization does not make much sense for this program that is practically read only. 

While enhancing the artifact, I did run into a few challenges. When initially attempting to load data into the binary tree, every node would contain the information of the last loaded course. I thought that there was an issue with my insert function somehow overwriting the root of the tree with each new insert. In reality, my load courses function assigned a course to the root, then overwrote that course with each new line. This was fixed by moving the declaration of the course into the loop so a new course was declared for every line. Another challenge I faced was issues with the user input for the menu. I had declared three separate scanners that utilized System.in, one for each class that took user input. These scanners conflicted with each other, leading to unexpected behavior. In order to fix this problem, I declared a single instance of scanner in the main class that the other classes called when they needed input. 


## Artifact Two - Datastructures and Algorithms

**[Original Artifact - IT 145 Project](https://github.com/akoenig4885/IT145)**

**[Enhancement Two](https://github.com/akoenig4885/akoenig4885.github.io/tree/main/CS%20499%20Artifact%20Two/Enchancement_Two)**

The artifact that I selected for this enhancement was the project from IT 145 – Foundation in Application Development. I took this course in July of 2022, which is when the artifact was created. The artifact is a Java application that contains three class files and a driver file. The class files consist of a Rescue Animal class and Dog and Monkey classes that inherit from it. In the driver class, array lists of both the dog and monkey classes are created and initialized with a few animals. A menu is displayed with options to intake new animals, print the full list of either dogs or monkeys, print the list of all animals that are not reserved, or reserve an animal. The reserve function asks users for an animal type and country, and then searches for a matching animal that is not reserved. 

I selected this artifact because I believe it offers an opportunity to show how I have grown as a developer. This artifact was made early in my computer science education, and there was room for improvement. First, I cleaned up a lot of the comments that were leftover instructions. Then, I created a new function to randomly generate a dog to add to the list. In this way, I was able to use a for loop to change the number of initialized dogs from 3 to 50,000. Increasing the number of dogs better shows the other enhancements. I then created two new classes, the first being a hash table node class containing a animal object, a string key, and a next node. The second class is a hash table, consisting of an array list of nodes. Since the animals are searched for by country, I made the country field the key for the hash function. The hash table also contains insert and search functions. It handles collisions through the use of a linked list, with each node in the hash table pointing to the next node. When a collision occurs, the new node is added as the next node of the first node with null as its next node. 

I chose a hash table for the data structure because insertions and searches average O(1) time. To compare the hash table with the original array list, I used System.time to calculate the duration each took to reserve an animal. In tests when a matching animal exists, the hash function took 9,400ns to find it, while the array list took 66,800ns. That is 7 times faster to use the hash table than the array list. When attempting to reserve an animal that does not exist, the hash table concluded there was no match in 11,900ns, while the array list’s search took 3,116,400ns. That means the array list was 261 times faster. This is due to the fact that when a match does not exist in the array list, the search has to iterate through the entire list. This leads to O(n) time complexity. For the hash table, a country that does not exist should point to an empty bucket, leading to O(1). However, due to collisions there may be another country that hashes to the same value. In reality, the hash table has to search through all elements that hash to the same bucket to determine no match exists.

In order to show my abilities to use algorithms, I created a merge sort algorithm. This algorithm runs recursively, dividing the array list into sublists, sorting those sublists, and merging them together. I chose the merge sort because the best, average, and worst runtimes have O(n log n) complexity. The only drawback of the merge sort is that it needs to allocate the same amount of memory that the array list occupies. Once the dog list had been sorted, searches for animals in countries early in the alphabet happen at the same speed in the array list and hash table. However, searches for animals in countries low on the list, such as Yemen, take significantly longer for the array list than they do for the hash table.

The course outcome that I had planned to achieve for this enhancement was: design and evaluate computing solutions that solve a given problem using algorithmic principles and computer science practices and standards appropriate to its solution while managing the trade-offs involved in design choices.  The hash table data structure and merge sort algorithm are well suited for the problem they solve in this program. I acknowledge that the merge sort algorithm has a tradeoff in the amount of memory it requires, yet for this program it is not an issue. If I were working with a system that had memory constraints, another sorting algorithm such as heapsort would be preferable. 

While adding these enhancements to the artifact, the only challenge I ran into was that my hash table would initially reserve every matching animal rather than the first found match. This was due to a bug where when a match was found, the code would not return the match and the while loop did not end. Therefore, it would iterate through every node until it reached a null node, reserving every match. This was fixed by returning the match when it was found. 

## Artifact Three - Databases

**[Original Artifact - CS 340 Project](https://github.com/akoenig4885/CS340)**

**[Enhancement Three](https://github.com/akoenig4885/akoenig4885.github.io/tree/main/Enhancement%203)**

**[API Server For Enhancement Three](https://github.com/akoenig4885/akoenig4885.github.io/tree/main/API%20Server/demo/demo)**



