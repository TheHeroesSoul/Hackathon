package model;

import java.time.LocalDateTime;

public class Commento {
    private Utente giudice;
    private String testo;
    private LocalDateTime data;

    public Commento(Utente giudice, String testo) {
        this.giudice = giudice;
        this.testo = testo;
        this.data = LocalDateTime.now();
    }

    public Utente getGiudice() { return giudice; }
    public String getTesto() { return testo; }
    public LocalDateTime getData() { return data; }
}