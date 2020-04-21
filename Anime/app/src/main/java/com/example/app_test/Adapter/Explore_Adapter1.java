package com.example.app_test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app_test.Model.Explore;
import com.example.app_test.Model.Library;
import com.example.app_test.R;

import java.util.List;

public class Explore_Adapter1 extends RecyclerView.Adapter<ExploreViewholder> {
    private Context context;
    private List<Explore> exploreList;

    public Explore_Adapter1(Context context, List<Explore> exploreList) {
        this.context = context;
        this.exploreList = exploreList;
    }

    @NonNull
    @Override
    public ExploreViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mview= LayoutInflater.from(context).inflate(R.layout.item_explore_1,parent,false);
        return new ExploreViewholder(mview);
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreViewholder holder, int position) {
        Glide.with(context)
                .load(exploreList.get(position).getAnh())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return exploreList.size();
    }
}
class ExploreViewholder extends RecyclerView.ViewHolder{
    ImageView img;
    public ExploreViewholder (@NonNull View view)
    {
        super(view);
        img=view.findViewById(R.id.img_phim2);
    }
}
