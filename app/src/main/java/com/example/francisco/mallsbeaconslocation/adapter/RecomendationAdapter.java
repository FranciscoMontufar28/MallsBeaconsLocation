package com.example.francisco.mallsbeaconslocation.adapter;


import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.francisco.mallsbeaconslocation.MainActivity;
import com.example.francisco.mallsbeaconslocation.R;

import com.example.francisco.mallsbeaconslocation.databinding.ActivityMainBinding;
import com.example.francisco.mallsbeaconslocation.databinding.TemplateClosePromotionBinding;
import com.example.francisco.mallsbeaconslocation.databinding.TemplatePromotionBinding;
import com.example.francisco.mallsbeaconslocation.databinding.TemplateRecomendationBinding;
import com.example.francisco.mallsbeaconslocation.models.Recomendation;
import com.example.francisco.mallsbeaconslocation.net.api.AisleNameApi;
import com.example.francisco.mallsbeaconslocation.net.api.UserApi;
import com.example.francisco.mallsbeaconslocation.util.Preferences;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by jhovy on 22/09/2017.
 */


public class RecomendationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    LayoutInflater inflater;
    List<Recomendation> data;


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
        }else if(viewType==3){
            v = inflater.inflate(R.layout.template_close_promotion, parent, false);
            return new ClosePromotionHolder(v);
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

            holder2.RecomendationHolderClick(position);

        }else if (holder instanceof PromotionHolder){
            PromotionHolder holder1 = (PromotionHolder) holder;
            holder1.bindingPromotion.setPromotion(data.get(position));

            holder1.RecomendationHolderClick();

        }else {
            ClosePromotionHolder holder3 = (ClosePromotionHolder) holder;
            holder3.bindingClosePromotion.setClosepromotion(data.get(position));
        }


    }

    @Override
    public int getItemViewType(int position) {

        boolean valor = data.get(position).getPromotion();
        int numero;
        if(valor==true){
            String typevalor = data.get(position).getItemsodium();
            if (typevalor.equals("other")){
                numero=3;
            }else{
                numero=1;
            }

        }else{
            numero=0;
        }
        return numero;
        //return data.get(position).getPromotion() ? 1 : 0;
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
    class RecomendationHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Context context;
        TemplateRecomendationBinding binding;
        FloatingActionButton btn_recomend;
        SharedPreferences preferences;


        public RecomendationHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            binding = DataBindingUtil.bind(itemView);
            btn_recomend = itemView.findViewById(R.id.Btn_Like_Reco);
        }
        void RecomendationHolderClick(int Position){
            btn_recomend.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.Btn_Like_Reco:
                    final UserApi userApi = new UserApi(context);

                    SharedPreferences preferences = context.getSharedPreferences(Preferences.PREFERENCES_NAME, MODE_PRIVATE);
                    String UserId = preferences.getString(Preferences.KEY_ID, null);
                    int position = getAdapterPosition();
                    String itemname = data.get(position).getItemname();
                    //Toast.makeText(context,""+itemname+" "+UserId,Toast.LENGTH_SHORT).show();
                    Log.e("BTN_Adapter", "BTN_LIKE");


                    userApi.setUserResponse(""+UserId, "" +itemname);
                    break;
                }
            }
        }



    class PromotionHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Context context;
        FloatingActionButton btn_Promotion;

        TemplatePromotionBinding bindingPromotion;
        public PromotionHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            bindingPromotion = DataBindingUtil.bind(itemView);
            btn_Promotion = itemView.findViewById(R.id.Btn_promo_like);
        }

        void RecomendationHolderClick(){
            btn_Promotion.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.Btn_promo_like:
                    final UserApi userApi = new UserApi(context);

                    SharedPreferences preferences = context.getSharedPreferences(Preferences.PREFERENCES_NAME, MODE_PRIVATE);
                    String UserId = preferences.getString(Preferences.KEY_ID, null);
                    int position = getAdapterPosition();
                    String itemname = data.get(position).getItemname();
                    //Toast.makeText(context,""+itemname+" "+UserId,Toast.LENGTH_SHORT).show();
                    Log.e("BTN_Adapter", "BTN_LIKE");

                    userApi.setUserResponse(""+UserId, "" +itemname);
                    break;
            }

        }
    }


    class ClosePromotionHolder extends RecyclerView.ViewHolder{

        TemplateClosePromotionBinding bindingClosePromotion;
        public ClosePromotionHolder(View itemView) {
            super(itemView);
            bindingClosePromotion = DataBindingUtil.bind(itemView);
        }
    }


}
//endregion

