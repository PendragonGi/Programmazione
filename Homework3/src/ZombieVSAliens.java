public class ZombieVSAliens {
    public static void main(String[] args){

        //creo campo di 5x5
        Campo campo = new Campo(5);

        //la partita consente 8 mosse
        Personaggio sequenza_mosse[] = new Personaggio[8];

        //creo i personaggi: 2 alieni, 2 zombie con coordinate iniziali
        Personaggio zombie1 = new Zombie(0, 2);
        Personaggio zombie2 = new Zombie(0, 3);
        Personaggio alien1 = new Alien(0, 0);
        Personaggio alien2 = new Alien(0, 1);

        //posiziono i personaggi sul campo
        campo.placePersonaggio(0, 2, zombie1);
        campo.placePersonaggio(0, 3, zombie2);
        campo.placePersonaggio(0, 0, alien1);
        campo.placePersonaggio(0, 1, alien2);

        // TEST0: limiti della board, in questa configurazione
        /*
        // iniziale nessuno può muoversi
        Personaggio zombie1 = new Zombie(4, 2);
        Personaggio zombie2 = new Zombie(4, 3);
        Personaggio alien1 = new Alien(4, 0);
        Personaggio alien2 = new Alien(4, 1);
        
        board.placePersonaggio(4, 2, zombie1);
        board.placePersonaggio(4, 3, zombie2);
        board.placePersonaggio(4, 0, alien1);
        board.placePersonaggio(4, 1, alien2);
        */
        
        //TEST 1: le ultime due mosse devono essere skippate perchè il personaggio
        
        //zombie1 a quel punto è morto, patta
        sequenza_mosse[0]=alien1;
        sequenza_mosse[1]=zombie1;
        sequenza_mosse[2]=alien2;
        sequenza_mosse[3]=zombie2;
        sequenza_mosse[4]=alien1;
        sequenza_mosse[5]=alien1;
        sequenza_mosse[6]=zombie1;
        sequenza_mosse[7]=zombie1;
        
        
        //TEST 2: vincono gli alieni
        /*
        sequenza_mosse[0]=alien1;
        sequenza_mosse[1]=zombie1;
        sequenza_mosse[2]=alien2;
        sequenza_mosse[3]=zombie2;
        sequenza_mosse[4]=zombie2;
        sequenza_mosse[5]=alien2;
        sequenza_mosse[6]=zombie2;
        sequenza_mosse[7]=zombie2;
        */
        
        //TEST 3: vincono le pedine
        /*
        sequenza_mosse[0]=alien1;
        sequenza_mosse[1]=alien2;
        sequenza_mosse[2]=zombie1;
        sequenza_mosse[3]=zombie2;
        sequenza_mosse[4]=alien1;
        sequenza_mosse[5]=alien1;
        sequenza_mosse[6]=zombie2;
        sequenza_mosse[7]=zombie2;
        */
         
        //TEST 4: patta dopo 8 mosse reali
        /*
        sequenza_mosse[0]=zombie1;
        sequenza_mosse[1]=zombie2;
        sequenza_mosse[2]=zombie1;
        sequenza_mosse[3]=zombie2;
        sequenza_mosse[4]=zombie1;
        sequenza_mosse[5]=zombie2;
        sequenza_mosse[6]=alien1;
        sequenza_mosse[7]=alien2;
        */

        // Stampa della board nello stato iniziale
       System.out.println("Stato iniziale");
       printBoardState(campo);
       System.out.println("numero di alieni" + Alien.getAlienCount());
       System.out.println("numero di pedine" + Zombie.getZombieCount());
        
       
        int i=0;
        while(i<sequenza_mosse.length && !campo.gameover()) {
            sequenza_mosse[i].move(campo);
            System.out.println("Stampa della board dopo la mossa");
            printBoardState(campo);
            System.out.println("numero di alieni" + Alien.getAlienCount());
            System.out.println("numero di pedine" + Zombie.getZombieCount());
            i++;
        }
        if (Alien.getAlienCount()==0)
            System.out.println("Hanno vinto gli zombie!");

        else if (Zombie.getZombieCount()==0)
            System.out.println("Hanno vinto gli alieni!");

        else
            System.out.println("Partita patta dopo " + sequenza_mosse.length + " mosse!");
        
    }

    // Metodo per stampare lo stato attuale della board
    private static void printBoardState(Campo campo) {
        Personaggio[][] grid = campo.getGrid();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Personaggio giocatore = grid[i][j];
                if (giocatore instanceof Zombie) {
                    System.out.print("Z ");
                } else if (giocatore instanceof Alien) {
                    System.out.print("A ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
