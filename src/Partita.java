import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Partita {
    private Squadra squadraDiCasa;
    private Squadra squadraOspite;
    private Arbitro arbitro;

    private boolean iniziata = false;
    private List<Goal> goalSquadraDiCasa = new ArrayList<>();
    private List<Goal> goalSquadraOspite = new ArrayList<>();

    public Partita(Squadra squadraDiCasa, Squadra squadraOspite, Arbitro arbitro) {
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.arbitro = arbitro;
    }

    public Squadra getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public Squadra getSquadraOspite() {
        return squadraOspite;
    }

    public void inizia() {
        iniziata = true;
    }

    public void simula() {
        inizia();

        Random random = new Random();
        for (int i = 0; i < 90; i++) {

            if (random.nextInt(100) < 10) {
                Giocatore giocatoreCheHaSegnato;

                if (random.nextInt(2) == 1) {
                    List<Giocatore> giocatoriSquadraDiCasa = getSquadraDiCasa().getGiocatori();
                    giocatoreCheHaSegnato = giocatoriSquadraDiCasa.get(random.nextInt(giocatoriSquadraDiCasa.size()));
                } else {
                    List<Giocatore> giocatoriSquadraOspite = getSquadraOspite().getGiocatori();
                    giocatoreCheHaSegnato = giocatoriSquadraOspite.get(random.nextInt(giocatoriSquadraOspite.size()));
                }


                goal(giocatoreCheHaSegnato, i);
            }
        }

        finisci();
    }

    public void finisci() {
        iniziata = false;
    }

    public String getRisultato() {
        return goalSquadraDiCasa.size() + " - " + goalSquadraOspite.size();
    }

    public void goal(Giocatore giocatore, int minuto) throws PartitaNonIniziataException {
        if (!iniziata) throw new PartitaNonIniziataException("La partita non è ancora iniziata!");

        if (squadraDiCasa.getGiocatori().contains(giocatore)) goalSquadraDiCasa.add(new Goal(giocatore, minuto));
        else goalSquadraOspite.add(new Goal(giocatore, minuto));
    }

    @Override
    public String toString() {
        String string = "Partita " + squadraDiCasa.getNome() + " - " + squadraOspite.getNome() + "\n" +
                "Risultato: " + getRisultato() + "\n";

        String marcatoriCasa = squadraDiCasa.getNome() + ":\n";
        String marcatoriOspite = squadraOspite.getNome() + ":\n";


        for (Goal goal :
                goalSquadraDiCasa) {
            marcatoriCasa += goal.getMarcatore().getNome() + " - Minuto: " + goal.getMinuto() + "\n";
        }

        for (Goal goal :
                goalSquadraOspite) {
            marcatoriOspite += goal.getMarcatore().getNome() + " - Minuto: " + goal.getMinuto()+ "\n";
        }

        string += marcatoriCasa + marcatoriOspite;
        return string;

    }
}


