import java.time.LocalDate;

public class Giocatore extends Persona{
    private String ruolo;

    public Giocatore(String nome, LocalDate dataDiNascita) {
        super(nome, dataDiNascita);
    }
    public Giocatore(String nome, LocalDate dataDiNascita, String ruolo) {
        super(nome, dataDiNascita);
        this.ruolo = ruolo;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public String toString() {
        return "Giocatore{" +
                "ruolo='" + ruolo + '\'' +
                "} " + super.toString() + "\n";
    }
}
