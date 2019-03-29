package m03.uf5.p01.grup03.gestiohospital.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorConexion {
    private final String bd = "gestiohospital";
    private final String user = "root"; //se deberá cambiar
    private final String password = "123456";
    private final String url = "jdbc:mysql://localhost:3307/" + bd;
    private Connection con = null;
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } catch(SQLException e){
            System.err.println(e);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(GestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     return con;   
    }
}
    
