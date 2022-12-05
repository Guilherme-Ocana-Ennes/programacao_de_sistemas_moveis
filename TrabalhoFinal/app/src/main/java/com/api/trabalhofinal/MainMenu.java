package com.api.trabalhofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.api.trabalhofinal.placeholder.filterFragment;
import com.api.trabalhofinal.objetos.Usuarios;

public class MainMenu extends AppCompatActivity {

    int showFlag = 0;
    Usuarios usuarios;

    public Usuarios getUser(){
        return usuarios;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        getSupportActionBar().hide();



        DbHelper db = new DbHelper(MainMenu.this);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        Intent receve = getIntent();
        String name = receve.getStringExtra("name");
        usuarios = db.getUserByName(name);

        TextView userName = findViewById(R.id.UserName);

        userName.setText(name);

        Fragment listaEventosFragment = new listaEventosFragment();
        Fragment filtrosEventFragment = new filterFragment();



        //transaction.replace(R.id.conteudo,listaEventosFragment);
        //transaction.commit();

        Bundle bundle = new Bundle();
        bundle.putInt("userId", usuarios.getId());
        listaEventosFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.conteudo,listaEventosFragment, "tag").commit();

        Button buttonFragment = findViewById(R.id.buttonFragment);
        Button buttonADD = findViewById(R.id.buttonADD);

        buttonFragment.setText("Listar Eventos");
        buttonADD.setText("Filtrar");

        buttonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (showFlag == 0) {
                        showFlag = 1;
                        //FragmentTransaction transaction = fm.beginTransaction();
                        //transaction.replace(R.id.conteudo, filtrosEventFragment);
                        //transaction.commit();

                        Bundle bundle = new Bundle();
                        bundle.putInt("userId", usuarios.getId());
                        Fragment fragment = new Fragment();
                        fragment.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.conteudo,fragment, "tag").commit();




                        buttonFragment.setText("Listar Eventos");
                        buttonADD.setText("Filtrar");
                    } else {
                        showFlag = 0;
                        FragmentTransaction transaction = fm.beginTransaction();
                        transaction.replace(R.id.conteudo, listaEventosFragment);
                        transaction.commit();
                        buttonFragment.setText("Filtrar");
                        buttonADD.setText("Adicionar Evento");
                    }
                }catch (Exception e){
                    Toast.makeText(MainMenu.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        buttonADD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent add = new Intent(MainMenu.this, AddEvent.class);
                add.putExtra("Usuario",usuarios.getId());
                startActivity(add);
            }
        });


    }
}