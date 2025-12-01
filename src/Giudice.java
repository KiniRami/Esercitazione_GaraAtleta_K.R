import java.util.*;

public class Giudice {
    public List<Atleta> iscritti = new ArrayList<>();
    public List<Atleta> classifica = new ArrayList<>();
    public double distanza;
    public GestioneFile gestore = new GestioneFile();

    public Giudice(double distanza) {
        this.distanza = distanza;
    }

    public double getDistanza() {
        return distanza;
    }

    public void registra(Atleta a) {
        iscritti.add(a);
    }

    public void avvia() {
        for (int i = 3; i >= 1; i--) {
            System.out.println("Partenza in: " + i);
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.println("");

        List<Thread> threads = new ArrayList<>();
        for (Atleta a : iscritti) {
            Thread t = new Thread(a);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    public synchronized void garaFinita(Atleta a) {
        classifica.add(a);
        if (classifica.size() == iscritti.size()) {
            terminaGara();
        }
    }

    public void terminaGara() {
        StringBuilder testo = new StringBuilder("gara terminata\n");
        for (int i = 0; i < classifica.size(); i++) {
            testo.append((i + 1) + "° posto: ").append(classifica.get(i).nome).append("\n");
        }
        System.out.println(testo.toString());

        gestore.scriviFile(testo.toString());
        System.out.println("Podio salvato nel file.");
    }
}
