package com.example.francisco.mallsbeaconslocation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.estimote.coresdk.common.requirements.SystemRequirementsChecker;
import com.example.francisco.mallsbeaconslocation.Receivers.BeaconReceiver;
import com.example.francisco.mallsbeaconslocation.adapter.RecomendationAdapter;
import com.example.francisco.mallsbeaconslocation.databinding.ActivityMainBinding;
import com.example.francisco.mallsbeaconslocation.fragments.MainFragment;
import com.example.francisco.mallsbeaconslocation.models.AisleName;
import com.example.francisco.mallsbeaconslocation.models.Recomendation;
import com.example.francisco.mallsbeaconslocation.net.api.AisleNameApi;
import com.example.francisco.mallsbeaconslocation.net.api.BeaconSearchApi;
import com.example.francisco.mallsbeaconslocation.services.BeaconLocationService;
import com.example.francisco.mallsbeaconslocation.util.Preferences;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class MainActivity extends AppCompatActivity implements BeaconSearchApi.onBeaconSearch, AisleNameApi.onAisleSearch{

    ActivityMainBinding binding;
    Intent intent;
    BeaconReceiver receiver;

    Disposable disposable;
    MainFragment fragment;
    SharedPreferences preferences;
    String UserId;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPromotionhandler(this);
        fragment = MainFragment.instance();
        putFragment(R.id.container, fragment);

        //Toast.makeText(this, ""+email,Toast.LENGTH_SHORT).show();


    }

    public void putFragment(int container, Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(container, fragment);
        ft.commit();
    }

    public void start() {


        if (binding.floatingactionmain.getBackgroundTintList().equals(ContextCompat.getColorStateList(this, R.color.RednoActivate))) {
            binding.floatingactionmain.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary));
            SystemRequirementsChecker.checkWithDefaultDialogs(this);
            preferences = getSharedPreferences(Preferences.PREFERENCES_NAME, MODE_PRIVATE);
            UserId = preferences.getString(Preferences.KEY_ID, null);

            final BeaconSearchApi api = new BeaconSearchApi(this);
            final AisleNameApi aisleNameapi = new AisleNameApi(this);
            api.getPreferencesRecomender(""+UserId,"1","2",this);
            //api.getPreferencesMostPreferred(""+UserId,"1","2",this);

            aisleNameapi.getAisleName("1","2",this);

            Toast.makeText(this, "Inicar Servicio", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, BeaconLocationService.class);
            startService(intent);
            receiver = new BeaconReceiver();
            IntentFilter filter = new IntentFilter(BeaconReceiver.ACTION_BEACON);
            registerReceiver(receiver, filter);
            disposable = receiver.getBeaconNotify()
                    .distinctUntilChanged(new Function<Integer[], Object>() {
                        @Override
                        public Object apply(Integer[] integers) throws Exception {
                            return integers[0];
                        }
                    })
                    .subscribe(new Consumer<Integer[]>() {
                        @Override
                        public void accept(Integer[] integers) throws Exception {
                            //aisleNameapi.getAisleName("" + integers[0], "" + integers[1], MainActivity.this);
                            //api.getPreferencesRecomender("2000105", "" + integers[0], "" + integers[1], MainActivity.this);
                            //api.getPreferencesRecomender("2000008","1","2",MainActivity.this);
                            //Toast.makeText(MainActivity.this, "" + integers[0] + " " + integers[1], Toast.LENGTH_SHORT).show();
                            //Log.i("BEACONINFO", "MARJOR1: " + integers[0] + " MAJOR2:" + integers[1]);
                        }
                    });

        }else{
            binding.floatingactionmain.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.RednoActivate));
            Toast.makeText(this, "Detener Servicio", Toast.LENGTH_SHORT).show();
            stopService(intent);
            disposable.dispose();
            unregisterReceiver(receiver);
        }
    }

    /*public void stop(){

        Toast.makeText(this, "Detener Servicio", Toast.LENGTH_SHORT).show();
        stopService(intent);
        disposable.dispose();
        unregisterReceiver(receiver);
    }*/

    public void logout(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Desea cerrar Sesión?")
                .setTitle("Sesion");



        builder.setPositiveButton("Cerrar Sesión", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                preferences = getSharedPreferences(Preferences.PREFERENCES_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean(Preferences.KEY_LOGGED, false);
                editor.apply();

                Intent intentlogout = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentlogout);
                finish();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }



    @Override
    public void onBeaconSearch(List<Recomendation> data) {
        fragment.addItems(data);
    }

    @Override
    public void onAisleSearch(List<AisleName> dataaisle) {

        AisleName aisleName = dataaisle.get(0);
        TextView Title = findViewById(R.id.aisle_name_text);
        Title.setText(aisleName.getAislename());

    }
}
