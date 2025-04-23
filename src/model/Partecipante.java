package model;

public class Partecipante extends Utente {

    public Partecipante(int id, String username, String email, String nome, String cognome) {
        super(id, username, email, nome, cognome);
    }

    public void acceptInvito(Invito invito) {
        invito.accetta();
    }

    public void refuseInvito(Invito invito) {
        invito.rifiuta();
    }
}