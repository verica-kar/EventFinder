package com.example.eventfinder;

import java.io.Serializable;

public class Event implements Serializable {

    String name, date, time, location, description;

    public Event(String n, String d, String t, String l, String dr) {
        name = n;
        date = d;
        time = t;
        location = l;
        description = dr;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }
}
