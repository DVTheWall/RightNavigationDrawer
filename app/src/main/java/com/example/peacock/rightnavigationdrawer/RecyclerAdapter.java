package com.example.peacock.rightnavigationdrawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by peacock on 25/11/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder> {

    Context context;
    ArrayList<DataModel> itemlist = null;


    public RecyclerAdapter(Context context, ArrayList<DataModel> itemlist) {
        this.context = context;
        this.itemlist = itemlist;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {

        DataModel dataModel = itemlist.get(position);

        holder.txtData.setText(dataModel.getName());
    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {

        TextView txtData;

        public viewHolder(View itemView) {
            super(itemView);


            txtData = itemView.findViewById(R.id.txtData);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Toast.makeText(context, "Position : " + getAdapterPosition(), Toast.LENGTH_SHORT).show();

                }
            });

        }


    }
}

