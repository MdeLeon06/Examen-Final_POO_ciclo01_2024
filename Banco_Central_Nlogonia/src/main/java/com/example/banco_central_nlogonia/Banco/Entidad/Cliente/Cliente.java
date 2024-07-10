package com.example.banco_central_nlogonia.Banco.Entidad.Cliente;

public class Cliente {
    private int Id; // 00012523 Variable de tipo entero para el id
    private String IdUsuario; // 00012523 Varaiable de tipo String para IdUsuario
    private String nombre; // 00012523 Variable tipo String para nombre
    private String direccion; // 00012523 Variable tipo String para Direccion
    private String telefono; // 00012523 Variable tipo String para Telefono

    public Cliente(String nombre, String direccion, String telefono) { // 00012523 Constructor con parametros
        this.nombre = nombre; // 0012523 Asignandole un valor a la variable nombre
        this.direccion = direccion; // 0012523 Asignandole un valor a la variable Direccion
        this.telefono = telefono; // 0012523 Asignandole un valor a la variable Telefono
    }

    public int getId() { //00012523 Funcion getter
        return Id; // 0012523 Retorna el id
    }

    public void setId(int id) { //00012523 Funcion setter
        Id = id; // 00012523 Asignandole el valor de la variable el valor del parametro
    }

    public String getIdUsuario() { //00012523 Funcion getter
        return IdUsuario; // 0012523 Retorna el IdUsuario
    }

    public void setIdUsuario(String idUsuario) { //00012523 Funcion setter
        IdUsuario = idUsuario; // 00012523 Asignandole el valor de la variable el valor del parametro
    }

    public Cliente() { // 00012523 Constructor vacio
        this.nombre = ""; // 0012523 Asignandole un valor vacio
        this.direccion = "";// 0012523 Asignandole un valor vacio
        this.telefono = "";// 0012523 Asignandole un valor vacio
    }

    public String getNombre() { //00012523 Funcion getter
        return nombre; // 0012523 Retorna el nombre
    }

    public void setNombre(String nombre) { //00012523 Funcion setter
        this.nombre = nombre; // 00012523 Asignandole el valor de la variable el valor del parametro
    }

    public String getDireccion() { //00012523 Funcion getter
        return direccion; // 0012523 Retorna la direccion
    }

    public void setDireccion(String direccion) { //00012523 Funcion setter
        this.direccion = direccion; // 00012523 Asignandole el valor de la variable el valor del parametro
    }

    public String getTelefono() { //00012523 Funcion getter
        return telefono; // 0012523 Retorna el telefono
    }

    public void setTelefono(String telefono) { //00012523 Funcion setter
        this.telefono = telefono;// 00012523 Asignandole el valor de la variable el valor del parametro
    }

    @Override
    public String toString() { // 00012523 Funcion to String
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
