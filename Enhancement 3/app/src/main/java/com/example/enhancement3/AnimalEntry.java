package com.example.enhancement3;

public class AnimalEntry {
    public int rec_num;
    public String age_upon_outcome;
    public String animal_id;
    public String animal_type;
    public String breed;
    public String date_of_birth;
    public String date_time;
    public String name;
    public String outcome_type;
    public String sex_upon_outcome;

    public String color;


    public AnimalEntry(int rec_num, String age, String id, String type, String breed, String birth, String date, String name, String outcome, String sex){
        this.rec_num = rec_num;
        this.age_upon_outcome = age;
        this.animal_id = id;
        this.animal_type = type;
        this.breed = breed;
        this.date_of_birth = birth;
        this.date_time = date;
        this.name = name;
        this.outcome_type = outcome;
        this.sex_upon_outcome = sex;
    }

    public AnimalEntry(){

    }





}
