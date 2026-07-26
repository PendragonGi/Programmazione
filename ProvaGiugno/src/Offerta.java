public abstract class Offerta {
    protected String nomeStruttura;
    protected String localita;
    protected int capienza;
    protected double prezzoPerNotte;

    //COSTRUTTORE
    public Offerta(String nomeStruttura, String localita, int capienza, double prezzoPerNotte){
        this.nomeStruttura = nomeStruttura;
        this.localita = localita;
        this.capienza = capienza;
        this.prezzoPerNotte = prezzoPerNotte;
    }

    //GETTER
    public String getNomeStruttura() {
        return nomeStruttura;
    }
    public String getLocalita() {
        return localita;
    }
    public int getCapienza() {
        return capienza;
    }
    public double getPrezzoPerNotte() {
        return prezzoPerNotte;
    }

    public abstract double calcolaPrezzoTotale(int notti);
    public abstract String prenota(String cliente, int nPersone);

    @Override
    public String toString() {
        return nomeStruttura +" a " +localita + " - € " +prezzoPerNotte +"/notte";
    }
}
 