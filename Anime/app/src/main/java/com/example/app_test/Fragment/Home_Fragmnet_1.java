package com.example.app_test.Fragment;


import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class Home_Fragmnet_1 extends Fragment {


    public Home_Fragmnet_1() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    HomeMore_Adapter adapter;
    ArrayList<Jsoup_model> jsoup_models=new ArrayList<>();
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        view= inflater.inflate(R.layout.home_fragmnet_1, container, false);
//        recyclerView=view.findViewById(R.id.recycleview_home1);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
//        adapter= new Jsoup_Adapter(jsoup_models,getContext());
//        recyclerView.setAdapter(adapter);
//        Content content= new Content();
//        content.execute();
//        return view;
//    }

    private static Home_Fragmnet_1 instance;

    public static Home_Fragmnet_1 getInstance() {
        if (instance == null) {
            synchronized (Home_Fragmnet_1.class) {
                if (instance == null) {
                    instance = new Home_Fragmnet_1();
                }
            }
        }
        return instance;
    }
    View viewRoot;
    private View createView(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.home_fragmnet_1, null, false);
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
    void mapping(View view){
        recyclerView=view.findViewById(R.id.recycleview_home1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        adapter= new HomeMore_Adapter(jsoup_models,getContext());
        recyclerView.setAdapter(adapter);
        Content content= new Content();
        content.execute();
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
                 String url="https://www10.gogoanime.io/?fbclid=IwAR1oWXolOfxrs9gVuoOXlcaBsXen-dMHWQn8arNDQUk9_V_uGxnCMklveZ0";
                //String url="https://ajax.apimovie.xyz/ajax/page-recent-release.html?page=1&type=2";
                Document doc= org.jsoup.Jsoup.connect(url).get();
                Elements data=doc.select("div.last_episodes.loaddub li");
                // Elements data=doc.select("div.img");
                int size=data.size();
                Log.d("doc","doc"+doc);
                Log.d("data","data"+data);
                Log.d("size","size"+size);
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
                    String tap=data.select("p.episode")
                            .eq(i)
                            .text();
                    jsoup_models.add(new Jsoup_model(imgUrl,ten,tap));
                    Log.d("last_episodes.loaddub","img: " + imgUrl + " . title:" +ten+ "episode:" +tap);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public static Home_Fragmnet_1 newInstance(int page, String title) {
        Home_Fragmnet_1 homeFragment = new Home_Fragmnet_1();
        Bundle args = new Bundle();
        args.putInt("page", page);
        args.putString("title", title);
        homeFragment.setArguments(args);
        return homeFragment;
    }

}
