import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hackathon {
    private String titolo;
    private String sede;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private int maxIscritti;
    private int maxPersoneInUnTeam;
    private LocalDate inizioIscrizioni;
    private LocalDate fineIscrizioni;
    private String descrizioneProblema;
    private Organizzatore organizzatore;
    private List<Giudice> giudici = new ArrayList<>();
    private List<Registrazione> iscrizioni = new ArrayList<>();
    private Problema problema;

    public Hackathon(String titolo, String sede, LocalDate dataInizio, LocalDate dataFine,
                     int maxIscritti, int maxPersoneInUnTeam, LocalDate inizioIscrizioni,
                     LocalDate fineIscrizioni, String descrizioneProblema, Organizzatore organizzatore) {
        this.titolo = titolo;
        this.sede = sede;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.maxIscritti = maxIscritti;
        this.maxPersoneInUnTeam = maxPersoneInUnTeam;
        this.inizioIscrizioni = inizioIscrizioni;
        this.fineIscrizioni = fineIscrizioni;
        this.descrizioneProblema = descrizioneProblema;
        this.organizzatore = organizzatore;
    }

    public String getTitolo() {
        return titolo;
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

    public int getmaxPersoneInUnTeam() {
        return maxPersoneInUnTeam;
    }
}
