public class Zombie extends Personaggio {

    private static int ZombieCount = 0;

    public Zombie(int x, int y){
        super(x, y);
        ZombieCount ++;
    }

    @Override
    protected void die(){
        ZombieCount --;
        vivo = false;
    }

    public static int getZombieCount() {
        return ZombieCount;
    }

    @Override
    public void move(Campo campo){
        if(vivo){
            //Zombie si muove in avanti di una posizione
            int currentX = getX();
            int currentY = getY();

            //calcolo le nuove coordinate per lo spostamento in avanti
            int newX = currentX + 1;

            //controllo che la nuova posizione sia all'interno del campo
            if(campo.isValidPosition(newX, currentY) && (campo.whois(newX, currentY) instanceof Zombie) == false){
                campo.removePersonaggio(currentX, currentY);    //rimuovo il personaggio
                campo.placePersonaggio(newX, currentY, this);       //riposiziono il personaggio
                this.setX(newX);
            }
            else
                System.out.println("Mossa non valida");
        }
    }
}
