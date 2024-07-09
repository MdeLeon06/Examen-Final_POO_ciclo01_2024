package Banco.Datos;

import Banco.Conexion.ConexionDB;
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
}
