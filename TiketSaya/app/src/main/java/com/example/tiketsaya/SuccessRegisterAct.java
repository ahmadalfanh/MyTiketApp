package com.example.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuccessRegisterAct extends AppCompatActivity {

    Button btn_continue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_register);

        btn_continue = findViewById(R.id.btn_continue);
          btn_continue.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                Intent gotosuccessbuyTicket = new Intent(SuccessRegisterAct.this , HomeAct.class);
                startActivity(gotosuccessbuyTicket);
              }
          });


    }
}
