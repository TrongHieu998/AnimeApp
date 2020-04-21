package com.example.app_test.Fragment;


import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_test.Adapter.HomeMore_Adapter;
import com.example.app_test.Model.Jsoup_model;
import com.example.app_test.R;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Romance_Fragment_Explore extends Fragment {


    private static Romance_Fragment_Explore instance;

    public static Romance_Fragment_Explore getInstance() {
        if (instance == null) {
            synchronized (Romance_Fragment_Explore.class) {
                if (instance == null) {
                    instance = new Romance_Fragment_Explore();
                }
            }
        }
        return instance;
    }
    public Romance_Fragment_Explore() {
        // Required empty public constructor
    }

    View viewRoot;
    private View createView(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_drama_explore, null, false);
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
    RecyclerView recyclerView;
    HomeMore_Adapter adapter;
    ArrayList<Jsoup_model> jsoup_models=new ArrayList<>();
    void mapping(View view){
        recyclerView=view.findViewById(R.id.recycleView_DramaExplore);
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
                String url="https://www11.gogoanime.io/genre/romance";
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
