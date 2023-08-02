public class Goal {
    private Giocatore marcatore;
    private int minuto;

    public Goal(Giocatore marcatore, int minuto) {
        this.marcatore = marcatore;
        this.minuto = minuto;
    }

    public Giocatore getMarcatore() {
        return marcatore;
    }

    public int getMinuto() {
        return minuto;
    }
}
