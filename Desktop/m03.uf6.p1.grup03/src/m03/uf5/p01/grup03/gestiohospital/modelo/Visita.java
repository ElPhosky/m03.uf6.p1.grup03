package m03.uf5.p01.grup03.gestiohospital.modelo;

import java.time.LocalDateTime;

public class Visita {

    private final LocalDateTime data;
    private final Metge metge;
    private final Malaltia diagnostic;
    private final Pacient pacient;

    public Visita(LocalDateTime data, Metge metge, Malaltia diagnostic,Pacient pacient) {
        this.data = data;
        this.metge = metge;
        this.diagnostic = diagnostic;
        this.pacient=pacient;
    }

    public LocalDateTime getDate() {
        return data;
    }

    public Metge getMetge() {
        return metge;
    }

    public Malaltia getDiagnostic() {
        return diagnostic;
    }
    public Pacient getPacient(){
        return pacient;
    }
    
        public LocalDateTime getData() {
        return data;
    }

}
