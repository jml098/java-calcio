public class Main {
    public static void main(String[] args) {
        Partita partita = RandomSoccerGameGenerator.generaPartita("Milan", "Inter");

        partita.simula();

        System.out.println(partita);

    }
}

