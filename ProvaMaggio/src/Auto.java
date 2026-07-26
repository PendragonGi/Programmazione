//PICCOLA 1,50€/h
//MEDIA 2,00€/h
//GRANDE 2,50€/h

public class Auto extends Veicolo{
    private String categoria;
    private String orientamento;

    public Auto(String targa, int riga, int colonna, String categoria, String orientamento){
        super(targa, riga, colonna);
        this.categoria = categoria;
        this.orientamento = orientamento;
    }

    @Override
    public char getSymbol() {
        return 'A';
    }

    @Override
    public double getTariffaOraria() {
        if(categoria.equals("PICCOLA"))
            return 1.50;
        else if(categoria.equals("MEDIA"))
            return 2.00;
        else if(categoria.equals("GRANDE"))
            return 2.50;
        return 0.0;
    }

    @Override
    public void parcheggia(AreaParcheggio area) throws CellaNonDisponibileException {
        int riga2 = riga;
        int colonna2 = colonna;

        if(orientamento.equals("ORIZZONTALE"))
            colonna2 = colonna + 1;
        else if(orientamento.equals("VERTICALE"))
            riga2 = riga + 1;

        area.verificaCellaLibera(riga, colonna);
        area.verificaCellaLibera(riga2, colonna2);

        area.occupaCella(riga, colonna, this);
        area.occupaCella(riga2, colonna2, this);

    }
    @Override
    public String toString() {
        return "Auto " +super.toString() +" (" +categoria +", " +orientamento +")";
    }
}

/*
public class Auto extends Veicolo {
    private String categoria;    // "PICCOLA", "MEDIA", "GRANDE"
    private String orientamento;  // "ORIZZONTALE" o "VERTICALE"

    public Auto(String targa, int riga, int colonna, String categoria, String orientamento) {
        super(targa, riga, colonna);
        this.categoria = categoria.toUpperCase();
        this.orientamento = orientamento.toUpperCase();
    }

    @Override
    public char getSymbol() { return 'A'; }

    @Override
    public double getTariffaOraria() {
        switch (categoria) {
            case "PICCOLA": return 1.50;
            case "MEDIA": return 2.00;
            case "GRANDE": return 2.50;
            default: return 0.0;
        }
    }

    @Override
    public void parcheggia(AreaParcheggio ap) throws CellaNonDisponibileException {
        // Calcoliamo le coordinate della seconda cella in base all'orientamento
        int riga2 = riga;
        int colonna2 = colonna;

        if (orientamento.equals("ORIZZONTALE")) {
            colonna2 = colonna + 1;
        } else if (orientamento.equals("VERTICALE")) {
            riga2 = riga + 1;
        }

        // FASE 1: Controllo preventivo (se una fallisce, lancia l'eccezione e si ferma qui)
        ap.verificaCellaLibera(riga, colonna);
        ap.verificaCellaLibera(riga2, colonna2);

        // FASE 2: Occupazione effettiva (avviene solo se la FASE 1 ha avuto successo totale)
        ap.occupaCella(riga, colonna, this);
        ap.occupaCella(riga2, colonna2, this);
    }

    @Override
    public String toString() {
        return "Auto " + targa + " (" + categoria + ", " + orientamento + ")";
    }
}
*/