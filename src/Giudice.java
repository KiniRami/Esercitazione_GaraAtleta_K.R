import java.util.ArrayList;

public class Giudice extends Thread {
    private static int numero;
    private static ArrayList<Atleta> Atleti = new ArrayList<>();
    private static ArrayList<Atleta> Podio = new ArrayList<>();
    private static GestioneFile gf = new GestioneFile();



    public static void aggiungimi(Atleta a) {
        Atleti.add(a);
    }

    public static void finito(Atleta a) {
        Podio.add(a);
        if (Podio.size() == Atleti.size()) {
            fineGara();

        }
    }

    public static void fineGara() {
        System.out.println("Gara Terminata! Ecco il Podio:");
        System.out.println("Primo in classifica: " + Podio.get(0).nome);
        System.out.println("Secondo in classifica: " + Podio.get(1).nome);
        System.out.println("Terzo in classifica: " + Podio.get(2).nome);
        gf.scrivifile(Podio);
        gf.leggifile();

    }

    public static void avviaGara() {
        for (int i = 3; i > 0; i--) {
            System.out.println("Inizio in " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Errore sleep");
            }
        }

        System.out.println("VIA!!!");

        for (Atleta a : Atleti) {
            new Thread(a).start();
        }
    }

}
