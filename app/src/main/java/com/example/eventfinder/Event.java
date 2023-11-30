package com.example.eventfinder;

public class Event {

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
}
