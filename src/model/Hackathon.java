package model;

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
    private Problema descrizioneProblema;
    private List<Giudice> giudici = new ArrayList<>();
    private List<Utente> partecipanti = new ArrayList<>();
    private List<Voto> classifica = new ArrayList<>();
    private boolean iscrizioniAperte;

    public Hackathon(int id, String titolo, String sede, LocalDate dataInizio, LocalDate dataFine,
                     int maxIscritti, int maxPersoneInUnTeam, LocalDate inizioIscrizioni) {
        this.id = id;
        this.titolo = titolo;
        this.sede = sede;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.maxIscritti = maxIscritti;
        this.maxPersoneInUnTeam = maxPersoneInUnTeam;
        this.inizioIscrizioni = inizioIscrizioni;
        this.iscrizioniAperte = false;
    }

    public void apriIscrizioni() {
        if (LocalDate.now().isAfter(inizioIscrizioni.minusDays(1)) &&
                LocalDate.now().isBefore(dataInizio.minusDays(2).plusDays(1))) {
            this.iscrizioniAperte = true;
        }
    }

    public void chiudiIscrizioni() {
        this.iscrizioniAperte = false;
    }

    public boolean isIscrizioniAperte() {
        return iscrizioniAperte;
    }

    public void aggiungiGiudice(Giudice g) {
        if (!giudici.contains(g)) {
            giudici.add(g);
        }
    }

    public void aggiungiPartecipante(Utente u) {
        if (partecipanti.size() < maxIscritti && !partecipanti.contains(u)) {
            partecipanti.add(u);
        }
    }

    public void pubblicaProblema(Problema p) {
        this.descrizioneProblema = p;
    }

    public void aggiungiVoto(Voto voto) {
        classifica.add(voto);
    }

    public List<Voto> getClassifica() {
        return classifica.stream()
                .sorted((v1, v2) -> Integer.compare(v2.getValore(), v1.getValore()))
                .toList();
    }

    public String getTitolo() {
        return titolo;
    }

    public int getMaxIscritti() {
        return maxIscritti;
    }

    public int getMaxPersoneInUnTeam() {
        return maxPersoneInUnTeam;
    }

    public Utente[] getPartecipanti() {
        return partecipanti.toArray(new Utente[partecipanti.size()]);
    }
}