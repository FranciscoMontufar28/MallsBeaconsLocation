package com.example.francisco.mallsbeaconslocation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.francisco.mallsbeaconslocation.databinding.ActivityLoginBinding;
import com.example.francisco.mallsbeaconslocation.util.Preferences;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    SharedPreferences preferences;

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
        String UserID = binding.IdUsuario.getEditText().getText().toString();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Preferences.KEY_ID, UserID);
        editor.putBoolean(Preferences.KEY_LOGGED, true);
        editor.apply();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
