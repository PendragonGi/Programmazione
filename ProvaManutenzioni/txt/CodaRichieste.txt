public class CodaRichieste {
    private Nodo testa;

    CodaRichieste() {
        this.testa = null;
    }

    //PREDICATO
    public boolean isEmpty() {
        return testa == null;
    }

    //INSERIMENTO IN CODA (politica FIFO)
    public void inserisci(Richiesta r) {
        Nodo nuovo = new Nodo(r);

        if (isEmpty()) {
            testa = nuovo;
        } else {
            Nodo temp = testa;
            while (temp.getNext() != null)
                temp = temp.getNext();
            temp.setNext(nuovo);
        }
    }

    //VERIFICA SE ESISTE ALMENO UNA RICHIESTA URGENTE
    public boolean esisteUrgente(double sogliaCostoFermo) {
        Nodo temp = testa;

        while (temp != null) {
            if (temp.getElem().valutaUrgente(sogliaCostoFermo))
                return true;
            temp = temp.getNext();
        }
        return false;
    }

    //ESTRAZIONE: se e' presente almeno una richiesta urgente viene estratta la prima
    //urgente secondo l'ordine di arrivo, altrimenti si segue la normale politica FIFO
    public Richiesta estrai(double sogliaCostoFermo) throws CodaVuotaException {
        if (isEmpty())
            throw new CodaVuotaException("Impossibile estrarre: la coda delle richieste e' vuota");

        if (esisteUrgente(sogliaCostoFermo)) {
            Nodo prec = null;
            Nodo temp = testa;

            while (!temp.getElem().valutaUrgente(sogliaCostoFermo)) {
                prec = temp;
                temp = temp.getNext();
            }

            if (prec == null)
                testa = temp.getNext();
            else
                prec.setNext(temp.getNext());

            return temp.getElem();
        } else {
            Richiesta r = testa.getElem();
            testa = testa.getNext();
            return r;
        }
    }
}
