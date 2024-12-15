package com.example.enhancement3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText recEditText;
    EditText idEditText;
    EditText ageEditText;
    EditText sexEditText;
    EditText breedEditText;
    EditText colorEditText;
    EditText birthEditText;
    EditText dischargeEditText;
    EditText nameEditText;
    EditText typeEditText;
    EditText outcomeEditText;
    String animalId;
    AnimalEntry animal;
    DBHandler db = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        animalId = intent.getStringExtra("id");
        animal = db.findOne(animalId);
        recEditText = findViewById(R.id.edit_rec_edit_text);
        recEditText.setText(animal.rec_num);
        idEditText = findViewById(R.id.edit_id_edit_text);
        idEditText.setText(animal.animal_id);
        ageEditText = findViewById(R.id.edit_age_edit_text);
        ageEditText.setText(animal.age_upon_outcome);
        sexEditText = findViewById(R.id.edit_sex_edit_text);
        sexEditText.setText(animal.sex_upon_outcome);
        breedEditText = findViewById(R.id.edit_breed_edit_text);
        breedEditText.setText(animal.breed);
        colorEditText = findViewById(R.id.edit_color_edit_text);
        colorEditText.setText(animal.color);
        birthEditText = findViewById(R.id.edit_birth_edit_text);
        birthEditText.setText(animal.date_of_birth);
        dischargeEditText = findViewById(R.id.edit_discharge_time_edit_text);
        dischargeEditText.setText(animal.date_time);
        nameEditText = findViewById(R.id.edit_name_edit_text);
        nameEditText.setText(animal.name);
        typeEditText = findViewById(R.id.edit_type_edit_text);
        typeEditText.setText(animal.animal_type);
        outcomeEditText = findViewById(R.id.edit_outcome_edit_text);
        outcomeEditText.setText(animal.outcome_type);
    }

    public void editAnimal(View view){
        AnimalEntry updatedAnimal = new AnimalEntry();
        updatedAnimal.rec_num = Integer.valueOf(recEditText.getText().toString());
        updatedAnimal.animal_id = idEditText.getText().toString();
        updatedAnimal.age_upon_outcome = ageEditText.getText().toString();
        updatedAnimal.sex_upon_outcome = sexEditText.getText().toString();
        updatedAnimal.breed = breedEditText.getText().toString();
        updatedAnimal.color = colorEditText.getText().toString();
        updatedAnimal.date_of_birth = birthEditText.getText().toString();
        updatedAnimal.date_time = dischargeEditText.getText().toString();
        updatedAnimal.name = nameEditText.getText().toString();
        updatedAnimal.animal_type = typeEditText.getText().toString();
        updatedAnimal.outcome_type = outcomeEditText.getText().toString();

        db.updateData(updatedAnimal);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void deleteAnimal(View view){

        db.deleteAnimal(animal);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}