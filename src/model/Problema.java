package model;

public class Problema {
    private String descrizione;
    private Hackathon hackathon;

    public Problema(String descrizione, Hackathon hackathon, Giudice giudice) {
        this.descrizione = descrizione;
        this.hackathon = hackathon;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Hackathon getHackathon() {
        return hackathon;
    }

    public void setHackathon(Hackathon hackathon) {
        this.hackathon = hackathon;
    }
}