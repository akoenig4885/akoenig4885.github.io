
package com.example.demo;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;

public class DatabaseHandler {
    
    // An instance of the DatabaseHandler class for Singleton 
    private static DatabaseHandler instance;

    // Make the constructor private to prevent external initialization
    private DatabaseHandler(){

    }

    // Returns instance of DatabaseHandler
    public static DatabaseHandler getInstance(){
        if(instance == null){
            instance = new DatabaseHandler();
        }

        return instance;
    }

    // Connects to the MongoClient using username and password in config file
    public MongoClient connection() throws IOException{
		FileInputStream config = new FileInputStream("demo/config.properties");
		Properties prop = new Properties();
		prop.load(config);
		String username = prop.getProperty("database.username");
		String password = prop.getProperty("database.password");
        String uri = "mongodb+srv://" + username + ":" + password + "@cluster0.1jxf0.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        MongoClient mongoClient = MongoClients.create(uri);
        return mongoClient;
    }


    //Inserts an animal document into the database
    public void insertAnimal(Document animal){
        try{
            MongoClient client = connection();
            MongoDatabase database = client.getDatabase("AAC");
            MongoCollection<Document> collection = database.getCollection("animals");
            collection.insertOne(animal);
            client.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //Returns the list of all animals
    public ArrayList<Document> readAnimals(){
        ArrayList<Document> documents = new ArrayList<Document>();
        try{
            MongoClient client = connection();
            MongoDatabase database = client.getDatabase("AAC");
            MongoCollection<Document> collection = database.getCollection("animals");
            MongoCursor<Document> cursor = collection.find().cursor();
            try{
                while(cursor.hasNext()){
                    documents.add(cursor.next());
                }
            }finally{
                cursor.close();
                client.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return documents;
    }  

    //Updates an animal in the database
    public void updateData(Document animal){
        try{
            MongoClient client = connection();
            MongoDatabase database = client.getDatabase("AAC");
            MongoCollection<Document> collection = database.getCollection("animals");
            Document filter = new Document();
            filter.append("animal_id", animal.get("animal_id"));

            Document update = new Document("$set", animal);
            collection.updateOne(filter, update);
            client.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //Deletes an animal in the database
    public void deleteAnimal(Document animal){
        try{
            MongoClient client = connection();
            MongoDatabase database = client.getDatabase("AAC");
            MongoCollection<Document> collection = database.getCollection("animals");

            Document filter = new Document("animal_id", animal.get("animal_id"));
            collection.deleteOne(filter);
            client.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Document findOne(String id){
        Document animal = new Document();
        try{
            MongoClient client = connection();
            MongoDatabase database = client.getDatabase("AAC");
            MongoCollection<Document> collection = database.getCollection("animals");
            Document query = new Document("animal_id", id);

            animal = collection.find(query).first();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return animal;
    }
		
}
