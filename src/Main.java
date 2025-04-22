import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crea un hackathon
        Organizzatore org = new Organizzatore("1", "mario@example.com", "Mario", "Rossi");
        LocalDate dataInizio = LocalDate.of(2025, 4, 23);
        LocalDate dataFine = LocalDate.of(2025, 4, 24);
        LocalDate inizioIscrizioni = dataInizio.minusDays(3);
        LocalDate fineIscrizioni = dataInizio.minusDays(1);

        Hackathon hackathon = new Hackathon(
                "H01",
                "CodeFest",
                "Milano",
                dataInizio,
                dataFine,
                100,
                4,
                inizioIscrizioni,
                fineIscrizioni,
                org
        );

        // Crea utenti e team
        Utente u1 = new Utente("2", "giulia@example.com", "Giulia", "Rossi");
        Team team = new Team("T1", "Team76", hackathon);
        team.aggiungiMembro(u1);

        // Giudici e voti
        Giudice g1 = new Giudice("3", "luca@example.com", "Luca", "Rossi");
        Giudice g2 = new Giudice("4", "sara@example.com", "Sara", "Rossi");

        team.aggiungiVoto(new Voto(9, g1, team));
        team.aggiungiVoto(new Voto(7, g1, team));

        System.out.println("Media voti: " + team.calcolaMediaVoti());
    }
}