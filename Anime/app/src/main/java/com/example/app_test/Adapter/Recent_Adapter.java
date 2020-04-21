package com.example.app_test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.app_test.Model.Detail_model;
import com.example.app_test.R;

import java.util.ArrayList;

public class Recent_Adapter extends RecyclerView.Adapter<Recent_Adapter.ViewHolder> {
    ArrayList<Detail_model> detail_modelArrayList;
    Context context;

    public Recent_Adapter(ArrayList<Detail_model> detail_modelArrayList, Context context) {
        this.detail_modelArrayList = detail_modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_library_1,parent,false);
        return new Recent_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Detail_model detail_model=detail_modelArrayList.get(position);
        holder.title.setText(detail_model.getTitle());
        holder.minutes.setText(detail_model.getMinutes());
    }

    @Override
    public int getItemCount() {
        return detail_modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, minutes;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.txt_tenphim1);
            minutes=itemView.findViewById(R.id.txt_tapphim1);
        }
    }

}
