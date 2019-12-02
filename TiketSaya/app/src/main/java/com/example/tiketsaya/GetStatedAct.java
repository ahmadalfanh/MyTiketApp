package com.example.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GetStatedAct extends AppCompatActivity {

    Button btn_sign_in , btn_new_account_creat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_stated);

        btn_sign_in = findViewById(R.id.btn_sign_in);
        btn_new_account_creat = findViewById(R.id.btn_new_account_creat);

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotosign = new Intent(GetStatedAct.this, SigninAct.class);
                startActivity(gotosign);

            }
        });
        btn_new_account_creat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gotoregisterone = new Intent(GetStatedAct.this, RegisterOneAct.class);
                startActivity(gotoregisterone);
            }
        });
    }
}
