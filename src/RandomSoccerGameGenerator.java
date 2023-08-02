import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSoccerGameGenerator {

    /*Fields*/
    private static final List<String> NOMI = List.of(
            "Alessandro", "Federico", "Marco", "Andrea",
            "Francesco", "Simone", "Luca", "Davide",
            "Matteo", "Gabriele", "Giuseppe", "Antonio",
            "Giovanni", "Roberto", "Stefano", "Riccardo",
            "Alberto", "Filippo", "Daniele", "Fabio"

    );


    private static final List<String> RUOLI = List.of(
            "Portiere",
            "Difensore",
            "Centrocampista",
            "Attaccante"
    );

    private static final List<String> COGNOMI = List.of(
            "Rossi", "Bianchi", "Neri", "Verdi",
            "Russo", "Ferrari", "Esposito", "Romano",
            "Ricci", "Lombardi", "Moretti", "Greco",
            "Conti", "Marino", "Giordano", "Lombardo",
            "Mancini", "Costa", "Rizzo", "Longo"
    );

    /*Public Methods*/
    public static Partita generaPartita(String nomeSquadraDiCasa, String nomeSquadraOspite) {
        return new Partita(
                generaSquadraRandom(nomeSquadraDiCasa, "1-5-4-1"),
                generaSquadraRandom(nomeSquadraOspite, "1-3-4-3"),
                arbitroRandom("Arbitro")
        );
    }

    /*Private Methods*/
    public static Squadra generaSquadraRandom(String nome, String strategia) {
        return new Squadra(nome, giocatoriRandom(strategia), allenatoreRandom(strategia));
    }

    private static List<Giocatore> giocatoriRandom(String strategia) {
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

        return giocatoriRandom;
    }

    private static Arbitro arbitroRandom(String ruolo) {
        return new Arbitro(nomeRandom(), dataRandom(1970, 1990), ruolo);
    }

    private static Allenatore allenatoreRandom(String strategia) {
        return new Allenatore(nomeRandom(), dataRandom(1970, 1990), strategia);
    }

    private static Giocatore giocatoreRandom(int ruolo) {
        return new Giocatore(nomeRandom(), dataRandom(1995, 2002), RUOLI.get(ruolo));
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
