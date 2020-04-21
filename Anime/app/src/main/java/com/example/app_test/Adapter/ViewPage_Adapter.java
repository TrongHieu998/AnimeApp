package com.example.app_test.Adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.app_test.Fragment.Fragment_Home;
import com.example.app_test.Fragment.Home_Fragment_DUB_1;
import com.example.app_test.Fragment.Home_Fragmnet_1;

import java.util.ArrayList;
import java.util.List;

public class ViewPage_Adapter extends FragmentPagerAdapter {
    private Home_Fragmnet_1 m1stFragment;
    private Home_Fragment_DUB_1 m2ndFragment;
    private final List<Fragment> fragmentList=new ArrayList<>();
    private final List<String> FragmentListTitle= new ArrayList<>();

    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "RECENT RELEASE", "DUB"};
    private Context context;

    public ViewPage_Adapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        //return Fragment_Home.newInstance(position+1);
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
       return FragmentListTitle.size();
        //return PAGE_COUNT;
    }
    public void AddFragment (Fragment fragment,String Title)
    {
        fragmentList.add(fragment);
        FragmentListTitle.add(Title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentListTitle.get(position);
       // return tabTitles[position];
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object object = super.instantiateItem(container, position);
//        Fragment createdFragment = (Fragment) super.instantiateItem(container, position);
//        switch (position) {
//            case 0:
//                m1stFragment = (Home_Fragmnet_1) createdFragment;
//                break;
//            case 1:
//                m2ndFragment = (Home_Fragment_DUB_1) createdFragment;
//                break;
//        }
//        return createdFragment;
        if (object instanceof Fragment) {
            Fragment fragment = (Fragment) object;
            String tag = fragment.getTag();
        }
        return object;
    }

}
