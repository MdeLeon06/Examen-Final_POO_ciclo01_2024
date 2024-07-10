package com.example.banco_central_nlogonia.Banco.Datos;

import com.example.banco_central_nlogonia.Banco.Conexion.ConexionDB;
import com.example.banco_central_nlogonia.Banco.Entidad.Cliente.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {
    private Connection con; // 00012523 Creando variable privada para conectar en cada funcion
    private ConexionDB instanciaConexion = new ConexionDB(); // 00012523 Variable de la clase ConexionDB

    public ClienteDAO() {} // 00012523 contructos vacio de la clase ClienteDAO

    @Override
    public List<Cliente> listarClientes() { //00012523 Funcion para enlistar clientes
        List<Cliente> listaClientes = new ArrayList<Cliente>(); // 00012523 variable para guardar los datos de los clientes
        con = instanciaConexion.conectarDB();  //00012523 iniciando la conexion con la base de datos
        String sql = "SELECT * FROM clientes"; // 00012523 creando el codigo de colsulta de la base de datos
        try{  //00012523 Intentando generar la consulta a la base de datos
            PreparedStatement ps = this.con.prepareStatement(sql); //00012523 Preparando la consulta a la pase de datos
            ResultSet rs = ps.executeQuery(); // 00012523 Realizandoo la consulta y obreniendo los resultados
            while (rs.next()) { //00012523 Obteniendo datos linea por linea
                Cliente cliente = new Cliente(); // 0001252 Creando variable cliente para guardar los datos obtenidos
                cliente.setId(rs.getInt("Id_Cliente")); //00012523 Guardando el dato del id del cliente
                cliente.setNombre(rs.getString("Nombre_Completo")); //00012523 Guardando el dato del nombre del cliente
                cliente.setDireccion(rs.getString("direccion")); // 00012523 Guardando el dato de la direccion del cliente
                cliente.setTelefono(rs.getString("telefono")); //00012523 Guardando el dato del telefono del cliente
                listaClientes.add(cliente); // 00012523 Guardando los datos obtenidos de la fila en una lista
            }
        } catch (SQLException e) { // 00012523 Clausula en el caso que no se genere la consulta
            throw new RuntimeException(e); // 00012523 Mostrando excepcion en el caso que no se genere la consulta
        } finally { //00012523 Al finalizar la consulta  la vase de datos
            try{ // 00012523 Intentando cerrar la conexion
                this.con.close(); //00012523 Cerrar la conexion de la base de datos para la fincion
            } catch (SQLException e) { // 00012523 Excepcion por si el cierre de conexion no funciona
                throw new RuntimeException(e); // 00012523 Lanzando mensaje de la excepcion
            }
        }
        return listaClientes; //00012523 Rertonando la lista de la funcion
    }

    @Override
    public Cliente buscarClientePorID(int id) { // 00012523 Funcion cliente para buscar por id
        Cliente cliente = null; // 00012523 variable tipo cliente para guagar los datos obrenidos
        con = instanciaConexion.conectarDB(); //00012523 Iniciando la conexion con la base de datos
        String sql = "SELECT * FROM clientes WHERE id_Cliente = ?"; //00012523 Preparando variable con la consulta de la base de datos
        try{ //00012523 Intentando generar la consulta
            PreparedStatement ps = this.con.prepareStatement(sql); //00012523 preparando la consulta para la base de datos
            ps.setInt(1, id); // 00012523 Ingresando el numeto de id que se desea buscar
            ResultSet rs = ps.executeQuery(); //00012523 Ejecutando y obteniendo datos de la consulta
            while (rs.next()) { //00012523 guadando datos obtenidos por al consulta
                cliente.setId(rs.getInt("Id_Cliente")); // 00012523 Guardando el id del cliente
                cliente.setNombre(rs.getString("Nombre_Completo")); // 00012523 Guardando el nombre del cliente
                cliente.setDireccion(rs.getString("direccion")); // 00012523 Guardando la direccion del cliente
                cliente.setTelefono(rs.getString("telefono")); // 00012523 Guardando el numero de telefono del cliente
            }
        } catch (SQLException e) { // 00012523 Clausula si la consulta no funciona
            throw new RuntimeException(e); // 00012523 Mensaje de la excepcion
        } finally { // 00012523 Al finalizar la consulta  la vase de datos
            try{ // 00012523 Intentar cerrar la conexion
                this.con.close(); //00012523 Cerrando la conexion
            } catch (SQLException e) { // 00012523 Clausula si en dado caso la consulta no se genera
                throw new RuntimeException(e); // 00012523 Mensaje de la excepcion
            }
        }
        return cliente; //00012523 Retorna la variable cliente
    }

    @Override
    public void insertarDatosCliente(Cliente cliente) { //00012523 Funcion para insertar clientes
        con = instanciaConexion.conectarDB(); // 00012523 Iniciando la conexion con la base de datos
        String sql = "Insert into clientes(Nombre_Completo, direccion, telefono) values(?,?,?)"; // 00012523 Preparando para insertar datos
        try { // 00012523 Preparando el envio de datos a la base de datos
            PreparedStatement ps = con.prepareStatement(sql); // 00012523 Preparando la insercion de datos a la base de datos
            ps.setString(1, cliente.getNombre()); // 00012523 Ingresando el nombre al primer parametro
            ps.setString(2, cliente.getDireccion()); //00012523 Ingresando datos al segundo parametro
            ps.setString(3, cliente.getTelefono()); //0012523 Ingresando datos al tercer parametro
            ps.executeUpdate(); // 00012523 Ejecutando el insert a la base de datos
        } catch (SQLException e) { //00012523 Clausula de exepcion por si la insercion no funciona
            throw new RuntimeException(e); //0012523 Lanza el mensaje de la exepcion
        } finally { // 00012523 Finalizar la conexion con la base de datos
            try{ // 00012523 Intentar cerrar la conexion
                this.con.close(); // 00012523 Cerrando la conexion con la base de datos
            } catch (SQLException e) { // 00012523 Clausula de excepcion por si el cierre de la conexion no funciona
                throw new RuntimeException(e); //00012523 Mensaje del Error que se halla generado
            }
        }
    }

    @Override
    public void actualizarDatosCliente(Cliente cliente) {  // 00012523 Funcion para actualizar datos del cliente
        con = instanciaConexion.conectarDB(); // 00012523 Iniciar la conexion con la base de datos
        String sql = "UPDATE clientes SET Nombre_Completo=?, direccion=?, telefono=? WHERE id_Cliente = ?"; // 00012523 Codigo que se ejecutara para realizar la consulta a la base de datos
        try { // 00012523 Intentar generar la actualizacion de datos a la base de datos
            PreparedStatement ps = con.prepareStatement(sql); // 00012523 Preparando la consulta
            ps.setString(1, cliente.getNombre()); // 00012523 Ingresando datos al parametro 1 de la consulta
            ps.setString(2, cliente.getDireccion()); // 00012523 Ingresando datos al parametro 2 de la consulta
            ps.setString(3, cliente.getTelefono()); // 00012523 Ingresando datos al parametro 3 de la consulta
            ps.setInt(4, cliente.getId()); // 00012523 Ingresando datos al parametro 4 de la consulta
            ps.executeUpdate(); // 00012523 Ejecutando la actualizacion de datos
        } catch (SQLException e) { //00012523 Clausula de exepcion por si la actualizacion de datos no funciona
            throw new RuntimeException(e); // 00012523 Mensaje del error
        } finally { //0001523 Finalicacion de la consulta
            try{ // 00012523 Intentar cerrar la conexion
                this.con.close(); // 00012523 Cerrando la conexion con la base de datos
            } catch (SQLException e) { // 0012523 Clasusula por si la base de datos falla
                throw new RuntimeException(e); //00012523 Mensaje de error
            }
        }
    }

    @Override
    public int conseguirIdCliente(Cliente cliente) { // 00012523 Funcion para conseguir el id del cliente
        con = instanciaConexion.conectarDB(); // 00012523 Inicindo la conexion con la base de datos
        String sql = "SELECT * FROM clientes WHERE telefono = ? and Nombre_Completo = ?"; //00012523 Codigo de sql para pedir el id del cliente
        try{ // 00012523 Intento de realizar la consulta
            PreparedStatement ps = con.prepareStatement(sql); //00012523 Preparando la consulta
            ps.setString(1, cliente.getTelefono()); //00012523 Inserdando datos en el parametro 1 de la consulta
            ps.setString(2, cliente.getNombre()); //00012523 Inserdando datos en el parametro 2 de la consulta
            ResultSet rs = ps.executeQuery(); //00012523 Ejecutando y recibiendo los datos de la consulta
            while (rs.next()) { // 00012523 While para alpacenar datos en la variable cliente
                 cliente.setId(rs.getInt("Id_Cliente")); //00012523 Guardando el dato id en la clase
            }
        } catch (SQLException e) { // 00012523 Clausula de excpcion en el caso que la consulta no se genere
            throw new RuntimeException(e); // 00012523 Mensaje de error
        }
        return cliente.getId(); //00012523 Retorno de la funcion id
    }
}
