package m03.uf5.p01.grup03.gestiohospital.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Creacion {
    
    public Creacion(){
        creaAdrecayHospital();
    }

    public static Hospital hospitalPrueba = null;
    //ubi Creacion del hospital
    private static String ubiAdrecayHospital = ("src/m03/uf5/p01/grup03/gestiohospital/modelo/ubiAdrecayHospital.csv");
    private static File fileAdreca = new File(ubiAdrecayHospital);

    //ubi malalaties
    private static String ubiMalaltia = ("src/m03/uf5/p01/grup03/gestiohospital/modelo/ubiMalaltia.csv");
    private static File fileMalaltia = new File(ubiMalaltia);

    //ubi metges
    private static String ubiMetges = ("src/m03/uf5/p01/grup03/gestiohospital/modelo/ubiMetges.csv");
    private static File fileMetges = new File(ubiMetges);

    //ubi pacient
    private static String ubiPacients = ("src/m03/uf5/p01/grup03/gestiohospital/modelo/ubiPacients.csv");
    private static File filePacients = new File(ubiPacients);

    //ubi visites
    private static String ubiVisites = ("src/m03/uf5/p01/grup03/gestiohospital/modelo/ubiVisites.csv");
    private static File fileVisites = new File(ubiVisites);

    public static void creaAdrecayHospital() {
        Scanner sc = null;
        try {
            sc = new Scanner(fileAdreca);
            String[] datosAdreca = sc.nextLine().split(",");
            String nombreHospital = sc.nextLine();
            Adreca adrecaPrueba = new Adreca(datosAdreca[0], datosAdreca[1], datosAdreca[2], Integer.parseInt(datosAdreca[3]), datosAdreca[4], Integer.parseInt(datosAdreca[5]));
            hospitalPrueba = new Hospital(nombreHospital, adrecaPrueba);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Creacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sc.close();
        }
    }

    public static void leeMalaltia() {
        Scanner sc = null;
        try {

            sc = new Scanner(fileMalaltia);

            while (sc.hasNextLine()) {
                String[] datosMalaltia = sc.nextLine().split(",");
                hospitalPrueba.afegirMalaltia(new Malaltia(datosMalaltia[0], Boolean.parseBoolean(datosMalaltia[1]), datosMalaltia[2], Duration.parse(datosMalaltia[3])));

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Creacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sc.close();
        }
    }

    public static void leeMetge() {
        Scanner sc = null;
        try {
            sc = new Scanner(fileMetges);

            while (sc.hasNextLine()) {
                String[] datosMetge = sc.nextLine().split(",");
                hospitalPrueba.afegirMetge(new Metge(datosMetge[0], datosMetge[1], datosMetge[2], datosMetge[3], datosMetge[4], Integer.parseInt(datosMetge[5]), Integer.parseInt(datosMetge[6]), datosMetge[7], datosMetge[8],
                        new Adreca(datosMetge[9], datosMetge[10], datosMetge[11], Integer.parseInt(datosMetge[12]), datosMetge[13], Integer.parseInt(datosMetge[14]))));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Creacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sc.close();
        }
    }

    public static void leePacientes() {
        Scanner sc = null;
        try {

            sc = new Scanner(filePacients);
            while (sc.hasNextLine()) {
                String[] datosPaciente = sc.nextLine().split(",");
                hospitalPrueba.afegirPacient(new Pacient(datosPaciente[0], datosPaciente[1], datosPaciente[2], datosPaciente[3], datosPaciente[4], datosPaciente[5],
                        new Adreca(datosPaciente[6], datosPaciente[7], datosPaciente[8], Integer.parseInt(datosPaciente[9]), datosPaciente[10], Integer.parseInt(datosPaciente[11]))));

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Creacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sc.close();
        }
    }

    public static void leeVisites() {
        Scanner sc = null;

        try {
            sc = new Scanner(fileVisites);
            while (sc.hasNextLine()) {
                String[] datosVisites = sc.nextLine().split(",");
                Pacient p = hospitalPrueba.buscarPacientNif(datosVisites[0]);
                Metge m = hospitalPrueba.buscarMetgeNif(datosVisites[1]);
                Malaltia ma = hospitalPrueba.buscarMalaltiaCodi(Integer.parseInt(datosVisites[2]));
                hospitalPrueba.crearVisita(p, m, ma);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Creacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sc.close();
        }
    }

    public static void escriuMalaltia(Malaltia malaltia) {
        Scanner sc = null;

        try {
                
            sc = new Scanner(fileMalaltia);
            ArrayList<String> completo = new ArrayList();
            while (sc.hasNextLine()) {
                completo.add(sc.nextLine());
            }
            sc.close();

            FileWriter lee = new FileWriter(fileMalaltia);
            PrintWriter save = new PrintWriter(lee);

            String total = (malaltia.getNom() + "," + malaltia.getMotiuDeBaixaLaboral() + "," + malaltia.getTractamentASeguir() + "," + malaltia.getDuradaTractament());
            save.println(total);
            for (int i = 0; i < completo.size(); i++) {
                if (i == completo.size() - 1) {
                    save.print(completo.get(i));
                } else {
                    save.println(completo.get(i));
                }
            }

            save.close();
            hospitalPrueba.afegirMalaltia(malaltia);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Creacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Creacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

    }

    public static void escriuMetge(Metge metge) {
        try {
            Scanner sc = new Scanner(fileMetges);
            ArrayList<String> completo = new ArrayList();
            while (sc.hasNextLine()) {
                completo.add(sc.nextLine());
            }
            sc.close();

            FileWriter lee = new FileWriter(fileMetges);
            PrintWriter save = new PrintWriter(lee);

            String total = (metge.getNom() + "," + metge.getCognom1() + "," + metge.getCognom2() + "," + metge.getNumSegSocial() + "," + metge.getNif() + "," + metge.getNumEmpleat() + "," + metge.getsalariMensual() + "," + metge.getCodiCompteCorrent() + "," + metge.getTelefon()
                    + "," + metge.getAdreca().getCiutat() + "," + metge.getAdreca().getCodiPostal() + "," + metge.getAdreca().getCarrer() + "," + metge.getAdreca().getNumero() + "," + metge.getAdreca().getPlanta() + "," + metge.getAdreca().getPorta());
            save.println(total);
            for (int i = 0; i < completo.size(); i++) {
                if (i == completo.size() - 1) {
                    save.print(completo.get(i));
                } else {
                    save.println(completo.get(i));
                }
            }
                save.close();
                hospitalPrueba.afegirMetge(metge);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Creacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Creacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void escriuPacient(Pacient pacient) {
        try {
            Scanner sc = new Scanner(filePacients);
            ArrayList<String> completo = new ArrayList();
            while (sc.hasNextLine()) {
                completo.add(sc.nextLine());
            }
            sc.close();

            FileWriter lee = new FileWriter(filePacients);
            PrintWriter save = new PrintWriter(lee);

            String total = (pacient.getNom() + "," + pacient.getCognom1() + ","
                    + pacient.getCognom2() + "," + pacient.getNumSegSocial() + ","
                    + pacient.getNif() + "," + pacient.getTelefon() + "," + pacient.getAdreca().getCiutat()
                    + "," + pacient.getAdreca().getCodiPostal() + "," + pacient.getAdreca().getCarrer()
                    + "," + pacient.getAdreca().getNumero() + ","
                    + pacient.getAdreca().getPlanta() + "," + pacient.getAdreca().getPorta());
            save.println(total);
            for (int i = 0; i < completo.size(); i++) {
                if (i == completo.size() - 1) {
                    save.print(completo.get(i));
                } else {
                    save.println(completo.get(i));
                }}
                save.close();
                hospitalPrueba.afegirPacient(pacient);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Creacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Creacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void escriuVisita(Visita visita) {
        try {
            Scanner sc = new Scanner(fileVisites);
            ArrayList<String> completo = new ArrayList();
            while (sc.hasNextLine()) {
                completo.add(sc.nextLine());
            }
            sc.close();

            FileWriter lee = new FileWriter(fileVisites);
            PrintWriter save = new PrintWriter(lee);
            String total = (visita.getPacient().getNif() + "," + visita.getMetge().getNif() + "," + visita.getDiagnostic().codi);
            save.println(total);
            for (int i = 0; i < completo.size(); i++) {
                if (i == completo.size() - 1) {
                    save.print(completo.get(i));
                } else {
                    save.println(completo.get(i));
                }}
                save.close();
                hospitalPrueba.crearVisita(visita.getPacient(), visita.getMetge(), visita.getDiagnostic());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Creacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Creacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
/*    public static void main(String[] args) {
        
        creaAdrecayHospital();
        leeMalaltia();
        leeMetge();
        leePacientes();
        Malaltia malaltia = new Malaltia("prueba1", true, "prueba para ver si guarda", Duration.ofDays(4));
        escriuMalaltia(malaltia);
        Metge metge = new Metge("TestGuardas?3", "Test1", "Test3", "2348923524", "46640738Z", 4, 1234, "2349825942", "665194009", new Adreca("Parla", "08191", "willyrex", 0, "parla2", 0));
        escriuMetge(metge);
        Pacient pacient = new Pacient("willy1", "willy1", "willy2", "111132456789", "45570736D", "651970283", new Adreca("Sevilla", "38534985", "ponme un 10", 0, "1A", 0));
        escriuPacient(pacient);
        Visita visita = new Visita(LocalDateTime.MAX, metge, malaltia, pacient);
        escriuVisita(visita);
//new Malaltia(datosMalaltia[0], Boolean.parseBoolean(datosMalaltia[1]),
        //datosMalaltia[2], Duration.parse(datosMalaltia[3]))
    } */
}