package com.example.eventfinder;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.JsonWriter;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Event> eventList = new ArrayList<>();
    RecyclerView re;
    private EventAdapter eAdapter;
    private ArrayList<Event> event = new ArrayList<Event>();
    private ActivityResultLauncher<Intent> activityResultLauncher;


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

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                this::handleResult);

        eAdapter = new EventAdapter (event, this);

        re.setAdapter(eAdapter);

        re.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));

        this.loadFile();
    }

    public void handleResult(ActivityResult activityResult) {
        if (activityResult.getResultCode() == RESULT_OK){
            Intent data = activityResult.getData();
            if (data == null) {
                this.saveNote();
                return;
            }
            if (data.hasExtra("NEW_EVENT")) {
                Event newEvent = (Event) data.getSerializableExtra("NEW_EVENT");
                eventList.add(0, newEvent);
                eAdapter.notifyItemInserted(0);
                this.saveNote();
            } else if (data.hasExtra("UPDATE_EVENT")) {
                Event editEvent = (Event) data.getSerializableExtra("UPDATE_EVENT");
                int pos = data.getIntExtra("UPDATE_POS", 0);

                Event toUpdate = eventList.get(pos);
                toUpdate.setName(editEvent.getName());
                toUpdate.setDate(editEvent.getDate());
                toUpdate.setTime(editEvent.getTime());
                toUpdate.setLocation(editEvent.getLocation());
                toUpdate.setDescription(editEvent.getDescription());
                eAdapter.notifyItemChanged(pos);

                eventList.remove(pos);
                eAdapter.notifyItemRemoved(pos);

                eventList.add(0, toUpdate);
                eAdapter.notifyItemInserted(0);
                this.saveNote();
            }
        }
    }

    private void loadFile() {
        try {
            InputStream is = getApplicationContext().openFileInput(getString(R.string.file_name));
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }

            JSONArray jsonArray = new JSONArray(sb.toString());
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");
                    String date = jsonObject.getString("date");
                    String time = jsonObject.getString("time");
                    String loc = jsonObject.getString("loc");
                    String des = jsonObject.getString("des");
                    eventList.add(new Event(name, date, time, loc, des));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveNote() {
        String output = toJSON(eventList);
        try {
            FileOutputStream fos = getApplicationContext().openFileOutput("Note.json", Context.MODE_PRIVATE);
            PrintWriter printWriter = new PrintWriter(fos);
            printWriter.print(output);
            printWriter.close();
            fos.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public String toJSON(ArrayList<Event> event){

        try {
            StringWriter sw = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(sw);
            jsonWriter.setIndent(" ");

            jsonWriter.beginArray();
            for(Event n : event) {
                jsonWriter.beginObject();

                jsonWriter.name("name").value(n.getName());
                jsonWriter.name("date").value(n.getDate());
                jsonWriter.name("time").value(n.getTime());
                jsonWriter.name("loc").value(n.getLocation());
                jsonWriter.name("des").value(n.getDescription());

                jsonWriter.endObject();
            }
            jsonWriter.endArray();

            jsonWriter.close();
            return sw.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
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