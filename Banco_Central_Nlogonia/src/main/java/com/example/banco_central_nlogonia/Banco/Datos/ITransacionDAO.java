package com.example.banco_central_nlogonia.Banco.Datos;

import com.example.banco_central_nlogonia.Banco.Entidad.Transaccion.Transaccion;

import java.util.List;

public interface ITransacionDAO {
    List<Transaccion> listadoTransacciones(); // 00012523 Declaracion de funcion para conseguir listado de las transacciones
    void InsertarTransaccion(Transaccion transaccion); //00012523 Declaracion de funcion para insertar transacciones a la base de datos
    void EliminarTransaccion(Transaccion transaccion); //00012523 Declaracion de funcion para eliminar transacciones
    List<Transaccion> ComprasClientes(int Id); //00012523 Declaracion de funcion para mostrar lista de las compras de los clientes
    List<Transaccion> MontoTotal(int Id, String fecha1, String fecha2); //00012523 Declaracion de funcion para mostrar el monto total por cliente
}
