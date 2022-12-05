package com.api.trabalhofinal;

import static java.lang.Float.parseFloat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.api.trabalhofinal.objetos.Eventos;
import com.api.trabalhofinal.objetos.Usuarios;
import com.api.trabalhofinal.objetos.UsuariosEventos;

public class AddEvent extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        DbHelper db = new DbHelper(AddEvent.this);

        Intent receve = getIntent();
        int idUsuario = receve.getIntExtra("Usuario",-1);
        Usuarios usuarios = db.getUserById(idUsuario);


        EditText name = findViewById(R.id.Name);
        EditText date = findViewById(R.id.editTextDate);
        EditText desc = findViewById(R.id.textView_Descricao);
        EditText lat = findViewById(R.id.latitude);
        EditText lon = findViewById(R.id.longitude);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button salvar;
        salvar = findViewById(R.id.buttonSalvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Eventos eventos = new Eventos(db.getNextEventId(),name.getText().toString(),date.getText().toString(),parseFloat(lat.getText().toString()),parseFloat(lon.getText().toString()),desc.getText().toString());
                UsuariosEventos usuariosEventos = new UsuariosEventos(0,eventos,usuarios);

                db.createEvent(eventos);
                db.createUsuarioEvent(usuariosEventos);

                Intent add = new Intent(AddEvent.this, MainMenu.class);
                add.putExtra("name",usuarios.getNome());
                startActivity(add);
            }
        });

    }

}