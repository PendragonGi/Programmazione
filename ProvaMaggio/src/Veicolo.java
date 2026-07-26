public abstract class Veicolo{
    protected String targa;
    protected int riga;
    protected int colonna;

    public Veicolo(String targa, int riga, int colonna){
        this.targa = targa;
        this.riga = riga;
        this.colonna = colonna;
    }

    public abstract char getSymbol();
    public abstract double getTariffaOraria();
    
    public double calcolaCosto(double ore){
        return this.getTariffaOraria() * ore;
    }

    public abstract void parcheggia(AreaParcheggio area) throws CellaNonDisponibileException;

    @Override
    public String toString() {
        return targa;
    }
}

/*public abstract class Veicolo {
    protected String targa;
    protected int riga;
    protected int colonna;

    public Veicolo(String targa, int riga, int colonna) {
        this.targa = targa;
        this.riga = riga;
        this.colonna = colonna;
    }

    public String getTarga() { return targa; }
    public int getRiga() { return riga; }
    public int getColonna() { return colonna; }

    // Metodi astratti che OGNI sottoclasse deve obbligatoriamente implementare
    public abstract char getSymbol();
    public abstract double getTariffaOraria();
    public abstract void parcheggia(AreaParcheggio ap) throws CellaNonDisponibileException;

    // Calcola il costo base per un'ora
    public double calcolaCosto() {
        return getTariffaOraria();
    }
}*/