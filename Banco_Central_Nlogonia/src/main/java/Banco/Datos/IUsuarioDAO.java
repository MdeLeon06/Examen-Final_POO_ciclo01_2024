package Banco.Datos;

import Banco.Entidad.Cliente.Cliente;
import Banco.Entidad.Usuario.Usuario;

public interface IUsuarioDAO {
    void CrearCuenta(Usuario usuario);
    void EliminarCuenta(Usuario Usuario);
    Cliente BuscarCliente(String Usuario);
    boolean IniniarSecion(String Usuario, String Clave);
}
