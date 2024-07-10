package com.example.banco_central_nlogonia.Banco.Datos;

import com.example.banco_central_nlogonia.Banco.Conexion.ConexionDB;
import com.example.banco_central_nlogonia.Banco.Entidad.Tarjeta.Tarjeta;
import com.example.banco_central_nlogonia.Banco.Entidad.Transaccion.Transaccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacionDAO implements ITransacionDAO {
    private Connection con; // 00012523 Variable para la conexion
    private ConexionDB InstanciaConexion = new ConexionDB(); // 00012523 Variable para realizar la conexion de la base de datos

    public TransacionDAO() {} // 00012523 Constructor vacio para inicializar la variable

    @Override
    public List<Transaccion> listadoTransacciones() { // 00012523 Funcion lista para recolectar todas las transaciones en general
        List<Transaccion> listaTransacciones = new ArrayList<Transaccion>(); // 00012523 Variable para almacenar los datos
        String sql = "select * from Transaccion"; // 00012523 Codigo de consulta
        this.con = InstanciaConexion.conectarDB(); // 0012523 Inico de la conexion con la base de datos
        try{
            PreparedStatement ps = con.prepareStatement(sql);// 00012523 Preparacion del codigo para realizar la consulta con la base de datos
            ResultSet rs = ps.executeQuery(); // 00012523 Ejecucion y Almacenamiento de datos
            while (rs.next()) { // 00012523 Recorrido por filas de los datos obtenidos
                Transaccion transaccion = new Transaccion(); // 00012523 Variable para almacenr los datos
                transaccion.setCodigo(rs.getInt("Id_Transaccion")); // 00012523 Guardado del id de transaccion
                transaccion.setDescripcion(rs.getString("Descripcion")); // 00012523 Guardado de la descripcion
                transaccion.setMonto(rs.getFloat("Monto_Total")); // 00012523 Guardado del moto total por transsaccion
                transaccion.setFecha(rs.getString("Fecha_Compra")); //00012523 Guardado de la fecha que se realizo la transaccion
                listaTransacciones.add(transaccion); // 00012523 Guardado de datos en la lista
            }
        } catch (SQLException e) { // 00012523 Clausula de excepcion en le caso que la consulta falle
            System.out.println("Err al extraer los datos: " + e.getMessage()); // 00012523 Mensaje de error
        } finally { // 00012523 Finalizacion de la consulta
            try{ // 00012523 Intento de cierre de conexion
                con.close(); // 0012523 Cierre de conexion
            } catch (SQLException e) { // 00012523 Clausula de excepcion en el caso que el cierre de conexion faller
                System.out.println("Err al cerrar: " + e.getMessage()); //00012523 Mensje de error
            }
        }
        return listaTransacciones; // 00012523 Retorno de la lista
    }

    @Override
    public void InsertarTransaccion(Transaccion transaccion) {
        this.con = InstanciaConexion.conectarDB(); // 0012523 Inico de la conexion con la base de datos
        String sql = "insert into Transaccion (Id_Transaccion, Descripcion, Monto_Total, Fecha_Compra, Id_Tarjeta) values (?,?,?,?,?)"; // 00012523 Codigo para realizar la insercion de datos con la base de datos
        try{ // 00012523 Intento de realizacion de insercion de datos a la base de datos
            PreparedStatement ps = con.prepareStatement(sql); // 00012523 Preparacion de la insercion de datos  a la base de datos
            ps.setInt(1, transaccion.getCodigo()); // 00012523 Insertando el valor al parametro 1 del insert
            ps.setString(2, transaccion.getDescripcion()); // 00012523 Insertando el valor al parametro 2 del insert
            ps.setFloat(3, transaccion.getMonto()); // 00012523 Insertando el valor al parametro 3 del insert
            ps.setString(4, transaccion.getFecha()); // 00012523 Insertando el valor al parametro 4 del insert
            ps.setInt(5, transaccion.getIdTarjeta()); // 00012523 Insertando el valor al parametro 5 del insert
            ps.executeUpdate(); // 00012523 Ejecutando insercion de datos a la base de datos
        } catch (SQLException e) { // 00012523 Clausula de excepcion en el caso la insercion falle
            System.out.println("Err al insertar transaccion: " + e.getMessage()); // 00012523 Mensaje de error
        }finally { // 00012523 Ejecucion final de la funcion
            try{ // 00012523 Intento de cierre de la conexion
                con.close(); // 00012523 Cierre de la conexion
            } catch (SQLException e) { // 00012523 Clausula de excepcion en el caso del fallo del cierre de la conexion
                System.out.println("Err al cerrar: " + e.getMessage()); // 00012523 Mensaje de error
            }
        }
    }

    @Override
    public void EliminarTransaccion(Transaccion transaccion) { // 00012523 Funcion de eliminacion de transacion
        this.con = InstanciaConexion.conectarDB(); // 0012523 Inico de la conexion con la base de datos
        String sql = "DELETE FROM Transaccion WHERE Id_Transaccion=?"; // 00012523 Codigo para realizar un delete en la base de datos
        try{ // 00012523 intento de realizacion del delete
            PreparedStatement ps = con.prepareStatement(sql); // 00012523 Preparacion del codigo de delete
            ps.setInt(1, transaccion.getCodigo()); // 00012523 Insertando el valor al parametro 1 del delete
            ps.executeUpdate(); // 00012523 Ejecucion del codigo delete
        } catch (SQLException e) { // Clausula de excepcion en el caso que el delete falle
            System.out.println("Err al insertar transaccion: " + e.getMessage()); // 00012523 Mensaje de error
        }finally { // 00012523 Ejecucion final de la funcion
            try{ // 00012523 Intento de de cierre de conexion
                con.close(); //00012523 Cierre de la conexion
            } catch (SQLException e) {  // Clausula de excepcion en el caso que el cierre de la conexion falle
                System.out.println("Err al cerrar: " + e.getMessage()); // 00012523 mensaje de error
            }
        }
    }

    @Override
    public List<Transaccion> ComprasClientes(int Id) { // 00012523 Funcion para llamar las compras que ha realizado un cliente
        this.con = InstanciaConexion.conectarDB(); // 0012523 Inico de la conexion con la base de datos
        List<Transaccion> transacciones = new ArrayList<Transaccion>(); // 00012523  Variable lista para el almacenamiento de datos
        String sql = "select * from Transaccion as t inner join Tarjeta as ta on t.Id_Tarjeta = ta.id_tarjeta inner join Clientes as c on ta.Id_Cliente = c.Id_Cliente where Id_Cliente=?"; // 00012523 Codigo para realizar la consulta con la base de datos
        try{ //00012523 Intento de realizar la consulta
            PreparedStatement ps = con.prepareStatement(sql); // 00012523 Preparacion de la consulta a la base de datos
            ps.setInt(1, Id); // 00012523 Insertando el valor al parametro 1
            ResultSet rs = ps.executeQuery(); // 00012523 Ejecutando y obteniendo datos de la consulta
            while (rs.next()) { // 00012523 Ordenando datos por fila para almacenamiento
                Transaccion transaccion = new Transaccion(); // 00012523 Variable para almacenar datos obtenidos
                transaccion.setCodigo(rs.getInt("Id_Transaccion")); // 00012523 Guardado de datos del numero de transaccion
                transaccion.setDescripcion(rs.getString("Descripcion")); // 00012523 Guardado de datos de la descripcion de transaccion
                transaccion.setMonto(rs.getFloat("Monto_Total")); // 00012523 Guardado de datos del monto total de transaccion
                transaccion.setFecha(rs.getString("Fecha_Compra")); // 00012523 Guardado de datos deal fecha de transaccion
                transaccion.setIdTarjeta(rs.getInt("Id_Tarjeta")); // 00012523 Guardado de datos del id de la tarjeta
                transacciones.add(transaccion); // 00012523 Guardado de los datos en una lista
            }
        } catch (SQLException e) { // 00012523 Clausula de excepcion en el case que la consulta falle
            throw new RuntimeException(e); // 00012523 Mensaje de error
        } finally { // 00012523 Accion final de la funcion
            try{ // 00012523 Intendo de cierre de la conexion
                con.close(); // 00012523 cierre de la conexion
            } catch (SQLException e) { // 00012523 Clausula de excepcion en el case que el delete falle
                throw new RuntimeException(e); //00012523 Mensaje de error
            }
        }

        return transacciones; // 00012523 Retorno de la lista
    }

    @Override
    public List<Transaccion> MontoTotal(int Id, String fecha1, String fecha2) { // 00012523 Funcion para obtener el monto total de transacciones  por tarjeta
        this.con = InstanciaConexion.conectarDB(); // 0012523 Inico de la conexion con la base de datos
        List<Transaccion> transacciones = new ArrayList<Transaccion>(); // 00012523 Variable  para el guardado de datos
        String sql = "select sum(t.Monto_total) as 'Total', ta.num_tarjeta as 'Tarjeta', count(Id_Transaccion) as 'Cantidad' from Transaccion as t inner join Tarjeta as ta on t.Id_Tarjeta = ta.id_tarjeta inner join Clientes as c on ta.Id_Cliente = c.Id_Cliente where Id_Cliente=? and Fecha_Compra between ? and ?";// 00012523 Codigo para realizrr la consulta con la base de datos
        try{ // 00012523 Intento de generar la consulta
            PreparedStatement ps = con.prepareStatement(sql); //00012523 Preparacion de la consulta
            ps.setInt(1, Id); // 00012523 Insertando el valor al parametro 1
            ps.setString(2, fecha1); // 00012523 Insertando el valor al parametro 2
            ps.setString(3, fecha2); // 00012523 Insertando el valor al parametro 3
            ResultSet rs = ps.executeQuery(); // 00012523 Ejecucion y obtencion de datos
            while (rs.next()) { // 00012523 Obtencion de datos por fila
                Transaccion transaccion = new Transaccion(); // 00012523 Variable para el almacenmiento de datos
                transaccion.setMonto(rs.getFloat("Total")); // 00012523 Guardado de datos del monto total
                transaccion.setTarjeta(rs.getString("Tarjeta")); // 00012523 Guardado de datos del tarjeta
                transaccion.setCantidad(rs.getInt("Cantidad")); // 00012523 Guardado de datos de cantidad
                transacciones.add(transaccion); // 00012523 Guardado de datos en el list
            }
        } catch (SQLException e) { // 00012523 Clausula de excepcion en el caso que la consulta falle
            throw new RuntimeException(e); // 00012523 Mensaje de error
        }
        return transacciones; // 00012523 Retorno de la lista
    }
}
