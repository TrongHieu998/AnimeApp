package com.example.app_test.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.app_test.Fragment.Home_Fragment_DUB_1;
import com.example.app_test.Fragment.Home_Fragmnet_1;

public class HomePage_Adapter extends FragmentStatePagerAdapter {
    int cuonttab;

    public HomePage_Adapter(FragmentManager fm, int cuonttab) {
        super(fm);
        this.cuonttab = cuonttab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 1:
                Home_Fragmnet_1 home_fragmnet_1=new Home_Fragmnet_1();
                return home_fragmnet_1;
            case 2:
                Home_Fragment_DUB_1 home_fragment_2=new Home_Fragment_DUB_1();
                return home_fragment_2;
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return cuonttab;
    }
}
