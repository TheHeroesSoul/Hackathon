package model;

import model.Commento;

import java.time.LocalDateTime;
import java.util.*;

public class Progresso {
    private Team team;
    private LocalDateTime data;
    private String documento;
    private List<Commento> commentiGiudici = new ArrayList<Commento>();

    public Progresso(Team team, String documento) {
        this.team = team;
        this.data = LocalDateTime.now();
        this.documento = documento;
    }

    public void aggiungiCommento(Commento commento) {
        commentiGiudici.add(commento);
    }

}