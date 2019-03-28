package m03.uf5.p01.grup03.gestiohospital.vista;

import java.awt.GridLayout;
import java.time.Duration;
import javax.swing.*;
import m03.uf5.p01.grup03.gestiohospital.controlador.Controlador;
import m03.uf5.p01.grup03.gestiohospital.controlador.MenuAnyadirMetgeControlador;

public class MenuAnyadirMalaltia extends JFrame {

    private Controlador controlador;

    JLabel lblNom = new JLabel("Nom : ");
    JLabel lblBaixa = new JLabel(": ");
    JLabel lblTractament = new JLabel("Cognom 2: ");
    JLabel lblDuration = new JLabel("Duracion (en dias) : ");
    
    
    public JTextField tfNom = new JTextField();
    public JTextField tfBaixa = new JTextField();
    public JTextField tfTractament = new JTextField();
    public JTextField tfDuration = new JTextField();
    public JButton btnAcceptar = new JButton("Acceptar");
    public JButton btnCancelar = new JButton("Cancelar");
    GridLayout mAPLayout = new GridLayout(0, 2);

    public MenuAnyadirMalaltia(Controlador c) {
        super("Añadir Metge");
        controlador = c;
        inicializa();
    }

    public void inicializa() {

        this.setTitle("Registre");
        this.setLayout(mAPLayout);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(400, 300);
        btnAcceptar.addActionListener(controlador);
        btnCancelar.addActionListener(controlador);
        add(lblNom);
        add(tfNom);
        add(lblBaixa);
        add(tfBaixa);
        add(lblTractament);
        add(tfTractament);
        add(lblDuration);
        add(tfDuration);
        add(btnAcceptar);
        add(btnCancelar);
    }

}
