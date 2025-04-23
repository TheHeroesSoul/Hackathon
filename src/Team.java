import java.util.ArrayList;
import java.util.List;

public class Team {
    private String id;
    private List<Utente> membri = new ArrayList<>();
    private Hackathon hackathon;
    private List<Voto> voti = new ArrayList<>();

    public Team(String id, String nomeTeam, Hackathon hackathon) {
        this.id = id;
        this.hackathon = hackathon;
    }

    public void aggiungiMembro(Utente u) {
        if (!membri.contains(u) && puoAccettare()) {
            membri.add(u);
            System.out.println("Utente " + u.getNome() + " aggiunto al team.");
        } else {
            System.out.println("Impossibile aggiungere " + u.getNome() + ": team pieno.");
        }
    }

    public int getNumeroMembri() {
        return membri.size();
    }

    public Hackathon getHackathon() {
        return hackathon;
    }

    public List<Utente> getMembri() {
        return membri;
    }

    public boolean puoAccettare() {
        return membri.size() < hackathon.getMaxPersoneTeam();
    }

    public void aggiungiVoto(Voto voto) {
        voti.add(voto);
    }

    public double calcolaMediaVoti() {
        if (voti.isEmpty()) return 0.0;

        int somma = 0;
        for (Voto v : voti) {
            somma += v.getValore();
        }
        return (double) somma / voti.size();
    }
}