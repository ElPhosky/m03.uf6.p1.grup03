/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup03.gestiohospital;


public abstract class Persona {

    private String nom;
    private String cognom1;
    private String cognom2;
    private String numSegSocial;
    private String nif;
    private String telefon;
    private final Adreca adreca;

    public String getNom() {
        return nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public String getNumSegSocial() {
        return numSegSocial;
    }

    public String getNif() {
        return nif;
    }

    public String getTelefon() {
        return telefon;
    }

    public Adreca getAdreca() {
        return adreca;
    }

    public Persona(String nom, String cognom1, String cognom2, String numSegSocial, String nif, String telefon, Adreca adreca) {
        this.numSegSocial = numSegSocial;
        this.nif = nif;
        this.telefon = telefon;
        this.adreca = adreca;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
    }

}
