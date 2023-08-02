import java.time.LocalDate;
import java.time.Period;

public class Persona {
    private String nome;
    private LocalDate dataDiNascita;

    public Persona(String nome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.dataDiNascita = dataDiNascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public int getEta() {
        return Period.between(LocalDate.now(), dataDiNascita).getYears();
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", dataDiNascita=" + dataDiNascita + ", " +
                "eta=" + getEta() +
                '}';
    }
}
