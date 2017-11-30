package com.example.francisco.mallsbeaconslocation.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.francisco.mallsbeaconslocation.R;
import com.example.francisco.mallsbeaconslocation.adapter.RecomendationAdapter;
import com.example.francisco.mallsbeaconslocation.data.Data;
import com.example.francisco.mallsbeaconslocation.databinding.FragmentMainBinding;
import com.example.francisco.mallsbeaconslocation.models.Recomendation;
import com.example.francisco.mallsbeaconslocation.net.api.BeaconSearchApi;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment{

    public static MainFragment instance(){
        return new MainFragment();
    }

    List<Recomendation> data;
    FragmentMainBinding binding;
    RecomendationAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.e("URL","Entro en onCreateView Fragment");
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        //adapter = new RecomendationAdapter(getLayoutInflater(null), Data.getRecomendaciones());
        adapter = new RecomendationAdapter(getLayoutInflater(null), data);
        binding.recycler.setAdapter(adapter);
        //binding.recycler.setLayoutManager(new GridLayoutManager(getContext(),2)); para hacer una grilla
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();
    }


    public void addItems(List<Recomendation> data){
        this.data.addAll(data);
        adapter.notifyDataSetChanged();
    }

    public void changedata(List<Recomendation>data){
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }

}
