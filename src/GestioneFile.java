import java.io.*;
import java.util.ArrayList;

public class GestioneFile {
String nomefile;
public GestioneFile(){
    nomefile="Classifica.txt";

}
public void leggifile(){
    File file = new File(nomefile);
    if (!file.exists()) {
        System.out.println("Nessuna classifica trovata.");
        return;
    }
    System.out.println("\nUltima classifica salvata:");
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("Fine della classifica .\n");
    } catch (IOException e) {
        System.err.println("Errore durante la lettura della classifica: " + e.getMessage());
    }
}

    public void scrivifile(ArrayList<Atleta> Podio) {
        try (FileWriter writer = new FileWriter(nomefile)) {
            writer.write("Classifica dei passaggi:\n");
            for (Atleta atleta: Podio) {
                writer.write("Giocatore " + atleta.getName() + ": " + atleta.getPassesMade() + " passaggi\n");
            }
            System.out.println("Classifica salvata nel file 'classifica.txt'.");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio della classifica: " + e.getMessage());
        }

    }
}
