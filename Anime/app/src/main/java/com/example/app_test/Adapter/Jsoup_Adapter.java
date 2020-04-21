package com.example.app_test.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_test.Activity.Detail;
import com.example.app_test.Model.Jsoup_model;
import com.example.app_test.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Jsoup_Adapter extends RecyclerView.Adapter<Jsoup_Adapter.ViewHolder> {
    ArrayList<Jsoup_model> jsoupArrayList;
    Context context;
    public Jsoup_Adapter(ArrayList<Jsoup_model> jsoupArrayList, Context context) {
        this.jsoupArrayList = jsoupArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public Jsoup_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jsoup,parent,false);
//        return new ViewHolder(view);
        View view = LayoutInflater.from(context).inflate(R.layout.item_jsoup,parent,false);

        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (parent.getWidth()/2.8);
       // Log.d("avc",(parent.getWidth()/3)+"");
        view.setLayoutParams(layoutParams);

        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull Jsoup_Adapter.ViewHolder holder, int position) {
        Jsoup_model jsoup_model=jsoupArrayList.get(position);
        holder.ten.setText(jsoup_model.getTen());
        holder.tap.setText(jsoup_model.getTap());
        Picasso.get().load(jsoup_model.getImg()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return jsoupArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView ten,tap;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_item_jsoup);
            ten=itemView.findViewById(R.id.tenphim_jsoup);
            tap=itemView.findViewById(R.id.tapphim_jsoup);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            Jsoup_model jsoup_model=jsoupArrayList.get(position);
            Intent intent=new Intent(context, Detail.class);
            intent.putExtra("image",jsoup_model.getImg());
            intent.putExtra("title",jsoup_model.getTen());
            intent.putExtra("episode",jsoup_model.getTap());
            intent.putExtra("detailUrl",jsoup_model.getDetailUrl());
            context.startActivity(intent);
        }
    }
}
