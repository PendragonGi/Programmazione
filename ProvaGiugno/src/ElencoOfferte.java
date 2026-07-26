import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class ElencoOfferte {
    private int max;
    private int size;
    private Offerta[] elenco;

    //COSTRUTTORE BASE
    public ElencoOfferte(int max){
        this.max = max;
        this.size = 0;
        this.elenco = new Offerta[max];
    }

    //COSTRUTTORE lettura file
    public ElencoOfferte(String nomeFile){
        try(Scanner tastiera = new Scanner(new File(nomeFile))){
            if(tastiera.hasNextInt()){
                this.max = tastiera.nextInt();
                this.elenco = new Offerta[max];
                this.size = 0;
            }

            while(tastiera.hasNext()){
                String tipo = tastiera.next();
                String nome = tastiera.next();
                String localita = tastiera.next();
                int capienza = tastiera.nextInt();
                double prezzo = tastiera.nextDouble();

                Offerta o;
                if(tipo.equalsIgnoreCase("Hotel"))
                    o = new Hotel(nome, localita, capienza, prezzo);
                else
                    o = new Appartamento(nome, localita, capienza, prezzo);

                this.add(o);
            }
        } catch (FileNotFoundException e){
            System.out.println("File non trovato. Creazione elenco vuoto di default.");
            this.max = 10;
            this.elenco = new Offerta[10];
            this.size = 0;
        }
    }

    //METODO INSERIMENTO ORDINATO
    public void add(Offerta o){
        if(size >= max)
            return;
        
        int i = size - 1;

        while(i >= 0 && elenco[i].getPrezzoPerNotte() > o.getPrezzoPerNotte()){
            elenco[i + 1] = elenco[i];
            i--;
        }
        elenco[i + 1] = o;
        size++;
    }

    //METODO FILTRA
    public ElencoOfferte filtra(String destinazione, int nPersone){
        ElencoOfferte filtrate = new ElencoOfferte(this.size);
        for(int i=0; i<size; i++){
            if(elenco[i].getLocalita().equalsIgnoreCase(destinazione) && elenco[i].getCapienza() >= nPersone)
                filtrate.add(elenco[i]);
        }
        return filtrate;
    }

    //METODO TROVA OFFERTA
    public Offerta getMinima(int notti){
        if(size == 0)
            return null;
        
        Offerta minima = elenco[0];
        double costoMinimo = minima.calcolaPrezzoTotale(notti);

        for(int i=1; i<size; i++){
            double costoCorrente = elenco[i].calcolaPrezzoTotale(notti);
            if(costoCorrente < costoMinimo){
                costoMinimo = costoCorrente;
                minima = elenco[i];
            }
        }
        return minima;
    }

    //METODO STAMPA
    public void stampa(){
        for(int i=0; i<size; i++)
            System.out.println(elenco[i]);
    }
    
    public int getSize() {
        return size;
    }
}
