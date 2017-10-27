package com.example.ravi.machinetest2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ravi on 26/10/17.
 */

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.DataVieholder> {

    ArrayList<Data> marrylist;
    Context mcontext;

    public RecyAdapter(ArrayList<Data> marrylist, Context mcontext) {
        this.marrylist = marrylist;
        this.mcontext = mcontext;
    }

    @Override
    public DataVieholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_layout,null);

        return new DataVieholder(view);
    }

    @Override
    public void onBindViewHolder(DataVieholder holder, int position) {
        Data data = marrylist.get(position);

        holder.textView.setText(data.getmTitle());
        holder.txtDes.setText(data.getmDescription());
        Picasso.with(mcontext).load(data.getLImg()).into(holder.imageView);

    }



    @Override
    public int getItemCount() {
        return marrylist.size();
    }

    class DataVieholder extends RecyclerView.ViewHolder
    {
        TextView textView,txtDes;
        ImageView imageView;


        public DataVieholder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.xtxtTitle);
            txtDes = (TextView) itemView.findViewById(R.id.xtxtdes);
            imageView = (ImageView) itemView.findViewById(R.id.xImg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Data data = marrylist.get(getAdapterPosition());

                    Intent intent  = new Intent(mcontext,Main2Activity.class);
                    intent.putExtra("Re",data);
                    mcontext.startActivity(intent);
                }
            });


        }
    }
}
