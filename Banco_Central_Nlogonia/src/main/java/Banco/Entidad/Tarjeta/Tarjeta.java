package Banco.Entidad.Tarjeta;

import Banco.Entidad.Cliente.Cliente;

public class Tarjeta {
    private int id;
    private int Id_Facilitador;
    private int Id_Cliente;
    private String Tarjeta;
    private String Facilitador;
    private String FechExpiarion;
    private String TipoTarjeta;
    private Cliente cliente;

    public Tarjeta(String tarjeta, String facilitador, String Fecha, String tipoTarjeta, Cliente cliente){
        this.Tarjeta = tarjeta;
        this.Facilitador = facilitador;
        this.FechExpiarion = Fecha;
        this.TipoTarjeta = tipoTarjeta;
        this.cliente = cliente;
    }

    public Tarjeta() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Facilitador() {
        return Id_Facilitador;
    }

    public void setId_Facilitador(int id_Facilitador) {
        Id_Facilitador = id_Facilitador;
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        Id_Cliente = id_Cliente;
    }

    public String getFechExpiarion() {
        return FechExpiarion;
    }

    public void setFechExpiarion(String fechExpiarion) {
        FechExpiarion = fechExpiarion;
    }

    public String getTarjeta() {
        return Tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        Tarjeta = tarjeta;
    }

    public String getFacilitador() {
        return Facilitador;
    }

    public void setFacilitador(String facilitador) {
        Facilitador = facilitador;
    }

    public String getTipoTarjeta() {
        return TipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        TipoTarjeta = tipoTarjeta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "Tarjeta='" + Tarjeta + '\'' +
                ", Facilitador='" + Facilitador + '\'' +
                ", FechExpiarion='" + FechExpiarion + '\'' +
                ", TipoTarjeta='" + TipoTarjeta + '\'' +
                '}';
    }
}
