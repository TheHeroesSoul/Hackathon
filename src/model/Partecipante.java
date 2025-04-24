package model;

public class Partecipante extends Utente {

    public Partecipante(int id, String username, String email, String nome, String cognome) {
        super(id, username, email, nome, cognome);
    }

    public void accettaInvito(Invito invito) {
        invito.getTeam().aggiungiMembro(this);
        System.out.println(this.getNome() + " ha accettato l'invito per il team " + invito.getTeam().getNome());
    }

    public void rifiutaInvito(Invito invito) {
        System.out.println(this.getNome() + " ha rifiutato l'invito per il team " + invito.getTeam().getNome());
    }
}