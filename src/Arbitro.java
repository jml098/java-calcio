import java.time.LocalDate;

public class Arbitro extends Persona {
    private String ruolo;

    public Arbitro(String nome, LocalDate dataDiNascita, String ruolo) {
        super(nome, dataDiNascita);
        this.ruolo = ruolo;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
}


