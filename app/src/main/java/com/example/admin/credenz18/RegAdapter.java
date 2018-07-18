package com.example.admin.credenz18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

class RegAdapter extends
        RecyclerView.Adapter<RegAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView date;
        public TextView id;
        public TextView total;
        public TextView no;

        public ViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.part_name);
            date=itemView.findViewById(R.id.date);
            id=itemView.findViewById(R.id.uniId);
            total=itemView.findViewById(R.id.totPrice);
            no=itemView.findViewById(R.id.totEvents);
        }
    }


    @Override
    public RegAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.receipt_rv, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    private ArrayList<PrevData> data;


    public RegAdapter(ArrayList<PrevData> registration) {
        data = registration;
    }


    @Override
    public void onBindViewHolder(final RegAdapter.ViewHolder viewHolder, final int position) {
        final PrevData prevData=data.get(position);
        viewHolder.name.setText(prevData.getRegName());
        viewHolder.date.setText(prevData.getRegDate());
        viewHolder.id.setText(prevData.getUniId());
        viewHolder.total.setText("Total: "+Integer.toString(prevData.gettotal()));
        viewHolder.no.setText("No. of Events: "+Integer.toString(prevData.getNoOfEvents()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
