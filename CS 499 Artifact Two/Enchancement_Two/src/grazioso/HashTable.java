package grazioso;

import java.util.ArrayList;

// A hash table that uses the countries of animals for the hash function
public class HashTable {
	
	//195 is the number of countries in the world
	private final int TABLE_SIZE = 195;
	
	private ArrayList<HashTableNode> nodes = new ArrayList<HashTableNode>(TABLE_SIZE);
	
	public HashTable() {
		HashTableNode node = new HashTableNode();
		for(int i = 0; i < TABLE_SIZE; i++) {
			nodes.add(node);
		}
	}
	
	
	// Takes a string and returns a hash value.
	private int hash(String key) {
		int hashValue = 0;
		
		for(int i = 0; i < key.length(); i++) {
			hashValue = 7 * hashValue + key.charAt(i);
		}
		// Use the modular operator to convert the hash value to the table size
		hashValue = Math.abs(hashValue % TABLE_SIZE);
		
		return hashValue;
	}
	
	// Inserts an animal into the hashTable
	public void Insert(RescueAnimal animal) {
		int hashIndex = hash(animal.getInServiceLocation());
		
		HashTableNode newNode = new HashTableNode();
		newNode.animal = animal;
		newNode.key = animal.getInServiceLocation();
		
		// If the index is empty, simply insert the animal
		if(nodes.get(hashIndex).animal == null) {
			nodes.set(hashIndex, newNode);
		}
		// If the index is not empty, find the next empty node and insert the animal
		else {
			HashTableNode tempNode = nodes.get(hashIndex);
			while(tempNode.next != null) {
				tempNode = tempNode.next;
			}
			
			tempNode.next = newNode;
		}
	}
	
	//Searches for and reserves a matching animal
	public RescueAnimal Search(String animalType, String country) {
		RescueAnimal foundAnimal = new RescueAnimal();
		foundAnimal.setName("NOT_FOUND");
		int hashIndex = hash(country);
		HashTableNode node = nodes.get(hashIndex);
		
		if(node.animal == null) {
			return(foundAnimal);
		}
		else {
			while(node != null) {
				if(node.key.equals(country) && node.animal.getAnimalType().equals(animalType) && !node.animal.getReserved()) {
					foundAnimal = node.animal;
					node.animal.setReserved(true);
					return(foundAnimal);
				}
				else {
					node = node.next;
				}
			}
		}
		return(foundAnimal);
	}
	
}
