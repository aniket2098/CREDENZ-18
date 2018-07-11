package com.example.admin.credenz18;

import java.util.ArrayList;

public class Event {

 static public ArrayList<Event> events = new ArrayList<>();

    private String eventName;
    private int eventPrice;
    private boolean eventCheck;

    public Event(String event,Integer price,boolean check) {
        eventName = event;
        eventPrice = price;
        eventCheck = check;
    }

    public String getName() {
        return eventName;
    }

    public Integer getPrice() {
        return eventPrice;
    }

    public boolean getCheck(){
        return eventCheck;
    }

    public static ArrayList<Event> createContactsList() {

        events.clear();
        events.add(new Event("  B-Plan",10,false));
        events.add(new Event("  Contraption",20,false));
        events.add(new Event("  Clash",30,false));
        events.add(new Event("  Cretronix",40,false));
        events.add(new Event("  Croodle",50,false));
        events.add(new Event("  MAD Talks",60,false));
        events.add(new Event("  NTH",70,false));
        events.add(new Event("  Paper\n  Presentation",80,false));
        events.add(new Event("  Pixelate",90,false));
        events.add(new Event("  Roboliga",100,false));
        events.add(new Event("  Reverse\n  Coding",120,false));
        events.add(new Event("  Quiz",130,false));
        events.add(new Event("  Software\n  Development",140,false));
        events.add(new Event("  Seminars",150,false));
        events.add(new Event("  Web Weaver",160,false));
        events.add(new Event("  Wall Street",170,false));
        events.add(new Event("  Xodia",180,false));
        events.add(new Event("  Workshop",190,false));
        return events;
    }

    public void modify(int position,boolean value)
    {
        events.get(position).eventCheck=value;
    }

}
