package com.example.eventfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        re = findViewById(R.id.recycler);
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