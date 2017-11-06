package com.example.francisco.mallsbeaconslocation.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.francisco.mallsbeaconslocation.R;
import com.example.francisco.mallsbeaconslocation.adapter.RecomendationAdapter;
import com.example.francisco.mallsbeaconslocation.data.Data;
import com.example.francisco.mallsbeaconslocation.databinding.FragmentMainBinding;


public class MainFragment extends Fragment {

    public static MainFragment instance(){
        return new MainFragment();
    }

    FragmentMainBinding binding;
    RecomendationAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        adapter = new RecomendationAdapter(getLayoutInflater(null), Data.getRecomendaciones());
        binding.recycler.setAdapter(adapter);
        //binding.recycler.setLayoutManager(new GridLayoutManager(getContext(),2)); para hacer una grilla
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();
    }
}
