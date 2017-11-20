package com.example.francisco.mallsbeaconslocation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.francisco.mallsbeaconslocation.databinding.ActivityLoginBinding;
import com.example.francisco.mallsbeaconslocation.util.Preferences;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    SharedPreferences preferences;
    String UserID = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences(Preferences.PREFERENCES_NAME, MODE_PRIVATE);
        boolean logged = preferences.getBoolean(Preferences.KEY_LOGGED, false);
        if (logged){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return;
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setLoginhandler(this);


    }

    public void Login(){
        UserID = binding.IdUsuario.getEditText().getText().toString();
        Log.e("Login","Mensaje:"+UserID+"Fin Mensaje");
        if (UserID.length()<3 && UserID.length()!=0){
            Toast.makeText(this, "No se ha proporcionado un Id de usuario correcto", Toast.LENGTH_SHORT).show();

        }else if (UserID.length()==0){
            Toast.makeText(this, "UserId Requerido", Toast.LENGTH_SHORT).show();
        }
        else {
            //Toast.makeText(this, ""+UserID, Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(Preferences.KEY_ID,"2000"+UserID);
            editor.putBoolean(Preferences.KEY_LOGGED, true);
            editor.apply();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
    }
}
