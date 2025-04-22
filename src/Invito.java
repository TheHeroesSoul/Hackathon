public class Invito extends Utente {
    private String nomeTeam;

    public Invito(String email, String nome, String cognome) {
        super(email, nome, cognome);
        this.nomeTeam = nomeTeam;
    }

    private String invitoTeam() {
        return "Abbiamo bisogno di te! Sei dei nostri?";
    }

}