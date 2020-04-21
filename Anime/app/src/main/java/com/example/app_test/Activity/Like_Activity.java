package com.example.app_test.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.app_test.Adapter.Like_Adapter;
import com.example.app_test.Database.Database;
import com.example.app_test.Model.Like;
import com.example.app_test.R;

import java.util.ArrayList;

public class Like_Activity extends AppCompatActivity {
    Database database;
    ListView listView;
    ArrayList<Like> likeArrayList;
    Like_Adapter likeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like_);


        listView=findViewById(R.id.listview_like);
        likeArrayList= new ArrayList<>();
        likeAdapter= new Like_Adapter(this,R.layout.item_like,likeArrayList);
        listView.setAdapter(likeAdapter);
        database= new Database(this,"LikeList.sqlite",null,3);
        Cursor dataLike =database.GetData("SELECT * FROM Like");
        likeArrayList.clear();
        while (dataLike.moveToNext()){
            int Id=dataLike.getInt(0);
            String title1=dataLike.getString(1);
            String category1=dataLike.getString(2);
            String info1=dataLike.getString(3);
            likeArrayList.add(new Like(Id,title1,category1,info1));
        }
        likeAdapter.notifyDataSetChanged();
    }
}
