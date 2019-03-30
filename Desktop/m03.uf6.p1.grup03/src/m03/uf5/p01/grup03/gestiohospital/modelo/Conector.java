/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup03.gestiohospital.modelo;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import m03.uf5.p01.grup03.gestiohospital.controlador.GestorConexion;

/**
 *
 * @author Phosky
 */
public class Conector {
    
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private GestorConexion conn = new GestorConexion();
    private static Conector conector = null;
    
    public static void main(String[] args) {
        Conector conector = Conector.getConector();
        conector.getPacientes();
        
    }
    
    public static Conector getConector(){
        if(conector == null){
            conector = new Conector();
        }
        return conector;
    }
    
    private Conector(){
        conectaDB();
    }
    
    public static boolean conectaDB(){

        try {
            GestorConexion conn = new GestorConexion();
            Connection con = conn.getConexion();
            return con.isValid(0);
            
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Object[] getPacientes(){
        Object[] filas = null;            
        try {

            Connection con = conn.getConexion();
            String sql = "SELECT nom, cognom1, cognom2, nif, numSS, codiPostal FROM pacientHistorial";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            while(rs.next()){
                filas = new Object[cantidadColumnas];
                
                for(int i = 0; i<cantidadColumnas; i++){
                    filas[i] = rs.getObject(i +1);
                }
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filas;
    } 
}
