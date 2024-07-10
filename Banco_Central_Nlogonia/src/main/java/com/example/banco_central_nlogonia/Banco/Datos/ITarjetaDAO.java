package com.example.banco_central_nlogonia.Banco.Datos;

import java.util.List;
import com.example.banco_central_nlogonia. Banco.Entidad.Tarjeta.Tarjeta;

public interface ITarjetaDAO {
    List<Tarjeta> obtenerTarjetas(); // 00012523 Declaracion de la funcion para enlistar las tarjetas
    void guardarTarjeta(Tarjeta tarjeta); // 00012523 Declaracion de la funcion para guardar datos de la tarjeta
    void eliminarTarjeta(Tarjeta tarjeta); // 00012523 Declaracion de la funcion para eliminar una tarjeta de la base de datos
    List<Tarjeta> obtenerTarjetaPorCliente(int id); // 00012523 Declaracion de la funcion para obtener las tarjetas por cliente
}
