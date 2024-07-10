package Banco.Datos;

import Banco.Entidad.Transaccion.Transaccion;

import java.util.List;

public interface ITransacionDAO {
    List<Transaccion> listadoTransacciones();
    void InsertarTransaccion(Transaccion transaccion);
    void EliminarTransaccion(Transaccion transaccion);
    List<Transaccion> ComprasClientes(int Id);
    List<Transaccion> MontoTotal(int Id, String fecha1, String fecha2);
}
