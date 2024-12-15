package com.example.enhancement3;

import android.os.Bundle;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.Manifest;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;


public class AddAnimalActivity extends AppCompatActivity {

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
    Button addAnimalButton;
    boolean recHasText = false;
    boolean idHasText = false;
    boolean nameHasText = false;
    boolean sexHasText = false;
    boolean birthHasText = false;
    boolean dischargeHasText = false;
    boolean outcomeHasText = false;
    boolean breedHasText = false;
    boolean ageHasText = false;
    boolean typeHasText = false;
    boolean colorHasText = false;

    DBHandler db = new DBHandler(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_animal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recEditText = findViewById(R.id.add_rec_edit_text);
        idEditText = findViewById(R.id.add_id_edit_text);
        ageEditText = findViewById(R.id.add_age_edit_text);
        sexEditText = findViewById(R.id.add_sex_edit_text);
        breedEditText = findViewById(R.id.add_breed_edit_text);
        colorEditText = findViewById(R.id.add_color_edit_text);
        birthEditText = findViewById(R.id.add_birth_edit_text);
        dischargeEditText = findViewById(R.id.add_discharge_time_edit_text);
        nameEditText = findViewById(R.id.add_name_edit_text);
        typeEditText = findViewById(R.id.add_type_edit_text);
        outcomeEditText = findViewById(R.id.add_outcome_edit_text);
        addAnimalButton = findViewById(R.id.add_animal_button);
        addAnimalButton.setEnabled(false);

        //Text listeners to ensure edit texts have data
        recEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String rec = recEditText.getText().toString();
                recHasText = !rec.isEmpty();
                if (idHasText && nameHasText && sexHasText && birthHasText && dischargeHasText
                        && outcomeHasText && breedHasText && ageHasText && typeHasText) {
                    addAnimalButton.setEnabled(true);
                } else {
                    addAnimalButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        idEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String id = idEditText.getText().toString();
                idHasText = !id.isEmpty();
                if (idHasText && nameHasText && sexHasText && birthHasText && dischargeHasText
                        && outcomeHasText && breedHasText && ageHasText && typeHasText) {
                    addAnimalButton.setEnabled(true);
                } else {
                    addAnimalButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String age = ageEditText.getText().toString();
                ageHasText = !age.isEmpty();
                if (idHasText && nameHasText && sexHasText && birthHasText && dischargeHasText
                        && outcomeHasText && breedHasText && ageHasText && typeHasText) {
                    addAnimalButton.setEnabled(true);
                } else {
                    addAnimalButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        sexEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String sex = sexEditText.getText().toString();
                sexHasText = !sex.isEmpty();
                if (idHasText && nameHasText && sexHasText && birthHasText && dischargeHasText
                        && outcomeHasText && breedHasText && ageHasText && typeHasText) {
                    addAnimalButton.setEnabled(true);
                } else {
                    addAnimalButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        breedEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String breed = breedEditText.getText().toString();
                breedHasText = !breed.isEmpty();
                if (idHasText && nameHasText && sexHasText && birthHasText && dischargeHasText
                        && outcomeHasText && breedHasText && ageHasText && typeHasText) {
                    addAnimalButton.setEnabled(true);
                } else {
                    addAnimalButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        colorEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String color = colorEditText.getText().toString();
                colorHasText = !color.isEmpty();
                if (idHasText && nameHasText && sexHasText && birthHasText && dischargeHasText
                        && outcomeHasText && breedHasText && ageHasText && typeHasText) {
                    addAnimalButton.setEnabled(true);
                } else {
                    addAnimalButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        birthEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String birth = birthEditText.getText().toString();
                birthHasText = !birth.isEmpty();
                if (idHasText && nameHasText && sexHasText && birthHasText && dischargeHasText
                        && outcomeHasText && breedHasText && ageHasText && typeHasText) {
                    addAnimalButton.setEnabled(true);
                } else {
                    addAnimalButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        dischargeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String discharge = dischargeEditText.getText().toString();
                dischargeHasText = !discharge.isEmpty();
                if (idHasText && nameHasText && sexHasText && birthHasText && dischargeHasText
                        && outcomeHasText && breedHasText && ageHasText && typeHasText) {
                    addAnimalButton.setEnabled(true);
                } else {
                    addAnimalButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String name = nameEditText.getText().toString();
                nameHasText = !name.isEmpty();
                if (idHasText && nameHasText && sexHasText && birthHasText && dischargeHasText
                        && outcomeHasText && breedHasText && ageHasText && typeHasText) {
                    addAnimalButton.setEnabled(true);
                } else {
                    addAnimalButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        typeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String type = typeEditText.getText().toString();
                typeHasText = !type.isEmpty();
                if (idHasText && nameHasText && sexHasText && birthHasText && dischargeHasText
                        && outcomeHasText && breedHasText && ageHasText && typeHasText) {
                    addAnimalButton.setEnabled(true);
                } else {
                    addAnimalButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        outcomeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String outcome = outcomeEditText.getText().toString();
                outcomeHasText = !outcome.isEmpty();
                if (idHasText && nameHasText && sexHasText && birthHasText && dischargeHasText
                        && outcomeHasText && breedHasText && ageHasText && typeHasText) {
                    addAnimalButton.setEnabled(true);
                } else {
                    addAnimalButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
    public void addAnimal(View view){
        AnimalEntry animal = new AnimalEntry();
        animal.rec_num = Integer.valueOf(recEditText.getText().toString());
        animal.animal_id = idEditText.getText().toString();
        animal.age_upon_outcome = ageEditText.getText().toString();
        animal.sex_upon_outcome = sexEditText.getText().toString();
        animal.breed = breedEditText.getText().toString();
        animal.color = colorEditText.getText().toString();
        animal.date_of_birth = birthEditText.getText().toString();
        animal.date_time = dischargeEditText.getText().toString();
        animal.name = nameEditText.getText().toString();
        animal.animal_type = typeEditText.getText().toString();
        animal.outcome_type = outcomeEditText.getText().toString();

        db.InsertAnimal(animal);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}