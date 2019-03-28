package m03.uf5.p01.grup03.gestiohospital.vista;

import java.awt.GridLayout;
import javax.swing.*;
import m03.uf5.p01.grup03.gestiohospital.controlador.Controlador;
import m03.uf5.p01.grup03.gestiohospital.controlador.MenuAnyadirMetgeControlador;

public class MenuAnyadirMetge extends JFrame {

    private Controlador controlador;

    JLabel lblNom = new JLabel("Nom : ");
    JLabel lblCognom1 = new JLabel("Cognom 1: ");
    JLabel lblCognom2 = new JLabel("Cognom 2: ");
    JLabel lblNSS = new JLabel("Numero Seguretat Social: ");
    JLabel lblDNI = new JLabel("DNI : ");
    JLabel lblTelefon = new JLabel("Telefon : ");
    JLabel lblNumEmpleat = new JLabel("Nº Empleat : ");
    JLabel lblSalariMensual = new JLabel("Salari : ");
    JLabel lblCompteCorrent = new JLabel("Compte Corrent : ");
    JLabel lblValido = new JLabel("Valido : ");
    JLabel lblCiudad = new JLabel("Ciutat : ");
    JLabel lblCodiPostal = new JLabel("Codi Postal : ");
    JLabel lblCarrer = new JLabel("Carrer : ");
    JLabel lblNumero = new JLabel("Numero : ");
    JLabel lblPlanta = new JLabel("Planta : ");
    JLabel lblPorta = new JLabel("Porta : ");
    JLabel lblSeparador1 = new JLabel("-----------------------------------------ADRE");
    JLabel lblSeparador2 = new JLabel("ÇA-----------------------------------------------");
    public JLabel lblConfirmar = new JLabel("");
    public JTextField tfNom = new JTextField();
    public JTextField tfCognom1 = new JTextField();
    public JTextField tfCognom2 = new JTextField();
    public JTextField tfNSS = new JTextField();
    public JTextField tfDNI = new JTextField();
    public JTextField tfTelefon = new JTextField();
    public JTextField tfNumEmpleat = new JTextField();
    public JTextField tfSalariMensual = new JTextField();
    public JTextField tfCompteCorrent = new JTextField();
    public JTextField tfCiudad = new JTextField();
    public JTextField tfCodiPostal = new JTextField();
    public JTextField tfCarrer = new JTextField();
    public JTextField tfNumero = new JTextField();
    public JTextField tfPlanta = new JTextField();
    public JTextField tfPorta = new JTextField();
    public JButton btnAcceptar = new JButton("Acceptar");
    public JButton btnCancelar = new JButton("Cancelar");
    GridLayout mAPLayout = new GridLayout(0, 2);

    public MenuAnyadirMetge(Controlador c) {
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
        add(lblCognom1);
        add(tfCognom1);
        add(lblCognom2);
        add(tfCognom2);
        add(lblNSS);
        add(tfNSS);
        add(lblDNI);
        add(tfDNI);
        add(lblTelefon);
        add(tfTelefon);
        add(lblNumEmpleat);
        add(tfNumEmpleat);
        add(lblSalariMensual);
        add(tfSalariMensual);
        add(lblCompteCorrent);
        add(tfCompteCorrent);
        add(lblSeparador1);
        add(lblSeparador2);
        add(lblCiudad);
        add(tfCiudad);
        add(lblCodiPostal);
        add(tfCodiPostal);
        add(lblCarrer);
        add(tfCarrer);
        add(lblNumero);
        add(tfNumero);
        add(lblPlanta);
        add(tfPlanta);
        add(lblPorta);
        add(tfPorta);
        add(lblValido);
        add(lblConfirmar);
        add(btnAcceptar);
        add(btnCancelar);
    }

}
