import java.util.Scanner;

public class Booking {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        //inizializzazione da File
        ElencoOfferte catalogo = new ElencoOfferte("offerte.txt");

        if(catalogo.getSize() == 0){
            catalogo.add(new Hotel("Giardino", "Firenze", 4, 120.0));
            catalogo.add(new Appartamento("Sole", "Roma", 2, 90.0));
            catalogo.add(new Hotel("Mercury", "Roma", 3, 110.0));
            catalogo.add(new Appartamento("Lago", "Como", 4, 80.0));
            catalogo.add(new Hotel("Centro", "Milano", 5, 140.0));
        }

        System.out.println("\nBenvenuto nel sistema di prenotazione \"Soggiorni Intelligenti\"!");

        String risposta;
        do{
            System.out.println("Quale e' la tua destinazione?");
            String destinazione = scanner.next();

            System.out.println("Numero persone? ");
            int persone = scanner.nextInt();

            System.out.println("Per quante notti? ");
            int notti = scanner.nextInt();

            //filtra le offerte
            ElencoOfferte offerteDisponibili = catalogo.filtra(destinazione, persone);

            System.out.println("Offerte disponibili: ");
            offerteDisponibili.stampa();

            //individua l'offerta economica
            Offerta migliore = offerteDisponibili.getMinima(notti);

            if(migliore != null){
                System.out.println("L'offerta piu' conveniente in base al costo totale e': ");
                System.out.println(migliore);
                System.out.printf("Prezzo totale per %d notti: €%.2f\n", notti, migliore.calcolaPrezzoTotale(notti));

                System.out.println("Vuoi prenotare questa offerta? (S/N)");
                String conferma = scanner.next();

                if(conferma.equalsIgnoreCase("S")){
                    String esito = migliore.prenota("Mario Rossi", persone);
                    System.out.println(esito);
                }
            }
            else
                System.out.println("Nessuna offerta trovata per i criteri specificati.");

            System.out.println("Vuoi effettuare un'altra richiesta? (S/N)\n");
            risposta = scanner.next();
            
        }
        while(risposta.equalsIgnoreCase("S"));

        System.out.println("Arrivederci!");
        scanner.close();
    }
}
