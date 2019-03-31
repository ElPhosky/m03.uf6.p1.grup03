package m03.uf5.p01.grup03.gestiohospital.controlador;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m03.uf5.p01.grup03.gestiohospital.modelo.Conector;
//import static m03.uf5.p01.grup03.gestiohospital.controlador.MenuControlador.control;
import m03.uf5.p01.grup03.gestiohospital.modelo.Malaltia;
import m03.uf5.p01.grup03.gestiohospital.modelo.Metge;
import m03.uf5.p01.grup03.gestiohospital.modelo.Pacient;
import m03.uf5.p01.grup03.gestiohospital.modelo.Visita;
import m03.uf5.p01.grup03.gestiohospital.vista.IntroducirEnfermedad;
import m03.uf5.p01.grup03.gestiohospital.vista.RadioRegistrarVisitaMedico;
import m03.uf5.p01.grup03.gestiohospital.vista.RadioRegistrarVisitaPaciente;

public class RadioRegistrarVisitaControlador extends Controlador { //CONTROLADOR QUE SIRVE PARA DOS VISTAS

    private RadioRegistrarVisitaPaciente radioPaciente;
    private RadioRegistrarVisitaMedico radioMedico;
    private IntroducirEnfermedad introducirEnf;

    private Metge metge;
    private int malaltia;
    private Pacient pacient;
    private LocalDateTime fecha;
    private Visita visita;

    public RadioRegistrarVisitaControlador() {
        inicializa();
    }

    private void inicializa() {
        radioPaciente = new RadioRegistrarVisitaPaciente(this);
        radioPaciente.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //PACIENTE

        //BOTÓN ACEPTAR
        if (e.getSource() == radioPaciente.btnAcceptar) {
            String texto = radioPaciente.fieldIdentificacion.getText();

            //COMPRUEBA DNI
            if (radioPaciente.radioNif.isSelected() == true) {
                Pattern pat = Pattern.compile("\\d{8}[A-HJ-NP-TV-Z]");
                Matcher mat = pat.matcher(texto);
                if (mat.find()) {
                    String codiHistorial = Conector.FindPacientDNI(texto).toString();
                    if (codiHistorial == null) {
                        radioPaciente.lblComprobar.setText("No está registrado.");
                    } else {
                        radioMedico = new RadioRegistrarVisitaMedico(this);
                        radioMedico.setVisible(true);
                    }

                } else {
                    radioPaciente.lblComprobar.setText("No identificado");
                }
            }

            //COMPRUEBA NUM SS
            if (radioPaciente.radioNumss.isSelected() == true) {
                Pattern pat = Pattern.compile("(66|53|50|[0-4][0-9])-?\\d{8}-?\\d{2}");
                Matcher mat = pat.matcher(texto);
                if (mat.find()) {
                    String codiHistorial = Conector.FindMetgenSS(texto).toString();
                    if (codiHistorial == null) {
                        radioPaciente.lblComprobar.setText("No está registrado.");
                    } else {
                        radioMedico = new RadioRegistrarVisitaMedico(this);
                        radioMedico.setVisible(true);
                    }
                } else {
                    radioPaciente.lblComprobar.setText("No identificado");
                }
            }

            //HISTORIAL
            if (radioPaciente.radioHistorial.isSelected() == true) {
                radioPaciente.lblComprobar.setText("OKKK");
                try {
                    
                    String codiHistorial = Conector.FindMetgenumHistorial(texto).toString();
                    if (codiHistorial == null) {
                        radioPaciente.lblComprobar.setText("No está registrado.");
                    } else {
                        introducirEnf = new IntroducirEnfermedad(this);
                        introducirEnf.setVisible(true);
                    }
                } catch (NumberFormatException exc) {
                    radioPaciente.lblComprobar.setText("Número introducido incorrectamente");
                }
            }
        }

        //BOTÓN CANCELAR
        if (e.getSource() == radioPaciente.btnCancelar) {
            radioPaciente.dispose();
        }

        //MÉDICO
        if (e.getSource() == radioMedico.btnAcceptar) {
            String texto = radioMedico.fieldIdentificacion.getText();

            //COMPRUEBA DNI
            if (radioMedico.radioNif.isSelected() == true) {
                Pattern pat = Pattern.compile("\\d{8}[A-HJ-NP-TV-Z]");
                Matcher mat = pat.matcher(texto);
                if (mat.find()) {
                    radioMedico.lblComprobar.setText("OKKK");
                    String numEmpleado = Conector.FindPacientDNI(texto).toString();
                    if (numEmpleado == null) {
                        radioMedico.lblComprobar.setText("No está registrado.");
                    } else {
                        introducirEnf = new IntroducirEnfermedad(this);
                        introducirEnf.setVisible(true);
                    }

                } else {
                    radioMedico.lblComprobar.setText("No identificado");
                }
            }

            //COMPRUEBA NUM SS
            if (radioMedico.radioNumss.isSelected() == true) {
                Pattern pat = Pattern.compile("(66|53|50|[0-4][0-9])-?\\d{8}-?\\d{2}");
                Matcher mat = pat.matcher(texto);
                if (mat.find()) {
                    radioMedico.lblComprobar.setText("OKKK");
                    String numEmpleado = Conector.FindPacientnSS(texto).toString();
                    if (numEmpleado == null) {
                        radioMedico.lblComprobar.setText("No está registrado.");
                    } else {
                        introducirEnf = new IntroducirEnfermedad(this);
                        introducirEnf.setVisible(true);
                    }

                } else {
                    radioMedico.lblComprobar.setText("No identificado");
                }
            }

            //HISTORIAL
            if (radioMedico.radioHistorial.isSelected() == true) {
                radioMedico.lblComprobar.setText("OKKK");
                try {
                    String numEmpleado = Conector.FindPacientnumHistorial(texto).toString();
                    if (numEmpleado == null) {
                        radioMedico.lblComprobar.setText("No está registrado.");
                    } else {
                        
                        introducirEnf = new IntroducirEnfermedad(this);
                        introducirEnf.setVisible(true);
                    }
                } catch (NumberFormatException exc) {
                    radioMedico.lblComprobar.setText("Número introducido incorrectamente");
                }
            }
        }

        //BOTÓN CANCELAR
        if (e.getSource() == radioMedico.btnCancelar) {
            radioMedico.dispose();
        }

        //ID MALALTIA
        if (e.getSource() == introducirEnf.btnAcceptar) {
            String texto = introducirEnf.tfID.getText();
            String enfermedad = "";
            try {
                malaltia = Integer.parseInt(texto);
                enfermedad = Conector.FindMalaltia(malaltia).toString();
            } catch (NumberFormatException error) {
                introducirEnf.lblComprobar.setText(texto + " no es un número valido");
            }
            if (enfermedad == null) {
                introducirEnf.lblComprobar.setText("No está registrado.");
            } else {
                fecha = LocalDateTime.now();
                String sql = "INSERT INTO visita("+fecha+","+malaltia+",codiHistorial,numEmpleado) VALUES(\"31/03/2019\",3,1,1);";
                introducirEnf.lblComprobar.setText("Visita añadida correctamente.");
            }
        }
        if (e.getSource() == introducirEnf.btnCancelar) {
            introducirEnf.dispose();
        }
    }
}
