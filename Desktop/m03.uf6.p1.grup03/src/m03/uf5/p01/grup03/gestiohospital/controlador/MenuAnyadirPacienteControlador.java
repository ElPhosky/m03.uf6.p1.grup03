package m03.uf5.p01.grup03.gestiohospital.controlador;

import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import static m03.uf5.p01.grup03.gestiohospital.controlador.MenuControlador.control;
import m03.uf5.p01.grup03.gestiohospital.modelo.Adreca;
import m03.uf5.p01.grup03.gestiohospital.modelo.Creacion;
import m03.uf5.p01.grup03.gestiohospital.modelo.Pacient;
import m03.uf5.p01.grup03.gestiohospital.vista.*;

public class MenuAnyadirPacienteControlador extends Controlador {

    private MenuAnyadirPaciente mAP;

    public MenuAnyadirPacienteControlador() {
        inicializa();
    }

    private void inicializa() {
        mAP = new MenuAnyadirPaciente(this);
        mAP.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == mAP.btnAcceptar) { //BOTON ACEPTAR
            String nombre = mAP.tfNom.getText();
            String apellido1 = mAP.tfCognom1.getText();
            String apellido2 = mAP.tfCognom2.getText();
            String NSS = mAP.tfNSS.getText();
            String DNI = mAP.tfDNI.getText();
            String Telefon = mAP.tfTelefon.getText();
            String ciutat = mAP.tfCiudad.getText();
            String cp = mAP.tfCodiPostal.getText();
            String carrer = mAP.tfCarrer.getText();
            String numero = mAP.tfNumero.getText();
            String planta = mAP.tfPlanta.getText();
            String porta = mAP.tfPorta.getText();
            String salida = "";
            boolean temp = true;
            Pattern pat = Pattern.compile("^[a-zA-ZáéíóúàèìòùÀÈÌÒÙÁÉÍÓÚñÑçÇäÄëËïÏöÖüÜ\\s]*$");
            Matcher mat = pat.matcher(nombre);
            if (!mat.find()) { //COMPRUEBA NOMBRE
                salida = (salida+"Revisa Nombre ");
                temp = false;
            }
            mat = pat.matcher(apellido1);
            if (!mat.find()) { //COMPRUEBA APELLIDO1

                salida = (salida+"Revisa Primer Apellido");
                temp = false;
            }
            mat = pat.matcher(apellido2); //COMPRUEBA APELLIDO 2
            if (!mat.find()) {
                salida = (salida+"Revisa Segundo Apellido");
                temp = false;
            }
            pat = Pattern.compile("\\d{8}[A-HJ-NP-TV-Z]");
            mat = pat.matcher(DNI);
            if (!mat.find()) { //COMPRUEBA DNI
                salida = (salida+"Revisa DNI");
                temp = false;
            }
            pat = Pattern.compile("(66|53|50|[0-4][0-9])-?\\d{8}-?\\d{2}");
            mat = pat.matcher(NSS);
            if (!mat.find()) { //COMPRUEBA NSS
                salida = (salida+"Revisa NSS");
                temp = false;
            }
            pat = Pattern.compile("^(?:(?:\\+|00)?34)?[6789]\\d{8}$");
            mat = pat.matcher(Telefon);
            if (!mat.find()) { //COMPRUEBA TELEFON
                salida = (salida+"Revisa Telefon");
                temp = false;
            }
            try {
                Integer.parseInt(numero);
            } catch (NumberFormatException e) {
                salida = (salida+"Revisa el numero");
                temp = false;
            }
            try {
                Integer.parseInt(porta);
            } catch (NumberFormatException e) {
                salida = (salida+"Revisa la puerta.");
                temp = false;
            }

            if (temp) {
                Adreca adreca = new Adreca(ciutat, cp, carrer, Integer.parseInt(numero), planta, Integer.parseInt(porta));
                Pacient pacient = new Pacient(nombre, apellido1, apellido2, DNI, NSS, Telefon, adreca);
//                control.hospitalPrueba.afegirPacient(pacient);
                Creacion.escriuPacient(pacient);
                mAP.dispose();

            }else{
                mAP.lblConfirmar.setText(salida);
            }
        }
            //BOTÓN CANCELAR
            if (ae.getSource() == mAP.btnCancelar) {
                mAP.dispose();
            }
        }

    }

