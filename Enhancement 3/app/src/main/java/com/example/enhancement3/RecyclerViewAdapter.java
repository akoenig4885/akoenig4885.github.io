package com.example.enhancement3;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<AnimalEntry> animalList;

    private Context context;

    DBHandler db;


    public RecyclerViewAdapter(ArrayList<AnimalEntry> animalList, Context context){
        this.animalList = animalList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position){
        AnimalEntry entry = animalList.get(position);
        holder.idTextView.setText(entry.animal_id);
        holder.nameTextView.setText(entry.name);
        holder.breedTextView.setText(entry.breed);
        holder.outcomeTextView.setText(entry.outcome_type);
        holder.editButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), EditActivity.class);
                intent.putExtra("id", entry.animal_id);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return animalList.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView idTextView;
        private TextView nameTextView;
        private TextView breedTextView;
        private TextView outcomeTextView;
        private Button editButton;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            idTextView = itemView.findViewById(R.id.animal_id_value);
            nameTextView = itemView.findViewById(R.id.name_value);
            breedTextView = itemView.findViewById(R.id.breed_value);
            outcomeTextView = itemView.findViewById(R.id.outcome_value);
            editButton = itemView.findViewById(R.id.edit_button);
        }


    }

}
