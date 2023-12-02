package com.example.eventfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Account extends AppCompatActivity {

    private AccountObj acc;
    TextView n;
    TextView e;
    TextView sn;
    TextView p;
    TextView no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        getSupportActionBar().setTitle("Account");

        acc = new AccountObj("John Smith", "jsmith@hawk.iit.edu", "A12345678", true, true);

        n = findViewById(R.id.accName);
        e = findViewById(R.id.email);
        sn = findViewById(R.id.stuNum);
        p = findViewById(R.id.yn1);
        no = findViewById(R.id.yn2);

        fillInfo();
    }

    public void fillInfo() {
        n.setText(acc.getName());
        e.setText(acc.getEmail());
        sn.setText(acc.getStuNum());

        if (acc.getPush()) {
            p.setText("Yes");
        } else {
            p.setText("No");
        }

        if (acc.getNotif()) {
            p.setText("Yes");
        } else {
            p.setText("No");
        }
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

    public void saveChanges (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}