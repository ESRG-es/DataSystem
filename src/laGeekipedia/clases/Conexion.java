package clases;

import java.sql.*;

public class Conexion {
    //Conexión Local

    public static Connection conectar() {
        try {

            String url = "jdbc:mysql://www.ejemplo.com:3306/mobilia_bd_ds";
            String user = "usurio";
            String pass = "admin_ernesto";

            Connection cn = DriverManager.getConnection(url, user, pass);
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en conexión local " + e);
        }
        return (null);
    }
}
