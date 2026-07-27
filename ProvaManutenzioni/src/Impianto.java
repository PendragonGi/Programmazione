public class Impianto {
    private String codice;
    private String descrizione;
    private int livelloCriticita;
    private double costoFermo;

    //COSTRUTTORE
    public Impianto(String codice, String descrizione, int livelloCriticita, double costoFermo) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.livelloCriticita = livelloCriticita;
        this.costoFermo = costoFermo;
    }

    //GETTER
    public String getCodice() {
        return codice;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public int getLivelloCriticita() {
        return livelloCriticita;
    }
    public double getCostoFermo() {
        return costoFermo;
    }

    @Override
    public String toString() {
        return descrizione +" (" +codice +")";
    }
}
