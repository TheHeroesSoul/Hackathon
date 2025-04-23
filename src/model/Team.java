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
    private List<Progresso> progressi = new ArrayList<>();

    public Team(int id, Hackathon hackathon, String nome, Utente fondatore) {
        this.id = id;
        this.hackathon = hackathon;
        this.nome = nome;
    }

    public boolean aggiungiMembro(Utente u) {
        if (!membri.contains(u) && membri.size() < hackathon.getMaxPersoneInUnTeam()) {
            membri.add(u);
            return true;
        }
        return false;
    }

    public boolean puoAccettare() {
        return membri.size() < hackathon.getMaxPersoneInUnTeam();
    }

    public void aggiungiProgresso(Progresso progresso) {
        progressi.add(progresso);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Hackathon getHackathon() {
        return hackathon;
    }

    public int getNumeroMembri() {
        return membri.size();
    }

    public List<Utente> getMembri() {
        return Collections.unmodifiableList(membri);
    }

    public List<Progresso> getProgressi() {
        return Collections.unmodifiableList(progressi);
    }

}