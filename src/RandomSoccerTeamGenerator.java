import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomSoccerTeamGenerator {

    private static final List<String> NOMI = new ArrayList<>(
            Arrays.asList(
                    "Alessandro", "Federico", "Marco", "Andrea",
                    "Francesco", "Simone", "Luca", "Davide",
                    "Matteo", "Gabriele", "Giuseppe", "Antonio",
                    "Giovanni", "Roberto", "Stefano", "Riccardo",
                    "Alberto", "Filippo", "Daniele", "Fabio"
            )
    );


    private static final List<String> RUOLI = new ArrayList<>(
            Arrays.asList(
                    "Portiere",
                    "Difensore",
                    "Centrocampista",
                    "Attaccante"
            )
    );

    private static final List<String> COGNOMI = new ArrayList<String>(
            Arrays.asList(
                    "Rossi", "Bianchi", "Neri", "Verdi",
                    "Russo", "Ferrari", "Esposito", "Romano",
                    "Ricci", "Lombardi", "Moretti", "Greco",
                    "Conti", "Marino", "Giordano", "Lombardo",
                    "Mancini", "Costa", "Rizzo", "Longo"
            )
    );

    public static Squadra generaSquadraRandom(String strategia) {
        List<Giocatore> giocatoriRandom = new ArrayList<>();
        String[] strategiaSquadra = strategia.split("-");

        for (int i = 0; i < strategiaSquadra.length; i++) {
            int num = Integer.parseInt(strategiaSquadra[i]);

            for (int j = 0; j < num; j++) {
                Giocatore giocatoreRandom;

                do {
                    giocatoreRandom = giocatoreRandom(i);
                } while (giocatoriRandom.contains(giocatoreRandom));

                giocatoriRandom.add(giocatoreRandom);
            }
        }

        return new Squadra(giocatoriRandom, allenatoreRandom(strategia));
    }

    private static Allenatore allenatoreRandom(String strategia) {
        return new Allenatore(nomeRandom(), dataRandom(1970, 1990), strategia);
    }

    private static Giocatore giocatoreRandom(int ruolo) {
        Giocatore giocatoreRandom;

        giocatoreRandom = new Giocatore(
                nomeRandom(),
                dataRandom(1995, 2002),
                RUOLI.get(ruolo)
        );

        return giocatoreRandom;
    }

    private static String nomeRandom() {
        Random random = new Random();
        String nome = NOMI.get(random.nextInt(0, NOMI.size()));
        String cognome = COGNOMI.get(random.nextInt(0, COGNOMI.size()));

        return nome + " " + cognome;
    }

    private static LocalDate dataRandom(int minYear, int maxYear) {
        long minDay =
                LocalDate.of(minYear, 1, 1)
                        .toEpochDay();

        long maxDay =
                LocalDate.of(maxYear, 12, 31)
                        .toEpochDay();

        long randomDay = new Random().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

}
