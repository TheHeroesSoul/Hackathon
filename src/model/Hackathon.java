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

    public void apriIscrizioni() {
        if (LocalDate.now().isAfter(inizioIscrizioni.minusDays(1)) &&
                LocalDate.now().isBefore(dataInizio.minusDays(2).plusDays(1)) && !iscrizioniAperte) {
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

    public boolean aggiungiPartecipante(Utente u) {
        if (partecipanti.size() < maxIscritti && !partecipanti.contains(u)) {
            partecipanti.add(u);
            return true;
        }
        return false;
    }

    public void pubblicaProblema(Problema p) {
        this.descrizioneProblema = p;
    }

    public void aggiungiTeam(Team t) {
        if (teams.size() < maxIscritti / maxPersoneInUnTeam) { // Limite massimo di team
            teams.add(t);
        }
    }

/*    private Map<Team, Integer> calcolaPunteggio() {
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

    public List<Team> getClassifica() {
        Map<Team, Integer> teamPunti = calcolaPunteggio();

        List<Team> classificaGenerale = new ArrayList<>(teamPunti.keySet());
        classificaGenerale.sort((team1, team2) -> Integer.compare(teamPunti.get(team2), teamPunti.get(team1)));

        System.out.println("Classifica finale:");
        for (Team team : classificaGenerale) {
            System.out.println(team.getNome() + ": " + teamPunti.get(team) + " punti");
        }

        return classificaGenerale;
    }*/

    public String getTitolo() {
        return titolo;
    }

    public int getMaxIscritti() {
        return maxIscritti;
    }

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
