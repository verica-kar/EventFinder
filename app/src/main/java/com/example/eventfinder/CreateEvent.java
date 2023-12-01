package com.example.eventfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateEvent extends AppCompatActivity {

    EditText name;
    EditText date;
    EditText time;
    EditText loc;
    EditText des;
    Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        getSupportActionBar().setTitle("Create Event");

        name = findViewById(R.id.eventName);
        date = findViewById(R.id.eventDate);
        time = findViewById(R.id.startTime);
        loc = findViewById(R.id.location);
        des = findViewById(R.id.description);
        des.setMovementMethod(new ScrollingMovementMethod());
        sub = findViewById(R.id.button);
        Event event;

        Intent intent = getIntent();
        if (intent.hasExtra("EDIT_EVENT")){
            event = (Event) intent.getSerializableExtra("EDIT_EVENT");
            name.setText(event.getName());
            date.setText(event.getDate());
            time.setText(event.getTime());
            loc.setText(event.getLocation());
            des.setText(event.getDescription());
        }
    }

    public void submitButton(View view) {
        if (!name.getText().toString().isEmpty() && !date.getText().toString().isEmpty() && !time.getText().toString().isEmpty() && !loc.getText().toString().isEmpty() && !des.getText().toString().isEmpty()) {
            Event e = new Event(name.getText().toString(), date.getText().toString(), time.getText().toString(), loc.getText().toString(), des.getText().toString());

            String key = "NEW_EVENT";

            Intent intent = getIntent();
            if (intent.hasExtra("EDIT_EVENT")) {
                key = "UPDATE_EVENT";
            }

//            if (e != null) {
//                if (e.getTitle().equals(title2) && e.getNoteText().equals(text2)) {
//                    onBackPressed();
//                }
//            }

<<<<<<< HEAD
            Intent data = new Intent(this, MainActivity.class);
=======
            Intent data = new Intent(this , MainActivity.class);
>>>>>>> cc9682d635be5c8aee2a5f8d551e73582ce5733b
            data.putExtra(key, e);
            if (intent.hasExtra("EDIT_POS")) {
                int pos = intent.getIntExtra("EDIT_POS", 0);
                data.putExtra("UPDATE_POS", pos);
            }
            startActivity(data);

        } else if (name.getText().toString().isEmpty() || date.getText().toString().isEmpty() || time.getText().toString().isEmpty() || loc.getText().toString().isEmpty() || des.getText().toString().isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    CreateEvent.super.onBackPressed();
                }
            });
            builder.setTitle("Missing Information");
            builder.setMessage("Your event will not save without all information.");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }



    @Override
    public void onBackPressed() {
//        String title2 = title.getText().toString();
//        String text2 = text.getText().toString();
//
//        if (note != null){
//            if (note.getTitle().equals(title2) && note.getNoteText().equals(text2)){
//                super.onBackPressed();
//            }
//        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                onOptionsItemSelected(null);
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                CreateEvent.super.onBackPressed();
            }
        });
        builder.setTitle("Unsaved Changes");
        builder.setMessage("Do you want to save your changes before exiting?");
        AlertDialog dialog = builder.create();
        dialog.show();
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
//    public boolean switchCreateEventMenu(MenuItem mi){
//
//        //Log.d(TAG, "switchActivity: ");
//        Intent intent = new Intent(this, CreateEvent.class);
//
//        //add things to intent
//        startActivity(intent);
//
//        return true;
//    }
    public boolean switchEventsMenu(MenuItem mi){

        //Log.d(TAG, "switchActivity: ");
        Intent intent = new Intent(this, MainActivity.class);

        //add things to intent
        startActivity(intent);

        return true;
    }
}