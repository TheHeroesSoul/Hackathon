import java.time.LocalDateTime;

public class Registrazione {
    private Utente utente;
    private Hackathon hackathon;
    private LocalDateTime data;

    public Registrazione(Utente utente, Hackathon hackathon) {
        this.utente = utente;
        this.hackathon = hackathon;
        this.data = LocalDateTime.now();
    }
}