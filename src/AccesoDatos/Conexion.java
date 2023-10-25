package AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost:3306/hotel";
    private static final String USUARIO  = "root";
    private static final String PASSWORD = "";
    private static  Connection con;

    public Conexion() {
    }
    
    public static  Connection getConexion(){
        if(con == null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "error al cargar los drivers" );
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error al conectarse a la base de datos" );
            }
        }
        return con;
    }
    
}
