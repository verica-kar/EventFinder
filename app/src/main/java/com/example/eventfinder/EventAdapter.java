package com.example.eventfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private final List<Event> eventList;
    private final MainActivity mainAct;

    public EventAdapter(List<Event> empList, MainActivity ma){
        this.eventList = empList;
        mainAct = ma;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_entries, parent, false);

//        itemView.setOnClickListener(mainAct);
//        itemView.setOnLongClickListener(mainAct);

        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = eventList.get(position);

        holder.name.setText(event.getName());
        holder.date.setText(event.getDate());
        holder.time.setText(event.getTime());
        holder.loc.setText(event.getLocation());
        holder.des.setText(event.getDescription());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}