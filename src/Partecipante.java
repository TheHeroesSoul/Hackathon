public class Partecipante extends Utente {



    public Partecipante(String email, String nome, String cognome) {
        super(email, nome, cognome);
    }

    private String invitoTeam() {
        return String messaggioPartecipante("Abbiamo bisogno di te! Sei dei nostri?");
    }

    private String messaggioPartecipante(String s) {
    }


}
