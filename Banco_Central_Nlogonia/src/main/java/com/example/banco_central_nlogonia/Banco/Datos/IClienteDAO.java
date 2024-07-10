package com.example.banco_central_nlogonia.Banco.Datos;

import  com.example.banco_central_nlogonia.Banco.Entidad.Cliente.Cliente;

import java.util.List;

public interface IClienteDAO {
    List<Cliente> listarClientes(); // 00012523 Declaracion de la funcion para enlistar datos
    Cliente buscarClientePorID(int id); // 00012523 Declaracion de la funcion para obtener un cliente
    void insertarDatosCliente(Cliente cliente); //00012523 Declaracion de la funcion para insertar datos de un cliente
    void actualizarDatosCliente(Cliente cliente); // 0012523 Delcaracion de la funcion para actualizar datos de un cliente
    int conseguirIdCliente(Cliente cliente); // 00012523 Declaracion de la funcion para conseguir el id de un cliente


}
