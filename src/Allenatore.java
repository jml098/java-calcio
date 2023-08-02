import java.time.LocalDate;

public class Allenatore extends Persona{
    private String strategia;

    public Allenatore(String nome, LocalDate dataDiNascita, String strategia) {
        super(nome, dataDiNascita);
        this.strategia = strategia;
    }

    public String getStrategia() {
        return strategia;
    }

    public void setStrategia(String strategia) {
        this.strategia = strategia;
    }

    @Override
    public String toString() {
        return "Allenatore{" +
                "strategia='" + strategia + '\'' +
                "} " + super.toString();
    }
}
