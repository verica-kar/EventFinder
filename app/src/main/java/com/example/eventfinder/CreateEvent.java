package com.example.eventfinder;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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

        //this.getActionBar().setTitle("Create Event");

        name = findViewById(R.id.eventName);
        date = findViewById(R.id.eventDate);
        time = findViewById(R.id.startTime);
        loc = findViewById(R.id.location);
        des = findViewById(R.id.description);
        des.setMovementMethod(new ScrollingMovementMethod());
        sub = findViewById(R.id.button);

//        Intent intent = getIntent();
//        if (intent.hasExtra("EDIT_NOTE")){
//            note = (Note) intent.getSerializableExtra("EDIT_NOTE");
//            title.setText(note.getTitle());
//            text.setText(note.getNoteText());
//        }
    }

    public void submitButton(View view) {
        Event e = new Event(name.getText().toString(), date.getText().toString(), time.getText().toString(), loc.getText().toString(), des.getText().toString());
        
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
}