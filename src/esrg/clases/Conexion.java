package clases;

/**
 *
 * @author ESRG
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
       
    /**
     * Retorna la conexión a una base de datos.
     * La dirección url, el usuario y la contraseña pueden ser cambiados desde su respectiva variable.
     * @return La conexión a la base de datos.
     */
    public static Connection conexion(){
        
        String url = "jdbc:mysql://localhost/bd_ds";
        String user = "root";
        String pass = "";
        
        try {
            Connection conexion = DriverManager.getConnection(url, user, pass);
            return conexion;
        } catch (SQLException e) {
            System.err.println("Error " + e);
            JOptionPane.showMessageDialog(null, "Error de conexión.");
        }
        return null;
    }
            
}
