package com.example.banco_central_nlogonia.Banco.Datos;

import com.example.banco_central_nlogonia.Banco.Conexion.ConexionDB;
import com.example.banco_central_nlogonia.Banco.Entidad.Cliente.Cliente;
import com.example.banco_central_nlogonia.Banco.Entidad.Usuario.Usuario;

import java.sql.*;

public class UsuarioDAO implements IUsuarioDAO{
    Connection con; // 00012523 Variable para la conexion
    ConexionDB InstanciaConexion = new ConexionDB(); // 00012523 Variable de la clase ConexionDB

    public UsuarioDAO(){} // 00012523 Constructor vacio para inivialiciar las variables en los controllers

    @Override
    public void CrearCuenta(Usuario usuario) { // 00012523 Funcion para crear cuenta
        this.con = InstanciaConexion.conectarDB(); // 0012523 Inico de la conexion con la base de datos
        String sql = "insert into Usuario (Usuario,Clave, Id_Cliente) values (?,?,?)"; // 00012523 Codigo para realizr la insecion de datos con la base de datos
        try{ // 00012523 intento de insercion de datos
            PreparedStatement ps = con.prepareStatement(sql); // 00012523 Preparacion de la insercion de datos
            ps.setString(1, usuario.getUsuario()); // 00012523 Insertando el valor al parametro 1 del insert
            ps.setString(2, usuario.getClave()); // 00012523 Insertando el valor al parametro 2 del insert
            ps.setInt(3, usuario.getId_Cliente()); // 00012523 Insertando el valor al parametro 3 del insert
            ps.executeUpdate(); //00012523 Ejecucion de la insercion
        } catch (SQLException e) { // 00012523 Clausula de excepcion en el case que el insert falle
            throw new RuntimeException(e); // 00012523 Mensaje de error
        }
    }

    @Override
    public void EliminarCuenta(Usuario Usuario) { // 00012523 Funcion para eliminar cuenta
        this.con = InstanciaConexion.conectarDB(); // 0012523 Inico de la conexion con la base de datos
        String sql = "DELETE FROM usuario WHERE Id_Usuario = ?"; // 00012523 Codigo para realizar el delete en la base de datos
        try{ // 00012523 Intentando realizar el delete
            PreparedStatement ps = con.prepareStatement(sql); // 00012523 Preparacion del delete
            ps.setInt(1, Usuario.getId());// 00012523 Insertando el valor al parametro 1 del delete
            ps.executeUpdate(); // 00012523 Ejecutando el delete
        } catch (SQLException e) { // Clausula de excepcion en el case que el delete falle
            throw new RuntimeException(e); // 00012523 Mensaje de error
        } finally { // 00012523 Ejecucion final de la funcion
            try{ // 00012523 Intento de cierre de conexion
                con.close(); // 00012523 Cierre de la conexion con la base de datos
            } catch (SQLException e) { // 00012523 Clausula de excepcion en el case que el cierre de conexion falle
                throw new RuntimeException(e); // 00012523 Mensaje de error
            }
        }
    }

    @Override
    public Cliente BuscarCliente(String Usuario) { // 00012523 Funcion para buscar cliente
        this.con = InstanciaConexion.conectarDB(); // 0012523 Inico de la conexion con la base de datos
        Cliente cliente = new Cliente(); // 00012523 Variable para guardar los datos del cliente
        String sql = "select * from Clientes as c inner join Usuarios as u on c.Id_Cliente= u.Id_Cliente where usuario = ?"; // 00012523 Codigo para realizar la consulta con la base de datos
        try{ // 00012523 Intento de ejecucion de la consulta
            PreparedStatement ps = this.con.prepareStatement(sql); // 00012523 Preparacion de la consulta
            ps.setString(1, Usuario); // 00012523 Insertando el valor al parametro 1
            ResultSet rs = ps.executeQuery(); //Ejecucion y obtencion de datos
            while(rs.next()){ // Ordenado de datos por fila
                cliente.setNombre(rs.getString("Nombre_Completo")); // 00012523 Guardado del dato nombre completo
                cliente.setDireccion(rs.getString("direccion")); // 00012523 Guardado del dato de dirreccion
                cliente.setTelefono(rs.getString("telefono")); // 00012523 Guardado del dato del telefono
            }
        } catch (SQLException e) { // 00012523 Clausula de excepcion en el caso que la consulta falle
            throw new RuntimeException(e); //00012523 Mensaje de error
        }
        return cliente; // 00012523 Retorno de la clase cliente
    }

    @Override
    public boolean IniniarSecion(String Usuario, String Clave) { // 00012523 Funcion para iniciar secion
        this.con = InstanciaConexion.conectarDB();  // 0012523 Inicio de la conexion con la base de datos
        boolean resultado = false; // 00012523 Variable para indicar si existe o no la cuenta
        String sql = "select * from Usuarios where usuario = ? and Clave = ?"; // 00012523 Codigo para realizr la consulta con la base de datos
        try{ // 00012523 Intento de ejecucion de la consulta
            PreparedStatement ps = this.con.prepareStatement(sql); // 00012523  Preparacion de la consulta
            ps.setString(1, Usuario); // 00012523 Insertando el valor al parametro 1
            ps.setString(2, Clave); // 00012523 Insertando el valor al parametro 2
            ResultSet rs = ps.executeQuery(); // 00012523 Ejecutando y obteniendo datos
            while(rs.next()){ // 00012523 verificacion de existencia de la cuenta
                resultado = true; // 00012523 La cuenta si existe
                System.out.println("Inicio Exitoso");
            }
        } catch (SQLException e) { // 00012523 Clausula de excepcion en el caso que la consulta falle
            throw new RuntimeException(e); // 0001252 Mensaje de error
        } finally { // 00012523 Ejecucion de la parte final de la funcion
            try{ // 00012523 Intento de cierre de la conexion
                this.con.close(); // 00012523 Cierre de la conexion con la base de datos
            } catch (SQLException e) { // 00012523 Clausula de excepcion en el caso que la consulta falle
                throw new RuntimeException(e); // 00012523 Mensaje de error
            }
        }
        return resultado; // 00012523 Retorno del resultado
    }
}
