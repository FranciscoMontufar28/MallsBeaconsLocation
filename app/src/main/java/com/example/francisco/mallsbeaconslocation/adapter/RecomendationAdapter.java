package com.example.francisco.mallsbeaconslocation.adapter;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.francisco.mallsbeaconslocation.R;

import com.example.francisco.mallsbeaconslocation.databinding.ActivityMainBinding;
import com.example.francisco.mallsbeaconslocation.databinding.TemplateRecomendationBinding;
import com.example.francisco.mallsbeaconslocation.models.Recomendation;

import java.util.List;

/**
 * Created by jhovy on 22/09/2017.
 */


public class RecomendationAdapter extends RecyclerView.Adapter<RecomendationAdapter.RecomendationHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    List<Recomendation> data;
    Context context;

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

        //holder.NoComprar.setOnClickListener(this);
        //holder.Comprar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.Btn_Comprar:
                Toast.makeText(context, "Btn Comprar", Toast.LENGTH_SHORT).show();
                Log.e("OnclickAdpater", "Comprar");
                break;
        }

    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Recomendation> data){
        this.data = data;
        notifyDataSetChanged();
    }



    //region RecomendationHolder
    static class RecomendationHolder extends RecyclerView.ViewHolder{

        Button NoComprar;
        Button Comprar;

        TemplateRecomendationBinding binding;

        public RecomendationHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            Comprar = itemView.findViewById(R.id.Btn_Comprar);
            //NoComprar = itemView.findViewById(R.id.Btn_No_Comprar);
            //NoComprar = binding.BtnNoComprar;
            //Comprar = binding.BtnComprar;
        }
    }
    //endregion


}
