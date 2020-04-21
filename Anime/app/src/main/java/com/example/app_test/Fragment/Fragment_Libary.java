package com.example.app_test.Fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;


import com.example.app_test.Activity.Search_Activity;
import com.example.app_test.Adapter.HomeMore_Adapter;
import com.example.app_test.Adapter.Jsoup_Adapter;
import com.example.app_test.Model.Jsoup_model;
import com.example.app_test.R;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Libary extends Fragment {

    private static Fragment_Libary instance;

    public static Fragment_Libary getInstance() {
        if (instance == null) {
            synchronized (Fragment_Libary.class) {
                if (instance == null) {
                    instance = new Fragment_Libary();
                }
            }
        }
        return instance;
    }
    public Fragment_Libary() {
        // Required empty public constructor
    }

    View viewRoot;
    private View createView(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_fragment_libary, null, false);
        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        viewRoot = createView(savedInstanceState);
        super.onCreate(savedInstanceState);

        mapping(viewRoot);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return viewRoot;
    }
    ProgressDialog progressDialog;
    RecyclerView recyclerView_recent,recyclerView_sort;
    Jsoup_Adapter adapter;
    HomeMore_Adapter adapter1;
    ArrayList<Jsoup_model> jsoup_models=new ArrayList<>();
    ArrayList<Jsoup_model> jsoup_models1=new ArrayList<>();
    Button btn_search;
    void mapping(View view){
        recyclerView_recent=view.findViewById(R.id.recycleView_LibraryRecent);
        recyclerView_recent.setHasFixedSize(true);
        recyclerView_recent.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        adapter= new Jsoup_Adapter(jsoup_models,getContext());
        recyclerView_recent.setAdapter(adapter);


        recyclerView_sort=view.findViewById(R.id.recycleView_LibrarySort);
        recyclerView_sort.setHasFixedSize(true);
        recyclerView_sort.setLayoutManager(new GridLayoutManager(view.getContext(),3));
        adapter1= new HomeMore_Adapter(jsoup_models1,getContext());
        recyclerView_sort.setAdapter(adapter1);
        Content content= new Content();
        content.execute();
        btn_search=view.findViewById(R.id.btn_search1);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), Search_Activity.class);
                startActivity(intent);
            }
        });
    }
    private class Content extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog= new ProgressDialog(getContext());
            progressDialog.setMessage("Loading Data...");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
            adapter1.notifyDataSetChanged();
            progressDialog.dismiss();
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String url="https://gogoanime.movie/";
                Document doc= org.jsoup.Jsoup.connect(url).get();
                Elements data=doc.select("div.last_episodes.loaddub li");
                int size=data.size();
                for(int i=0;i<size;i++) {
                    String imgUrl = data.select("div.img")
                            .select("img")
                            .eq(i)
                            .attr("src");
                    String ten = data.select("p.name")
                            .select("a")
                            .eq(i)
                            .attr("title");
                    String tap = data.select("p.episode")
                            .eq(i)
                            .text();
                    String detailUrl=data.select("p.name")
                            .select("a")
                            .eq(i)
                            .attr("href");
                    jsoup_models.add(new Jsoup_model(imgUrl, ten, tap,detailUrl));
                }
                String url1="https://ajax.apimovie.xyz/ajax/page-recent-release.html?page=1&type=2";
                Document doc1= org.jsoup.Jsoup.connect(url1).get();
                Elements data1=doc1.select("div.last_episodes.loaddub li");
                int size1=data1.size();
                for(int j=0;j<size1;j++)
                {
                    String imgUrl=data1.select("div.img")
                            .select("img")
                            .eq(j)
                            .attr("src");
                    String ten=data1.select("p.name")
                            .select("a")
                            .eq(j)
                            .attr("title");
                    String tap=data1.select("p.episode")
                            .eq(j)
                            .text();
                    String detailUrl=data1.select("p.name")
                            .select("a")
                            .eq(j)
                            .attr("href");
                    jsoup_models1.add(new Jsoup_model(imgUrl,ten,tap,detailUrl));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
