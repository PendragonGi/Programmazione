public abstract class Richiesta {
    protected String codice;
    protected String descrizione;
    protected double costoOrario;
    protected int ore;
    protected Impianto impianto;

    //COSTRUTTORE
    public Richiesta(String codice, String descrizione, double costoOrario, int ore, Impianto impianto) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.costoOrario = costoOrario;
        this.ore = ore;
        this.impianto = impianto;
    }

    //GETTER
    public String getCodice() {
        return codice;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public double getCostoOrario() {
        return costoOrario;
    }
    public int getOre() {
        return ore;
    }
    public Impianto getImpianto() {
        return impianto;
    }

    //METODI ASTRATTI: il costo dipende dalla natura specifica del guasto
    public abstract double calcolaCosto();

    //Una richiesta e' urgente se il livello di criticita' dell'impianto e' maggiore di 1
    //oppure se il costo del fermo dell'impianto supera la soglia indicata al momento
    public boolean valutaUrgente(double sogliaCostoFermo) {
        return impianto.getLivelloCriticita() > 1 || impianto.getCostoFermo() > sogliaCostoFermo;
    }

    @Override
    public String toString() {
        return codice +" - " +descrizione +" (impianto: " +impianto.getDescrizione() +")";
    }
}
