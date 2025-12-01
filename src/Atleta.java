import java.util.Random;

public class Atleta implements Runnable {
    public Giudice giudice;
    public String nome;
    public double metri;
    public int secondi;

    // Anomalie
    public boolean scarpaSlacciata;
    public int secondiFermo;
    public int contatoreFermo;

    public boolean follaEsulta;
    public int secondiFolla;
    public int contatoreFolla;

    public boolean ventoContrario;
    public int contatoreVento;

    public Random rand = new Random();

    public Atleta(String nome, int numero, Giudice giudice) {
        this.nome = nome;
        this.giudice = giudice;
        this.metri = 0;
        this.secondi = 0;

        //anomalie
        this.scarpaSlacciata = false;
        this.follaEsulta = false;
        this.ventoContrario = false;

        this.contatoreFermo = 0;
        this.contatoreFolla = 0;
        this.contatoreVento = 0;
    }

    @Override
    public void run() {
        final double DISTANZA = 100.0;

        while (metri < DISTANZA) {
            
            if (!scarpaSlacciata && rand.nextInt(100) < 10) {
                scarpaSlacciata = true;
                secondiFermo = rand.nextBoolean() ? 1 : 2;
                contatoreFermo = 0;
                System.out.println(nome + " ha la scarpa slacciata! Fermo per " + secondiFermo + " secondo/i.");
            }

            if (!follaEsulta && rand.nextInt(100) < 15) {
                follaEsulta = true;
                secondiFolla = 2;
                contatoreFolla = 0;
                System.out.println(nome + " è distratto dalla folla! Sarà più lento per 2 secondi.");
            }

            if (!ventoContrario && rand.nextInt(100) < 5) {
                ventoContrario = true;
                contatoreVento = 0;
                System.out.println(nome + " affronta vento contrario! Avanza a fatica.");
            }

         //gestione di anomalie
            double avanzamento = 0;

            if (scarpaSlacciata) {
                contatoreFermo++;
                System.out.println(nome + " sistema la scarpa... (" + contatoreFermo + "/" + secondiFermo + ")");
                if (contatoreFermo >= secondiFermo) {
                    scarpaSlacciata = false;
                    System.out.println(nome + " riparte!");
                }
                // non avanza
            } else if (ventoContrario && contatoreVento == 0) {
                // Solo per 1 secondo
                avanzamento = rand.nextDouble(1, 2);
                contatoreVento++;
                ventoContrario = false; // finisce dopo questo secondo
            } else if (follaEsulta) {
                contatoreFolla++;
                avanzamento = rand.nextDouble(3, 4); 
                if (contatoreFolla >= secondiFolla) {
                    follaEsulta = false;
                    System.out.println(nome + " si concentra di nuovo!");
                }
            } else {
                
                avanzamento = rand.nextDouble(5, 8);
            }

            if (!scarpaSlacciata) {
                metri += avanzamento;
                if (metri > DISTANZA) metri = DISTANZA;
                System.out.printf("%s - Metri: %.2f\n", nome, metri);
            }

            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            secondi++;
        }

        System.out.println(nome + " ha finito la gara!");
        giudice.garaFinita(this);
    }
}
