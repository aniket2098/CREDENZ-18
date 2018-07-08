package com.example.admin.credenz18;

import java.util.ArrayList;

public class Event {

 static public ArrayList<Event> events = new ArrayList<>();

    private String eventName;
    private int eventPrice;

    public Event(String event,Integer price) {
        eventName = event;
        eventPrice = price;
    }

    public String getName() {
        return eventName;
    }

    public Integer getPrice() {
        return eventPrice;
    }

    public static ArrayList<Event> createContactsList() {

        events.add(new Event("  B-Plan",10));
        events.add(new Event("  Contraption",20));
        events.add(new Event("  Clash",30));
        events.add(new Event("  Cretronix",40));
        events.add(new Event("  Croodle",50));
        events.add(new Event("  MAD Talks",60));
        events.add(new Event("  NTH",70));
        events.add(new Event("  Paper\n  Presentation",80));
        events.add(new Event("  Pixelate",90));
        events.add(new Event("  Roboliga",100));
        events.add(new Event("  Reverse\n  Coding",120));
        events.add(new Event("  Quiz",130));
        events.add(new Event("  Software\n  Development",140));
        events.add(new Event("  Seminars",150));
        events.add(new Event("  Web Weaver",160));
        events.add(new Event("  Wall Street",170));
        events.add(new Event("  Xodia",180));
        events.add(new Event("  Workshop",190));

        return events;
    }
}
