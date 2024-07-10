package com.example.banco_central_nlogonia.Banco.Datos;

import com.example.banco_central_nlogonia.Banco.Entidad.Cliente.Cliente;
import com.example.banco_central_nlogonia.Banco.Entidad.Usuario.Usuario;

public interface IUsuarioDAO {
    void CrearCuenta(Usuario usuario); // 00012523 Declaracion de funcion para crear cuenta
    void EliminarCuenta(Usuario Usuario); // 00012523 Declaracion de funcion para eliminar cuenta
    Cliente BuscarCliente(String Usuario); // 00012523 Declaracion de funcion para buscar cliente
    boolean IniniarSecion(String Usuario, String Clave); // 00012523 Declaracion de funcion para iniciar secion
}
