package m03.uf5.p01.grup03.gestiohospital;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Historial {

    static int numHistorial = 1;
    int codi;
    Pacient pacient;
    private final ArrayList<Visita> visita;

    @Override
    public String toString() {
        return ("Codi " + codi + ". " + pacient.toString() + ", " + visita.size()
                + ", " + visita.toString());
    }

    public void crearVisita(Metge medico, Malaltia enfermedad,Pacient pacient) {
        LocalDateTime fecha= LocalDateTime.now();
        visita.add(new Visita(fecha, medico, enfermedad, pacient));
    }

    public Historial(Pacient pacient) {
        codi = numHistorial;
        numHistorial++;
        this.pacient = pacient;
        visita = new ArrayList<>();
    }

    public int getCodi() {
        return codi;
    }

    public Pacient getPacient() {
        return pacient;
    }

}
