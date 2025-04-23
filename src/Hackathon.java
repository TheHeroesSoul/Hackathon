import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hackathon {
    private int id;
    private String titolo;
    private String sede;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private int maxIscritti;
    private int maxPersoneInUnTeam;
    private LocalDate inizioIscrizioni;
    private LocalDate fineIscrizioni;
    private Problema descrizioneProblema;
    private List<Giudice> giudici = new ArrayList<>();
    private List<Utente> partecipanti = new ArrayList<>();
    private List<Voto> classifica = new ArrayList<>();
    private boolean iscrizioniAperte;

    public Hackathon(int id, String titolo, String sede, LocalDate dataInizio, LocalDate dataFine,
                     int maxIscritti, int maxPersoneInUnTeam, LocalDate inizioIscrizioni,
                     LocalDate fineIscrizioni) {
        this.id = id;
        this.titolo = titolo;
        this.sede = sede;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.maxIscritti = maxIscritti;
        this.maxPersoneInUnTeam = maxPersoneInUnTeam;
        this.inizioIscrizioni = inizioIscrizioni;
        this.fineIscrizioni = fineIscrizioni;
        this.iscrizioniAperte = false;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getMaxIscritti() {
        return maxIscritti;
    }

    public int getMaxPersoneTeam() {
        return maxPersoneTeam;
    }

    public void setMaxPersoneTeam(int maxPersoneTeam) {
        this.maxPersoneTeam = maxPersoneTeam;
    }

    public void aggiungiGiudice(Giudice g) {
        if (!giudici.contains(g)) {
            giudici.add(g);
        }
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
    }
