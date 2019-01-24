/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup03.gestiohospital;

public class Pacient extends Persona{
    Historial historial;

    @Override
    public String toString(){
        return ("Pacient: "+getNom()+" "+getCognom1()+" "+getCognom2()+" \ncodi seguretat social: "
                +getNumSegSocial()+"\nDNI: "+getNif()+"\nTelefon: "+getTelefon());
    }
    
    
    public Pacient(String nom, String cognom1, String cognom2, String numSegSocial, String nif, String telefon, Adreca adreca) {
        super(nom, cognom1, cognom2, numSegSocial, nif, telefon, adreca);
        this.historial=new Historial(this);
    }
    
    
    public Historial getHistorial(){
        return historial;
        
    }
    
}
