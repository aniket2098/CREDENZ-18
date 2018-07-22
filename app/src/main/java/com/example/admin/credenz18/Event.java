package com.example.admin.credenz18;

import java.util.ArrayList;

public class Event {


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



    public void modify(int position,boolean value,ArrayList<Event> events)
    {
        events.get(position).eventCheck=value;
    }

}
