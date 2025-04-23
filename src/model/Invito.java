package model;

public class Invito {
    public enum StatoRichiesta {
        IN_ATTESA, ACCETTATO, RIFIUTATO
    }

    private Utente mittente;
    private Utente destinatario;
    private Team team;
    private String messaggio;
    private StatoRichiesta stato;

    public Invito(Utente mittente, Utente destinatario, Team team, String messaggio) {
        this.mittente = mittente;
        this.destinatario = destinatario;
        this.team = team;
        this.messaggio = messaggio;
        this.stato = StatoRichiesta.IN_ATTESA;
    }

    public void accetta() {
        if (team.getNumeroMembri() < team.getHackathon().getMaxPersoneInUnTeam()) {
            team.aggiungiMembro(destinatario);
            stato = StatoRichiesta.ACCETTATO;
            System.out.println(destinatario.getNome() + " ha accettato l'invito.");
        } else {
            System.out.println("Team pieno, impossibile aggiungere.");
        }
    }

    public void rifiuta() {
        stato = StatoRichiesta.RIFIUTATO;
        System.out.println(destinatario.getNome() + " ha rifiutato l'invito.");
    }

    public StatoRichiesta getStato() {
        return stato;
    }
}