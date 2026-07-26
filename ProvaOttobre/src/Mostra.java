public class Mostra {

    private String nome;
    private String location;
    private String data;
    private Catalogo catalogo;

    public Mostra(String nome, String location, String data) {
        this.nome = nome;
        this.location = location;
        this.data = data;
        this.catalogo = new Catalogo();
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void ordinaCatalogo() {
        if (catalogo != null) {
            catalogo.ordinaOpere();
        }
    }

    public void stampaCatalogoMostra() {
        System.out.println("***Mostra " + nome + "***");
        System.out.println("***" + location + " " + data + "***");
        if (catalogo != null) {
            catalogo.visualizzaOpere();
        }
    }
}
