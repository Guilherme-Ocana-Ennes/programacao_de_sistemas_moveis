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

public class LoginActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getSupportActionBar().hide();

        Button buttonLogin = findViewById(R.id.buttonLogin);
        Button buttonSingin = findViewById(R.id.buttonSingin);

        EditText editTextLogin = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);

        DbHelper db = new DbHelper(LoginActivity.this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    if (validaLogin()) {
                        Intent mainMenu = new Intent(LoginActivity.this, MainMenu.class);
                        mainMenu.putExtra("name",editTextLogin.getText().toString());
                        startActivity(mainMenu);
                    } else {
                        Snackbar.make(view, "Login ou Senha Icorretos", 1000).show();
                    }
                }catch (Exception e){
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            private boolean validaLogin(){


                if (editTextLogin.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Preencha o campo usuario", Toast.LENGTH_SHORT).show();
                }
                if (editTextPassword.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Preencha o campo senha", Toast.LENGTH_SHORT).show();
                }

                Usuarios usuarios = db.getUserByName(editTextLogin.getText().toString());
                if (usuarios == null){
                    return false;
                }
                if (usuarios.getSenha().equals(editTextPassword.getText().toString())){
                    return true;
                }
                return false;

            }
        });

        buttonSingin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent singUp = new Intent(LoginActivity.this,SingUpActivity.class);
                startActivity(singUp);
            }
        });






    }

}