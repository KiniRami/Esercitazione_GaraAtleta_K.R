import java.util.Random;

public class Atleta implements Runnable {
     int numero;
    String nome;
    double metri = 0;
    static final double LUNGHEZZA_GARA = 50.0;

    public Atleta(int pNumero, String pNome) {
        this.numero = pNumero;
        this.nome = pNome;
        Giudice.aggiungimi(this);
    }

    @Override
    public void run() {
        Random metriPercorsi = new Random();
        while (metri <= LUNGHEZZA_GARA) {
            metri += metriPercorsi.nextDouble(10);
            System.out.println(nome + " Metri Percorsi: " + metri);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Errore sleep");
            }
        }
        Giudice.finito(this);
    }
}