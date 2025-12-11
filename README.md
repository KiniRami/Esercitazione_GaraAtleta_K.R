nel mio codice ho fatto
1)Multithreading: La simulazione sfrutta il multithreading. Ogni atleta è eseguito come un thread separato (Atleta implements Runnable), permettendo la corsa contemporanea.
2)Sincronizzazione: Il Giudice gestisce l'arrivo dei thread in modo sicuro. Il metodo di registrazione è sincronizzato (synchronized) per garantire che la classifica finale 
sia sempre corretta e in ordine.
3)Anomalie Casuali: Ho  messo le scarpaslacciata,ventocontrario e follaesulta
Scarpa Slacciata: atleta si blocca e non parte finche non allaccia le scarpe
Folla Esulta: atleta perde la concentrazione
Vento Contrario: atleta ha difficolta per colpa il vento
Output: La classifica finale e i tempi di arrivo mosso che vengono salvati nel file classifica.txt.
