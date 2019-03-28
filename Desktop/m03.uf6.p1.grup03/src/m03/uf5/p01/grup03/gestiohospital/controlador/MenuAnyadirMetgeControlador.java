package m03.uf5.p01.grup03.gestiohospital.controlador;

import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static m03.uf5.p01.grup03.gestiohospital.controlador.MenuControlador.control;

import m03.uf5.p01.grup03.gestiohospital.modelo.*;
import m03.uf5.p01.grup03.gestiohospital.vista.*;

public class MenuAnyadirMetgeControlador extends Controlador {

    private MenuAnyadirMetge mAM;

    public MenuAnyadirMetgeControlador() {
        inicializa();
    }

    private void inicializa() {
        mAM = new MenuAnyadirMetge(this);
        mAM.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == mAM.btnAcceptar) { //BOTON ACEPTAR
            String nombre = mAM.tfNom.getText();
            String apellido1 = mAM.tfCognom1.getText();
            String apellido2 = mAM.tfCognom2.getText();
            String NSS = mAM.tfNSS.getText();
            String DNI = mAM.tfDNI.getText();
            String Telefon = mAM.tfTelefon.getText();
            String numEmpleat = mAM.tfNumEmpleat.getText();
            String salariMensual = mAM.tfSalariMensual.getText();
            String codiCompteCorrent = mAM.tfCompteCorrent.getText();
            String ciutat = mAM.tfCiudad.getText();
            String cp = mAM.tfCodiPostal.getText();
            String carrer = mAM.tfCarrer.getText();
            String numero = mAM.tfNumero.getText();
            String planta = mAM.tfPlanta.getText();
            String porta = mAM.tfPorta.getText();
            String salida = "";
            boolean temp = true;
            Pattern pat = Pattern.compile("^[a-zA-ZáéíóúàèìòùÀÈÌÒÙÁÉÍÓÚñÑçÇäÄëËïÏöÖüÜ\\s]*$");
            Matcher mat = pat.matcher(nombre);
            if (!mat.find()) { //COMPRUEBA NOMBRE
                salida = (salida+"Revisa Nombre");
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
                Metge metge = new Metge(nombre, apellido1, apellido2, NSS, DNI, Integer.parseInt(numEmpleat), Integer.parseInt(salariMensual), codiCompteCorrent, Telefon, adreca);
                control.hospitalPrueba.afegirMetge(metge);
                Creacion.escriuMetge(metge);
                mAM.dispose();
            }else{
                mAM.lblConfirmar.setText(salida);
            }
        }
            //BOTÓN CANCELAR
            if (ae.getSource() == mAM.btnCancelar) {
                mAM.dispose();
            }
        }

    }

