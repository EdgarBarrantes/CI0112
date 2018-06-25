
/**
* Write a description of class Nodo here.
*
* @author (your name)
* @version (a version number or a date)
*/
public class Nodo
{
    // Variables del nodo.
    int x;
    boolean empty;
    Nodo next;
    Nodo prev;
    
    /**
    * Constructor for objects of class Nodo
    */
    public Nodo()
    {
        next = null;
        prev = null;
        empty = false;
    }
    
    /**
    * Constructor for objects of class Nodo
    */
    public Nodo(int v) {
        x = v;
        next = null;
        prev = null;
        empty = false;
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
            iter.next.prev = iter;
        }
    }
    
    /**
    *  Returns a String with all the values in the nodes starting in the current one.
    */
    public String getAllVal() {
        String t = "";
        Nodo iter = this;
        if (!empty) {
            while (iter.next != null) {
                t += iter.x + " ";
                iter = iter.next;
            }
            t += iter.x;
        }
        return t;
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
}
