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
import com.example.francisco.mallsbeaconslocation.databinding.TemplatePromotionBinding;
import com.example.francisco.mallsbeaconslocation.databinding.TemplateRecomendationBinding;
import com.example.francisco.mallsbeaconslocation.models.Recomendation;

import java.util.List;

/**
 * Created by jhovy on 22/09/2017.
 */


public class RecomendationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    List<Recomendation> data;
    Context context;

    public RecomendationAdapter(LayoutInflater inflater, List<Recomendation> data) {
        this.inflater = inflater;
        this.data = data;
    }

    /*@Override
    public RecomendationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_recomendation, parent, false);
        return new RecomendationHolder(v);
    }*/


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        if (viewType==1){
            v = inflater.inflate(R.layout.template_promotion, parent, false);
            return new PromotionHolder(v);
        }else{
            v = inflater.inflate(R.layout.template_recomendation, parent, false);
            return new RecomendationHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof  RecomendationHolder){
            RecomendationHolder holder2 = (RecomendationHolder)  holder;
            holder2.binding.setRecomendation(data.get(position));
        }else{
            PromotionHolder holder1 = (PromotionHolder) holder;
            holder1.bindingPromotion.setPromotion(data.get(position));
        }


        //holder.binding.setRecomendation(data.get(position));

        //holder.NoComprar.setOnClickListener(this);
        //holder.Comprar.setOnClickListener(this);

    }

    @Override
    public int getItemViewType(int position) {
        Log.e("TypeView", ""+data.get(position).getPromotion());
        return data.get(position).getPromotion() ? 1 : 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.Btn_Like_Reco:
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



    //region Holders
    static class RecomendationHolder extends RecyclerView.ViewHolder{

        Button LikeItem;

        TemplateRecomendationBinding binding;

        public RecomendationHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            //LikeItem = itemView.findViewById(R.id.Btn_Like_Reco);
            //Comprar = binding.BtnComprar;
        }

    }


    static class PromotionHolder extends RecyclerView.ViewHolder{

        Button LikeItem;

        TemplatePromotionBinding bindingPromotion;
        public PromotionHolder(View itemView) {
            super(itemView);
            bindingPromotion = DataBindingUtil.bind(itemView);
            //LikeItem = itemView.findViewById(R.id.Btn_Like_Promo);

        }
    }

//endregion
}
