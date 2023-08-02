import java.util.List;

public class Squadra {
    private String nome;
    private final List<Giocatore> giocatori;
    private Allenatore allenatore;

    public Squadra(String nome, List<Giocatore> giocatori, Allenatore allenatore) {
        this.nome = nome;
        this.giocatori = giocatori;
        this.allenatore = allenatore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Allenatore getAllenatore() {
        return allenatore;
    }

    public void setAllenatore(Allenatore allenatore) {
        this.allenatore = allenatore;
    }

    public List<Giocatore> getGiocatori() {
        return giocatori;
    }

    @Override
    public String toString() {
        return "Squadra{" +
                "giocatori=" + "\n" + giocatori +
                ", allenatore=" + allenatore + '\'' +
                '}';
    }
}
