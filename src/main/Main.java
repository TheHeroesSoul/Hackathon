package main;

import model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Organizzatore org = new Organizzatore(45, "org1", "org@email.com", "Elena", "Esposito");

        Hackathon hackathon = org.creaHackathon(
                1,
                "AI Challenge",
                "Napoli",
                LocalDate.now().plusDays(5),
                LocalDate.now().plusDays(7),
                10,
                3,
                LocalDate.now()
        );

        Giudice giudice1 = new Giudice(1, "giudice1", "g1@email.com", "Luca", "Rossi");
        Giudice giudice2 = new Giudice(2, "giudice2", "g2@email.com", "Anna", "Verdi");

        hackathon.aggiungiGiudice(giudice1);
        hackathon.aggiungiGiudice(giudice2);

        giudice1.selezionato(hackathon);
        giudice2.selezionato(hackathon);

        Partecipante p1 = new Partecipante(10, "utente1", "u1@email.com", "Marco", "Bianchi");
        Partecipante p2 = new Partecipante(11, "utente2", "u2@email.com", "Sara", "Neri");
        Partecipante p3 = new Partecipante(12, "utente3", "u3@email.com", "Davide", "Gallo");
        Partecipante p4 = new Partecipante(13, "utente4", "u4@email.com", "Giuseppe", "Verdi");

        hackathon.apriIscrizioni();
        if (hackathon.isIscrizioniAperte()) {
            hackathon.aggiungiPartecipante(p1);
            hackathon.aggiungiPartecipante(p2);
            hackathon.aggiungiPartecipante(p3);
            hackathon.aggiungiPartecipante(p4);
        }

        System.out.println("Partecipanti registrati:");
        for (Utente u : hackathon.getPartecipanti()) {
            System.out.println("- " + u.getNome() + " " + u.getCognome());
        }

        Problema problema = new Problema("Sviluppa un'app AI per la sostenibilità", hackathon, giudice1);
        hackathon.pubblicaProblema(problema);

        System.out.println("Problema pubblicato: " + problema.getDescrizione());

        Team team1 = new Team(1, hackathon, "Invincibili", p2);
        team1.aggiungiMembro(p3);

        Team team2 = new Team(2, hackathon, "Nerdissimi", p1);
        team2.aggiungiMembro(p4);

        Progresso prog1 = new Progresso(team1, "Versione 1.0 progetto AI.pdf");
        Progresso prog2 = new Progresso(team2, "Modello predittivo finale.zip");

        team1.aggiungiProgresso(prog1);
        team2.aggiungiProgresso(prog2);

        giudice1.commentaProgresso(prog1, "Buona struttura, migliorare output.");
        giudice2.commentaProgresso(prog2, "Ottima accuratezza del modello!");

        hackathon.aggiungiVoto(new Voto(giudice1, team1, 9));
        hackathon.aggiungiVoto(new Voto(giudice2, team2, 8));

        System.out.println("Classifica:");
        for (Voto v : hackathon.getClassifica()) {
            System.out.println("Team: " + v.getTeam().getNome() +
                    " | Giudice: " + v.getGiudice().getNome() +
                    " | Voto: " + v.getValore());
        }

        System.out.println("Commenti su progressi:");
        for (Commento c : prog1.getCommentiGiudici()) {
            System.out.println("- [" + c.getData() + "] " + c.getGiudice().getNome() + ": " + c.getTesto());
        }
    }
}