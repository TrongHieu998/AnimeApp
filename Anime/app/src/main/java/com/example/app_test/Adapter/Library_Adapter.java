package com.example.app_test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_test.Model.Library;
import com.example.app_test.R;

import java.util.List;

public class Library_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Library> libraryList;

    public Library_Adapter(Context context, int layout, List<Library> libraryList) {
        this.context = context;
        this.layout = layout;
        this.libraryList = libraryList;
    }

    @Override
    public int getCount() {
        return libraryList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.item_library,null);
        ImageView anh=convertView.findViewById(R.id.img_phim);
        TextView ten=convertView.findViewById(R.id.tenphim);
        Library library=libraryList.get(position);
        anh.setImageResource(library.getAnh());
        ten.setText(library.getTen());
        return convertView;
    }
}
