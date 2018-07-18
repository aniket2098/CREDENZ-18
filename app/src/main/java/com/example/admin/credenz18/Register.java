package com.example.admin.credenz18;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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
    public List<Event> receipt=new ArrayList<>();


    private static String TABLE_NAME="prev_reg";
    private static String COLUMN1="name";
    private static String COLUMN2="date";
    private static String COLUMN3="total";
    private static String COLUMN4="total_events";
    private static String COLUMN5="unique_id";
    SQLiteDatabase sqLiteDatabase;

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
        Bundle bundle = getIntent().getExtras();
        String name=bundle.getString("name");
        Date c=Calendar.getInstance().getTime();
        SimpleDateFormat d=new SimpleDateFormat("dd-MM-yyyy");
        prevData=new PrevData(name,"UNIQUE",total,receipt.size(),d.format(c));

        sqLiteDatabase=openOrCreateDatabase("previousData",MODE_PRIVATE,null);

        sqLiteDatabase.execSQL("create table if not exists " + TABLE_NAME + "("
                + COLUMN1 + " varchar(30)" + ","
                + COLUMN2 + " varchar(30)" + ","
                + COLUMN3 + " integer"  + ","
                + COLUMN4 + " integer"  + ","
                + COLUMN5 + " varchar(30)"  +
                ");" );

        ContentValues contentValues=new ContentValues();

        contentValues.put(COLUMN1,prevData.getRegName());
        contentValues.put(COLUMN2,prevData.getRegDate());
        contentValues.put(COLUMN3,prevData.gettotal());
        contentValues.put(COLUMN4,prevData.getNoOfEvents());
        contentValues.put(COLUMN5,prevData.getUniId());

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        Cursor cursor=sqLiteDatabase.rawQuery("select * from " + TABLE_NAME + ";",null);

        cursor.moveToNext();

        cursor.close();
        sqLiteDatabase.close();
    }
    @Override
    public void onBackPressed() {

    }

}
