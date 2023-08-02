import java.util.ArrayList;
import java.util.List;

public class Squadra {
    private final List<Giocatore> giocatori;
    private Allenatore allenatore;

    public Squadra(List<Giocatore> giocatori, Allenatore allenatore) {
        this.giocatori = giocatori;
        this.allenatore = allenatore;
    }

    public Allenatore getAllenatore() {
        return allenatore;
    }

    public void setAllenatore(Allenatore allenatore) {
        this.allenatore = allenatore;
    }

    @Override
    public String toString() {
        return "Squadra{" +
                "giocatori=" + "\n" + giocatori +
                ", allenatore=" + allenatore + '\'' +
                '}';
    }
}
