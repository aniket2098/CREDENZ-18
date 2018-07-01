package com.example.admin.credenz18;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class Register extends AppCompatActivity {

    ArrayList<Event> events;
    RegisterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RecyclerView rvContacts = findViewById(R.id.rv);
        events = Event.createContactsList();
        adapter = new RegisterAdapter(events);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        Button register = findViewById(R.id.registerButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                            //SEND  ArrayList 'receipt' to the server
                for(int i=0;i<5;i++)                                    //'receipt.get(i).getName()' will return the name at position i
                {                                                       //'receipt.get(i).getPrice()' will return the price of the event at position i
                    Log.i("event", adapter.receipt.get(i).getName());
                }
                Intent intent = new Intent(Register.this,QRCode.class);
                startActivity(intent);
            }
        });
    }
}
