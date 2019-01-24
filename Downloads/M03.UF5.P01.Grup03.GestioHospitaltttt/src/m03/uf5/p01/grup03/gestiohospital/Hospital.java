package m03.uf5.p01.grup03.gestiohospital;

import java.util.ArrayList;

public class Hospital {
    String nombre;
    ArrayList<Pacient> pacientes;
    ArrayList<Metge> metges;
    ArrayList<Malaltia> malalties;
    ArrayList<Historial> historials;
    Adreca adreca;
    
    public Hospital(String nom, Adreca adreca){
        this.nombre = nom;
        pacientes = new ArrayList<>();
        metges = new ArrayList<>();
        malalties = new ArrayList<>();
        historials = new ArrayList<>();
        this.adreca = adreca;
    }
    
    public void afegirPacient(Pacient paciente){
        pacientes.add(paciente);
        historials.add(paciente.getHistorial());
    }
    
    public void afegirMetge(Metge medico){
        metges.add(medico);
    }
    
    public void afegirMalaltia(Malaltia enfermedad){
        malalties.add(enfermedad);
    }
    
    public Pacient buscarPacientNif(String nif){
        
        for(Pacient paciente : pacientes){
            if(paciente.getNif().equals(nif))
                return paciente;
        }
        return null;
    }
    
    public Pacient buscarPacientNumSeg(String SegSoc){
        
        for(Pacient paciente : pacientes){
            if(paciente.getNumSegSocial().equals(SegSoc))
                return paciente;
        }
        return null;
    }
    
    public Pacient buscarPacientCodiHistorial(int codi){
        for(Historial historial : historials){
            if(historial.getCodi() == codi)
                return historial.getPacient();
        }
        return null;
    }
   
    public Malaltia buscarMalaltiaCodi(int codi){
        for(Malaltia enfermedad : malalties)
            if(enfermedad.getCodi() == codi)
                return enfermedad;
        return null;
    }
    
    //Buscar metges
    public Metge bucarMetgeNif(String nif){
        for(Metge medico : metges)
            if(medico.getNif().equals(nif))
                return medico;
        return null;
    }
    
    public Metge buscarMetgeNumSeg(String SegSoc){
        for(Metge medico: metges)
            if(medico.getNumSegSocial().equals(SegSoc))
                return medico;
        return null;
    }
    
    
    public Metge buscarMetgeNumEmpleat(int numEmpleat){
        for(Metge medico: metges)
            if(medico.getNumEmpleat() == numEmpleat)
                return medico;
        return null;
    }
    
    public void crearVisita(Pacient pacient, Metge medico, Malaltia enfermedad){
        if(pacient == null || medico == null || enfermedad == null){
            throw new NullPointerException("Parametros invalios");
        }else{
        pacient.getHistorial().crearVisita(medico, enfermedad, pacient);
    }}
    public ArrayList<Pacient> getListaPacients(){
        return pacientes;
    }
    public ArrayList<Metge> getListaMetges(){
        return metges;
    }
    
    public Historial findHistorial(int codigo){
        for(Historial a: historials){
            if(a.codi==codigo){
                return a;
            }
        }
        return null;
    }
}

