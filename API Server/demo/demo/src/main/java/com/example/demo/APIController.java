package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import org.bson.Document;


@RestController
public class APIController {

    @GetMapping("/animals")
    ArrayList<Document> getAll(){
        return DatabaseHandler.getInstance().readAnimals();
    }

    @GetMapping("/animals/{id}")
    Document getOne(@PathVariable String id){
        return DatabaseHandler.getInstance().findOne(id);
    }

    @PostMapping("/animals")
    void updateOne(@RequestBody Document animal){
        DatabaseHandler.getInstance().updateData(animal);
    }

    @PutMapping("/animals")
    void createAnimal(@RequestBody Document animal){
        DatabaseHandler.getInstance().insertAnimal(animal);
    }

    @DeleteMapping("/animals")
    void deleteAnimal(@RequestBody Document animal){
        DatabaseHandler.getInstance().deleteAnimal(animal);
    }
}
