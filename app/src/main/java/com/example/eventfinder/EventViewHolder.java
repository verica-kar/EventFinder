package com.example.eventfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EventViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    TextView date;
    TextView time;
    TextView loc;
    TextView des;


    public EventViewHolder(View view) {
        super(view);
        name = view.findViewById(R.id.name);
        date = view.findViewById(R.id.date);
        time = view.findViewById(R.id.time);
        loc = view.findViewById(R.id.loc);
        des = view.findViewById(R.id.desc);
    }
}