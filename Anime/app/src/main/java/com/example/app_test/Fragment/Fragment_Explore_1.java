package com.example.app_test.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.app_test.Adapter.Explore_Adapter;
import com.example.app_test.Adapter.Explore_Adapter1;
import com.example.app_test.MainActivity;
import com.example.app_test.Model.Explore;
import com.example.app_test.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Explore_1 extends Fragment {


    public Fragment_Explore_1() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    ListView listView;
    ArrayList<Explore> arrayList;
    ArrayList<Explore> m_arrayList;
    Explore_Adapter adapter;
    View view;
    Explore_Adapter1 myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_explore_1,null);
        anhXa();
        adapter= new Explore_Adapter(view.getContext(),R.layout.item_explore,arrayList);
        listView.setAdapter(adapter);
        recyclerView=view.findViewById(R.id.recycle_view_1);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        m_arrayList= new ArrayList<>();
        m_arrayList.add(new Explore(R.drawable.truyen1));
        m_arrayList.add(new Explore(R.drawable.truyen2));
        m_arrayList.add(new Explore(R.drawable.truyen3));
        m_arrayList.add(new Explore(R.drawable.truyen4));
        m_arrayList.add(new Explore(R.drawable.truyen5));
        myAdapter=new Explore_Adapter1(view.getContext(), m_arrayList);
        recyclerView.setAdapter(myAdapter);
        return view;
    }
    private void anhXa() {
        listView=(ListView) view.findViewById(R.id.listview_truyen);
        arrayList= new ArrayList<>();
        arrayList.add(new Explore("New Dangaronpa V3: Min","Based on the game of the same name, a variety of authors and artist","Spike Chunsoft","140k","7820","8.4",R.drawable.truyen1));
        arrayList.add(new Explore("Re: Creator","One night after going to get a figurine of Selesia she ","Hiroe rei","105k","5240","8.4",R.drawable.truyen2));
        arrayList.add(new Explore("Tsumi to Kai","Based on the game of the same","Spike Chunsoft","140k","7820","8.4",R.drawable.truyen3));
        arrayList.add(new Explore("New Dangaronpa V3: Min","Based on the game of the same","Spike Chunsoft","140k","7820","8.4",R.drawable.truyen4));
        arrayList.add(new Explore("New Dangaronpa V3: Min","Based on the game of the same","Spike Chunsoft","140k","7820","8.4",R.drawable.truyen5));
        arrayList.add(new Explore("New Dangaronpa V3: Min","Based on the game of the same","Spike Chunsoft","140k","7820","8.4",R.drawable.truyen1));

    }
}
