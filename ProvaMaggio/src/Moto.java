//CICLOMOTORE 0,80€/h
//MOTOCICLETTA 1,20€/h

public class Moto extends Veicolo{
    private String tipo;

    public Moto(String targa, int riga, int colonna, String tipo){
        super(targa, riga, colonna);
        this.tipo = tipo;
    }

    @Override
    public char getSymbol() {
        return 'M';
    }

    @Override
    public double getTariffaOraria() {
        if(tipo.equals("CICLOMOTORE"))
            return 0.80;
        else if(tipo.equals("MOTOCICLETTA"))
            return 1.20;
        return 0.0;
    }

    @Override
    public void parcheggia(AreaParcheggio area) throws CellaNonDisponibileException{
        area.verificaCellaLibera(riga, colonna);
        area.occupaCella(riga, colonna, this);
    }

    @Override
    public String toString() {
        return "Moto " +super.toString() +" (" +tipo +")";
    }
}

/*
public class Moto extends Veicolo {
    private String tipo; // "CICLOMOTORE" o "MOTOCICLETTA"

    public Moto(String targa, int riga, int colonna, String tipo) {
        super(targa, riga, colonna); // Passa i dati al costruttore di Veicolo
        this.tipo = tipo.toUpperCase();
    }

    @Override
    public char getSymbol() {
        return 'M'; // Simbolo grafico sulla mappa
    }

    @Override
    public double getTariffaOraria() {
        if (tipo.equals("CICLOMOTORE")) return 0.80;
        if (tipo.equals("MOTOCICLETTA")) return 1.20;
        return 0.0;
    }

    @Override
    public void parcheggia(AreaParcheggio ap) throws CellaNonDisponibileException {
        // 1. Verifica preventiva
        ap.verificaCellaLibera(riga, colonna);
        // 2. Occupazione fisica
        ap.occupaCella(riga, colonna, this);
    }

    @Override
    public String toString() {
        return "Moto " + targa + " (" + tipo + ")";
    }
}
*/