public class Alien extends Personaggio {

    private static int AlienCount = 0;

    public Alien(int x, int y){
        super(x, y);
        AlienCount ++;
    }

    @Override
    protected void die(){
        AlienCount --;
        vivo = false;
    }

    public static int getAlienCount() {
        return AlienCount;
    }

    @Override
    public void move(Campo campo){
        if(vivo){
            //Alien si muove in obliquo in avanti di una posizione verso destra
            int currentX = getX();
            int currentY = getY();

            //calcolo le nuove coordinate per lo spostamento in diagonale a destra
            int newX = currentX + 1;
            int newY = currentY + 1;

            //controllo che la nuova posizione sia all'interno del campo
            if(campo.isValidPosition(newX, newY) && (campo.whois(newX, newY) instanceof Alien) == false){
                campo.removePersonaggio(currentX, currentY);
                campo.placePersonaggio(newX, newY, this);
                this.setX(newX);
                this.setY(newY);
            }
            else
                System.out.println("Mossa non valida");
        }
    }
}