package model;

public class Partecipante extends Utente {

    public Partecipante(int id, String username, String email, String nome, String cognome) {
        super(id, username, email, nome, cognome);
    }

    public void accettaInvito(Invito invito) {
        invito.accetta();
    }

    public void rifiutaInvito(Invito invito) {
        invito.rifiuta();
    }
}