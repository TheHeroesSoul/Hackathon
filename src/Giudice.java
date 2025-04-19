public class Giudice extends Utente {

    public Giudice(String email, String nome, String cognome) {
        super(email, nome, cognome);
    }

    public void riceviInvito(Hackathon hackathon, String messaggioInvito) {
        System.out.println("Invito ricevuto per " + hackathon.getTitolo() + " " + messaggioInvito);
    }
}