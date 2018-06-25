/**
* Tarea Programada 3.
* B10833
* Prof: Javier Vásquez.
* Esta es la lista si clase aparte para nodos. Hay ejemplos de uso en el main.
* Con cabeza y cola.
* 
* @author Edgar Barrantes 
* @version 1.0.0
*/
public class Lista
{
    int x;
    boolean empty;
    Lista next;
    /**
    * Constructors for objects of class Lista
    */
    public Lista()
    {
        empty=true;
        next = null;
    }
    
    public Lista(int v) {
        empty = false;
        this.x = v;
        next = null;
    }
    
    public Lista(Lista lista)
    {
        x = lista.x;
        empty= lista.empty;
        next = lista.next;
        
    }
    
    /**
    * Adds at the end of the list.
    */
    public void add(int v) {
        if (empty) {
            x = v;
            empty = false;
        }
        else {
            if (next == null) {
                next = new Lista(v);
            }
            else {
                Lista iter = new Lista(this);
                while (iter.next != null) {
                    iter = iter.next;
                }
                iter.next = new Lista(v);
            }            
        }
    }
    
    /**
    * Adds at the begining of the list.
    */
    void addToHead(int v) {
        if (empty) {
            x = v;
            empty = false;
        }
        else {
            next = new Lista (this);
            x = v;
        }
    }
    
    /**
    * Returns a String with all the values.
    */
    String getValues() {
        String r = x + " ";
        Lista iter = new Lista(this);
        while(iter.next != null) {
            iter = iter.next;
            r += iter.x + " ";
        }   
        return r;
    }
    
    /**
    * Returns whether or not an integer is on the list.
    */
    public boolean search(int v) {
        Lista iter = new Lista(this);
        if (iter.x == v) {
            return true;
        }
        while (iter.next != null) {
            if (iter.next.x == v) {
                return true;
            }
            iter = iter.next;
        }
        return false;
    }
    
    /**
    * Returns the index at which the integer is in the list.
    */
    public int searchIndex(int v) {
        int counter = 1;
        Lista iter = new Lista(this);
        if (iter.x == v) {
            return 0;
        }
        while (iter.next != null) {
            if (iter.next.x == v) {
                return counter;
            }
            iter = iter.next;
            counter += 1;
        }
        if (counter == iter.size() - 1) {
            return -1;
        }
        return counter;
    }
    
    /** 
    * Returns the size of a Lista.
    */
    public int size() {
        int counter = 1;
        Lista iter = new Lista(this);
        while (iter.next != null) {
            iter = iter.next;
            counter += 1;
        }
        return counter;
    }
    
    /**
    * Erases a value in the list.
    */
    public void remove(int v) {
        Lista iter = new Lista(this);
        if (iter.x != v) {
            while (iter.next.x != v) {
                if (iter.next != null) {
                    iter = iter.next;
                }
            }
        }
        if (iter.next.x == v) {
            iter.next = iter.next.next;
        }
    }
    
    /**
    * Returns the sum of the numbers in the list.
    */
    public double sum() {
        double sum = x;
        Lista iter = new Lista(this);
        while (iter.next != null) {
            sum += iter.next.x;
            iter = iter.next;
        }
        return sum;
    }
    
    /**
    * Returns the List at a given index.
    */
    public Lista getListaAt(int i) {
        Lista iter = new Lista(this);
        for (int j = 0; j < i; j++) {
            iter = iter.next;
        }
        return iter;
    }
    
    /**
    * Returns the prom of the numbers in the list.
    */
    public double prom () {
        return this.sum()/this.size();
    }
    
    /**
    * Orders the list.
    */
    public void order() {
        int temp;
        for (int i = this.size(); i > 0; i--) {
            for (int j = 1; j <= i - 1; j++) {
                if (this.getListaAt(j).x < this.getListaAt(j - 1).x) {
                    temp = this.getListaAt(j).x;
                    this.getListaAt(j).x = this.getListaAt(j - 1).x;
                    this.getListaAt(j - 1).x = temp;
                }
            }
        }
    }

    /**
     * Returns the most ammount of times any value is repeated.
     */
    public int repeated() {
        this.order();
        int counter = 1;
        int currentCounter = 1;
        for (int i = 0; i < this.size() - 1; i++) {
            if(this.getListaAt(i).x == this.getListaAt(i + 1).x) {
                currentCounter += 1;
            }
            else {
                if (currentCounter > counter) {
                    counter = currentCounter;
                }
                currentCounter = 1;
            }
        }
        if (currentCounter > counter) {
            counter = currentCounter;
        }
        return counter;
    }

    /**
    * Returns the modes in the List.
    */
    public Lista modes() {
        Lista modes = new Lista();
        int currentCounter = 1;
        int repeated = this.repeated();
        for (int i = 0; i < this.size() - 1; i++) {
            if(this.getListaAt(i).x == this.getListaAt(i + 1).x) {
                currentCounter += 1;
            }
            else {
                if (currentCounter == repeated) {
                    modes.add(this.getListaAt(i).x);
                }
                currentCounter = 1;
            }
        }
        return modes;
    }
    
    public static void main () {
        Lista lista = new Lista();
        lista.add(2);
        lista.add(5);
        lista.add(4);
        lista.add(11);
        lista.add(4);
        lista.add(45);
        lista.add(11);
        lista.add(4);
        lista.add(4);
        lista.add(11);
        System.out.println("Valores: " + lista.getValues());
        int f = 2;
        System.out.println("¿Está el valor " + f + " en la lista? " + lista.search(f));
        if (lista.search(f)) {
            System.out.println("El valor " + f + " está en el índice " + lista.searchIndex(f));
        }
        f = 32;
        System.out.println("¿Está el valor " + f + " en la lista? " + lista.search(f));
        if (lista.search(f)) {
            System.out.println("El valor " + f + " está en el índice " + lista.searchIndex(f));
        }
        f = 4;
        lista.remove(f);
        System.out.println("Valores después de remover el " + f + ": " + lista.getValues());
        System.out.println("El promedio de los valores en la lista es: " + lista.prom());
        lista.order();
        System.out.println("Los valores ordenados: " + lista.getValues());
        System.out.println("La cantidad de veces que se repite(n) la(s) moda(s) es: " + lista.repeated());
        System.out.println("La(s) moda(s) es(son): " + lista.modes().getValues());
    }
}
