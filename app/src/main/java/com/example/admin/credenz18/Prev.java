package com.example.admin.credenz18;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Prev extends AppCompatActivity {

    private ArrayList<PrevData> registrations=new ArrayList<>();
    PrevData prevData;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prev);

        final RecyclerView rv= findViewById(R.id.registrations);

        try
        {
        SQLiteDatabase sqLiteDatabase=openOrCreateDatabase("previousData",MODE_PRIVATE,null);
        Cursor cursor=sqLiteDatabase.rawQuery("select * from " + "prev_reg" + ";",null);

        if (cursor.moveToFirst()){
            do{
                prevData=new PrevData(cursor.getString(cursor.getColumnIndex("name")),
                        null,
                        null,
                        null,
                        null,
                        null,
                        cursor.getString(cursor.getColumnIndex("unique_id")),
                        cursor.getInt(cursor.getColumnIndex("total")),
                        cursor.getInt(cursor.getColumnIndex("total_events")),
                        cursor.getString(cursor.getColumnIndex("date")),
                        cursor.getString(cursor.getColumnIndex("college")),
                        null);
                registrations.add(prevData);
            }while(cursor.moveToNext());
        }
        cursor.close();

        RegAdapter adapter = new RegAdapter(registrations,Prev.this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(Prev.this));
        }
        catch(Exception e)
        {
            TextView textView=findViewById(R.id.message);
            textView.setVisibility(View.VISIBLE);
        }




    }
    public void goToNext(String uid)
    {

        Log.i("touch", "onInterceptTouchEvent: ");
    }

}
