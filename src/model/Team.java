package model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int id;
    private List<Utente> membri = new ArrayList<>();
    private Hackathon hackathon;
    private List<Voto> voti = new ArrayList<>();

    public Team(int id, Hackathon hackathon) {
        this.id = id;
        this.hackathon = hackathon;
    }

    public void aggiungiMembro(Utente u) {
        if (!membri.contains(u) && puoAccettare()) {
            membri.add(u);
            System.out.println("Utente " + u.getNome() + " aggiunto al team.");
        } else {
            System.out.println("Impossibile aggiungere " + u.getNome() + ": team pieno.");
        }
    }

    public boolean puoAccettare() {
        return membri.size() < hackathon.getMaxPersoneInUnTeam();
    }

    public int getId() {
        return id;
    }

    public int getNumeroMembri() {
        return membri.size();
    }

    public Hackathon getHackathon() {
        return hackathon;
    }

    public List<Utente> getMembri() {
        return membri;
    }



}