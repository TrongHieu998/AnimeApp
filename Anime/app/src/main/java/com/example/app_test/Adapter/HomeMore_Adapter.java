package com.example.app_test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_test.Model.Jsoup_model;
import com.example.app_test.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeMore_Adapter extends RecyclerView.Adapter<HomeMore_Adapter.ViewHolder> {
    ArrayList<Jsoup_model> jsoupArrayList;
    Context context;

    public HomeMore_Adapter(ArrayList<Jsoup_model> jsoupArrayList, Context context) {
        this.jsoupArrayList = jsoupArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_more,parent,false);
        return new HomeMore_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Jsoup_model jsoup_model=jsoupArrayList.get(position);
        holder.ten.setText(jsoup_model.getTen());
        holder.tap.setText(jsoup_model.getTap());
        Picasso.get().load(jsoup_model.getImg()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return jsoupArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView ten,tap;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_item_home_more);
            ten=itemView.findViewById(R.id.tenphim_item_home_more);
            tap=itemView.findViewById(R.id.tapphim_item_home_more);
        }
    }
}
