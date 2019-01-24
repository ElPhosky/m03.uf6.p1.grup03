package m03.uf5.p01.grup03.gestiohospital;

public class Adreca {

    private String ciutat;
    private String codiPostal;
    private String carrer;
    private int numero;
    private String planta;
    private int porta;

    public Adreca(String ciutat, String codiPostal, String carrer, int numero, String planta, int porta) {
        this.ciutat = ciutat;
        this.codiPostal = codiPostal;
        this.carrer = carrer;
        this.numero = numero;
        this.planta = planta;
        this.porta = porta;
    }

    public String getCiutat() {
        return ciutat;
    }

    public String getCodiPostal() {
        return codiPostal;
    }

    public String getCarrer() {
        return carrer;
    }

    public int getNumero() {
        return numero;
    }

    public String getPlanta() {
        return planta;
    }

    public int getPorta() {
        return porta;
    }

}
