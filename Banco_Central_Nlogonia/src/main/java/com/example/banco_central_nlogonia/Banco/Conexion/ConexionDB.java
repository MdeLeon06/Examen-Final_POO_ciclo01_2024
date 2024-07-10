package com.example.banco_central_nlogonia.Banco.Conexion;

import java.sql.*;

public class ConexionDB {
    private Connection con; // 00012523 Definiendo variable para la conexion
    private String Url = "jdbc:mysql://localhost:3306/parcial_final" ; //00012523 Definiendo variable para el enlace con la base de datos
    private String User = "root"; //00012523 Definiendo credencial de usuario para la base de datos
    private String Password = "22102003"; // 00012523 Definiendo la clave de acceso para la base de datos

    public Connection conectarDB() { // 0001252 Funcion para realizar la conexion
        try{ // 00012523 Intentar conectar la base de datos con java
            con = DriverManager.getConnection(Url, User, Password); //00012523 Conectando la base de datos con java
        } catch (SQLException e) { // 00012523 Si la conexion no es posible
            System.out.println("Err conexion: " + e.getMessage()); //00012523 Mensaje de Err si la conexion falla
        }
        return this.con; //00012523 Retorna la conexion
    }

}
