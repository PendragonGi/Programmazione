public class Viaggio {
    private int idViaggio;
    private String origine;
    private String destinazione;
    private boolean prenotato;

    public Viaggio(int idViaggio, String origine, String destinazione){
        this.idViaggio = idViaggio;
        this.origine = origine;
        this.destinazione = destinazione;
        this.prenotato = false;
    }

    public int getIdViaggio() {
        return idViaggio;
    }
    public String getDestinazione() {
        return destinazione;
    }

    public void prenotaViaggio() throws ViaggioGiaPrenotatoException{
        if(prenotato)
            throw new ViaggioGiaPrenotatoException("Il viaggio con ID: " +idViaggio +" e' gia' prenotato.");
        else
            prenotato = true;
    }

    @Override
    public String toString() {
        return "Viaggio {idViaggio= " +idViaggio +", origine= " +origine +", destinazione= " +destinazione +", prenotato= " +prenotato +"}";
    }
}