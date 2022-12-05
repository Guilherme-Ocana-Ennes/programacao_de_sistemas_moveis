package com.api.trabalhofinal.placeholder.objetos;

import java.util.IdentityHashMap;

public class Usuarios {

    private int Id;
    private String Nome;
    private String Senha;

    public Usuarios(int id, String nome, String senha){
        setId(id);
        setNome(nome);
        setSenha(senha);
    }



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

}
