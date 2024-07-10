package Banco.Datos;

import Banco.Conexion.ConexionDB;
import Banco.Entidad.Cliente.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class    ClienteDAO implements IClienteDAO {
    private Connection con;
    private ConexionDB instanciaConexion = new ConexionDB();

    public ClienteDAO() {}

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        con = instanciaConexion.conectarDB();
        String sql = "SELECT * FROM clientes";
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("Id_Cliente"));
                cliente.setNombre(rs.getString("Nombre_Completo"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                this.con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return listaClientes;
    }

    @Override
    public Cliente buscarClientePorID(int id) {
        Cliente cliente = null;
        con = instanciaConexion.conectarDB();
        String sql = "SELECT * FROM clientes WHERE id_Cliente = ?";
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setId(rs.getInt("Id_Cliente"));
                cliente.setNombre(rs.getString("Nombre_Completo"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                this.con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return cliente;
    }

    @Override
    public void insertarDatosCliente(Cliente cliente) {
        con = instanciaConexion.conectarDB();
        String sql = "Insert into clientes(Nombre_Completo, direccion, telefono) values(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getTelefono());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                this.con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void actualizarDatosCliente(Cliente cliente) {
        con = instanciaConexion.conectarDB();
        String sql = "UPDATE clientes SET Nombre_Completo=?, direccion=?, telefono=? WHERE id_Cliente = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getTelefono());
            ps.setInt(4, cliente.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                this.con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public int conseguirIdCliente(Cliente cliente) {
        con = instanciaConexion.conectarDB();
        String sql = "SELECT * FROM clientes WHERE telefono = ? and Nombre_Completo = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getTelefono());
            ps.setString(2, cliente.getNombre());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setId(rs.getInt("Id_Cliente"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente.getId();
    }
}
