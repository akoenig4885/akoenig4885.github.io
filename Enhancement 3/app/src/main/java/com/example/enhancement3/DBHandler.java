package com.example.enhancement3;

import android.content.Context;
import android.widget.Toast;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import com.mongodb.client.MongoCursor;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Request;
import okhttp3.Response;


public class DBHandler {

    public static final MediaType JSON = MediaType.get("application/json");
    public static final OkHttpClient client = new OkHttpClient();

    public Context context;

    public DBHandler(Context context){
        this.context = context;
    }

    public Document animalToDocument(AnimalEntry animal){
        Document document = new Document("rec_num", animal.rec_num)
                .append("age_upon_outcome", animal.age_upon_outcome)
                .append("animal_id", animal.animal_id)
                .append("animal_type", animal.animal_type)
                .append("breed", animal.breed)
                .append("color", animal.color)
                .append("date_of_birth", animal.date_of_birth)
                .append("date_time", animal.date_time)
                .append("name", animal.name)
                .append("outcome_type", animal.outcome_type)
                .append("sex_upon_outcome", animal.sex_upon_outcome);
        return document;
    }

    public AnimalEntry documentToAnimal(Document document){
        AnimalEntry animal = new AnimalEntry();
        if(document.get("rec_num") != null) {
            animal.rec_num = Integer.valueOf(document.get("rec_num").toString());
            animal.age_upon_outcome = document.get("age_upon_outcome").toString();
            animal.animal_id = document.get("animal_id").toString();
            animal.animal_type = document.get("animal_type").toString();
            animal.breed = document.get("breed").toString();
            animal.color = document.get("color").toString();
            animal.date_of_birth = document.get("date_of_birth").toString();
            animal.date_time = document.get("date_time").toString();
            animal.name = document.get("name").toString();
            animal.outcome_type = document.get("outcome_type").toString();
            animal.sex_upon_outcome = document.get("sex_upon_outcome").toString();
        }

        return animal;
    }
    public void InsertAnimal(AnimalEntry animal){
        Document document = animalToDocument(animal);
        RequestBody body = RequestBody.create(JSON, document.toString());
        Request request = new Request.Builder()
                .url("http://localhost:8080/animal")
                .put(body)
                .build();
        try (Response response = client.newCall(request).execute()){
            if(response.isSuccessful() && response.body()!=null) {
                System.out.println(response.body().string());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<AnimalEntry> readAnimals() {
        Document document = new Document();
        ArrayList<AnimalEntry> animals = new ArrayList<AnimalEntry>();
        Request request = new Request.Builder()
                .url("http://localhost:8080/animals")
                .build();
        try(Response response = client.newCall(request).execute()){
            if(response.isSuccessful() && response.body()!=null) {
                String responseString = response.body().toString();
                document = Document.parse(responseString);
            }
            else{
                Toast.makeText(context, "No records found", Toast.LENGTH_SHORT).show();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        animals.add(documentToAnimal(document));



        return animals;
    }

    public void updateData(AnimalEntry animal){
        Document setData = animalToDocument(animal);
        RequestBody body = RequestBody.create(JSON, setData.toString());
        Request request = new Request.Builder()
                .url("http://localhost:8080/animal")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()){
            if(response.isSuccessful() && response.body()!= null) {
                System.out.println(response.body().string());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public void deleteAnimal(AnimalEntry animal){
        Document deleteData = animalToDocument(animal);
        RequestBody body = RequestBody.create(JSON, deleteData.toString());
        Request request = new Request.Builder()
                .url("http://localhost:8080/animal")
                .delete(body)
                .build();
        try (Response response = client.newCall(request).execute()){
            if(response.isSuccessful() && response.body()!= null) {
                System.out.println(response.body().string());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public AnimalEntry findOne(String id){

        AnimalEntry animal = new AnimalEntry();
        Document document = new Document();
        Request request = new Request.Builder()
                .url("http://localhost:8080/animals/" + id)
                .build();
        try(Response response = client.newCall(request).execute()){
            if(response.isSuccessful() && response.body() != null) {
                String responseString = response.body().toString();
                document = Document.parse(responseString);
            }
            else{
                Toast.makeText(context, "No records found", Toast.LENGTH_SHORT).show();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        documentToAnimal(document);

        return animal;
    }


}
