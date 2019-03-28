package m03.uf5.p01.grup03.gestiohospital.modelo;

import java.time.Duration;


public class Malaltia {
    static int numMalaltia = 1;
    int codi;
    String nom;
    boolean baixaLaboral;
    String tractament;
    Duration duradaTractament;
    
    public Malaltia(String nom, boolean baixaLaboral, String tractament, Duration duradaTractament){
        codi = numMalaltia++;
        this.duradaTractament = duradaTractament;
        this.baixaLaboral = baixaLaboral;
        this.nom = nom;
        this.tractament = tractament;
    }
    public String getNom(){
        return nom;
    }
    
    public int getCodi(){
        return codi;
    }
    
    public boolean getMotiuDeBaixaLaboral(){
        return baixaLaboral;
    }
    
    public String getTractamentASeguir(){
        return tractament;
    }

    public String getDuradaTractament() {
        return duradaTractament.toString();
    }

    
    
}