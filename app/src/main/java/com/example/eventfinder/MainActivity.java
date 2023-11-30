package com.example.eventfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Event> eventList = new ArrayList<>();
    RecyclerView re;
    private EventAdapter eAdapter;
    private ArrayList<Event> event = new ArrayList<Event>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        re = findViewById(R.id.recycler);
        //String n, String d, String t, String l, String dr)
        event.add(new Event("Happy Hawks Hackathon" , "12/8/23" , "12:30" , "Galvin Library" , "Bring your friends!"));
        event.add(new Event("Student Government meeting" , "Tuesday" , "7:00" , "Kaplan" , "We will discuss chartwells decision to make school lunch even worse"));
        event.add(new Event("Tennis Club" , "12/13/23" , "3:59" , "Tennis Courts" , "Singles tournament"));
        event.add(new Event("Squirrels Watching Olympics " , "11/11/23" , "3:01" , "Man on a bench park" , "We will be watching fat frank eat 200 nuts in an hour"));
        event.add(new Event("Rock Climbing" , "Wednesday" , "5:00" , "MTCC" , "Meet us for weekly climbing gym trips"));
        event.add(new Event("Lettuce club" , "12/25/23" , "8:00" , "Fire place" , "Christmas morning lettuce breakfast for international students"));
        event.add(new Event("Student Life" , "10/31/23" , "7:30" , "Your Dorm" , "Reverse trick or treat!"));


        eAdapter = new EventAdapter (event, this);

        re.setAdapter(eAdapter);

        re.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));


    }
    public boolean onCreateOptionsMenu(@NonNull Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    public boolean switchAccountMenu(MenuItem mi){

        //Log.d(TAG, "switchActivity: ");
        Intent intent = new Intent(this, Account.class);
//        intent.putExtra("deg" , deg);
//        intent.putExtra("location" , location);
        //add things to intent
        startActivity(intent);

        return true;
    }

    public boolean switchModerationMenu(MenuItem mi){

        //Log.d(TAG, "switchActivity: ");
        Intent intent = new Intent(this, Moderate.class);

        //add things to intent
        startActivity(intent);

        return true;
    }
    public boolean switchCreateEventMenu(MenuItem mi){

        //Log.d(TAG, "switchActivity: ");
        Intent intent = new Intent(this, CreateEvent.class);

        //add things to intent
        startActivity(intent);

        return true;
    }
    public boolean switchEventsMenu(MenuItem mi){

        //Log.d(TAG, "switchActivity: ");
        Intent intent = new Intent(this, MainActivity.class);

        //add things to intent
        startActivity(intent);

        return true;
    }
}