/**
 * Tarea Programada 3.
 * B10833
 * Prof: Javier Vásquez.
 * Es el nodo de la lista simple con la implementación 1.
 * Con cabeza y cola.
 * 
 * @author Edgar Barrantes 
 * @version 1.0.0
 */
public class Nodo
{
    // Variables of the Node.
    int x;
    boolean empty;
    Nodo next;

    /**
     *  Constructor with value.
     */
    public Nodo(int v) {
        x = v;
        next = null;
        empty = false;
    }

    /**
     *  Constructor without value.
     */
    public Nodo() {
        next=null;
        empty=true;
    }

    /**
     *  Returns a String with all the values in the nodes starting in the current one.
     */
    public String getAllVal() {
        String t = "";
        Nodo iter=this;
        if (!empty) {           
            while (iter.next != null) {
                t += iter.x + " ";
                iter = iter.next;
            }
            t += iter.x + " ";
        }
        return t;
    }

    /**
     * Returns the ammount of nodes following the current node.
     */
    public int getSize() {
        int index = 1;
        Nodo iter = this;
        if (!empty) {
            while (iter.next != null) {
                index += 1;
                iter = iter.next;
            }
        }
        return index;
    }

    /**
     * Searches for a value. Returns -1 if the number is not on the list.
     */
    public int searchValue(int v) {
        int index = 0;
        Nodo iter = this;
        while (iter.x != v && iter.next != null) {
            index += 1;
            iter = iter.next;
        }
        if (iter.x != v) {
            return -1;
        }
        return index;
    }

    /**
     * Deletes a value.
     */
    public void deleteValue(int v) {
        Nodo iter = this;
        if (iter.x != v) {
            while (iter.next.x != v && iter.next.next != null) {
                iter = iter.next;
            }
        }
        if (iter.next.x == v) {
            iter.next = iter.next.next;
        }
    }

    /**
     * Returns sum of all values.
     */
    public double sum() {
        double p = 0;
        Nodo iter = this;
        while (iter.next != null) {
            p += iter.x;
            iter = iter.next;
        }
        p += iter.x;
        return p;
    }

    /**
     * Returns modals.
     */
    public String modals() {
        String modals = "";
        return modals;
    }

    /**
     * Returns the node at index i.
     */
    public Nodo getNodoAt(int i) {
        Nodo iter = this;
        for (int j = 0; j < i; j++) {
            iter = iter.next;
        }
        return iter;
    }
}
