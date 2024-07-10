package Banco.Conexion;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ConexionDB {
    private Connection con;
    private String Url = "jdbc:mysql://localhost:3306/Parcial_Final" ;
    private String User = "root";
    private String Password = "Contrasena05";

    public Connection conectarDB() {
        try{
            con = DriverManager.getConnection(Url, User, Password);
        } catch (SQLException e) {
            System.out.println("Err conexion: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return this.con;
    }

}
