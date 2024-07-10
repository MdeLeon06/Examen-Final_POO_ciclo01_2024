package com.example.banco_central_nlogonia.Banco.Datos;

import com.example.banco_central_nlogonia.Banco.Conexion.ConexionDB;
import com.example.banco_central_nlogonia.Banco.Entidad.Tarjeta.Tarjeta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarjetaDAO implements ITarjetaDAO{
    private Connection con; // 00012523 Declaracion de variable para conecta la base de datos
    private ConexionDB InstanciaConexion = new ConexionDB(); // 00012523 Declaracion de variable para la clase ConexionDB

    public TarjetaDAO() {} //Constructor vacio para inicia variables

    @Override
    public List<Tarjeta> obtenerTarjetas() { // 00012523 Funcion para obtener una lista de tarjetas
        List<Tarjeta> listaTarjetas = new ArrayList<Tarjeta>(); //0001523 Variable para almacena datos en form de lista
        con = InstanciaConexion.conectarDB(); // 0012523 Inico de la conexion con la base de datos
        String sql = "SELECT t.num_tarjeta as 'Cuenta', t.Fecha_Expiriacion as 'Vencimiento', t.Tipo_tarjeta as 'Tarjeta', f.Facilitador as 'Facilitador' FROM tarjeta as t inner join Facilador as f on f.Id_facilitador = t.Id_Facilitador"; // 00012523 Codigo para realizr la consulta con la base de datos
        try{ // 00012523 Intento de realizar la consulta a la base de datos
            PreparedStatement ps = this.con.prepareStatement(sql); // 00012523 Preparacion de la consulta a la base de datos
            ResultSet rs = ps.executeQuery(); // 00012523 Ejecucion y obtencion de datos
            while (rs.next()) { // 00012523 While para recorrer y almacenar datos
                Tarjeta tarjeta = new Tarjeta(); // 00012523 Variable para guardar los datos obtenidos de la base de datos
                tarjeta.setTarjeta(rs.getString("Cuenta")); // 00012523 Guardado del dato de numero de cuenta
                tarjeta.setFechExpiarion(rs.getString("Vencimiento")); // 00012523 Guardado del dato de la fecha de vencimiento
                tarjeta.setTipoTarjeta(rs.getString("Tarjeta")); // 00012523 Guardado de del dato del tipo de tarjeta
                tarjeta.setFacilitador(rs.getString("Facilitador")); // 00012523 Guardado de datos del facilitador
                listaTarjetas.add(tarjeta); // 00012523 Guardado de todos los datos en una lista
            }
        } catch (SQLException e) { // 00012523 Clausula de excepcion en el caso que la consulta no se realice
            throw new RuntimeException(e); //00012523 Mensaje de error
        }
        return listaTarjetas; // 00012523 Retorno de la lista
    }

    @Override
    public void guardarTarjeta(Tarjeta tarjeta) {
        con = InstanciaConexion.conectarDB(); // 0012523 Inico de la conexion con la base de datos
        String sql = "INSERT INTO Tarjeta( num_tarjeta, Fecha_Expiriacion, Tipo_tarjeta, Id_Facilitador, Id_Cliente) VALUES (?,?,?,?,?,)"; // 00012523 Codigo para realizr una insercion con la base de datos
        try{ // 00012523 Intento de la ejecucion del codigo de insercion para la base de datos
            PreparedStatement ps = this.con.prepareStatement(sql); // 00012523 Preparando el codigo para insertar datos
            ps.setString(1, tarjeta.getTarjeta()); // 00012523 Insetando el valor al parametro 1 del insert
            ps.setString(2, tarjeta.getFechExpiarion()); // 00012523 Insetando el valor al parametro 2 del insert
            ps.setString(3, tarjeta.getTipoTarjeta()); // 00012523 Insetando el valor al parametro 3 del insert
            ps.setInt(4, tarjeta.getId_Facilitador()); // 00012523 Insetando el valor al parametro 4 del insert
            ps.setInt(5, tarjeta.getId_Cliente()); // 00012523 Insetando el valor al parametro 5 del insert
            ps.executeUpdate(); // 00012523 Ejecutando el codigo sql para insertar los datos a la base de datos
        } catch (SQLException e) { // 00012523 Clausula de excepcion por se no se opera el codigo de insercon de datos
            throw new RuntimeException(e); // 00012523 Mensaje de error
        } finally { // 0012523 Ejecucion para cerrar la conexion
            try{ //00012523 Intento de cierre de la base de datos
                con.close(); // 00012523 Cierre de la base de datos
            } catch (SQLException e) { // 00012523 Clausula en el caso falle el cierre de la conexion
                throw new RuntimeException(e); // 00012523 Mensaje de error
            }
        }
    }

    @Override
    public void eliminarTarjeta(Tarjeta tarjeta) { // 00012523 Funcion para eliminar tarjeta
        con = InstanciaConexion.conectarDB(); // 0012523 Inico de la conexion con la base de datos
        String sql = "DELETE FROM Tarjeta WHERE id_tarjeta=?"; // 00012523 Codigo para realizr el delete con la base de datos
        try{ // 00012523 Intento de ejecucion del codigo sql
            PreparedStatement ps = this.con.prepareStatement(sql); // Preparacion de la instruccion a la base de datos
            ps.setInt(1, tarjeta.getId()); // 00012523 Insetando el valor al parametro 1 del insert
            ps.executeUpdate(); // 00012523 Ejecucion de la instruccion
        } catch (SQLException e) { // 00012523 Clausula de excepcion en el caso del fallo al ejecutal la instruccion
            throw new RuntimeException(e); //00012523 Mensaje de error
        } finally { //00012523 Al finalizar la ejecucion de la instrucion
            try{ // 00012523 Intento de cierre de la conexion
                con.close(); // 00012523 cierre de la conexion con la base de datos
            } catch (SQLException e) { // 00012523 Clausula en el caso del fallo del cierre de la conexion
                throw new RuntimeException(e); // 00012523 Mensaje de error
            }
        }
    }

    @Override
    public List<Tarjeta> obtenerTarjetaPorCliente(int id) { // 00012523 Funcion para obtener las tarjetas de un cliente
        con = InstanciaConexion.conectarDB(); // 0012523 Inico de la conexion con la base de datos
        List<Tarjeta> Tarjetas = new ArrayList<Tarjeta>(); // 00012523 Variable tipo list para guardar datos de la clase Tarjeta
        String sql = "select * from Tarjeta as t inner join Clientes as c on t.Id_cliente=c.Id_cliente where Id_cliente=? "; // 00012523 Codigo para realizr la consulta con la base de datos
        try{ // 00012523 Intento de ejecucion de la consulta a la base de datos
            PreparedStatement ps = con.prepareStatement(sql); // 00012523 Preparacion de la consulta
            ps.setInt(1, id); // 00012523 Insrtando el valor al parametro 1
            ResultSet rs = ps.executeQuery(); // 00012523 Ejecucion de la consulta y obtencion de datos
            while (rs.next()) { // 00012523 Recoleccion de datos por fila para almacenamiento de datos
                Tarjeta tarjeta = new Tarjeta(); // 00012523 Variable para el almacenamiento de datos
                tarjeta.setTarjeta(rs.getString("Cuenta")); // 00012523 Guardado del numero de cuenta
                tarjeta.setTipoTarjeta(rs.getString("Tipo_Tarjeta")); // 00012523 Guardado del tipo de tarjeta
                Tarjetas.add(tarjeta); // 00012523 Guardado de la variable
            }
        } catch (SQLException e) { // 00012523 Clausula de excepcion en el caso que la consulta no se ejecute
            throw new RuntimeException(e); //0012523 Mensaje de error
        } finally { // 00012523 finalizacion de la conexion
            try{ // 00012523 Intento de cierre de la conexion
                con.close(); // 00012523 Cierre de la conexion
            } catch (SQLException e) { // 00012523 Clausula de excepcion en el caso que el cierre no se realice
                throw new RuntimeException(e); // 00012523 Mensaje de error
            }
        }

        return Tarjetas; // 00012523 Retorno de la lista
    }
}
