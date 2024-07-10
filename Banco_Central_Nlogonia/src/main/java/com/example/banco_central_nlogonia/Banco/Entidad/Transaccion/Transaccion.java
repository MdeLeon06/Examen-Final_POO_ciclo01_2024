package com.example.banco_central_nlogonia.Banco.Entidad.Transaccion;

import com.example.banco_central_nlogonia.Banco.Entidad.Tarjeta.Tarjeta;

public class Transaccion {
    private int codigo;
    private int IdTarjeta;
    private float Monto;
    private String descripcion;
    private String fecha;
    private String tarjeta;
    private int cantidad;
    public Transaccion(int codigo, float monto, String descripcion, String tarjeta, String fecha) {
        this.codigo = codigo;
        this.Monto = monto;
        this.descripcion = descripcion;
        this.tarjeta = tarjeta;
        this.fecha = fecha;
    }

    public Transaccion(int idTransaccion, float monto, String descripcion, Tarjeta tarjeta, String string) {
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public float getMonto() {
        return Monto;
    }
    public void setMonto(float monto) {
        Monto = monto;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getTarjeta() {
        return tarjeta;
    }
    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public int getIdTarjeta() {
        return IdTarjeta;
    }
    public void setIdTarjeta(int idTarjeta) {
        IdTarjeta = idTarjeta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
