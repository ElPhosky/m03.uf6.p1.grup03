/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup03.gestiohospital.controlador;

import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import static m03.uf5.p01.grup03.gestiohospital.controlador.MenuControlador.control;
import m03.uf5.p01.grup03.gestiohospital.modelo.Historial;
import m03.uf5.p01.grup03.gestiohospital.modelo.Metge;
import m03.uf5.p01.grup03.gestiohospital.vista.RadioRegistrarVisitaMedico;

public class MostrarControladorMedico extends Controlador{

    private RadioRegistrarVisitaMedico radioMedico;
    
    public MostrarControladorMedico() {
        inicializa();
    }
    
        private void inicializa() {
        radioMedico = new RadioRegistrarVisitaMedico(this);
        radioMedico.setVisible(true);
    }
    
        public void actionPerformed(ActionEvent e) {

        //BOTÓN ACEPTAR
        if(e.getSource() == radioMedico.btnAcceptar){
            String texto = radioMedico.fieldIdentificacion.getText();
            
            //COMPRUEBA DNI
            if(radioMedico.radioNif.isSelected() == true){
                Pattern pat = Pattern.compile("\\d{8}[A-HJ-NP-TV-Z]");
                Matcher mat = pat.matcher(texto);
            if (mat.find()) {
//             Metge metge = control.hospitalPrueba.buscarMetgeNif(texto);
                
//                radioMedico.lblComprobar.setText(metge.toString());
            } else {
                radioMedico.lblComprobar.setText("No identificado");
            } 
            }
            
            //COMPRUEBA NUM SS
            if(radioMedico.radioNumss.isSelected() == true){
            Pattern pat = Pattern.compile("(66|53|50|[0-4][0-9])-?\\d{8}-?\\d{2}");
            Matcher mat = pat.matcher(texto);
            
            if (mat.find()) {
//                Metge metge =control.hospitalPrueba.buscarMetgeNumSeg(texto);
                
//                radioMedico.lblComprobar.setText(metge.toString());
                
                
            } else {
                radioMedico.lblComprobar.setText("No identificado");
            }
            }
            
            if(radioMedico.radioHistorial.isSelected()==true){
                try{
/*                Historial cont = control.hospitalPrueba.findHistorial(Integer.parseInt(texto));
                if(cont!=null){
                    radioMedico.lblComprobar.setText(cont.toString());
                }else{
                    radioMedico.lblComprobar.setText("No identificado");
                } */
            }catch (NumberFormatException ea){
                radioMedico.lblComprobar.setText("Error");
                
            }}
            //FALTA CODIGO HISTORIAL
            
        }
        
        //BOTÓN CANCELAR
        if(e.getSource() == radioMedico.btnCancelar){
            radioMedico.dispose();
        }
        }
}
