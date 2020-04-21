package com.example.app_test.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.app_test.Adapter.ViewPage_Adapter;
import com.example.app_test.Fragment.Home_Fragment_DUB_1;
import com.example.app_test.Fragment.Home_Fragmnet_1;
import com.example.app_test.R;
import com.google.android.material.tabs.TabLayout;

public class HomeRecentMore extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_recent_more);
        viewPager=findViewById(R.id.viewpager_recent);
        tabLayout=findViewById(R.id.tablayout_recent);
        ViewPage_Adapter adapter=new ViewPage_Adapter(getSupportFragmentManager());
        adapter.AddFragment(Home_Fragmnet_1.getInstance(),"Recent Relaease");
        adapter.AddFragment(Home_Fragment_DUB_1.getInstance(), "DUB");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
