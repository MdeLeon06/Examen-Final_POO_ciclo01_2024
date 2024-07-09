package Banco.Datos;

import Banco.Conexion.ConexionDB;

import java.sql.*;

public class FacilitadorDAO implements IFacilitadorDAO {
    Connection con;
    ConexionDB InstanciaConexion = new ConexionDB();

    public FacilitadorDAO() {}

    @Override
    public int BuscarFacilitador(String nombre) {
        this.con = InstanciaConexion.conectarDB();
        int resultado = 0;
        String sql = "SELECT Id_Facilitador FROM facilitador WHERE nombre = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return resultado = rs.getInt("Id_Facilitador");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return resultado;
    }
}
