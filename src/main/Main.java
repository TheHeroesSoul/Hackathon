import model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Organizzatore org = new Organizzatore(45, "org1", "org@email.com", "Francesco", "Maresca");

        // Crea un hackathon
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

        // Crea giudici
        Giudice giudice1 = new Giudice(1, "giudice1", "g1@email.com", "Luca", "Rossi");
        Giudice giudice2 = new Giudice(2, "giudice2", "g2@email.com", "Anna", "Verdi");

        hackathon.aggiungiGiudice(giudice1);
        hackathon.aggiungiGiudice(giudice2);

        giudice1.selezionato(hackathon);
        giudice2.selezionato(hackathon);

        // Crea partecipanti
        Partecipante p1 = new Partecipante(10, "utente1", "u1@email.com", "Marco", "Bianchi");
        Partecipante p2 = new Partecipante(11, "utente2", "u2@email.com", "Sara", "Neri");
        Partecipante p3 = new Partecipante(12, "utente3", "u3@email.com", "Davide", "Gallo");
        Partecipante p4 = new Partecipante(13, "utente4", "u4@email.com", "Giuseppe", "Verdi");
        Partecipante p5 = new Partecipante(14, "utente5", "u5@email.com", "Lucia", "Conti");
        Partecipante p6 = new Partecipante(15, "utente6", "u6@email.com", "Federico", "Esposito");
        Partecipante p7 = new Partecipante(16, "utente7", "u7@email.com", "Alessia", "Moretti");
        Partecipante p8 = new Partecipante(17, "utente8", "u8@email.com", "Giorgio", "Leone");
        Partecipante p9 = new Partecipante(18, "utente9", "u9@email.com", "Martina", "Fiore");

        // Apertura iscrizioni
        hackathon.apriIscrizioni();
        if (hackathon.isIscrizioniAperte()) {
            hackathon.aggiungiPartecipante(p1);
            hackathon.aggiungiPartecipante(p2);
            hackathon.aggiungiPartecipante(p3);
            hackathon.aggiungiPartecipante(p4);
            hackathon.aggiungiPartecipante(p5);
            hackathon.aggiungiPartecipante(p6);
            hackathon.aggiungiPartecipante(p7);
            hackathon.aggiungiPartecipante(p8);
            hackathon.aggiungiPartecipante(p9);
        }

        System.out.println("Partecipanti registrati:");
        for (Utente u : hackathon.getPartecipanti()) {
            System.out.println("- " + u.getNome() + " " + u.getCognome());
        }

        // Creazione dei team
        Team team1 = new Team(1, hackathon, "Invincibili", p2);
        team1.aggiungiMembro(p3);

        Team team2 = new Team(2, hackathon, "Nerdissimi", p1);
        team2.aggiungiMembro(p4);

        Team team3 = new Team(3, hackathon, "Smanettoni", p6);
        team3.aggiungiMembro(p5);

        // Aggiungi team all'hackathon
        hackathon.aggiungiTeam(team1);
        hackathon.aggiungiTeam(team2);
        hackathon.aggiungiTeam(team3);

        // Rimozione di un team (ad esempio team2)
        hackathon.rimuoviTeam(team2);

        // Gestione classifica: elimina i voti per i team rimossi
        hackathon.getClassifica().removeIf(voto -> voto.getTeam() != null && voto.getTeam().equals(team2));

        // Gestione commenti sui progressi: elimina i commenti per i team rimossi
        hackathon.getProgressi().forEach(progress -> {
            if (progress.getTeam().equals(team2)) {
                progress.getCommentiGiudici().clear();
            }
        });

        // Visualizza i team dopo la rimozione
        System.out.println("Team attivi:");
        for (Team team : hackathon.getTeams()) {
            System.out.println("Team: " + team.getNome());
        }

        // Inviti tra partecipanti
        Invito invito1 = new Invito(p6, p2, team3, "Ci serve il tuo aiuto!");
        p2.accettaInvito(invito1);
        System.out.println("Stato invito a Sara: " + invito1.getStato());

        Team team4 = new Team(4, hackathon, "DreamTeam", p3);
        Invito invito2 = new Invito(p3, p2, team4, "Vuoi unirti al DreamTeam?");
        p2.rifiutaInvito(invito2);
        System.out.println("Stato invito rifiutato: " + invito2.getStato());

        Invito invito3 = new Invito(p3, p1, team4, "Ti aspettiamo!");
        p1.accettaInvito(invito3);
        System.out.println("Stato invito accettato: " + invito3.getStato());

        // Creazione del team finale
        Team team5 = new Team(5, hackathon, "OverFlow", p7);
        team5.aggiungiMembro(p8);
        team5.aggiungiMembro(p9);
        team5.aggiungiMembro(p1);

        // Visualizza membri finali dei team
        Team[] teams = {team1, team3, team4, team5};
        System.out.println("Membri finali dei team:");
        for (Team t : teams) {
            System.out.println("Team " + t.getNome() + ":");
            for (Utente u : t.getMembri()) {
                System.out.println("- " + u.getNome());
            }
        }

        // Pubblicazione dei problemi
        Problema problema = new Problema("Sviluppa un'app AI per la sostenibilità", hackathon, giudice1);
        hackathon.pubblicaProblema(problema);
        System.out.println("Problema pubblicato: " + problema.getDescrizione());

        // Creazione dei progressi
        Progresso prog1 = new Progresso(team1, "Versione 1.0 progetto AI.pdf");
        Progresso prog2 = new Progresso(team3, "Modello finale.zip");
        Progresso prog3 = new Progresso(team4, "Soluzione completa AI.pdf");
        Progresso prog4 = new Progresso(team5, "OverFlow.zip");

        team1.aggiungiProgresso(prog1);
        team3.aggiungiProgresso(prog2);
        team4.aggiungiProgresso(prog3);
        team5.aggiungiProgresso(prog4);

        // Commenti sui progressi
        giudice1.commentaProgresso(prog1, "Buona struttura, migliorare output.");
        giudice2.commentaProgresso(prog2, "Ottima accuratezza del modello!");
        giudice1.commentaProgresso(prog3, "Buon lavoro, ottima organizzazione.");
        giudice2.commentaProgresso(prog4, "Creatività interessante!");

        // Voti per i team
        hackathon.aggiungiVoto(new Voto(giudice1, team1, 9));
        hackathon.aggiungiVoto(new Voto(giudice2, team3, 10));
        hackathon.aggiungiVoto(new Voto(giudice1, team4, 7));
        hackathon.aggiungiVoto(new Voto(giudice2, team5, 8));

        // Visualizzazione classifica
        System.out.println("Classifica:");
        for (Voto v : hackathon.getClassifica()) {
            if (v.getTeam() != null) {
                System.out.println("Team: " + v.getTeam().getNome() +
                        " | Giudice: " + v.getGiudice().getNome() +
                        " | Voto: " + v.getValore());
            }
        }

        // Commenti finali sui progressi
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Commenti su tutti i progressi:");
        Progresso[] tuttiProgressi = {prog1, prog2, prog3, prog4};
        for (Progresso p : tuttiProgressi) {
            System.out.println("Team: " + p.getTeam().getNome());
            for (Commento c : p.getCommentiGiudici()) {
                String dataFormattata = c.getData().format(formatter);
                System.out.println("- [" + dataFormattata + "] " + c.getGiudice().getNome() + ": " + c.getTesto());
            }
            System.out.println();
        }
    }
}
