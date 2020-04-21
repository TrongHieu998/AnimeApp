package com.example.app_test;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.app_test.Fragment.Fragment_Account;
import com.example.app_test.Fragment.Fragment_Explore;
import com.example.app_test.Fragment.Fragment_Home;
import com.example.app_test.Fragment.Fragment_Libary;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class bottom_navigation extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            return loadFragment(item.getItemId());
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(R.id.navigation_home);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);
    }
    public boolean loadFragment(int id) {
        String backStateName = "Home";
        Fragment fragment = null;
        switch (id) {
            case R.id.navigation_account:
                fragment = Fragment_Account.getInstance();
                backStateName = "Account";
                break;
            case R.id.navigation_home:
                fragment =Fragment_Home.getInstance();
                backStateName = "Home";
                break;
            case R.id.navigation_explre:
                fragment = Fragment_Explore.getInstance();
                backStateName = "explre";
                break;
            case R.id.navigation_libary:
                    fragment =Fragment_Libary.getInstance();
                    break;
        }
        replaceFragment(fragment,backStateName,id);
        return true;
    }

    public void replaceFragment (Fragment fragment, String backStateName, int i){
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager.findFragmentByTag(backStateName) == null){
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.FrameLayoutMain, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }else{
            getSupportFragmentManager().popBackStack(backStateName,i);
        }
    }
}
