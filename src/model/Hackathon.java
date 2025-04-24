package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private List<Team> teams = new ArrayList<>();
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

    // Apre le iscrizioni se la data è corretta
    public void apriIscrizioni() {
        if (LocalDate.now().isAfter(inizioIscrizioni.minusDays(1)) &&
                LocalDate.now().isBefore(dataInizio.minusDays(2).plusDays(1)) && !iscrizioniAperte) {
            this.iscrizioniAperte = true;
        }
    }

    // Chiude le iscrizioni
    public void chiudiIscrizioni() {
        this.iscrizioniAperte = false;
    }

    // Restituisce lo stato delle iscrizioni
    public boolean isIscrizioniAperte() {
        return iscrizioniAperte;
    }

    // Aggiunge un giudice se non è già presente
    public void aggiungiGiudice(Giudice g) {
        if (!giudici.contains(g)) {
            giudici.add(g);
        }
    }

    // Aggiunge un partecipante se non è già presente e non si è raggiunto il massimo
    public boolean aggiungiPartecipante(Utente u) {
        if (partecipanti.size() < maxIscritti && !partecipanti.contains(u)) {
            partecipanti.add(u);
            return true;
        }
        return false;
    }

    // Pubblica la descrizione del problema
    public void pubblicaProblema(Problema p) {
        this.descrizioneProblema = p;
    }

    // Aggiunge un team
    public void aggiungiTeam(Team t) {
        if (teams.size() < maxIscritti / maxPersoneInUnTeam) { // Limite massimo di team
            teams.add(t);
        }
    }

    // Calcola la classifica finale basata sui voti
    private Map<Team, Integer> calcolaPunteggio() {
        Map<Team, Integer> teamPunti = new HashMap<>();
        for (Team team : teams) {
            int punteggioTotale = 0;
            for (Voto voto : team.getVoti()) {
                punteggioTotale += voto.getValore();
            }
            teamPunti.put(team, punteggioTotale);
        }
        return teamPunti;
    }

    // Restituisce la classifica dei team ordinata per punteggio
    public List<Team> getClassifica() {
        Map<Team, Integer> teamPunti = calcolaPunteggio();

        List<Team> classificaGenerale = new ArrayList<>(teamPunti.keySet());
        classificaGenerale.sort((team1, team2) -> Integer.compare(teamPunti.get(team2), teamPunti.get(team1)));

        System.out.println("Classifica finale:");
        for (Team team : classificaGenerale) {
            System.out.println(team.getNome() + ": " + teamPunti.get(team) + " punti");
        }

        return classificaGenerale;
    }

    // Getter per il titolo
    public String getTitolo() {
        return titolo;
    }

    // Getter per il numero massimo di iscritti
    public int getMaxIscritti() {
        return maxIscritti;
    }

    // Getter per il numero massimo di persone in un team
    public int getMaxPersoneInUnTeam() {
        return maxPersoneInUnTeam;
    }

    public List<Giudice> getGiudici() {
        return List.copyOf(giudici);
    }

    public List<Utente> getPartecipanti() {
        return List.copyOf(partecipanti);
    }

    public List<Team> getTeams() {
        return teams;
    }
}
