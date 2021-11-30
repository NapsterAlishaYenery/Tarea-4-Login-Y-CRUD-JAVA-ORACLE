/*
 * Esta clase contiene la conexion a Oracle SQL
 * con esta clase podre instanciarla desde cualquier
 * paquete para establecer la conexion
 */
package ConexioOracle;

//Importamos la libreria JDBC necesarias 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Napster Guerlmy Alexander Nuñez Matricula 2021-0466
 */
public class Conexion {
    
    //Declarando Parametros estaticos que contendran la URL en partes
    private static Connection conn = null;
    private static String login = "system";
    private static String clave = "system";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    
    //Metodo publico que conecta a java con Oracle
    public static Connection getConnection() {

        //Es bueno manejar las excepciones en un Try/Catch
        try {
            //Al parametro conn le pasamos la url en el siguiente orden
            conn = DriverManager.getConnection(url, login, clave);
            
            //Esto para poder elegir cuando hacer commit y cuando no
            conn.setAutoCommit(false);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Conexion Erronea" + e.getMessage());
        }
        //Si todo va bien se retorna el paramtro conn
        return conn;
    }
    
    // Metodo para desconexion dentro de un Try/Catch
    public void Desconectar() {
        try {
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al desconectar" + e.getMessage());
        }
    }

}
