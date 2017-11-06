package com.example.francisco.mallsbeaconslocation.adapter;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.francisco.mallsbeaconslocation.R;

import com.example.francisco.mallsbeaconslocation.databinding.TemplateRecomendationBinding;
import com.example.francisco.mallsbeaconslocation.models.Recomendation;

import java.util.List;

/**
 * Created by jhovy on 22/09/2017.
 */


public class RecomendationAdapter extends RecyclerView.Adapter<RecomendationAdapter.RecomendationHolder>{

    LayoutInflater inflater;
    List<Recomendation> data;

    public RecomendationAdapter(LayoutInflater inflater, List<Recomendation> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public RecomendationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_recomendation, parent, false);
        return new RecomendationHolder(v);
    }

    @Override
    public void onBindViewHolder(RecomendationHolder holder, int position) {
        holder.binding.setRecomendation(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    //region RecomendationHolder
    static class RecomendationHolder extends RecyclerView.ViewHolder{

        TemplateRecomendationBinding binding;

        public RecomendationHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
    //endregion


}
