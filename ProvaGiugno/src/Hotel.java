public class Hotel extends Offerta{
    private static final double SCONTO = 0.9;

    public Hotel(String nomeStruttura, String localita, int capienza, double prezzoPerNotte){
        super(nomeStruttura, localita, capienza, prezzoPerNotte);
    }

    @Override
    public double calcolaPrezzoTotale(int notti) {
        if(notti > 5)
            return (prezzoPerNotte * notti) * SCONTO;
        return prezzoPerNotte * notti;
    }

    @Override
    public String prenota(String cliente, int nPersone) {
        if(capienza >= nPersone){
            capienza = capienza - nPersone;
            String codice = "H" +Math.abs(cliente.hashCode());  //?
            return "Prenotazione Hotel per " +cliente +". Codice: " +codice;
        }
        else
            return "Errore: Capienza insufficiente per l'hotel!";
    }

    @Override
    public String toString() {
        return "Hotel " +super.toString();
    }
}
