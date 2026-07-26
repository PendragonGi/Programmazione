//gestione controllata dell'eccezione

public class CellaNonDisponibileException extends Exception{
    public CellaNonDisponibileException(String messaggio){
        super(messaggio);
    }
}