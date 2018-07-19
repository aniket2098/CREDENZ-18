package com.example.admin.credenz18;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Register extends AppCompatActivity{
    ArrayList<Event> events;
    TextView textView;
    int total;
    View view;
    PrevData prevData;
    public ArrayList<Event> receipt=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

         class RegisterAdapter extends
                RecyclerView.Adapter<RegisterAdapter.ViewHolder> {

             class ViewHolder extends RecyclerView.ViewHolder {

                public TextView event;
                public CheckBox box;
                public TextView price;

                public ViewHolder(View itemView) {
                    super(itemView);
                    event = (TextView) itemView.findViewById(R.id.event);
                    price = itemView.findViewById(R.id.price);
                    box = (CheckBox) itemView.findViewById(R.id.checkbox);
                }
             }


            @Override
            public RegisterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                Context context = parent.getContext();
                LayoutInflater inflater = LayoutInflater.from(context);
                View contactView = inflater.inflate(R.layout.recycler_item, parent, false);
                ViewHolder viewHolder = new ViewHolder(contactView);
                return viewHolder;
            }

            private List<Event> event;


            public RegisterAdapter(List<Event> events) {
                event = events;
            }

            @Override
            public int getItemCount() {
                return event.size();
            }
            @Override
            public void onBindViewHolder(final RegisterAdapter.ViewHolder viewHolder, final int position) {
                final Event register = event.get(position);
                TextView textView = viewHolder.event;
                textView.setText(register.getName());
                textView = viewHolder.price;
                textView.setText(String.valueOf(register.getPrice()));
                final CheckBox checkBox=viewHolder.box;
                checkBox.setChecked(event.get(position).getCheck());
                viewHolder.box.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = viewHolder.getAdapterPosition();
                        if(checkBox.isChecked()){
                            receipt.add(event.get(pos));
                            event.get(position).modify(position,true);
                            total+=event.get(position).getPrice();
                        }
                        else{
                            event.get(position).modify(position,false);
                            String temp=event.get(pos).getName();
                            for(int i=0;i<receipt.size();i++)
                            {
                                if(temp.equals(receipt.get(i).getName()))
                                {
                                    receipt.remove(i);
                                    total-=event.get(pos).getPrice();
                                }

                            }
                        }
                        ((TextView)findViewById(R.id.total)).setText(Integer.toString(total));
                    }
                });
            }
        }
        RegisterAdapter adapter;

        textView = findViewById(R.id.total);
        view = this.findViewById(android.R.id.content);
        final RecyclerView rvContacts = findViewById(R.id.rv);
        events = Event.createContactsList();
        adapter = new RegisterAdapter(events);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        Button register = findViewById(R.id.registerButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database();
                Intent intent = new Intent(Register.this, QRCode.class);
                startActivity(intent);
            }
        });
    }

    public void database()
    {
        SQLiteDatabase sqLiteDatabase=openOrCreateDatabase("previousData",MODE_PRIVATE,null);
        Bundle bundle = getIntent().getExtras();
        Date c=Calendar.getInstance().getTime();
        SimpleDateFormat d=new SimpleDateFormat("dd-MM-yyyy");
        prevData=new PrevData(bundle.getString("name"),bundle.getString("name2"),bundle.getString("name3"),bundle.getString("name4"),bundle.getString("phone"),bundle.getString("email"),bundle.getString("phone"),total,receipt.size(),d.format(c),bundle.getString("college"),receipt);
        Database database=new Database(prevData, sqLiteDatabase);
    }
    @Override
    public void onBackPressed() {

    }

}
