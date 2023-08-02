import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static final List<String> NOMI = new ArrayList<>(
            Arrays.asList(
                    "Alessandro", "Federico", "Marco", "Andrea",
                    "Francesco", "Simone", "Luca", "Davide",
                    "Matteo", "Gabriele", "Giuseppe", "Antonio",
                    "Giovanni", "Roberto", "Stefano", "Riccardo",
                    "Alberto", "Filippo", "Daniele", "Fabio"
            )
    );


    public static final List<String> RUOLI = new ArrayList<>(
            Arrays.asList(
                    "Portiere",
                    "Difensore",
                    "Centrocampista",
                    "Attaccante"
            )
    );

    public static final List<String> COGNOMI = new ArrayList<String>(
            Arrays.asList(
                    "Rossi", "Bianchi", "Neri", "Verdi",
                    "Russo", "Ferrari", "Esposito", "Romano",
                    "Ricci", "Lombardi", "Moretti", "Greco",
                    "Conti", "Marino", "Giordano", "Lombardo",
                    "Mancini", "Costa", "Rizzo", "Longo"
            )
    );

    public static void main(String[] args) {
        Allenatore mario = new Allenatore(nomeRandom(NOMI, COGNOMI), dataRandom(1970, 1980), "1-5-3-2");
        Allenatore lucio = new Allenatore(nomeRandom(NOMI, COGNOMI), dataRandom(1970, 1980), "1-2-5-3");
        Squadra milan = generaSquadraRandom(NOMI, COGNOMI, RUOLI, mario);
        Squadra inter = generaSquadraRandom(NOMI, COGNOMI, RUOLI, lucio);

        System.out.println(milan);
        System.out.println(inter);

    }

    public static Squadra generaSquadraRandom(List<String> nomi, List<String> cognomi, List<String> ruoli, Allenatore allenatore) {
        List<Giocatore> giocatoriRandom = new ArrayList<>();
        String[] strategia = allenatore.getStrategia().split("-");

        for (int i = 0; i < strategia.length; i++) {
            int num = Integer.parseInt(strategia[i]);

            for (int j = 0; j < num; j++) {
                Giocatore giocatoreRandom;

                do {
                    giocatoreRandom = new Giocatore(
                            nomeRandom(nomi, cognomi),
                            dataRandom(1995, 2002),
                            ruoli.get(i)
                    );
                } while (giocatoriRandom.contains(giocatoreRandom));

                giocatoriRandom.add(giocatoreRandom);
            }
        }

        return new Squadra(giocatoriRandom, allenatore);
    }

    public static String nomeRandom(List<String> nomi, List<String> cognomi) {
        Random random = new Random();
        String nome = nomi.get(random.nextInt(0, nomi.size()));
        String cognome = cognomi.get(random.nextInt(0, cognomi.size()));

        return  nome + " " + cognome;
    }

    public static LocalDate dataRandom(int minYear, int maxYear) {
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
