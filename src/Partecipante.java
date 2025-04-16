public class Partecipante extends Utente {

    public Partecipante(String email, String nome, String cognome) {
        super(email, nome, cognome);
    }

    private String invitoTeam() {
        String messaggioPartecipante= "Abbiamo bisogno di te! Sei dei nostri?";
        return messaggioPartecipante;
    }

}
