package Banco.Datos;

import Banco.Conexion.ConexionDB;
import Banco.Entidad.Tarjeta.Tarjeta;
import Banco.Entidad.Transaccion.Transaccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacionDAO implements ITransacionDAO {
    private Connection con;
    private ConexionDB InstanciaConexion = new ConexionDB();

    public TransacionDAO() {}

    @Override
    public List<Transaccion> listadoTransacciones() {
        List<Transaccion> listaTransacciones = new ArrayList<Transaccion>();
        String sql = "select * from Transaccion";
        this.con = InstanciaConexion.conectarDB();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaccion transaccion = new Transaccion();
                transaccion.setCodigo(rs.getInt("Id_Transaccion"));
                transaccion.setDescripcion(rs.getString("Descripcion"));
                transaccion.setMonto(rs.getFloat("Monto_Total"));
                transaccion.setFecha(rs.getString("Fecha_Compra"));
                listaTransacciones.add(transaccion);
            }
        } catch (SQLException e) {
            System.out.println("Err al extraer los datos: " + e.getMessage());
        } finally {
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println("Err al cerrar: " + e.getMessage());
            }
        }
        return listaTransacciones;
    }

    @Override
    public void InsertarTransaccion(Transaccion transaccion) {
        this.con = InstanciaConexion.conectarDB();
        String sql = "insert into Transaccion (Id_Transaccion, Descripcion, Monto_Total, Fecha_Compra, Id_Tarjeta) values (?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, transaccion.getCodigo());
            ps.setString(2, transaccion.getDescripcion());
            ps.setFloat(3, transaccion.getMonto());
            ps.setString(4, transaccion.getFecha());
            ps.setInt(5, transaccion.getIdTarjeta());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Err al insertar transaccion: " + e.getMessage());
        }finally {
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println("Err al cerrar: " + e.getMessage());
            }
        }
    }

    @Override
    public void EliminarTransaccion(Transaccion transaccion) {
        this.con = InstanciaConexion.conectarDB();
        String sql = "DELETE FROM Transaccion WHERE Id_Transaccion=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, transaccion.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Err al insertar transaccion: " + e.getMessage());
        }finally {
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println("Err al cerrar: " + e.getMessage());
            }
        }
    }

    @Override
    public List<Transaccion> ComprasClientes(int Id) {
        this.con = InstanciaConexion.conectarDB();
        List<Transaccion> transacciones = new ArrayList<Transaccion>();
        String sql = "select * from Transaccion as t inner join Tarjeta as ta on t.Id_Tarjeta = ta.id_tarjeta inner join Clientes as c on ta.Id_Cliente = c.Id_Cliente where Id_Cliente=?";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaccion transaccion = new Transaccion();
                transaccion.setCodigo(rs.getInt("Id_Transaccion"));
                transaccion.setDescripcion(rs.getString("Descripcion"));
                transaccion.setMonto(rs.getFloat("Monto_Total"));
                transaccion.setFecha(rs.getString("Fecha_Compra"));
                transaccion.setIdTarjeta(rs.getInt("Id_Tarjeta"));
                transacciones.add(transaccion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return transacciones;
    }

    @Override
    public List<Transaccion> MontoTotal(int Id, String fecha1, String fecha2) {
        this.con = InstanciaConexion.conectarDB();
        List<Transaccion> transacciones = new ArrayList<Transaccion>();
        String sql = "select sum(t.Monto_total) as 'Total', ta.num_tarjeta as 'Tarjeta', count(Id_Transaccion) as 'Cantidad' from Transaccion as t inner join Tarjeta as ta on t.Id_Tarjeta = ta.id_tarjeta inner join Clientes as c on ta.Id_Cliente = c.Id_Cliente where Id_Cliente=? and Fecha_Compra between ? and ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Id);
            ps.setString(2, fecha1);
            ps.setString(3, fecha2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaccion transaccion = new Transaccion();
                transaccion.setMonto(rs.getFloat("Total"));
                transaccion.setTarjeta(rs.getString("Tarjeta"));
                transaccion.setCantidad(rs.getInt("Cantidad"));
                transacciones.add(transaccion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transacciones;
    }
}
