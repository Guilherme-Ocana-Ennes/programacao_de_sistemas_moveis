package com.api.trabalhofinal.objetos;

public class UsuariosEventos {

    private int Id;
    private Eventos Evento;
    private Usuarios Usuario;

    public UsuariosEventos(int Id,Eventos evento, Usuarios usuario){
        setId(Id);
        setIdEvento(evento);
        setIdUsuario(usuario);
    }



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Eventos getIdEvento() {
        return Evento;
    }

    public void setIdEvento(Eventos evento) {
        Evento = evento;
    }

    public Usuarios getIdUsuario() {
        return Usuario;
    }

    public void setIdUsuario(Usuarios usuario) {
        Usuario = usuario;
    }
}
