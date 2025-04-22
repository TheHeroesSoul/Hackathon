public class Voto {
    private int valore;
    private Giudice giudice;
    private Team team;

    public Voto(int valore, Giudice giudice, Team team) {
        this.valore = valore;
        this.giudice = giudice;
        this.team = team;
    }
}