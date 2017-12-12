package com.example.francisco.mallsbeaconslocation.fragments;


import android.support.v4.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.francisco.mallsbeaconslocation.R;
import com.example.francisco.mallsbeaconslocation.databinding.FragmentHintBinding;

/**
 * Created by jhovy on 10/12/2017.
 */

public class HintFragment extends Fragment {
    public static HintFragment instance(){
        return new HintFragment();
    }


    FragmentHintBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hint, container, false);
        return binding.getRoot();

    }
}
