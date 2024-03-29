package com.example.tiketsaya;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//untuk melist data dari firebase
public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.MyViewHolder> {
     private Context context;
  private    ArrayList<MyTicket> myTicket;

    public TicketAdapter(Context c,ArrayList<MyTicket>p){
        context = c;
        myTicket= p;
    }


     @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_myticket,parent,false));
         //(R.layout.item_myticket,parent,false) );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //mendapatkan data dari database
        holder.xnama_wisata.setText(myTicket.get(position).getNama_wisata());
        holder.xlokasi.setText(myTicket.get(position).getLokasi());
        holder.xjumlah_tiket.setText(myTicket.get(position).getJumlah_tiket() + "Tickets");


        final String getNamawisata = myTicket.get(position).getNama_wisata();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent godatai = new Intent(context,MyTicketDetail.class);
                godatai.putExtra("nama_wisata", getNamawisata);
                context.startActivity(godatai);
            }
        });
    }
    @Override
    public int getItemCount() {
        return myTicket.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView xnama_wisata,xlokasi,xjumlah_tiket;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            xnama_wisata= itemView.findViewById(R.id.xnama_wisata);
            xlokasi= itemView.findViewById(R.id.xlokasi);
            xjumlah_tiket= itemView.findViewById(R.id.xjumlah_tiket);

        }
    }

}
