package com.example.banco_central_nlogonia.Banco.Entidad.Usuario;

public class Usuario {
    private int Id;
    private String Usuario;
    private String Clave;
    private int Id_Cliente;

    public Usuario() {}

    public Usuario(String Usuario, String Clave) {
        this.Usuario = Usuario;
        this.Clave = Clave;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        Id_Cliente = id_Cliente;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }
}
