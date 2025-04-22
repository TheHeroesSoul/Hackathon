public class Voto {
    private int valore;
    private Utente giudice;
    private Team team;

    public Voto(int valore, Utente giudice, Team team) {
        this.valore = valore;
        this.giudice = giudice;
        this.team = team;
    }
}