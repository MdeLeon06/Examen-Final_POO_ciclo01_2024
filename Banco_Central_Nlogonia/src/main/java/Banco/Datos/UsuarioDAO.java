package Banco.Datos;

import Banco.Conexion.ConexionDB;
import Banco.Entidad.Cliente.Cliente;
import Banco.Entidad.Usuario.Usuario;

import java.sql.*;

public class UsuarioDAO implements IUsuarioDAO{
    Connection con;
    ConexionDB InstanciaConexion = new ConexionDB();

    public UsuarioDAO(){}

    @Override
    public void CrearCuenta(Usuario usuario) {
        this.con = InstanciaConexion.conectarDB();
        String sql = "insert into Usuario (Usuario,Clave, Id_Cliente) values (?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getClave());
            ps.setInt(3, usuario.getId_Cliente());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void EliminarCuenta(Usuario Usuario) {
        this.con = InstanciaConexion.conectarDB();
        String sql = "DELETE FROM usuario WHERE Id_Usuario = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Usuario.getId());
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
    public Cliente BuscarCliente(String Usuario) {
        this.con = InstanciaConexion.conectarDB();
        Cliente cliente = new Cliente();
        String sql = "select * from Clientes as c inner join Usuarios as u on c.Id_Cliente= u.Id_Cliente where usuario = ?";
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, Usuario);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){

                cliente.setNombre(rs.getString("Nombre_Completo"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    @Override
    public boolean IniniarSecion(String Usuario, String Clave) {
        this.con = InstanciaConexion.conectarDB();
        boolean resultado = false;
        String sql = "select * from Usuarios where usuario = ? and Clave = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Usuario);
            ps.setString(2, Clave);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                    resultado = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return resultado;
    }

    public static void main(String[] Args){
        Cliente cliente = new Cliente();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String user = "Eduardo";
        String Clave = "22Oct2003";
        if(usuarioDAO.IniniarSecion(user, Clave)){
            System.out.println("Se ha iniciado secion");
        } else {
            System.out.println("No se ha iniciado secion");
        }
        cliente = usuarioDAO.BuscarCliente(user);
        System.out.println(cliente.toString());
    }

}
