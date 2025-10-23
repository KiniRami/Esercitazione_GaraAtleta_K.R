import java.util.Scanner;

public class Atleta implements Runnable {
    int numero;
    String nome;
    double tempo = 0;
    double metri = 0;
    final double LUNGHEZZAGARA = 40000;

    public Atleta(int pNumero, String pNome){
        numero = pNumero;
        nome = pNome;
    }
    @Override
    public void run(){
        while (metri <= LUNGHEZZAGARA){
            Scanner metriPercorsi;

        }
    }
}
