public class GuastoElettrico extends Richiesta {
    private static final double COSTO_MESSA_SICUREZZA = 80.0;

    private double costoComponenti;
    private boolean messaSicurezza;

    //COSTRUTTORE
    public GuastoElettrico(String codice, String descrizione, double costoOrario, int ore, Impianto impianto,
            double costoComponenti, boolean messaSicurezza) {
        super(codice, descrizione, costoOrario, ore, impianto);
        this.costoComponenti = costoComponenti;
        this.messaSicurezza = messaSicurezza;
    }

    //GETTER
    public double getCostoComponenti() {
        return costoComponenti;
    }
    public boolean isMessaSicurezza() {
        return messaSicurezza;
    }

    @Override
    public double calcolaCosto() {
        double costo = costoOrario * ore + costoComponenti;
        if (messaSicurezza)
            costo = costo + COSTO_MESSA_SICUREZZA;
        return costo;
    }
}
