package com.example.app_test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.app_test.Database.Database;
import com.example.app_test.Model.Like;
import com.example.app_test.R;

import java.util.List;

public class Like_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    Database database;
    private List<Like> likeList;

    public Like_Adapter(Context context, int layout, List<Like> likeList) {
        this.context = context;
        this.layout = layout;
        this.likeList = likeList;
    }

    @Override
    public int getCount() {
        return likeList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder
    {
        TextView title,category,info;
        ImageView img;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null)
        {
            viewHolder= new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);
            viewHolder.title=convertView.findViewById(R.id.title_like);
            viewHolder.category=convertView.findViewById(R.id.category_like);
            viewHolder.info=convertView.findViewById(R.id.info_like);
            viewHolder.img=convertView.findViewById(R.id.icon_dislike);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Like like=likeList.get(position);
        viewHolder.title.setText(like.getTitle());
        viewHolder.category.setText(like.getCategory());
        viewHolder.info.setText(like.getInfo());
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }
}
