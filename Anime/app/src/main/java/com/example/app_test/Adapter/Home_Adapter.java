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
import com.example.app_test.Model.Home;
import com.example.app_test.R;

import java.util.List;

public class Home_Adapter extends RecyclerView.Adapter<Home_ViewHolder> {
    private Context context;
    private List<Home> homeList;

    public Home_Adapter(Context context, List<Home> homeList) {
        this.context = context;
        this.homeList = homeList;
    }
    @NonNull
    @Override
    public Home_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_home,parent,false);
        return new Home_ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Home_ViewHolder holder, int position) {
        Glide.with(context)
                .load(homeList.get(position).getAnh())
                .into(holder.img);
        holder.tap.setText(homeList.get(position).getTap());
    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }
}
class Home_ViewHolder extends RecyclerView.ViewHolder{
    ImageView img;
    TextView tap;
    public Home_ViewHolder (@NonNull View view)
    {
        super(view);
        img=view.findViewById(R.id.img_item_home);
        tap=view.findViewById(R.id.sotap_item_home);
    }
}
