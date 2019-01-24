package m03.uf5.p01.grup03.gestiohospital;

public class Metge extends Persona {

    public int getNumEmpleat() {
        return numEmpleat;
    }

    private int numEmpleat;
    private int salariMensual;
    private String codiCompteCorrent;

    public Metge(String nom, String cognom1, String cognom2, String numSegSocial, String nif, int numEmpleat, int salariMensual, String codiCompteCorrent, String telefon, Adreca adreca) {
        super(nom, cognom1, cognom2, numSegSocial, nif, telefon, adreca);
        this.salariMensual = salariMensual;
        this.codiCompteCorrent = codiCompteCorrent;
        this.numEmpleat = numEmpleat;
    }

    @Override
    public String toString() {
        return ("Metge: " + getNom() + " " + getCognom1() + " " + getCognom2() + " \ncodi seguretat social: "
                + getNumSegSocial() + "\nDNI: " + getNif() + "\nTelefon: " + getTelefon() + "\n codi d'empleat: "
                + numEmpleat + "\nSalari mensual" + salariMensual + "Codi de compte Corrent: "
                + codiCompteCorrent);
    }
}
