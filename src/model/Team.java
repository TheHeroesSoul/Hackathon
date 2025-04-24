package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private int id;
    private Hackathon hackathon;
    private String nome;
    private Utente fondatore;
    private List<Utente> membri = new ArrayList<>();
    private List<Voto> voti = new ArrayList<>();
    private List<Progresso> progressi = new ArrayList<>();

    // Costruttore per creare il team con fondatore e partecipanti
    public Team(int id, Hackathon hackathon, String nome, Utente fondatore, List<Partecipante> partecipanti) {
        this.id = id;
        this.hackathon = hackathon;
        this.nome = nome;
        this.fondatore = fondatore;
        this.membri.add(fondatore);  // Aggiungiamo il fondatore ai membri del team

        // Aggiungiamo i partecipanti
        for (Partecipante p : partecipanti) {
            this.membri.add(p);
        }
        hackathon.aggiungiTeam(this);  // Aggiungi il team all'hackathon
    }

    // Metodo per aggiungere un membro al team
    public void aggiungiMembro(Partecipante utente) {
        if (utente.equals(fondatore)) {
            System.out.println(utente.getNome() + " è già fondatore di un altro team, non può essere aggiunto come membro.");
            return;
        }

        if (!membri.contains(utente)) {
            membri.add(utente);
            System.out.println(utente.getNome() + " aggiunto con successo al team " + nome);
        } else {
            System.out.println(utente.getNome() + " è già membro del team.");
        }
    }

    // Verifica se il team può accettare nuovi membri
    public boolean puoAccettare() {
        return membri.size() < hackathon.getMaxPersoneInUnTeam();
    }

    // Metodo per aggiungere un progresso del team
    public void aggiungiProgresso(Progresso p) {
        progressi.add(p);
    }

    // Getter per l'id del team
    public int getId() {
        return id;
    }

    // Getter per il nome del team
    public String getNome() {
        return nome;
    }

    // Getter per l'hackathon a cui appartiene il team
    public Hackathon getHackathon() {
        return hackathon;
    }

    // Getter per il numero di membri nel team
    public int getNumeroMembri() {
        return membri.size();
    }

    // Getter per i membri del team
    public List<Utente> getMembri() {
        return Collections.unmodifiableList(membri);
    }

    // Getter per i voti del team
    public List<Voto> getVoti() {
        return voti;
    }

    // Getter per i progressi del team
    public List<Progresso> getProgressi() {
        return Collections.unmodifiableList(progressi);
    }
}