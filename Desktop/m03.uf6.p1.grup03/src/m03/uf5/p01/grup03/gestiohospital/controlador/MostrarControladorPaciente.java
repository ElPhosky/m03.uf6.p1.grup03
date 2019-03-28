package m03.uf5.p01.grup03.gestiohospital.controlador;

import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static m03.uf5.p01.grup03.gestiohospital.controlador.MenuControlador.control;
import m03.uf5.p01.grup03.gestiohospital.modelo.Historial;
import m03.uf5.p01.grup03.gestiohospital.modelo.Pacient;
import m03.uf5.p01.grup03.gestiohospital.vista.RadioRegistrarVisitaMedico;
import m03.uf5.p01.grup03.gestiohospital.vista.RadioRegistrarVisitaPaciente;


public class MostrarControladorPaciente extends Controlador{ //CONTROLADOR QUE SIRVE PARA DOS VISTAS
    
    private RadioRegistrarVisitaPaciente radioPaciente;
    
    public MostrarControladorPaciente() {
        inicializa();
    }
    
    private void inicializa() {
        radioPaciente = new RadioRegistrarVisitaPaciente(this);
        radioPaciente.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //BOTÓN ACEPTAR
        if(e.getSource() == radioPaciente.btnAcceptar){
            String texto = radioPaciente.fieldIdentificacion.getText();
            
            //COMPRUEBA DNI
            if(radioPaciente.radioNif.isSelected() == true){
                Pattern pat = Pattern.compile("\\d{8}[A-HJ-NP-TV-Z]");
                Matcher mat = pat.matcher(texto);
            if (mat.find()) {
                Pacient pacient = control.hospitalPrueba.buscarPacientNif(texto);
                radioPaciente.lblComprobar.setText(pacient.toString());
               
                
            } else {
                radioPaciente.lblComprobar.setText("No identificado");
            }
            }
            
            //COMPRUEBA NUM SS
            if(radioPaciente.radioNumss.isSelected() == true){
            Pattern pat = Pattern.compile("(66|53|50|[0-4][0-9])-?\\d{8}-?\\d{2}");
            Matcher mat = pat.matcher(texto);
            if (mat.find()) {
                Pacient pacient = control.hospitalPrueba.buscarPacientNumSeg(texto);
                radioPaciente.lblComprobar.setText(pacient.toString());
                
                
            } else {
                radioPaciente.lblComprobar.setText("No identificado");
            }
            }
            
            if(radioPaciente.radioHistorial.isSelected()==true){
                try{
                    Historial historial = control.hospitalPrueba.findHistorial(Integer.parseInt(texto));
                    if(historial!=null){
                        radioPaciente.lblComprobar.setText(historial.getPacient().toString());
                    }else{
                        radioPaciente.lblComprobar.setText("No identificado");
                    }
                }catch(NumberFormatException ea){
                    radioPaciente.lblComprobar.setText("Error");
                }
                
            }
            
        }
        
        //BOTÓN CANCELAR
        if(e.getSource() == radioPaciente.btnCancelar){
            radioPaciente.dispose();
        }

        
    }
}