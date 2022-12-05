package com.api.trabalhofinal;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.api.trabalhofinal.objetos.Eventos;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<Eventos> eventosList;
    Context context;
    int listaId;


    public RecyclerViewAdapter(List<Eventos> productList, Context context, int listaId) {
        this.eventosList = productList;
        this.context = context;
        this.listaId = listaId;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView eventName;
        TextView eventDate;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.eventName);
            eventDate = itemView.findViewById(R.id.eventDate);
            parentLayout = itemView.findViewById(R.id.eventosRow);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_eventos_row,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.eventName.setText(eventosList.get(position).getNome());
        holder.eventDate.setText(eventosList.get(position).getData());

        holder.eventDate.setBackgroundColor(Color.GREEN);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    holder.eventDate.setBackgroundColor(Color.RED);


                }catch (Exception e){
                    Toast.makeText(context, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }


        });
    }



    @Override
    public int getItemCount() {
        return eventosList.size();
    }





}