package com.example.admin.credenz18;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class Database{


    private static String TABLE_NAME="prev_reg";
    private static String NAME="name";
    private static String DATE="date";
    private static String TOTAL="total";
    private static String NO="total_events";
    private static String ID="unique_id";
    private static String NAME2="name2";
    private static String NAME3="name3";
    private static String NAME4="name4";
    private static String EMAIL="email";
    private static String PHONE="phone";
    private static String COLLEGE="college";

    private static String UID="uid";
    private static String EVENT="event";

    SQLiteDatabase sqLiteDatabase;

    Database(PrevData prevData, SQLiteDatabase sqLiteDatabase)
    {

        sqLiteDatabase.execSQL("create table if not exists " + TABLE_NAME + "("
                + NAME + " varchar(30)" + ","
                + NAME2 + " varchar(30)" + ","
                + NAME3 + " varchar(30)" + ","
                + NAME4 + " varchar(30)" + ","
                + EMAIL + " varchar(30)" + ","
                + PHONE + " varchar(30)" + ","
                + DATE + " varchar(30)" + ","
                + TOTAL + " integer"  + ","
                + NO + " integer"  + ","
                + COLLEGE + " varchar(30)" + ","
                + ID + " varchar(30)" + " primary key" +
                ");" );

        sqLiteDatabase.execSQL("create table if not exists " + "EVENTS" + "("
                + UID + " varchar(30)" + ","
                + EVENT + " varchar(20), foreign key (" + UID + ") references " + TABLE_NAME + "(" + ID + ")"
                + ");");


        ContentValues contentValues=new ContentValues();

        contentValues.put(NAME,prevData.getRegName());
        contentValues.put(NAME2,prevData.getRegName2());
        contentValues.put(NAME3,prevData.getRegName3());
        contentValues.put(NAME4,prevData.getRegName4());
        contentValues.put(EMAIL,prevData.getRegEmail());
        contentValues.put(PHONE,prevData.getRegPhone());
        contentValues.put(DATE,prevData.getRegDate());
        contentValues.put(TOTAL,prevData.gettotal());
        contentValues.put(NO,prevData.getNoOfEvents());
        contentValues.put(ID,prevData.getUniId());
        contentValues.put(COLLEGE, prevData.getRegCollege());

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        contentValues.clear();
        for(int i=0;i<prevData.getReceipt().size();i++)
        {
            contentValues.put(UID,prevData.getUniId());
            contentValues.put(EVENT,prevData.getReceipt().get(i).getName());

            sqLiteDatabase.insert("EVENTS",null,contentValues);
        }


        sqLiteDatabase.close();
    }
}
