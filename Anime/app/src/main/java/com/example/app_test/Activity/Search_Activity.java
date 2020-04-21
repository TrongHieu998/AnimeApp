package com.example.app_test.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import com.example.app_test.Adapter.HomeMore_Adapter;
import com.example.app_test.Fragment.Fantasy_Fragment_Explore;
import com.example.app_test.Model.Jsoup_model;
import com.example.app_test.R;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Search_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    HomeMore_Adapter adapter;
    SearchView searchView;
    ArrayList<Jsoup_model> jsoup_models=new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchView=findViewById(R.id.searchView);
        recyclerView=findViewById(R.id.recycleView_search);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        adapter= new HomeMore_Adapter(jsoup_models,this);
        recyclerView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Content content= new Content();
                content.execute();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
    private class Content extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
        }
        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String baseUrl="https://www11.gogoanime.io/";
                String h="/search.html?keyword=";
                @SuppressLint("WrongThread") String a=searchView.getQuery().toString();
                String url=baseUrl+h+a;
                Document doc= org.jsoup.Jsoup.connect(url).get();
                Elements data=doc.select("div.last_episodes  li");
                int size=data.size();
                for(int i=0;i<size;i++)
                {
                    String imgUrl=data.select("div.img")
                            .select("img")
                            .eq(i)
                            .attr("src");
                    String ten=data.select("p.name")
                            .select("a")
                            .eq(i)
                            .attr("title");
                    String tap=data.select("p.released")
                            .eq(i)
                            .text();
                    jsoup_models.add(new Jsoup_model(imgUrl,ten,tap));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
