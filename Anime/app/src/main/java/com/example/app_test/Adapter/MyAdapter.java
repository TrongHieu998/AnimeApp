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
import com.example.app_test.Model.Library;
import com.example.app_test.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ListViewHolder> {
    private Context context;
    private List<Library> libraryList;

    public MyAdapter(Context context, List<Library> libraryList) {
        this.context = context;
        this.libraryList = libraryList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mview= LayoutInflater.from(context).inflate(R.layout.item_library_1,parent,false);
        return new ListViewHolder(mview);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Glide.with(context)
                .load(libraryList.get(position).getAnh())
                .into(holder.img);
        holder.ten.setText(libraryList.get(position).getTen());
        holder.tap.setText(libraryList.get(position).getTap());
    }

    @Override
    public int getItemCount() {
        return libraryList.size();
    }
}
class ListViewHolder extends RecyclerView.ViewHolder{
    ImageView img;
    TextView ten,tap;
    public ListViewHolder (@NonNull View view)
    {
        super(view);
        img=view.findViewById(R.id.img_phim1);
        ten=view.findViewById(R.id.txt_tenphim1);
        tap=view.findViewById(R.id.txt_tapphim1);
    }
}