public class Invito {
    public enum StatoInvito {
        IN_ATTESA, ACCETTATO, RIFIUTATO
    }

    private Utente mittente;
    private Utente destinatario;
    private Team team;
    private String messaggio;
    private StatoInvito stato;

    public Invito(Utente mittente, Utente destinatario, Team team, String messaggio) {
        this.mittente = mittente;
        this.destinatario = destinatario;
        this.team = team;
        this.messaggio = messaggio;
        this.stato = StatoInvito.IN_ATTESA;
    }

    public void accetta() {
        if (team.getNumeroMembri() < team.getHackathon().getMaxPersoneTeam()) {
            team.aggiungiMembro(destinatario);
            stato = StatoInvito.ACCETTATO;
            System.out.println(destinatario.getNome() + " ha accettato l'invito.");
        } else {
            System.out.println("Team pieno, impossibile aggiungere.");
        }
    }

    public void rifiuta() {
        stato = StatoInvito.RIFIUTATO;
        System.out.println(destinatario.getNome() + " ha rifiutato l'invito.");
    }

    public StatoInvito getStato() {
        return stato;
    }
}