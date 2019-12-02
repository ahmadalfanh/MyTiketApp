
package com.example.tiketsaya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.florent37.shapeofview.shapes.CircleView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class HomeAct extends AppCompatActivity {

    LinearLayout btn_ticket_pisa,
            btn_ticket_Torri,btn_ticket_Candi,
            btn_ticket_Sphinx,btn_ticket_monas,
            btn_ticket_pagoda;

    CircleView  btn_to_profile;
    ImageView photo_home_user;
    TextView user_balance,nama_lengkap,bio;

    DatabaseReference reference ;
    //Membuat data local
    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //pada saat di mulai
        getUsernamelocal();
        btn_ticket_pisa = findViewById(R.id.btn_ticket_pisa);
         btn_to_profile = findViewById(R.id.btn_to_profile);

        btn_ticket_Torri = findViewById(R.id.btn_ticket_Torri);
        btn_ticket_Candi = findViewById(R.id.btn_ticket_Candi);
        btn_ticket_Sphinx = findViewById(R.id.btn_ticket_Sphinx);
         btn_ticket_monas = findViewById(R.id.btn_ticket_monas);
         btn_ticket_pagoda = findViewById(R.id.btn_ticket_pagoda);


         photo_home_user = findViewById(R.id.photo_home_user);
         user_balance = findViewById(R.id.user_balance);
         nama_lengkap = findViewById(R.id.nama_lengkap);
         bio = findViewById(R.id.bio);

         //mengambil data berdasarkan login
        reference = FirebaseDatabase.getInstance().getReference()
                .child("Users").child(username_key_new);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nama_lengkap.setText(dataSnapshot.child("nama_lengkap").getValue().toString());
                bio.setText(dataSnapshot.child("bio").getValue().toString());
                user_balance.setText("US$"+ dataSnapshot.child("user_balance").getValue().toString());
                Picasso.with(HomeAct.this)
                        .load(dataSnapshot.child("url_photo_profile")
                        .getValue().toString()).centerCrop().fit().into(photo_home_user);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn_to_profile.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent GotoTicketProfile = new Intent(HomeAct.this, MyprofileAct.class);
                 startActivity(GotoTicketProfile);
             }
         });


         btn_ticket_pisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gototicketpisa = new Intent(HomeAct.this, TicketDetailAct.class);
                //meletakan data kepada intent
                gototicketpisa.putExtra("jenis_tiket","Pisa");
                startActivity(gototicketpisa);
                 }
        });
        btn_ticket_Torri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gototicketpisa = new Intent(HomeAct.this, TicketDetailAct.class);
                gototicketpisa.putExtra("jenis_tiket","Torri");
                startActivity(gototicketpisa);
            }
        });
        btn_ticket_Candi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gototicketpisa = new Intent(HomeAct.this, TicketDetailAct.class);
                gototicketpisa.putExtra("jenis_tiket","Candi");
                startActivity(gototicketpisa);
            }
        });
        btn_ticket_Sphinx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gototicketpisa = new Intent(HomeAct.this, TicketDetailAct.class);
                gototicketpisa.putExtra("jenis_tiket","Sphinx");
                startActivity(gototicketpisa);
            }
        });
        btn_ticket_pagoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gototicketpisa = new Intent(HomeAct.this, TicketDetailAct.class);
                gototicketpisa.putExtra("jenis_tiket","Pagoda");
                startActivity(gototicketpisa);
            }
        });
        btn_ticket_monas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gototicketpisa = new Intent(HomeAct.this, TicketDetailAct.class);
                gototicketpisa.putExtra("jenis_tiket","Monas");
                startActivity(gototicketpisa);
            }
        });

        }
    //usernam di simpan di local
    public void getUsernamelocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");
    }
    }
