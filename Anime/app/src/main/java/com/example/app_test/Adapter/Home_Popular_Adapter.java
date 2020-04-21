package com.example.app_test.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_test.Activity.Detail_Popular_Activity;
import com.example.app_test.Model.Popular;
import com.example.app_test.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Home_Popular_Adapter extends RecyclerView.Adapter<Home_Popular_Adapter.ViewHolder> {
    private ArrayList<Popular> popularArrayList;
    private Context context;

    public Home_Popular_Adapter(ArrayList<Popular> popularArrayList, Context context) {
        this.popularArrayList = popularArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Home_Popular_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_popular,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Home_Popular_Adapter.ViewHolder holder, int position) {
        Popular popular= popularArrayList.get(position);
//        Glide.with(context)
//                .load(popularArrayList.get(position).getImg())
//                .into(holder.img);

        Picasso.get().load(popular.getImg()).into(holder.img);
        holder.title.setText(popular.getTitle());
        holder.genres.setText(popular.getGenres());
        holder.lastest.setText(popular.getLastest());
    }
    @Override
    public int getItemCount() {
        return popularArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView img;
        TextView title,genres,lastest;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_itemHome_popular);
            title=itemView.findViewById(R.id.txt_itemHome_Title);
            genres=itemView.findViewById(R.id.txt_itemHome_Genres);
            lastest=itemView.findViewById(R.id.txt_itemHome_Laster);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            Popular popular=popularArrayList.get(position);
            Intent intent=new Intent(context, Detail_Popular_Activity.class);
            intent.putExtra("image",popular.getImg());
            intent.putExtra("title",popular.getTitle());
            intent.putExtra("genre",popular.getGenres());
            intent.putExtra("laster",popular.getLastest());
            intent.putExtra("type",popular.getType());
            intent.putExtra("detailUrl",popular.getDetailUrl());
            context.startActivity(intent);
        }
    }
}
