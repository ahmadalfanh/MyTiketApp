package com.example.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuccessBuyTicket extends AppCompatActivity {

    Button btn_view_ticket;
    Button btn_My_dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_buy_ticket);


        btn_view_ticket = findViewById(R.id.btn_view_ticket);
        btn_My_dashboard = findViewById(R.id.btn_My_dashboard);



        btn_view_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  gotoMypofile = new Intent(SuccessBuyTicket.this,  MyprofileAct.class);
                startActivity(gotoMypofile);

            }
        });


        btn_My_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  gotoMyhome = new Intent(SuccessBuyTicket.this,  HomeAct.class);
                startActivity(gotoMyhome);

            }
        });


    }
}
