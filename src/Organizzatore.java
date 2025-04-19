import java.util.List;

public class Organizzatore extends Utente {

    public Organizzatore(String email, String nome, String cognome) {
        super(email, nome, cognome);
    }

    private String messaggioInvito = "Sei stato selezionato per ricoprire il ruolo di giudice di questo evento!";

    public void selezionaGiudici (Hackathon hackathon, List<Giudice> giudiciSelezionati, String messaggioInvito) {
        for (Giudice g : giudiciSelezionati) {
            g.riceviInvito(hackathon, messaggioInvito);
        }
    }














}
