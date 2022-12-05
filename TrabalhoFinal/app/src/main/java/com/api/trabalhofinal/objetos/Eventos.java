package com.api.trabalhofinal.objetos;

import java.util.ArrayList;
import java.util.List;

public class Eventos {

    private int Id;
    private String Nome;
    private String Data;
    private float Latitude;
    private float Longitude;
    private String Descricao;

    public Eventos( int id,String nome,String data,float latitude,float longitude,String descricao){

        setId(id);
        setNome(nome);
        setData(data);
        setLatitude(latitude);
        setLongitude(longitude);
        setDescricao(descricao);

    }

    public static final List<Eventos> ITEMS = new ArrayList<Eventos>();

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

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}

