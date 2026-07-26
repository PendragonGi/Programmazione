public class GestioneParcheggio{
    public static void main(String[] args) {
        AreaParcheggio area = new AreaParcheggio(5, 7);

        //inserisco i veicoli
        Veicolo[] daParcheggiare = new Veicolo[]{
            new Moto("M001", 0, 0, "CICLOMOTORE"),
            new Auto("A001", 1, 1, "PICCOLA", "ORIZZONTALE"),
            new Auto("A002", 2, 3, "GRANDE", "VERTICALE"),
            new Moto("M002", 1, 2, "MOTOCICLETTA"),
            new Auto("A003", 4, 7, "MEDIA", "ORIZZONTALE"),
            new Moto("M003", 4, 0, "MOTOCICLETTA"),
        };
        Veicolo[] copia = new Veicolo[daParcheggiare.length];
        int flag = 0;

System.out.println();

        for(Veicolo v: daParcheggiare){
            try{
                v.parcheggia(area); //provo a parcheggiare il veicolo
                
                /*
                char iniziale = v.targa.charAt(0);
                if(iniziale == 'M')
                    System.out.println("- Parcheggiato: Moto " +v);

                else if(iniziale == 'A')
                    System.out.println("- Parcheggiato: Auto " +v);
                */

                System.out.println("- Parcheggiato: " +v);
                copia[flag] = v;
                flag++;
            }
            catch (CellaNonDisponibileException e){
                char iniziale = v.targa.charAt(0);
                if(iniziale == 'M')
                    System.out.println("Non parcheggiato: " +v);
                else if(iniziale == 'A')
                    System.out.println("Non parcheggiato: " +v);
                System.out.println("Motivo: " +e.getMessage());
            }
        }
        //System.out.println();

        area.stampaArea();  //stampa la mappa di parcheggio

        System.out.println("\nCelle occupate: " +area.contaCelleOccupate());
        System.out.printf("Area occupata: %.2f%%%n", area.percentualeAreaOccupata());
        //System.out.print("%");

        int ore = 3;
        System.out.println("\nCOSTI SOSTA (" +ore +" ore)");
        System.out.println("---------------------");
        double incassoTotale = 0.0;

        for(Veicolo v : copia){
            if(v != null){
                double incassoSingolo = v.calcolaCosto(ore);
                System.out.printf("%s -> %.2f euro%n", v.toString(), incassoSingolo);
                incassoTotale = incassoTotale + incassoSingolo;
            }
        }
        System.out.printf("Incasso totale: %.2f euro%n", incassoTotale);
    }
}

/*
import java.util.ArrayList;
import java.util.List;

public class GestioneParcheggio {
    public static void main(String[] args) {
        // Creazione dell'area fisica (5 righe x 7 colonne = 35 celle totali)
        AreaParcheggio area = new AreaParcheggio(5, 7);

        // Creazione della flotta di veicoli
        List<Veicolo> flotta = new ArrayList<>();
        flotta.add(new Moto("M001", 0, 0, "CICLOMOTORE"));
        flotta.add(new Auto("A001", 1, 1, "PICCOLA", "ORIZZONTALE"));
        flotta.add(new Auto("A002", 2, 3, "GRANDE", "VERTICALE"));
        flotta.add(new Moto("M002", 1, 2, "MOTOCICLETTA")); // COLLISIONE con A001!
        flotta.add(new Auto("A003", 4, 7, "MEDIA", "ORIZZONTALE")); // FUORI LIMITI!
        flotta.add(new Moto("M003", 4, 0, "MOTOCICLETTA"));

        List<Veicolo> parcheggiati = new ArrayList<>();

        // Fase di parcheggio
        for (Veicolo v : flotta) {
            try {
                v.parcheggia(area);
                System.out.println("Parcheggiato: " + v);
                parcheggiati.add(v);
            } catch (CellaNonDisponibileException e) {
                System.out.println("Non parcheggiato: " + v);
                System.out.println("Motivo: " + e.getMessage());
            }
        }
        System.out.println();

        // Visualizzazione stato finale
        area.stampaArea();

        System.out.println("Celle occupate: " + area.contaCelleOccupate());
        System.out.printf("Area occupata: %.2f%%%n%n", area.percentualeAreaOccupata());

        // Calcolo dei ricavi
        int oreSosta = 3;
        System.out.println("COSTI SOSTA (" + oreSosta + " ore)");
        double incassoTotale = 0.0;

        for (Veicolo v : parcheggiati) {
            double costoSingolo = v.calcolaCosto() * oreSosta;
            incassoTotale += costoSingolo;
            System.out.printf("%s -> %.2f euro%n", v.toString(), costoSingolo);
        }

        System.out.printf("Incasso totale: %.2f euro%n", incassoTotale);
    }
}
*/