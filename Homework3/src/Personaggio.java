public abstract class Personaggio {
    //coordinate X e Y
    private int x;
    private int y;

    protected boolean vivo;

    public Personaggio(int X, int Y){
        this.x = X;
        this.y = Y;
        this.vivo = true;
    }

    public int getX() {
        return x;
    }
    public void setX(int X) {
        this.x = X;
    }

    public int getY() {
        return y;
    }
    public void setY(int Y) {
        this.y = Y;
    }

    //metodo ABSTRACT perche' alieni e zombie si muovono in modo diverso
    public abstract void move (Campo campo);

    protected abstract void die();
}