public class Nodo {
    private Richiesta elem;
    private Nodo next;

    Nodo(Richiesta elem) {
        this.elem = elem;
        this.next = null;
    }

    public Richiesta getElem() {
        return elem;
    }
    public Nodo getNext() {
        return next;
    }
    public void setNext(Nodo next) {
        this.next = next;
    }
}
