public class GuastoMeccanico extends Richiesta implements Collaudabile {
    private static final double COSTO_COLLAUDO = 100.0;

    private double costoRicambi;
    private boolean collaudo;

    //COSTRUTTORE
    public GuastoMeccanico(String codice, String descrizione, double costoOrario, int ore, Impianto impianto,
            double costoRicambi, boolean collaudo) {
        super(codice, descrizione, costoOrario, ore, impianto);
        this.costoRicambi = costoRicambi;
        this.collaudo = collaudo;
    }

    //GETTER
    public double getCostoRicambi() {
        return costoRicambi;
    }
    public boolean isCollaudo() {
        return collaudo;
    }

    @Override
    public double calcolaCosto() {
        double costo = costoOrario * ore + costoRicambi;
        if (collaudo)
            costo = costo + COSTO_COLLAUDO;
        return costo;
    }

    @Override
    public String generaReportCollaudo() {
        String esito = collaudo ? "collaudo effettuato" : "nessun collaudo necessario";
        return "REPORT COLLAUDO: " +codice +" " +descrizione +" " +impianto.getDescrizione() +" - " +esito;
    }
}
