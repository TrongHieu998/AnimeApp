package com.example.app_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.app_test.Adapter.Explore_Adapter;
import com.example.app_test.Adapter.MyAdapter;
import com.example.app_test.Model.Explore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    ArrayList<Explore> arrayList;
    Explore_Adapter adapter ;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview_1);

        arrayList= new ArrayList<>();

        searchView = findViewById(R.id.search_vew);
        searchView.setIconifiedByDefault(true);
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.requestFocusFromTouch();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
    private void anhXa() {
        listView=(ListView) findViewById(R.id.listview_truyen);
        arrayList= new ArrayList<>();
        arrayList.add(new Explore("New Dangaronpa V3: Min","Based on the game of the same name, a variety of authors and artist","Spike Chunsoft","140k","7820","8.4",R.drawable.truyen1));
        arrayList.add(new Explore("Re: Creator","One night after going to get a figurine of Selesia she ","Hiroe rei","105k","5240","8.4",R.drawable.truyen2));
        arrayList.add(new Explore("Tsumi to Kai","Based on the game of the same","Spike Chunsoft","140k","7820","8.4",R.drawable.truyen3));
        arrayList.add(new Explore("New Dangaronpa V3: Min","Based on the game of the same","Spike Chunsoft","140k","7820","8.4",R.drawable.truyen4));
        arrayList.add(new Explore("New Dangaronpa V3: Min","Based on the game of the same","Spike Chunsoft","140k","7820","8.4",R.drawable.truyen5));
        arrayList.add(new Explore("New Dangaronpa V3: Min","Based on the game of the same","Spike Chunsoft","140k","7820","8.4",R.drawable.truyen1));
    }

}
