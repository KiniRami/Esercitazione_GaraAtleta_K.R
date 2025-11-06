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
        //l'atleta avvisa che partecipa alla gara
        while (metri <= LUNGHEZZAGARA){
            //ogni secondo devi generare un numero random di metri percorsi mertripercorsi
            Random metripercorsi = new random
            //e usare sleep
            //aggiungere questo numero a metri
        }
        //l'atleta comunica che ha finito di correre
        //l'atleta verifica se ha vinto (Giudice giudice.verifica())
    }
}
