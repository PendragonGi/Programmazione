public class ListaViaggi{

    private class Nodo{
        //ATTRIBUTI
        private Viaggio elem;
        private Nodo next;

        //COSTRUTTORE
        Nodo(Viaggio elem){
            this.elem = elem;
            this.next = null;
        }
    }//fine nodo

    private Nodo testa;
    ListaViaggi(){  this.testa = null;}
    
    //PREDICATI
    public boolean empty(){  return testa == null;}
    public boolean full(){  return false;}

    //INSERIMENTO IN TESTA
    private void push(Viaggio e){
        Nodo q = new Nodo(e);
        q.next = testa;
        testa = q;
    }

    //INSERIMENTO IN CODA
    public void append(Viaggio e){
        if(empty()){
            push(e);
        } else {
            Nodo temp = testa;
            Nodo q = new Nodo(e);

            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = q;
        }
    }

    //METODO STAMPA
    public void stampa(){
        Nodo temp = testa;
        while(temp != null){
            System.out.println(temp.elem);
            temp = temp.next;
        }
    }

    //METODO CERCA
    public Viaggio cerca(int e){
        Nodo temp = testa;
        while(temp != null){
            if(temp.elem.getIdViaggio() == e)
                return temp.elem;
            else
                temp = temp.next;
        }
        return null;
    }

    //METODO PRENOTA
    public void prenota(int idViaggio){
        Viaggio viaggio = cerca(idViaggio);
        if(viaggio == null)
            System.out.println("Nessun viaggio trovato con ID: " +idViaggio);
        else{
            try{
                viaggio.prenotaViaggio();
                System.out.println("Prenotazione effettuata per il viaggio con ID: " +idViaggio);
            }
            catch (ViaggioGiaPrenotatoException e){
                System.out.println("Errore: " +e.getMessage());
            }
        }
    }

    //METODO FILTRA
    public Viaggio[] filtra(String destinazione){
        int count = contaPerDestinazione(destinazione);
        if(count == 0)
            return null;

        Viaggio[] filtrati = new Viaggio[count];

        Nodo temp = testa;
        int i=0;

        while(temp != null){
            Viaggio viaggio = temp.elem;
            if(viaggio.getDestinazione().equalsIgnoreCase(destinazione)){
                filtrati[i] = viaggio;
                i++;
            }
            temp = temp.next;
        }
        return filtrati;
    }

    //METODO RICERCA DESTINAZIONE
    public int contaPerDestinazione(String destinazione) {
        Nodo temp = testa;
        int count = 0;

        while(temp != null){
            Viaggio viaggio = temp.elem;
            if(viaggio.getDestinazione().equalsIgnoreCase(destinazione))
                count++;

            temp = temp.next;
        }
        return count;
    }
}