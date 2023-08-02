import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Partita partita = RandomSoccerGameGenerator.generaPartita("Milan", "Inter");

        partita.inizia();

        Random random = new Random();
        for (int i = 0; i < 90; i++) {

            if (random.nextInt(100) < 10) {
                Giocatore giocatoreCheHaSegnato;

                if (random.nextInt(2) == 1) {
                    List<Giocatore> giocatoriSquadraDiCasa = partita.getSquadraDiCasa().getGiocatori();
                    giocatoreCheHaSegnato = giocatoriSquadraDiCasa.get(random.nextInt(giocatoriSquadraDiCasa.size()));
                } else {
                    List<Giocatore> giocatoriSquadraOspite = partita.getSquadraOspite().getGiocatori();
                    giocatoreCheHaSegnato = giocatoriSquadraOspite.get(random.nextInt(giocatoriSquadraOspite.size()));
                }


                partita.goal(giocatoreCheHaSegnato, i);
            }
        }

        partita.finisci();

        System.out.println(partita);

    }
}

