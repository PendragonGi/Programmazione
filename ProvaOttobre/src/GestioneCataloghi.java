public class GestioneCataloghi {
    public static void main(String[] args) {
        // Istanziamento della mostra
        Mostra mostra = new Mostra("I Maestri del Colore", "Venezia", "16-30 Settembre 2024");
        
        // La classe GestioneCataloghi usa Catalogo e gli dice di caricare il file
        Catalogo catalogo = mostra.getCatalogo();
        catalogo.leggiDaFile("opere.txt");

        // Stampa non ordinata
        System.out.println("\n");
        mostra.stampaCatalogoMostra();

        System.out.println("\nCatalogo ordinato per titolo");

        // Ordinamento e stampa ordinata
        mostra.ordinaCatalogo();
        mostra.stampaCatalogoMostra();
    }
}