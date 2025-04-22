import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hackathon {
    private String id;
    private String titolo;
    private String sede;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private int maxIscritti;
    private int maxPersoneTeam;
    private LocalDate inizioIscrizioni;
    private LocalDate fineIscrizioni;
    private Organizzatore organizzatore;
    private List<Giudice> giudici = new ArrayList<>();
    private List<Registrazione> iscrizioni = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();
    private List<Voto> classifica = new ArrayList<>();
    private Problema problema;

    public Hackathon(String id, String titolo, String sede, LocalDate dataInizio, LocalDate dataFine,
                     int maxIscritti, int maxPersoneTeam, LocalDate inizioIscrizioni,
                     LocalDate fineIscrizioni, Organizzatore organizzatore) {
        this.id = id;
        this.titolo = titolo;
        this.sede = sede;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.maxIscritti = maxIscritti;
        this.maxPersoneTeam = maxPersoneTeam;
        this.inizioIscrizioni = inizioIscrizioni;
        this.fineIscrizioni = fineIscrizioni;
        this.organizzatore = organizzatore;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getMaxPersoneTeam() {
        return maxPersoneTeam;
    }

    public void setMaxPersoneTeam(int maxPersoneTeam) {
        this.maxPersoneTeam = maxPersoneTeam;
    }

    public void aggiungiGiudice(Giudice g) {
        giudici.add(g);
    }

    public void aggiungiRegistrazione(Registrazione r) {
        iscrizioni.add(r);
    }

    public void pubblicaProblema(Problema p) {
        this.problema = p;
    }

    public int getmaxPersoneTeam() {
        return maxPersoneTeam;
    }

    public void mostraClassifica() {
        teams.sort((t1, t2) -> Double.compare(t2.calcolaMediaVoti(), t1.calcolaMediaVoti()));
        System.out.println("Classifica finale:");
        for (int i = 0; i < teams.size(); i++) {
            Team t = teams.get(i);
            System.out.printf("%d. %s - Media voto: %.2f%n", i + 1, t.getNomeTeam(), t.calcolaMediaVoti());
        }
    }
}
