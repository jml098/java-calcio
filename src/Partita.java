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

            Squadra squadraChePotrebbeSegnare =
                    random.nextBoolean() ? squadraDiCasa : squadraOspite;

            if (random.nextInt(100) < getProbabilitaDiGoal(squadraChePotrebbeSegnare)) {
                Giocatore giocatoreCheHaSegnato =
                        squadraChePotrebbeSegnare.getGiocatori().get(random.nextInt(11));

                goal(giocatoreCheHaSegnato, i);
            }
        }

        finisci();
    }

    private int getProbabilitaDiGoal(Squadra squadra) {
        if (squadra == squadraDiCasa) {
            int attaccantiCasa = Integer.parseInt(squadraDiCasa.getAllenatore().getStrategia().split("-")[3]);
            int difensoriOspite = Integer.parseInt(squadraOspite.getAllenatore().getStrategia().split("-")[1]);


            return 10 / ((difensoriOspite + attaccantiCasa) / attaccantiCasa);

        } else {
            int attaccantiOspite = Integer.parseInt(squadraOspite.getAllenatore().getStrategia().split("-")[3]);
            int difensoriCasa = Integer.parseInt(squadraDiCasa.getAllenatore().getStrategia().split("-")[1]);

            return 10 / ((difensoriCasa + attaccantiOspite) / attaccantiOspite);
        }
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

        StringBuilder marcatoriCasa = new StringBuilder(squadraDiCasa.getNome() + ":\n");
        StringBuilder marcatoriOspite = new StringBuilder(squadraOspite.getNome() + ":\n");


        for (Goal goal :
                goalSquadraDiCasa) {
            marcatoriCasa.append(goal.getMarcatore().getNome()).append(" - Minuto: ").append(goal.getMinuto()).append("\n");
        }

        for (Goal goal :
                goalSquadraOspite) {
            marcatoriOspite.append(goal.getMarcatore().getNome()).append(" - Minuto: ").append(goal.getMinuto()).append("\n");
        }

        string += marcatoriCasa + marcatoriOspite.toString();
        return string;

    }
}


