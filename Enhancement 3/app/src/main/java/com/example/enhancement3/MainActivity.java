package com.example.enhancement3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity extends AppCompatActivity {

    ArrayList<AnimalEntry> animalList = new ArrayList<>();

    RecyclerViewAdapter recyclerViewAdapter;

    DBHandler db = new DBHandler(this);

    RecyclerView animalsRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* For testing purposes
        AnimalEntry animal1 = new AnimalEntry(1, "1", "A1111111", "1", "Golden Retriever Mix", "1", "1", "1", "Euthanised", "Intact Female");
        AnimalEntry animal2 = new AnimalEntry(2, "2", "A2222222", "2", "German Shepard", "1", "1", "1", "Returned to Owner", "Neutered Male");
        AnimalEntry animal3 = new AnimalEntry(3, "1", "A3333333", "1", "English Shorthair", "1", "1", "1", "Adopted", "Intact Male");
        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);

         */
        System.out.println("about to attempt connection");

        animalList = db.readAnimals();


        recyclerViewAdapter = new RecyclerViewAdapter(animalList, MainActivity.this);
        animalsRV = findViewById(R.id.animal_data);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        animalsRV.setLayoutManager(layoutManager);
        animalsRV.setAdapter(recyclerViewAdapter);
    }

    public void addAnimal(View view){
        Intent intent = new Intent(this, AddAnimalActivity.class);
        startActivity(intent);
    }
}