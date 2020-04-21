package com.example.app_test.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.app_test.Activity.Search_Activity;
import com.example.app_test.Adapter.ViewPage_Adapter;
import com.example.app_test.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Explore extends Fragment {

    View view;
    ViewPager viewPager;
    TabLayout tabLayout;
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        view=inflater.inflate(R.layout.fragment_fragment_explore,null);
//        //////
//        //ViewPage_Adapter adapter1=new ViewPage_Adapter(getFragmentManager());
//        viewPager=view.findViewById(R.id.views);
//        tabLayout=view.findViewById(R.id.tabs);
////        adapter1.AddFragment(new Fragment_Explore_1(),"All");
////        adapter1.AddFragment(new Fragment_Libary(), "Romance");
////        adapter1.AddFragment(new Fragment_Explore_1(), "Drama");
////        adapter1.AddFragment(new Fragment_Account(), "Adventure");
////        adapter1.AddFragment(new Fragment_Account(), "Fantasy");
////
////        viewPager.setAdapter(adapter1);
//        tabLayout.setupWithViewPager(viewPager);
//        return view;
//    }
private static Fragment_Explore instance;

    public static Fragment_Explore getInstance() {
        if (instance == null) {
            synchronized (Fragment_Explore.class) {
                if (instance == null) {
                    instance = new Fragment_Explore();
                }
            }
        }
        return instance;
    }
    public Fragment_Explore() {
        // Required empty public constructor
    }

    View viewRoot;
    private View createView(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_fragment_explore, null, false);
        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        viewRoot = createView(savedInstanceState);
        super.onCreate(savedInstanceState);

        mapping(viewRoot);
        // mappingImageDetailGenres(viewRoot);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return viewRoot;
    }
    Button btn_search;
    void mapping(View view){
        ViewPage_Adapter adapter1=new ViewPage_Adapter(getFragmentManager());
        viewPager=view.findViewById(R.id.views);
        tabLayout=view.findViewById(R.id.tabs);
        adapter1.AddFragment(new Fragment_Explore_1(),"All");
        adapter1.AddFragment(new Romance_Fragment_Explore(), "Romance");
        adapter1.AddFragment(new Drama_Fragment_Explore(), "Drama");
        adapter1.AddFragment(new Adventure_Fragment_Explore(), "Adventure");
        adapter1.AddFragment(new Fantasy_Fragment_Explore(), "Fantasy");
        viewPager.setAdapter(adapter1);
        tabLayout.setupWithViewPager(viewPager);
        btn_search=view.findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), Search_Activity.class);
                startActivity(intent);
            }
        });
    }

}
