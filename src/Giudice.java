public class Giudice extends Utente {

    public Giudice(String id, String username, String email, String nome, String cognome) {
        super(id, username, email, nome, cognome);
    }

    public void selezionato(Hackathon hackathon) {
        System.out.println("Sei stato selezionato come giudice per l'hackathon: " + hackathon.getTitolo());
    }

    public void commentaProgresso(Progresso progresso, String testo) {
        Commento commento = new Commento(this, testo);
        progresso.aggiungiCommento(commento);
    }
}