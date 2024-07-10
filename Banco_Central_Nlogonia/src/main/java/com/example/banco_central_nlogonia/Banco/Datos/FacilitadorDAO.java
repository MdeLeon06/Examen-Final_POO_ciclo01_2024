package com.example.banco_central_nlogonia.Banco.Datos;

import com.example.banco_central_nlogonia.Banco.Conexion.ConexionDB;
import java.sql.*;

public class FacilitadorDAO implements IFacilitadorDAO {
    Connection con; // 00012523 Creacion de la variable para las conexiones de las funciones
    ConexionDB InstanciaConexion = new ConexionDB(); // 00012523 Creacion de la variable de a clase ConexionDB

    public FacilitadorDAO() {} //00012523 Constructor vacio para la inicializacion de las variables de la clase

    @Override
    public int BuscarFacilitador(String nombre) { //00012523 Funcion para buscar el facilitador de la tarjeta
        this.con = InstanciaConexion.conectarDB(); //00012523 Inicio de la conexion con la base de datos
        int resultado = 0; // 00012523 Variable para guardar los datos del id obtenidos
        String sql = "SELECT Id_Facilitador FROM facilitador WHERE Facilitador = ?"; // 00012523 Codigo para consultar a la base de datos
        try{ // 00012523 Intento de consultar a la base de datos
            PreparedStatement ps = con.prepareStatement(sql); //00012523 Preparado de la consulta con la base de datos
            ps.setString(1, nombre); // 00012523 Insertando datos al parametro 1 de la consulta
            ResultSet rs = ps.executeQuery(); // 00012523 Ejecucion y obtencion de datos de la base de datos
            while (rs.next()) { // 00012523 Guardadoo de datos por fila mediante un while
                resultado = rs.getInt("Id_Facilitador"); //00012523 Guardado de datos del id del facilitador
            }
        } catch (SQLException e) { //00012523 Clausula en el cso que no funcione la consulta
            throw new RuntimeException(e); //00012523 Mensaje de error
        }finally { // 00012523 Finalizacion de la consulta
            try { // 00012523 Intento de cierre de la conexion
                con.close(); // 00012523 Cierre de la conexion
            } catch (SQLException e) { // 00012523 Clausula de error si el cierre no se genera
                throw new RuntimeException(e); // 00012523 mensaje de error
            }
        }
        return resultado; // 00012523 Retorno del valor obtenido
    }
}
