public class Main {
    public static void main(String[] args) {
        Squadra milan = RandomSoccerTeamGenerator.generaSquadraRandom("1-5-3-2");
        Squadra inter = RandomSoccerTeamGenerator.generaSquadraRandom("1-2-5-3");

        System.out.println(milan);
        System.out.println(inter);
    }
}
