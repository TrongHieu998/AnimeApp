package com.example.app_test.Fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.app_test.Activity.HomeRecentMore;
import com.example.app_test.Adapter.Home_Popular_Adapter;
import com.example.app_test.Adapter.Jsoup_Adapter;
import com.example.app_test.Model.Jsoup_model;
import com.example.app_test.Model.Popular;
import com.example.app_test.R;
import com.google.android.material.tabs.TabLayout;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import static okhttp3.internal.Internal.instance;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Home extends Fragment {
    public Fragment_Home() {
        // Required empty public constructor
    }
    private static Fragment_Home instance;

    public static Fragment_Home getInstance() {
        if (instance == null) {
            synchronized (Fragment_Home.class) {
                if (instance == null) {
                    instance = new Fragment_Home();
                }
            }
        }
        return instance;
    }

    View viewRoot;
    private View createView(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_fragment_home, null, false);
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
    ViewPager viewPager;
    TabLayout tabLayout;
    RecyclerView recyclerView_recent,recyclerView_dub,recyclerView_popular;
    Jsoup_Adapter adapter;
    Jsoup_Adapter adapter1;
    Home_Popular_Adapter adapter2;
    ArrayList<Popular> populars=new ArrayList<>();
    ArrayList<Jsoup_model> jsoup_models=new ArrayList<>();
    ArrayList<Jsoup_model> jsoup_models1=new ArrayList<>();
    TextView moreRecent,moreDub;
    ImageView imageView;
    LinearLayout linearLayout;
    void mapping(View view){
//        viewPager=view.findViewById(R.id.viewpager_home);
//        tabLayout=view.findViewById(R.id.tablayout_home);
//        ViewPage_Adapter adapter=new ViewPage_Adapter(getFragmentManager());
//        adapter.AddFragment(Home_Fragmnet_1.getInstance(),"Recent Relaease");
//        adapter.AddFragment(Home_Fragment_DUB_1.getInstance(), "DUB");
//        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);


        recyclerView_recent=view.findViewById(R.id.recycleView_HomeRecent);
        recyclerView_recent.setHasFixedSize(true);
        recyclerView_recent.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        adapter= new Jsoup_Adapter(jsoup_models,getContext());
        recyclerView_recent.setAdapter(adapter);

        moreRecent=view.findViewById(R.id.txt_itemHome_moreRecent);
        moreRecent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), HomeRecentMore.class);
                startActivity(intent);
            }
        });


        recyclerView_dub=view.findViewById(R.id.recycleView_HomeDUB);
        recyclerView_dub.setHasFixedSize(true);
        recyclerView_dub.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        adapter1= new Jsoup_Adapter(jsoup_models1,getContext());
        recyclerView_dub.setAdapter(adapter1);

        moreDub=view.findViewById(R.id.txt_itemHome_moreDub);
        moreDub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), HomeRecentMore.class);
                startActivity(intent);
            }
        });

        recyclerView_popular=view.findViewById(R.id.recycleView_HomePopular);
        recyclerView_popular.setHasFixedSize(true);
        recyclerView_popular.setLayoutManager(new GridLayoutManager(getContext(),1));
        adapter2= new Home_Popular_Adapter(populars,getContext());
        recyclerView_popular.setAdapter(adapter2);
        Content content= new Content();
        content.execute();

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
            adapter2.notifyDataSetChanged();
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

                //String url2="https://gogoanime.movie/";
                String url2="https://ajax.apimovie.xyz/ajax/page-recent-release-ongoing.html?page=1";
                Document doc2= org.jsoup.Jsoup.connect(url2).get();
                Elements data2=doc2.select(".added_series_body.popular").select("li");
                int size2=data2.size();
                for(int k=0;k<size2;k++)
                {
                    String imgUrl = data2.get(k)
                            .select("div.thumbnail-popular")
                            .eq(0)
                            .attr("style");
                    imgUrl = imgUrl.replace("background: url('", "");
                    imgUrl = imgUrl.replace("');", "");
                    String fate = data2.get(k).select("a").get(1).attr("title");
                    String genres = data2.get(k)
                            .select(".genres").text();
                    String lastest =  data2.get(k).select("p").get(1).select("a").text();
                    String detailUrl=data2.get(k).select("a").get(1).attr("href");
                    populars.add(new Popular(imgUrl, fate, genres, lastest,detailUrl));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

//    public static Fragment_Home newInstance(int page, String title) {
//        Fragment_Home homeFragment = new Fragment_Home();
//        Bundle args = new Bundle();
//        args.putInt("page", page);
//        args.putString("title", title);
//        homeFragment.setArguments(args);
//        return homeFragment;
//    }

}
