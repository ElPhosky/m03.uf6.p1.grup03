package m03.uf5.p01.grup03.gestiohospital.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorConexion {
    private final String bd = "gestiohospital";
    private final String user = "admin_hospital_grup3"; //se deberá cambiar
    private final String password = "admin";
    private final String url = "jdbc:mysql://localhost:3306/"+bd+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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
    
