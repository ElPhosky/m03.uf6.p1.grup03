package m03.uf5.p01.grup03.gestiohospital.vista;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import m03.uf5.p01.grup03.gestiohospital.controlador.Controlador;

public class RadioRegistrarVisitaMedico extends JFrame { //VISTA QUE SIRVE PARA DOS CONTROLADORES
    
    private Controlador controlador;

    JLabel lblOpcion = new JLabel("¿Cómo quieres identificar al médico?");
    public JRadioButton radioNif=new JRadioButton("NIF",true);
    public JRadioButton radioNumss=new JRadioButton("Num. SS",false);
    public JRadioButton radioHistorial=new JRadioButton("Código de historial",false);
    ButtonGroup gRadio = new ButtonGroup();
    public JTextField fieldIdentificacion = new JTextField();
    public JButton btnAcceptar = new JButton("Aceptar");
    public JButton btnCancelar = new JButton("Cancelar");
    public JLabel lblComprobar = new JLabel("");
    
    public RadioRegistrarVisitaMedico(Controlador c) {
        super("Registrar Visita Médico");
        controlador = c;
        inicializa();
    }
    
    public void inicializa() {
        btnAcceptar.addActionListener(controlador);
        btnCancelar.addActionListener(controlador);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 900);
        setResizable(false);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(lblOpcion);
        gRadio.add(radioNif);
        gRadio.add(radioNumss);
        gRadio.add(radioHistorial);
        panel.add(radioNif);
        panel.add(radioNumss);
        panel.add(radioHistorial);
        panel.add(fieldIdentificacion);
        panel.add(btnAcceptar);
        panel.add(btnCancelar);
        panel.add(lblComprobar);
        
        add(panel);
    }

}
