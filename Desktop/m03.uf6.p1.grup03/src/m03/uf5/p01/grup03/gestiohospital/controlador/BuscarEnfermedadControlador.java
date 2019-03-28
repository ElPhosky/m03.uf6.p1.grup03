/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup03.gestiohospital.controlador;

import java.awt.event.ActionEvent;
import m03.uf5.p01.grup03.gestiohospital.vista.BuscarEnfermedad;
import m03.uf5.p01.grup03.gestiohospital.vista.RadioRegistrarVisitaMedico;

/**
 *
 * @author gonza
 */
public class BuscarEnfermedadControlador extends Controlador{
     private BuscarEnfermedad buscarEnf;
    
    public BuscarEnfermedadControlador() {
        inicializa();
    }
    
        private void inicializa() {
        buscarEnf = new BuscarEnfermedad(this);
        buscarEnf.setVisible(true);
        buscarEnf.lbl1.setText("");
        buscarEnf.lbl2.setText("");
        buscarEnf.lbl3.setText("");
        buscarEnf.lbl4.setText("");
        buscarEnf.lbl5.setText("");
        buscarEnf.lbl6.setText("");
        buscarEnf.lbl7.setText("");
        buscarEnf.lbl8.setText("");
        buscarEnf.lbl9.setText("");
    }
        
        public void actionPerformed(ActionEvent e) {

        //BOTÓN ACEPTAR
        if(e.getSource() == buscarEnf.btnCancelar){
            buscarEnf.dispose();
}
        }
}
