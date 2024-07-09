package Banco.Datos;

import Banco.Entidad.Cliente.Cliente;

import java.util.List;

public interface IClienteDAO {
    List<Cliente> listarClientes();
    Cliente buscarClientePorID(int id);
    void insertarDatosCliente(Cliente cliente);
    void actualizarDatosCliente(Cliente cliente);
    int conseguirIdCliente(Cliente cliente);

}
