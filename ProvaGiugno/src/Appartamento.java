public class Appartamento extends Offerta{
    private static final int PULIZIA = 30;

    public Appartamento(String nomeStruttura, String localita, int capienza, double prezzoPerNotte){
        super(nomeStruttura, localita, capienza, prezzoPerNotte);
    }

    @Override
    public double calcolaPrezzoTotale(int notti) {
        return (prezzoPerNotte * notti) + PULIZIA;
    }

    @Override
    public String prenota(String cliente, int nPersone) {
        if(nPersone == capienza && capienza > 0){
            capienza = 0;
            return "Appartamento prenotato da " +cliente +". Riceverai istruzioni via email.";
        }
        else
            return "Errore: Capienza insufficiente per l'appartamento";
    }

    @Override
    public String toString() {
        return "Appartamento " +super.toString();
    }
}
