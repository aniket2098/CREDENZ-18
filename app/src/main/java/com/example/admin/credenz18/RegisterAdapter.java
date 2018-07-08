package com.example.admin.credenz18;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RegisterAdapter extends
        RecyclerView.Adapter<RegisterAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView event;
        public CheckBox box;
        public TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            event = (TextView) itemView.findViewById(R.id.event);
            price=itemView.findViewById(R.id.price);
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
    public List<Event> receipt=new ArrayList<>();
    public int total=0;

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


        viewHolder.box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos = viewHolder.getAdapterPosition();
                if(viewHolder.box.isChecked()){
                    receipt.add(event.get(pos));
                    total+=event.get(pos).getPrice();

                }else{
                    String temp=event.get(pos).getName();
                    for(int i=0;i<receipt.size();i++)
                    {
                        if(temp.equals(receipt.get(i).getName()))
                            receipt.remove(i);
                    }
                }
            }
        });
    }
}

