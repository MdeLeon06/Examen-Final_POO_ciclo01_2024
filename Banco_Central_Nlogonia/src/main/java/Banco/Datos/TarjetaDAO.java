package Banco.Datos;

import Banco.Conexion.ConexionDB;
import Banco.Entidad.Tarjeta.Tarjeta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarjetaDAO implements ITarjetaDAO{
    private Connection con;
    private ConexionDB InstanciaConexion = new ConexionDB();

    public TarjetaDAO() {}

    @Override
    public List<Tarjeta> obtenerTarjetas() {
        List<Tarjeta> listaTarjetas = new ArrayList<Tarjeta>();
        con = InstanciaConexion.conectarDB();
        String sql = "SELECT t.num_tarjeta as 'Cuenta', t.Fecha_Expiriacion as 'Vencimiento', t.Tipo_tarjeta as 'Tarjeta', f.Facilitador as 'Facilitador' FROM tarjeta as t inner join Facilador as f on f.Id_facilitador = t.Id_Facilitador";
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tarjeta tarjeta = new Tarjeta();
                tarjeta.setTarjeta(rs.getString("Cuenta"));
                tarjeta.setFechExpiarion(rs.getString("Vencimiento"));
                tarjeta.setTipoTarjeta(rs.getString("Tarjeta"));
                tarjeta.setFacilitador(rs.getString("Facilitador"));
                listaTarjetas.add(tarjeta);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTarjetas;
    }

    @Override
    public void guardarTarjeta(Tarjeta tarjeta) {
        con = InstanciaConexion.conectarDB();
        String sql = "INSERT INTO Tarjeta( num_tarjeta, Fecha_Expiriacion, Tipo_tarjeta, Id_Facilitador, Id_Cliente) VALUES (?,?,?,?,?,)";
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, tarjeta.getTarjeta());
            ps.setString(2, tarjeta.getFechExpiarion());
            ps.setString(3, tarjeta.getTipoTarjeta());
            ps.setInt(4, tarjeta.getId_Facilitador());
            ps.setInt(5, tarjeta.getId_Cliente());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void eliminarTarjeta(Tarjeta tarjeta) {
        con = InstanciaConexion.conectarDB();
        String sql = "DELETE FROM Tarjeta WHERE id_tarjeta=?";
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, tarjeta.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Tarjeta> obtenerTarjetaPorCliente(int id) {
        con = InstanciaConexion.conectarDB();
        List<Tarjeta> Tarjetas = new ArrayList<Tarjeta>();
        String sql = "select * from Tarjeta as t inner join Clientes as c on t.Id_cliente=c.Id_cliente where Id_cliente=? ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tarjeta tarjeta = new Tarjeta();
                tarjeta.setTarjeta(rs.getString("Cuenta"));
                tarjeta.setTipoTarjeta(rs.getString("Tipo_Tarjeta"));
                Tarjetas.add(tarjeta);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static void main (String[] args) {
        TarjetaDAO TarjetaDAO = new TarjetaDAO();
        List<Tarjeta> tarjetas = TarjetaDAO.obtenerTarjetas();
        for (Tarjeta tarjeta : tarjetas) {
            System.out.println(tarjeta.toString());
        }
    }


}
