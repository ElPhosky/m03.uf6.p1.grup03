package m03.uf5.p01.grup03.gestiohospital.vista;

import java.awt.GridLayout;
import javax.swing.*;
import m03.uf5.p01.grup03.gestiohospital.controlador.MenuControlador;

public class Menu extends JFrame {

    private MenuControlador controlador; //?? No se muy bien porque esta esto. @quebin  Es necesario para divirlo en vista y controlador @rafa

    JLabel lblBenvingut = new JLabel("Benvingut a Gestió Hospital. Que desitja realitzar?");
    public JButton btnRegistrar = new JButton("Registrar visita");
    public JButton btnNuevo = new JButton("Nuevo paciente");
    public JButton btnNuevoMedico = new JButton("Nuevo Medico");
    public JButton btnMostrarPaciente = new JButton("Mostrar paciente");
    public JButton btnMostrarMedico = new JButton("Mostrar médico");
    public JButton btnHistorial = new JButton("Ver historial");
    public JButton btnBuscarEnfermedad = new JButton("Mostrar enfermedad");

    public Menu(MenuControlador c) {
        super("Menú de Gestió Hospital");
        controlador = c;
        inicializa();

    }

    private void inicializa() {
        btnRegistrar.addActionListener(controlador);
        btnNuevo.addActionListener(controlador);
        btnNuevoMedico.addActionListener(controlador);
        btnMostrarPaciente.addActionListener(controlador);
        btnMostrarMedico.addActionListener(controlador);
        btnHistorial.addActionListener(controlador);
        btnBuscarEnfermedad.addActionListener(controlador);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 900);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.add(lblBenvingut);
        panel.add(btnRegistrar);
        panel.add(btnNuevo);
        panel.add(btnNuevoMedico);
        panel.add(btnMostrarPaciente);
        panel.add(btnMostrarMedico);
        panel.add(btnHistorial);
        panel.add(btnBuscarEnfermedad);
        add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}
