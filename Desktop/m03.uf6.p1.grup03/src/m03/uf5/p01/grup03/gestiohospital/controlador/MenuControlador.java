package m03.uf5.p01.grup03.gestiohospital.controlador;

import java.awt.event.ActionEvent;
import java.util.Scanner;
import m03.uf5.p01.grup03.gestiohospital.modelo.Creacion;

import m03.uf5.p01.grup03.gestiohospital.vista.*;


public class MenuControlador extends Controlador{
    
    
    // public static Creacion control = null;
    
        public static void main(String[] args) {
        /*    control.creaAdrecayHospital();
            control.leeMalaltia();
            control.leeMetge();
            control.leePacientes();
            control.leeVisites(); */
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new MenuControlador();
            }
        });

    }

    private Menu m;
    private MenuAnyadirPacienteControlador mAPC;
    private RadioRegistrarVisitaControlador rRV;
    private MostrarControladorPaciente mCP;
    private MostrarControladorMedico mCM;
    private MenuAnyadirMetgeControlador mAMC;
    private BuscarEnfermedadControlador bEC;

    public MenuControlador() {
       inicializa(); 
    }

    private void inicializa() {
        m = new Menu(this);
        m.setVisible(true);
    }
    
    
    

    public static Scanner in = new Scanner(System.in, "ISO-8859-1");

        @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == m.btnNuevo){
            mAPC = new MenuAnyadirPacienteControlador();
        }
        if(ae.getSource() == m.btnNuevoMedico){
            mAMC= new MenuAnyadirMetgeControlador();
        }
        if(ae.getSource() == m.btnRegistrar){
            rRV = new RadioRegistrarVisitaControlador();
        }
        if(ae.getSource() == m.btnMostrarPaciente){
                new Pacient().setVisible(true);    
        }
        if(ae.getSource() == m.btnMostrarMedico){
                new Metge().setVisible(true); 
        }
        if(ae.getSource() == m.btnBuscarEnfermedad){
                new Enfermedad().setVisible(true); 
        }
    }
}
        /**

        Adreca adrecaPrueba = new Adreca("Terrassa", "08227", "Carrer Ampolla", 345, "Entr", 34);
        Hospital hospitalPrueba = new Hospital("Hospital de Guadalupe", adrecaPrueba);

        hospitalPrueba.afegirMalaltia(new Malaltia("resfriao", false, "Unas orikas en cama y como nuevo", Duration.ofHours(2)));
        hospitalPrueba.afegirMalaltia(new Malaltia("Me desmayo", true, "Pastillas y ya", Duration.ofDays(4)));
        hospitalPrueba.afegirMalaltia(new Malaltia("Esquizofrenia", true, "Xungo lo veo", Duration.ofDays(365)));

        hospitalPrueba.afegirMetge(new Metge("Rafa", "NoMeSeTuApellido1", "NoMeSeTuApellido2", "111234567890", "47840738L", 1, 1200, "ES10000", "935880478", new Adreca("Terrassa", "08191", "C/encantao", 1, null, 5)));
        hospitalPrueba.afegirMetge(new Metge("Kevin", "NoMeSeTuApellido1", "NoMeSeTuApellido2", "111345678990", "47843738L", 2, 1300, "ES1000023", "933880478", new Adreca("Terrassa", "08191", "C/tontin", 2, "2", 4)));
        hospitalPrueba.afegirMetge(new Metge("Óscar", "González", "García", "111234517890", "47740738Y", 3, 2500, "ES132420000", "935870478", new Adreca("Rubi", "08191", "C/encantats", 7, null, 5)));
        boolean continuar = true;
        while (continuar) {
            int accion;
            boolean valido;
            Pacient pacient = null;
            Metge metge = null;
            System.out.println("Elige la acción que quieras realizar: ");

            System.out.println("1. Registrar visita. \n2. Nuevo paciente"
                    + "\n3. Mostrar paciente \n4. Mostrar médico \n5. Ver historial"
                    + "\n6. Salir");

            accion = in.nextInt();

            switch (accion) {
                case 1:  //REGISTRAR VISITA

                    System.out.println("¿Cómo quieres identificar al paciente?"
                            + "\n1. NIF \n2. Num. SS \n3. Codigo de historial");
                    accion = scanearNum();

                    switch (accion) {
                        case 1: //NIF
                            pacient = hospitalPrueba.buscarPacientNif(obtenerNIF());

                            break;

                        case 2: //SS
                            pacient = hospitalPrueba.buscarPacientNumSeg(obtenerSS());
                            break;

                        case 3: //Codigo
                            int codigo = in.nextInt();
                            codigo = validarCodigo(codigo);
                            pacient = hospitalPrueba.buscarPacientCodiHistorial(codigo);
                            break;

                    }
                    System.out.println("¿Cómo quieres identificar al médico?"
                            + "\n1. NIF \n2. Num. SS \n3. Codigo de historial");
                    accion = scanearNum();

                    switch (accion) {
                        case 1: //NIF
                            metge = hospitalPrueba.bucarMetgeNif(obtenerNIF());
                            break;

                        case 2: //SS
                            metge = hospitalPrueba.buscarMetgeNumSeg(obtenerSS());
                            break;

                        case 3: //Codigo
                            int codigo = scanearNum();
                            codigo = validarCodigo(codigo);
                            metge = hospitalPrueba.buscarMetgeNumEmpleat(codigo);
                            break;
                    }
                    boolean t = false;
                    int ref = 0;
                    do {
                        try {
                            System.out.println("Introduce el ID de la enfermedad. ");
                            String temp = in.next();
                            ref = Integer.parseInt(temp);
                            t=true;
                        } catch (NumberFormatException e) {
                            System.out.println("¡Has pasado letras!");
                        }
                    } while (!t);
                    Malaltia malaltia;
                    malaltia = hospitalPrueba.buscarMalaltiaCodi(ref);
                    if(!(pacient == null||metge == null||malaltia == null)){
                    hospitalPrueba.crearVisita(pacient, metge, malaltia);
                    System.out.println("");
                    System.out.println("Visita registrada.");
                    }
                    else{
                        System.out.println("Algo a fallado, vuelve a intentarlo.");
                    }
                    break;

                case 2: //NUEVO PACIENTE
                    String nom,
                     cognom1,
                     cognom2,
                     nSS,
                     nif,
                     nTel;

                    do {
                        System.out.println("Introduce el nombre: ");
                        nom = in.next();
                        valido = compruebaUTF(nom);
                    } while (!valido);

                    do {
                        System.out.println("Introduce el primer apellido: ");
                        cognom1 = in.next();
                        valido = compruebaUTF(cognom1);
                    } while (!valido);

                    do {
                        System.out.println("Introduce el segundo apellido: ");
                        cognom2 = in.next();
                        valido = compruebaUTF(cognom2);

                    } while (!valido);
                    valido = false;
                    nSS = obtenerSS();
                    nif = obtenerNIF();
                    nTel = obtenerTlf();

                    System.out.println("Ciutat : ");
                    String ciutat = in.next();
                    System.out.println("Codi Postal : ");
                    String codiPostal = in.next();
                    System.out.println("Carrer : ");
                    String carrer = in.next();
                    System.out.println("Numero : ");
                    int numero = scanearNum();
                    System.out.println("Planta : ");
                    String planta = in.next();
                    System.out.println("Porta : ");
                    int porta = scanearNum();
                    
                    Adreca adreca = new Adreca(ciutat, codiPostal, carrer, numero, planta, porta);
                    Pacient paciente = new Pacient(nom, cognom1, cognom2, nSS, nif, nTel, adreca);
                    hospitalPrueba.getListaPacients().add(paciente);
                    break;

                case 3: //MOSTRAR PACIENTE
                    System.out.println("¿Cómo quieres identificar al paciente?"
                            + "\n1. NIF \n2. Num. SS \n3. Codigo de historial");
                    accion = in.nextInt();

                    switch (accion) {
                        case 1: { //NIF
                            String nifP = obtenerNIF();
                            pacient = hospitalPrueba.buscarPacientNif(nifP);
                            System.out.println(pacient.toString());
                            break;
                        }

                        case 2: { //SS
                            String nSSP = obtenerSS();
                            pacient = hospitalPrueba.buscarPacientNumSeg(nSSP);
                            System.out.println(pacient.toString());
                            break;
                        }
                        case 3: {//Codigo
                            String codigoP = in.nextLine();
                            pacient = hospitalPrueba.buscarPacientNumSeg(codigoP);
                            System.out.println(pacient.toString());
                            break;
                        }
                    }
                    break;

                case 4: //MOSTRAR MÉDICO
                    accion = 0;
                    System.out.println("¿Cómo quieres identificar al médico?"
                            + "\n1. NIF \n2. Num. SS \n3. Codigo de historial");
                    accion = scanearNum();
                    boolean encontrado;
                    switch (accion) {
                        case 1: //NIF
                            String nifM = obtenerNIF();
                            encontrado = false;
                            for (Metge metge1 : hospitalPrueba.getListaMetges()) {
                                if (metge1.getNif().equals(nifM)) {
                                    metge1.toString();

                                    encontrado = true;
                                }
                            }
                            if (encontrado == false) {
                                System.out.println("No se ha encontrado ningun resultado.");
                            }
                            break;

                        case 2: //SS
                            String nSSM = obtenerSS();
                            encontrado = false;
                            for (Metge metge1 : hospitalPrueba.getListaMetges()) {
                                if (metge1.getNif().equals(nSSM)) {
                                    metge1.toString();

                                    encontrado = true;
                                }
                            }
                            if (encontrado == false) {
                                System.out.println("No se ha encontrado ningun resultado.");
                            }
                            break;

                        case 3: //Codigo
                            String codigoM = in.next();
                            encontrado = false;
                            for (Metge metge1 : hospitalPrueba.getListaMetges()) {
                                if (metge1.getNif().equals(codigoM)) {
                                    metge1.toString();

                                    encontrado = true;
                                }
                            }
                            if (encontrado == false) {
                                System.out.println("No se ha encontrado ningun resultado.");
                            }
                            break;
                    }
                    break;

                case 5: //VER HISTORIAL
                    int codigoHistorial = scanearNum();
                    validarCodigo(codigoHistorial);
                    break;

                case 6: //SALIR
                    continuar = false;
                    break;
            }

        }
    }

    public static String obtenerNIF() {

        String nif = "";
        boolean correcto = false;
        while (correcto == false) {
            System.out.println("Escribe el NIF: ");
            nif = in.next();
            Pattern pat = Pattern.compile("\\d{8}[A-HJ-NP-TV-Z]");
            Matcher mat = pat.matcher(nif);
            if (mat.find()) {
                correcto = true;
            } else {
                correcto = false;
                System.out.println("NIF incorrecto");
            }
        }
        return nif;
    }

    public static String obtenerSS() {
        String ss = "";
        boolean correcto = false;
        while (correcto == false) {
            System.out.println("Introduce el numero de la Seguridad Social.");
            ss = in.next();
            Pattern pat = Pattern.compile("(66|53|50|[0-4][0-9])-?\\d{8}-?\\d{2}");
            Matcher mat = pat.matcher(ss);
            if (mat.find()) {
                correcto = true;
            } else {
                System.out.println("El Num. de Seguridad Social no tiene esa forma.");
                correcto = false;
            }
        }
        return ss;
    }

    public static String obtenerTlf() {

        String tlf = "";
        boolean correcto = false;
        while (correcto == false) {
            System.out.println("Introduce el numero de telefono del paciente.");
            tlf = in.next();
            Pattern pat = Pattern.compile("^(?:(?:\\+|00)?34)?[6789]\\d{8}$");
            Matcher mat = pat.matcher(tlf);
            if (mat.find()) {
                correcto = true;
            } else {
                System.out.println("El Num. de teléfono no tiene esa forma.");
                correcto = false;
            }
        }
        return tlf;
    }

    public static int validarCodigo(int codigo) {
        do {
            System.out.println("Introduce el codigo de la persona a la que quieras identificar : ");
            if (codigo > Historial.getHistorial()) {
                System.out.println("El codigo es demasiado grande, el numero maximo es: " + Historial.getHistorial());
                codigo = in.nextInt();
            }
        } while (codigo <= Historial.getHistorial());
        return codigo;
    }
        private static int scanearNum() {
        int num;
        Scanner in = new Scanner (System.in);
        while (true) {
            
            try {
                num = Integer.parseInt(in.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("El número no es válido");
            }
        }
    }

    public static boolean compruebaUTF(String texto) {
        Pattern regles = Pattern.compile("^[a-zA-ZáéíóúàèìòùÀÈÌÒÙÁÉÍÓÚñÑçÇäÄëËïÏöÖüÜ\\s]*$");
        Matcher textAnalitzar = regles.matcher(texto);
        if (textAnalitzar.find()) {
            return true;
        } else {
            System.out.println("Nombre erroneo, vuelvelo a intentar.");
            return false;
        }
    }
}
*/
