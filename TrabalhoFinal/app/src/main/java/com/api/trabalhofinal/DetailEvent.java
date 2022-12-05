package com.api.trabalhofinal;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.api.trabalhofinal.objetos.Eventos;

public class DetailEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);

        DbHelper db = new DbHelper(DetailEvent.this);

        Intent receve = getIntent();
        int id = receve.getIntExtra("Id",0);
        Eventos eventos = db.getEventById(id);

        TextView name = findViewById(R.id.textView_titulo_main);

        name.setText(eventos.getNome());

    }

    public void botaoConvidadosOnClick (View v){
        Intent telaConvidados = new Intent(this, ConvidadosActivity.class);
        startActivity(telaConvidados);
    }

    public void botaoDescricaoOnClick (View v1){
        Intent telaDescricao = new Intent(this, DescricaoActivity.class);
        startActivity(telaDescricao);
    }

    public void botaoFotosOnClick (View v2){
        Intent telaFotos = new Intent(this, FotosActivity.class);
        startActivity(telaFotos);
    }

    public void button_ReturnOnCLick (View v){
        Intent telareturn = new Intent(this, MainMenu.class);
        startActivity(telareturn);
    }

}