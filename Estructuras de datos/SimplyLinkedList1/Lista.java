/**
 * Tarea Programada 3.
 * B10833
 * Prof: Javier Vásquez.
 * Esta es la lista con una clase para nodos. Hay ejemplos de uso en el main.
 * Con cabeza y cola.
 * 
 * @author Edgar Barrantes 
 * @version 1.0.0
 */
public class Lista
{
    Nodo cabeza;
    Nodo cola;

    /**
     * Constructor for Lista.
     */
    public Lista()
    {
        cabeza = null;
        cola = null;
    }

    /**
     * Adds at the end of the list.
     */
    public void add(int v) {
        if (cabeza == null)
            cabeza = cola = new Nodo(v);
        else{
            cola.next = new Nodo(v);
            cola = cola.next;                
        }
    }

    /**
     * Adds at the begining of the list.
     */
    public void addToHead(int v) {
        if (cabeza == null) {
            cabeza = cola = new Nodo(v);
        }
        else {
            Nodo temp = cabeza;
            cabeza = new Nodo(v);
            cabeza.next = temp;
        }
    }

    /**
     * Adds at the desired index, replacing the old value.
     */
    public void addToIndex(int index, int v) {
        if (cabeza != null) {
            if (cabeza.getSize() > index) {
                cabeza.getNodoAt(index).x = v;
            }   
        }
    }

    /**
     * Returns all values in the List.
     */
    public String getValues() {
        return cabeza.getAllVal();
    }

    /**
     * Finds out if there is a value in the list and returns it's index. 
     * Returns -1 if the item is not on the list.
     */
    public int getIndex(int v) {
        return cabeza.searchValue(v);
    }

    /**
     * Return the ammount of values in list.
     */
    public int size() {
        return cabeza.getSize();
    }

    /**
     * Deletes a value.
     */
    public void delete(int v) {
        cabeza.deleteValue(v);
    }

    /**
     * Returns the sum of all numbers in list.
     */
    public double sum() {
        return cabeza.sum();
    }

    /**
     * Returns the prom of all values.
     */
    public double prom() {
        // These lines can be used for debugging.
        // System.out.println("Sum: " + this.sum());
        // System.out.println("Size: " + this.size());
        return (this.sum())/this.size();
    }

    /**
     * Returns the value at index i.
     */
    public int getValue(int i) {
        return getNode(i).x;
    }

    /**
     * Returns the node at index i.
     */
    public Nodo getNode(int i) {
        return cabeza.getNodoAt(i);
    }

    /**
     * Orders the list.
     */
    public void order() {
        for (int i = this.size(); i > 0; i--) {
            for (int j = 1; j <= i - 1; j++) {
                if (this.getValue(j) < this.getValue(j-1)) {
                    int temp = this.getValue(j);
                    this.getNode(j).x = this.getNode(j-1).x;
                    this.getNode(j-1).x = temp;
                }
            }
        }
    }

    /**
     * Returns the amount of times the more repeated value in the list
     * is repeated.
     */
    public int repeated() {
        this.order();
        int counter = 1;
        int currentCounter = 1;
        for (int i = 0; i < this.size() - 1; i++) {
            if(this.getValue(i) == this.getValue(i + 1)) {
                currentCounter += 1;
            }
            else {
                if (currentCounter > counter) {
                    counter = currentCounter;
                }
                currentCounter = 0;
            }
        }
        return counter;
    }

    /**
     * Returns the modes.
     */
    public Lista modes() {
        Lista m = new Lista();
        int currentCounter = 1;
        int r = repeated();
        for (int i = 0; i < this.size() - 1; i++) {
            if(this.getValue(i) == this.getValue(i + 1)) {
                currentCounter += 1;
            }
            else {
                // If the counter is equal to the max number
                // of repeated values. Then add it to the modes Lista.
                if (currentCounter == r) {
                    m.add(this.getValue(i));
                }
                currentCounter = 1;
            }
        }
        return m;
    }

    public static void main() {
        Lista l = new Lista();
        l.add(23);
        l.add(18);
        l.add(4);
        l.add(4);
        l.add(4);
        l.add(56);
        l.add(56);
        l.add(56);
        l.add(78);
        l.addToHead(100);
        // Prints the values.
        System.out.println("Valores: " + l.getValues());
        // Value to find.
        int e = 3;
        System.out.println("El valor " + e + (l.getIndex(e) == -1 ? " no está en la lista." : " está en el índice: " + l.getIndex(e)));
        // Ammount of nodes in the list.
        System.out.println("Cantidad de nodos: " + l.size());
        System.out.println("El promedio de los valores es: " + l.prom());
        // Integer to delete.
        int d = 23;
        l.delete(d);
        System.out.println("Valores después de borrar de la lista el nodo con el valor " + d + ": " + l.getValues());
        // Index to get the value of.
        int i = 1;
        System.out.println("El nodo en el indice: " + i + " tiene el valor de: " + l.getValue(i));
        l.order();
        System.out.println("Valores ordenados: " + l.getValues());
        System.out.println("Las veces que se repite la moda: " + l.repeated());
        System.out.println("Las modas: " + l.modes().getValues());
    }
}
