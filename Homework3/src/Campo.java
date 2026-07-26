public class Campo {
    private final Personaggio [][] grid;

    public Campo(int size){
        grid = new Personaggio [size][size];
    }

    public Personaggio[][] getGrid() {
        return grid;
    }

    //metodo per posizionare un personaggio sul campo
    public void placePersonaggio(int x, int y, Personaggio personaggio){
        if(grid[x][y] != null)
            grid[x][y].die();
        grid[x][y] = personaggio;
    }

    //metodo per rimuovere un personaggio dal campo
    public void removePersonaggio(int x, int y){
        grid[x][y] = null;
    }

    //metodo verifica posizione
    public boolean isValidPosition(int x, int y){
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    //metodo per controllare la fine della partita
    public boolean gameover(){
        return (Alien.getAlienCount() == 0 || Zombie.getZombieCount() == 0);
    }

    public Personaggio whois(int x, int y){
        return grid[x][y];
    }
}
