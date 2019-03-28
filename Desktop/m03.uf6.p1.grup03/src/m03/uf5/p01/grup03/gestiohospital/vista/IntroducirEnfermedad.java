package m03.uf5.p01.grup03.gestiohospital.vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import m03.uf5.p01.grup03.gestiohospital.controlador.RadioRegistrarVisitaControlador;

public class IntroducirEnfermedad extends JFrame{
    private RadioRegistrarVisitaControlador controlador;
    
    JLabel lblID = new JLabel("Introduce el ID de la enfermedad: ");
    public JTextField tfID = new JTextField();
    public JButton btnAcceptar = new JButton("Acceptar");
    public JButton btnCancelar = new JButton("Cancelar");
    public JLabel lblComprobar = new JLabel("Comprueba");
    GridLayout iELayout = new GridLayout(0, 2);
    
    public IntroducirEnfermedad(RadioRegistrarVisitaControlador c) {
        super("Añadir enfermedad");
        controlador = c;
        
        this.setLayout(iELayout);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(400, 300);
        btnAcceptar.addActionListener(controlador);
        btnCancelar.addActionListener(controlador);
        add(lblID);
        add(tfID);
        add(btnAcceptar);
        add(btnCancelar);
        add(lblComprobar);
        
}   
}
