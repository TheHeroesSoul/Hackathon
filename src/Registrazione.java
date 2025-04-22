import java.time.LocalDateTime;

public class Registrazione {
    private Utente utente;
    private Hackathon hackathon;
    private LocalDateTime dataRegistrazione;

    public Registrazione(Utente utente, Hackathon hackathon) {
        this.utente = utente;
        this.hackathon = hackathon;
        this.dataRegistrazione = LocalDateTime.now();
    }

    public Utente getUtente() {
        return utente;
    }

    public Hackathon getHackathon() {
        return hackathon;
    }

    public LocalDateTime getDataRegistrazione() {
        return dataRegistrazione;
    }

    @Override
    public String toString() {
        return "Registrazione di " + utente.getNome() + " all'hackathon \"" + hackathon.getTitolo() + "\" il " + dataRegistrazione;
    }
}