package com.example.admin.credenz18;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

class ReceiptItems extends
        RecyclerView.Adapter<ReceiptItems.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.eventName);
        }
    }


    @Override
    public ReceiptItems.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.receipt_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    private ArrayList<String> event;


    public ReceiptItems(ArrayList<String> events) {

        event=events;
    }


    @Override
    public void onBindViewHolder(final ReceiptItems.ViewHolder viewHolder, final int position) {
//        final PrevData prevData = data.get(position);
        viewHolder.name.setText(event.get(position));
    }

    @Override
    public int getItemCount() {
        return event.size();
    }
}
