package main;

import model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Hackathon hackathon = new Hackathon(
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

        Partecipante p1 = new Partecipante(10, "utente1", "u1@email.com", "Marco", "Bianchi");
        Partecipante p2 = new Partecipante(11, "utente2", "u2@email.com", "Sara", "Neri");
        Partecipante p3 = new Partecipante(12, "utente3", "u3@email.com", "Davide", "Gallo");

        hackathon.apriIscrizioni();

        if (hackathon.isIscrizioniAperte()) {
            hackathon.aggiungiPartecipante(p1);
            hackathon.aggiungiPartecipante(p2);
            hackathon.aggiungiPartecipante(p3);
        }

        System.out.println("Partecipanti registrati:");
        for (Utente u : hackathon.getPartecipanti()) {
            System.out.println("- " + u.getNome() + " " + u.getCognome());
        }

        Problema problema = new Problema("Sviluppa un'app AI per la sostenibilità", hackathon, giudice1);
        hackathon.pubblicaProblema(problema);

        System.out.println("Il problema da risolvere è " + ": " + problema.getDescrizione());

        Team team = new Team(1, hackathon);
        team.aggiungiMembro(p2);
        team.aggiungiMembro(p3);

        Team team2 = new Team(2, hackathon);
        team2.aggiungiMembro(p1);

        hackathon.aggiungiVoto(new Voto(giudice1, team, 10));
        hackathon.aggiungiVoto(new Voto(giudice2, team2, 8));

        System.out.println("\n🏆 Classifica:");
        for (Voto v : hackathon.getClassifica()) {
            System.out.println("Team: " + v.getTeam().getId() +
                    " | Giudice: " + v.getGiudice().getNome() +
                    " | Voto: " + v.getValore());
        }
    }
}