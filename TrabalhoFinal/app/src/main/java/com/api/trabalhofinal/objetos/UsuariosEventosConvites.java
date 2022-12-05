package com.api.trabalhofinal.objetos;

public class UsuariosEventosConvites {

    private int Id;
    private UsuariosEventos usuariosEventos;
    private int Status;
    private int Tipo;

    public UsuariosEventosConvites(UsuariosEventos usuariosEventos, int Id,int Status, int Tipo){

        setId(Id);
        setUsuariosEventos(usuariosEventos);
        setStatus(Status);
        setTipo(Tipo);

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int tipo) {
        Tipo = tipo;
    }

    public UsuariosEventos getUsuariosEventos() {
        return usuariosEventos;
    }

    public void setUsuariosEventos(UsuariosEventos usuariosEventos) {
        this.usuariosEventos = usuariosEventos;
    }
}
