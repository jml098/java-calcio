import java.util.ArrayList;
import java.util.List;

public class Squadra {
    private List<Giocatore> giocatori = new ArrayList<>();
    private Allenatore allenatore;

    public Squadra(Allenatore allenatore) {
        this.allenatore = allenatore;
    }

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
