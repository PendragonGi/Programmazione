public class AreaParcheggio{
    private Veicolo[][] parcheggio;
    private int R;
    private int C;

    public AreaParcheggio(int R, int C){
        this.R = R;
        this.C = C;
        this.parcheggio = new Veicolo[R][C];
    }

    public void verificaCellaLibera(int riga, int colonna) throws CellaNonDisponibileException{
        if(riga < 0 || riga >= R || colonna < 0 || colonna >= C){
            throw new CellaNonDisponibileException("cella fuori dall'area: (" + riga + "," + colonna + ")");
        }
        if(parcheggio[riga][colonna] != null){
            throw new CellaNonDisponibileException("cella gia' occupata: (" +riga +"," +colonna +")");
        }
    }

    public void occupaCella(int riga, int colonna, Veicolo v){
        parcheggio[riga][colonna] = v;
    }

    public  int contaCelleOccupate(){
        int contatore = 0;
        for(int righe = 0; righe < R; righe++){
            for(int colonne = 0; colonne < C; colonne++){
                if(parcheggio[righe][colonne] != null)
                    contatore++;
            }
        }
        return contatore;
    }

    public double percentualeAreaOccupata(){
        int totale = R * C;
        return ((double)contaCelleOccupate() / totale) * 100;
    }

    public void stampaArea(){
        System.out.println("\nMAPPA AREA PARCHEGGIO");
        System.out.println("---------------------");
        for(int righe = 0; righe < R; righe++){
            for(int colonne = 0; colonne < C; colonne++){
                if(parcheggio[righe][colonne] == null)
                    System.out.print(". ");
                else
                    System.out.print(parcheggio[righe][colonne].getSymbol() + " ");
            }
            System.out.println();
        }
    }
}

/*
public class AreaParcheggio {
    private Veicolo[][] matrice;
    private int righe;
    private int colonne;

    public AreaParcheggio(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;
        this.matrice = new Veicolo[righe][colonne];
    }

    // Controlla limiti e occupazione. Lancia l'eccezione personalizzata se qualcosa non va.
    public void verificaCellaLibera(int r, int c) throws CellaNonDisponibileException {
        if (r < 0 || r >= righe || c < 0 || c >= colonne) {
            throw new CellaNonDisponibileException("cella fuori dall'area: (" + r + ", " + c + ")");
        }
        if (matrice[r][c] != null) {
            throw new CellaNonDisponibileException("cella già occupata: (" + r + ", " + c + ")");
        }
    }

    public void occupaCella(int r, int c, Veicolo v) {
        matrice[r][c] = v;
    }

    public int contaCelleOccupate() {
        int conteggio = 0;
        for (int r = 0; r < righe; r++) {
            for (int c = 0; c < colonne; c++) {
                if (matrice[r][c] != null) conteggio++;
            }
        }
        return conteggio;
    }

    public double percentualeAreaOccupata() {
        int totali = righe * colonne;
        return ((double) contaCelleOccupate() / totali) * 100;
    }

    public void stampaArea() {
        System.out.println("MAPPA AREA PARCHEGGIO");
        for (int r = 0; r < righe; r++) {
            for (int c = 0; c < colonne; c++) {
                if (matrice[r][c] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(matrice[r][c].getSymbol() + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
*/