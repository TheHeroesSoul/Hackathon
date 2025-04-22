import java.time.LocalDateTime;
import java.util.*;

public class Progresso {
    private Team team;
    private LocalDateTime data;
    private String documento;
    private List<Commento> commentiGiudici = new ArrayList<Commento>();

    public Progresso(String documento) {
        this.data = LocalDateTime.now();
        this.documento = documento;
    }

    public void aggiungiCommento(Commento commento) {
        commentiGiudici.add(commento);
    }
}