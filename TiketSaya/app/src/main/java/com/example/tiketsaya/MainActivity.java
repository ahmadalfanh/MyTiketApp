package com.example.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {


    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUsernamelocal();

    }
    public void getUsernamelocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");
        if (username_key_new.isEmpty()){
            //untuk timer 2 detik
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //merubah acivity ke activity lain
                    Intent gogetstarted = new Intent(MainActivity.this,GetStatedAct.class);
                    startActivity(gogetstarted);
                    finish();
                }
            },2000); //1000 ms = 1 s

        }
        else {
            //untuk timer 2 detik
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //merubah acivity ke activity lain
                    Intent kehome = new Intent(MainActivity.this,HomeAct.class);
                    startActivity(kehome);
                    finish();
                }
            },2000); //1000 ms = 1 s
        }
    }

}
