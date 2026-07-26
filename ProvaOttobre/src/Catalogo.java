import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Catalogo {
    private Opera[] opere;
    private int nOpere;

    public Catalogo(){
        this.opere = new Opera[100];
        this.nOpere = 0;
    }

    public void aggiungiOpera(Opera o){
        if(o != null && nOpere < opere.length){
            opere[nOpere] = o;
            nOpere++;
        }
    }

    public void ordinaOpere(){
        for(int i=0; i<nOpere-1; i++){
            for(int j=0; j<nOpere-1-i; j++){    //-i perche' non serve verificare l'ultima posizione
                if(opere[j].compareTo(opere[j+1]) > 0){
                    Opera temp = opere[j];
                    opere[j] = opere[j+1];
                    opere[j+1] = temp;
                }
            }
        }
    }

    public void visualizzaOpere(){
        for(int i=0; i<nOpere; i++)
            System.out.println(opere[i].toString());
    }

    public void leggiDaFile(String nomeFile){
        try(Scanner tastiera = new Scanner(Paths.get(nomeFile))){
            if(!tastiera.hasNextInt())  //verifico che il primo elemento del file sia un numero che indica quanti elementi ci sono
                return;
            int totaleOpereFile = tastiera.nextInt();   //leggo il numero di opere presenti

            for(int i=0; i<totaleOpereFile; i++){
                String tipo = tastiera.next();  //leggo il tipo (QUADRO o ALTRO)

                if(tipo.equalsIgnoreCase("Quadro")){    //se e' QUADRO allora leggo il resto
                    String titolo = tastiera.next();
                    String autore = tastiera.next();
                    int anno = tastiera.nextInt();
                    String tecnica = tastiera.next();
                    String dimensioni = tastiera.next();

                    //creo l'oggetto Quadro e lo metto nell'array del catalogo
                    Quadro q = new Quadro(titolo, autore, anno, tecnica, dimensioni);
                    aggiungiOpera(q);
                }
                else{ //non e' un QUADRO
                    tastiera.next();    //scarto la dicitura "***"
                    tastiera.next();    //scarto la dicitura "***"
                    tastiera.nextInt(); //scarto il numero
                }
            }
        }
        catch(IOException e){
            System.out.println("Errore durante la lettura del file: " +e.getMessage());
        }
    }
    @Override
    public String toString() {
        String risultato = "";

        for(int i=0; i<nOpere; i++)
            risultato = risultato + opere[i].toString() +"\n";
        return risultato;
    }
}
