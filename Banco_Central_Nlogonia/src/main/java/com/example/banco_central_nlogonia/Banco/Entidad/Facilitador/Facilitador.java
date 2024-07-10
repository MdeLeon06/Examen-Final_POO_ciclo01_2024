package com.example.banco_central_nlogonia.Banco.Entidad.Facilitador;

public class Facilitador {
    private int IdFacilitador; // 00012523 Variable int para el id de Facilitador
    private String nombreFcilitador; // 00012523 Variable String para el Nombre del facilitador

    public Facilitador() {} // 00012523 Constructor vacio
    public Facilitador(int IdFacilitador, String nombreFcilitador) { // 00012523 Constructor Con parametros
        this.IdFacilitador = IdFacilitador; // 00012523 Asignandole el valor de la variable el valor del parametro
        this.nombreFcilitador = nombreFcilitador; // 00012523 Asignandole el valor de la variable el valor del parametro
    }

    public int getIdFacilitador() {//00012523 Funcion getter
        return IdFacilitador; //00012523 retornando el valor asignado en IdFacilitador
    }

    public void setIdFacilitador(int idFacilitador) { //00012523 Funcion setter
        IdFacilitador = idFacilitador; // 00012523 Asignandole el valor de la variable el valor del parametro
    }

    public String getNombreFcilitador() { //00012523 Funcion getter
        return nombreFcilitador; //00012523 retornando el valor asignado en nombreFacilitador
    }

    public void setNombreFcilitador(String nombreFcilitador) { //00012523 Funcion setter
        this.nombreFcilitador = nombreFcilitador; // 00012523 Asignandole el valor de la variable el valor del parametro
    }
}
