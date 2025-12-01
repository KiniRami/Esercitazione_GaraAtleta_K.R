import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numAtleti = 0;
        while (numAtleti < 3) {
            System.out.print("Quanti atleti vuoi registrare? (almeno 3): ");
            numAtleti = input.nextInt();
        }

        Giudice gara = new Giudice(100); // gara fissa a 100 metri
        input.nextLine();

        for (int i = 1; i <= numAtleti; i++) {
            System.out.print("Inserisci il nome dell'atleta " + i + ": ");
            String nome = input.nextLine();
            Atleta corridore = new Atleta(nome, i, gara);
            gara.registra(corridore);
        }

        gara.avvia();
    }
}
