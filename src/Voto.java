public class Voto {
    private Giudice giudice;
    private Team team;
    private int valore;

    public Voto(Giudice giudice, Team team, int valore) {
        this.giudice = giudice;
        this.team = team;
        this.valore = valore;
    }
}