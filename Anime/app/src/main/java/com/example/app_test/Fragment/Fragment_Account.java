package com.example.app_test.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.app_test.Activity.Like_Activity;
import com.example.app_test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Account extends Fragment {


    private static Fragment_Account instance;

    public static Fragment_Account getInstance() {
        if (instance == null) {
            synchronized (Fragment_Account.class) {
                if (instance == null) {
                    instance = new Fragment_Account();
                }
            }
        }
        return instance;
    }
    public Fragment_Account() {
        // Required empty public constructor
    }

    View viewRoot;
    private View createView(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_fragment_account, null, false);
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
    Button btn;
    void mapping(View view){
        btn=view.findViewById(R.id.listPhimLike);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), Like_Activity.class);
                startActivity(intent);
            }
        });

    }


}
