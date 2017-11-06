package com.example.francisco.mallsbeaconslocation;

import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.francisco.mallsbeaconslocation.Receivers.BeaconReceiver;
import com.example.francisco.mallsbeaconslocation.adapter.RecomendationAdapter;
import com.example.francisco.mallsbeaconslocation.databinding.ActivityMainBinding;
import com.example.francisco.mallsbeaconslocation.fragments.MainFragment;
import com.example.francisco.mallsbeaconslocation.models.Recomendation;
import com.example.francisco.mallsbeaconslocation.services.BeaconLocationService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Intent intent;
    BeaconReceiver receiver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPromotionhandler(this);

        putFragment(R.id.container, MainFragment.instance());
    }

    public void putFragment(int container, Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(container, fragment);
        ft.commit();
    }

    public void start(){

        Toast.makeText(this, "Inicar Servicio", Toast.LENGTH_SHORT).show();
        intent = new Intent(this, BeaconLocationService.class);
        startService(intent);
        receiver = new BeaconReceiver();
        IntentFilter filter = new IntentFilter(BeaconReceiver.ACTION_BEACON);
        registerReceiver(receiver, filter);


    }

    public void stop(){

        Toast.makeText(this, "Detener Servicio", Toast.LENGTH_SHORT).show();
        stopService(intent);
    }
}
