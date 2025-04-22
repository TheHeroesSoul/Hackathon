import java.time.LocalDateTime;
import java.util.*;

public class Progresso {
    private LocalDateTime data;
    private String documento;
    private List<String> commentiGiudici = new ArrayList<>();

    public Progresso(String documento) {
        this.data = LocalDateTime.now();
        this.documento = documento;
    }

    public void aggiungiCommento(String commento) {
        commentiGiudici.add(commento);
    }
}