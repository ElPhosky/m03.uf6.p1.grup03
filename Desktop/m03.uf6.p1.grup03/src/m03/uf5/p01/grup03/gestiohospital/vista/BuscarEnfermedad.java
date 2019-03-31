package m03.uf5.p01.grup03.gestiohospital.vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import m03.uf5.p01.grup03.gestiohospital.controlador.BuscarEnfermedadControlador;
import m03.uf5.p01.grup03.gestiohospital.controlador.RadioRegistrarVisitaControlador;

public class BuscarEnfermedad extends JFrame{
    private BuscarEnfermedadControlador controlador;
    public JLabel lbl1 = new JLabel("");
    public JLabel lbl2 = new JLabel("");
    public JLabel lbl3 = new JLabel("");
    public JLabel lbl4 = new JLabel("");
    public JLabel lbl5 = new JLabel("");
    public JLabel lbl6 = new JLabel("");
    public JLabel lbl7 = new JLabel("");
    public JLabel lbl8 = new JLabel("");
    public JLabel lbl9 = new JLabel("");
    
    public JButton btnCancelar = new JButton("Cancelar");
    GridLayout bE = new GridLayout(0, 2);
    
    
     public BuscarEnfermedad(BuscarEnfermedadControlador c) {
        super("Buscar enfermedad");
        controlador = c;
        this.setLayout(bE);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(400, 300);
        btnCancelar.addActionListener(controlador);
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(lbl1);
        add(lbl2);
        add(lbl3);
        add(lbl4);
        add(lbl5);
        add(lbl6);
        add(lbl7);
        add(lbl8);
        add(lbl9);
        add(btnCancelar);
        
        
}   
}
