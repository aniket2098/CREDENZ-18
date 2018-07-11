package com.example.admin.credenz18;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Register extends Activity {
    ArrayList<Event> events;
    RegisterAdapter adapter;
    TextView textView;
    int total;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.toolbar);
        textView = findViewById(R.id.total);
//        setSupportActionBar(toolbar);
        view = this.findViewById(android.R.id.content);
        final RecyclerView rvContacts = findViewById(R.id.rv);
        events = Event.createContactsList();
        adapter = new RegisterAdapter(events);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        Button register = findViewById(R.id.registerButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                            //SEND  ArrayList 'receipt' to the server
                Intent intent = new Intent(Register.this, QRCode.class);
                startActivity(intent);
            }
        });

//        rvContacts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(Register.this, "Successful!", Toast.LENGTH_LONG).show();
//            }
//        });

    }

    public void modify() {

        ((TextView)view.findViewById(R.id.total)).setText("Hello world");

    }
}
