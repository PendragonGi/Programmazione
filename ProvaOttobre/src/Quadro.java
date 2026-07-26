public class Quadro extends Opera{

    private String tecnica;
    private String dimensioni;
    
    public Quadro(String titolo, String autore, int annoDicreazione, String tecnica, String dimensioni){
        super(titolo, autore, annoDicreazione);
        this.tecnica = tecnica;
        this.dimensioni = dimensioni;
    }

    @Override
    public String toString() {
        return super.toString() +", Quadro [Tecnica= " +tecnica +", dimensioni= " +dimensioni +"]";
    }
}
