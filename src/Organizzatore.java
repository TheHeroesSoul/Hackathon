import java.util.List;

public class Organizzatore extends Utente {

    public Organizzatore(String username, String email, String nome, String cognome) {
        super(username, email, nome, cognome);
    }

    public void selezionaGiudici (Hackathon hackathon, List<Giudice> giudiciSelezionati, String messaggioInvito) {
        for (Giudice g : giudiciSelezionati) {
            g.riceviInvito(hackathon, messaggioInvito);
        }
    }
}
