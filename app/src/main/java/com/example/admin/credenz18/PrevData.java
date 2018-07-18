package com.example.admin.credenz18;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PrevData {

    private String name;
    private String date;
    private int total;
    private int noOfEvents;
    private String uniId;


    public String getRegName()
    {
        return name;
    }

    public String getRegDate()
    {
        return date;
    }

    public String getUniId()
    {
        return uniId;
    }

    public int gettotal()
    {
        return total;
    }

    public int getNoOfEvents()
    {
        return noOfEvents;
    }

    PrevData(String nameOfPerson,String id,int tot,int no,String prevDate)
    {
        name=nameOfPerson;
        uniId=id;
        total=tot;
        noOfEvents=no;
        date=prevDate;
    }
    private ArrayList<PrevData> retrieve;

    public ArrayList retrieveData()
    {

        return retrieve;
    }


}
