package com.example.app_test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app_test.Model.Explore;
import com.example.app_test.R;

import java.util.List;

public class Explore_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Explore> exploreList;

    public Explore_Adapter(Context context, int layout, List<Explore> exploreList) {
        this.context = context;
        this.layout = layout;
        this.exploreList = exploreList;
    }

    @Override
    public int getCount() {
        return exploreList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.item_explore,null);
        ImageView anh=convertView.findViewById(R.id.img_truyen);
        TextView ten=convertView.findViewById(R.id.ten);
        TextView tacgia=convertView.findViewById(R.id.tacgia);
        TextView mota=convertView.findViewById(R.id.mota);
        TextView luotxem=convertView.findViewById(R.id.luotxem);
        TextView luotthich=convertView.findViewById(R.id.luotthich);
        TextView danhgia=convertView.findViewById(R.id.danhgia);
        // gan gia tri
        Explore explore=exploreList.get(position);
        anh.setImageResource(explore.getAnh());
        ten.setText(explore.getTen());
        tacgia.setText(explore.getTacgia());
        mota.setText(explore.getMota());
        luotxem.setText(explore.getLuotxem());
        luotthich.setText(explore.getLuotthich());
        danhgia.setText(explore.getDanhgia());
        return convertView;
    }
}
