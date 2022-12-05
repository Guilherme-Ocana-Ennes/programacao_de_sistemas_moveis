package com.api.trabalhofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.api.trabalhofinal.objetos.Usuarios;
import com.google.android.material.snackbar.Snackbar;

public class SingUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        getSupportActionBar().hide();

        Button buttonCreate = findViewById(R.id.buttonCreate);
        Button buttonVoltar = findViewById(R.id.buttonVoltar);

        EditText editTextLogin = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);

        DbHelper db = new DbHelper(SingUpActivity.this);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (criarUsuario()){
                    Intent mainMenu = new Intent(SingUpActivity.this, MainMenu.class);
                    mainMenu.putExtra("name",editTextLogin.getText().toString());
                    startActivity(mainMenu);
                }else{
                    Snackbar.make(view, "Erro ao criar usuario",1000).show();
                }

            }

            private boolean criarUsuario() {
                int temp = 1;
                if (editTextLogin.getText().toString().equals("")){
                    Toast.makeText(SingUpActivity.this, "Preencha o campo usuario", Toast.LENGTH_SHORT).show();
                    temp = 0;
                }
                if (editTextPassword.getText().toString().equals("")){
                    Toast.makeText(SingUpActivity.this, "Preencha o campo senha", Toast.LENGTH_SHORT).show();
                    temp = 0;
                }

                if (temp == 1) {

                    Usuarios usuarios = db.getUserByName(editTextLogin.getText().toString());
                    if (usuarios == null){
                        db.createUser(editTextLogin.getText().toString(), editTextPassword.getText().toString());
                        return true;
                    }else{
                        return false;
                    }

                }
                return false;
            }
        });

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(SingUpActivity.this,LoginActivity.class);
                startActivity(login);
            }
        });


    }
}