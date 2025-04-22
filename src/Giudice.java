public class Giudice extends Utente {

    public Giudice(String username, String email, String nome, String cognome) {
        super(username, email, nome, cognome);
    }

    public void riceviInvito(Hackathon hackathon, String messaggioInvito) {
        System.out.println("Invito ricevuto per " + hackathon.getTitolo() + " " + messaggioInvito);
    }

    public void valuta(Team team, int voto) {
        System.out.println("Team valutato con " + voto + "/10");
    }
}