import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Manutenzioni {

    private static final String FILE_COLLAUDI = "collaudi.txt";
    private static final double SOGLIA_COSTO_FERMO = 300.0;

    public static void main(String[] args) {
        CodaRichieste coda = new CodaRichieste();

        creaRichieste(coda);

        System.out.println();
        System.out.println("**** valutazione costi degli interventi effettuati ***");
        eseguiInterventi(coda);

        System.out.println("\nContenuto del File:\n");
        stampaFile(FILE_COLLAUDI);
    }

    //Creazione degli impianti e delle richieste di manutenzione, inserite in coda
    private static void creaRichieste(CodaRichieste coda) {
        Impianto forno = new Impianto("IMP01", "Forno industriale", 2, 250.0);
        Impianto nastro = new Impianto("IMP02", "Nastro trasportatore", 1, 150.0);
        Impianto ventilazione = new Impianto("IMP03", "Sistema ventilazione", 1, 100.0);

        Richiesta r02 = new GuastoMeccanico("R02", "Sostituzione cuscinetto", 40.0, 5, nastro, 110.0, true);
        Richiesta r01 = new GuastoElettrico("R01", "Guasto quadro elettrico", 50.0, 4, forno, 120.0, true);
        Richiesta r03 = new GuastoMeccanico("R03", "Controllo motore", 30.0, 6, ventilazione, 120.0, false);

        inserisciERegistra(coda, r02);
        inserisciERegistra(coda, r01);
        inserisciERegistra(coda, r03);
    }

    private static void inserisciERegistra(CodaRichieste coda, Richiesta r) {
        coda.inserisci(r);
        System.out.println("Inserita richiesta: " +r.getCodice());
    }

    //Estrazione delle richieste dalla coda, calcolo del costo e, se collaudabile,
    //generazione del report di collaudo salvato su file
    private static void eseguiInterventi(CodaRichieste coda) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_COLLAUDI))) {
            while (!coda.isEmpty()) {
                Richiesta r = coda.estrai(SOGLIA_COSTO_FERMO);

                if (r.valutaUrgente(SOGLIA_COSTO_FERMO))
                    System.out.println("Eseguita richiesta di intervento urgente " +r.getCodice() +".");
                else
                    System.out.println("Eseguita richiesta di intervento " +r.getCodice() +".");

                System.out.printf("%s impianto: %s - costo: %.1f euro%n",
                        r.getDescrizione(), r.getImpianto().getDescrizione(), r.calcolaCosto());

                if (r instanceof Collaudabile) {
                    Collaudabile collaudabile = (Collaudabile) r;
                    writer.println(collaudabile.generaReportCollaudo());
                    writer.println("--------------------");
                }
            }
        } catch (CodaVuotaException e) {
            System.out.println("Errore: " +e.getMessage());
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file: " +e.getMessage());
        }
    }

    private static void stampaFile(String nomeFile) {
        try {
            List<String> righe = Files.readAllLines(Paths.get(nomeFile));
            for (String riga : righe)
                System.out.println(riga);
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file: " +e.getMessage());
        }
    }
}
