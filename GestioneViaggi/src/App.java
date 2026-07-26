import javax.sound.midi.MidiUnavailableException;

public class App {
    public static void main(String[] args) throws Exception {

        Viaggio v1 = new Viaggio(1, "Napoli", "Roma");
        Viaggio v2 = new Viaggio(2, "Milano", "Roma");
        Viaggio v3 = new Viaggio(3, "Torino", "Firenza");
        Viaggio v4 = new Viaggio(4, "Bari", "Roma");

        // 1. Creazione della lista
        ListaViaggi lista = new ListaViaggi();

        // 2. Inserimento dei viaggi nella lista
        lista.append(v1);
        lista.append(v2);
        lista.append(v3);
        lista.append(v4);

        //verifica che lista non sia vuota
        if(lista.empty()){
            System.out.println("\nLista vuota!");
            System.exit(1);
        }

        // 3. Stampa della lista iniziale
        System.out.println("\nLista iniziale:");
        lista.stampa();

        // 4. Ricerca del viaggio con ID 2
        System.out.println("\nRicerca viaggio con ID 2:");
        Viaggio trovato = lista.cerca(2);
        if(trovato  != null)
            System.out.println(trovato);
        else
            System.out.println("Nessun viaggio trovato");


        // 5. Test delle prenotazioni (Successo, Eccezione, ID inesistente)
        System.out.println("\nPrenotazioni:");
        lista.prenota(2);   //primo tentativo: successo
        lista.prenota(2);   //secondo tentativo: fallito (gia' prenotato)
        lista.prenota(10);  //tentativo con ID non valido


        // 6. Stampa dello stato aggiornato della lista
        System.out.println("\nLista aggiornata:");
        lista.stampa();


        // 7. Filtro per destinazione "Roma"
        System.out.println("\nFiltro per destinazione: Miami");
        Viaggio[] filtrati = lista.filtra("Miammi");

        if(filtrati != null){
            for(int i=0; i<filtrati.length; i++){
                System.out.println(filtrati[i]);
            }
        }
        else
            System.out.println("\nNessun viaggio corrispondente alla destinazione specificata");


        /*
        // 2. Inserimento dei viaggi nella lista
        lista.append(new Viaggio(1, "Napoli", "Roma"));
        lista.append(new Viaggio(2, "Milano", "Roma"));
        lista.append(new Viaggio(3, "Torino", "Firenze"));
        lista.append(new Viaggio(4, "Bari", "Roma"));
        */
    }
}
