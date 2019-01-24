package m03.uf5.p01.grup03.gestiohospital;

import java.time.Duration;


class Malaltia {
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
        this.duradaTractament = duradaTractament;
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

    public Duration getDuradaTractament() {
        return duradaTractament;
    }

    
    
}