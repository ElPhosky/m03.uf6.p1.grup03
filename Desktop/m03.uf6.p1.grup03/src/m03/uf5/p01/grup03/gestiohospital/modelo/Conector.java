/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup03.gestiohospital.modelo;

import com.sun.media.sound.ModelOscillator;
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

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static GestorConexion conn = new GestorConexion();
    private static Conector conector = null;

    public static void main(String[] args) {
        Conector conector = Conector.getConector();
//        conector.getPacientes();
//        conector.getMetges();
//        conector.getVisitas();
//       conector.getMalalties();
//        conector.FindPacientDNI("45986926J");
//        conector.FindPacientnSS("281234567840");
//        conector.FindPacientnumHistorial("2");
//        conector.FindMetgeDNI("47740739Y");
//        conector.FindMetgenSS("11134567890");
//        conector.FindMetgenumHistorial("1");
        conector.MostraHistorial();

    }

    public static Conector getConector() {
        if (conector == null) {
            conector = new Conector();
        }
        return conector;
    }

    private Conector() {
        conectaDB();
    }

    public static boolean conectaDB() {

        try {
            GestorConexion conn = new GestorConexion();
            Connection con = conn.getConexion();
            return con.isValid(0);

        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Object[] getResult(String consulta) {
        Object[] filas = null;
        try {

            Connection con = conn.getConexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            while (rs.next()) {
                filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filas;
    }

    public void getPacientes() {
        Object[] filas = null;
        try {

            Connection con = conn.getConexion();
            String sql = "SELECT nom, cognom1, cognom2, nif, numSS, codiPostal,codiHistorial FROM pacientHistorial";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            while (rs.next()) {
                filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.println(filas[i]);
                }
                m03.uf5.p01.grup03.gestiohospital.vista.Pacient.addRow(filas);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addPaciente(String sql) {
        PreparedStatement ps = null;
        GestorConexion objCon = new GestorConexion();
        Connection conn = objCon.getConexion();
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getMetges() {
        Object[] filas = null;
        try {

            Connection con = conn.getConexion();
            String sql = "SELECT nif,telefon,nom, cognom1, cognom2, numSS,"
                    + "numEmpleado,salariMensual FROM metge";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            while (rs.next()) {
                filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);

                    System.out.println(filas[i]);
                }
                m03.uf5.p01.grup03.gestiohospital.vista.Metge.addRow(filas);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addMetge(String sql){
            PreparedStatement ps = null;
        GestorConexion objCon = new GestorConexion();
        Connection conn = objCon.getConexion();
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static Object[] getVisitas() {
        Object[] filas = null;
        try {

            Connection con = conn.getConexion();
            String sql = "SELECT idVisita,fecha,codiMalaltia,nifPacient,nifMetge FROM visita";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            while (rs.next()) {
                filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.println(filas[i]);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filas;
    }

    public static Object[] getMalalties() {
        Object[] filas = null;
        try {

            Connection con = conn.getConexion();
            String sql = "SELECT codiMalaltia,nomMalaltia,causaBaixa,tractament,duradaTractament FROM malaltia";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            while (rs.next()) {
                filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.println(filas[i]);
                }
                m03.uf5.p01.grup03.gestiohospital.vista.Enfermedad.addRow(filas);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filas;
    }

    public static  Object[] FindPacientDNI(String dni) {
        Object[] filas = null;
        try {

            Connection con = conn.getConexion();
            String sql = "SELECT nif FROM pacientHistorial WHERE nif = '" + dni + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            while (rs.next()) {
                filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.println(filas[i]);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filas;
    }

    public static Object[] FindMetgeDNI(String dni) {
        Object[] filas = null;
        try {

            Connection con = conn.getConexion();
            String sql = "SELECT nif FROM metge WHERE nif = '" + dni + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            while (rs.next()) {
                filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.println(filas[i]);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filas;
    }

    public static Object[] FindPacientnSS(String nSS) {
        Object[] filas = null;
        try {

            Connection con = conn.getConexion();
            String sql = "SELECT nif FROM pacientHistorial WHERE numSS = '" + nSS + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            while (rs.next()) {
                filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.println(filas[i]);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filas;
    }

    public static Object[] FindMetgenSS(String nSS) {
        Object[] filas = null;
        try {

            Connection con = conn.getConexion();
            String sql = "SELECT nif FROM metge WHERE numSS = '" + nSS + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            while (rs.next()) {
                filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.println(filas[i]);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filas;
    }

    public static Object[] FindPacientnumHistorial(String historial) {
        Object[] filas = null;
        try {

            Connection con = conn.getConexion();
            String sql = "SELECT nif FROM pacientHistorial WHERE codiHistorial = '" + historial + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            while (rs.next()) {
                filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.println(filas[i]);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filas;
    }

    public static Object[] FindMetgenumHistorial(String numEmpleado) {
        Object[] filas = null;
        try {

            Connection con = conn.getConexion();
            String sql = "SELECT nif FROM metge WHERE numEmpleado = '" + numEmpleado + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            while (rs.next()) {
                filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.println(filas[i]);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filas;
    }

    public static Object[] MostraHistorial() {
        Object[] filas = null;
        try {

            Connection con = conn.getConexion();
            String sql = "SELECT metge.nif, malaltia.nomMalaltia, visita.fecha,pacientHistorial.nif FROM visita "
                    + "INNER JOIN pacientHistorial on visita.codiHistorial = pacientHistorial.codiHistorial "
                    + "INNER JOIN malaltia on visita.codiMalaltia = malaltia.codiMalaltia "
                    + "INNER JOIN metge on visita.numEmpleado = metge.numEmpleado";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            while (rs.next()) {
                filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.println(filas[i]);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filas;
    }
}
