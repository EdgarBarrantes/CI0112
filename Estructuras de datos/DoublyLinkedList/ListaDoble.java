/**
* Tarea Programada 3.
* B10833
* Prof: Javier Vásquez.
* Esta es la lista doble. Hay ejemplos de uso en el main.
* Con cabeza y cola.
* 
* @author Edgar Barrantes 
* @version 1.0.0
*/
public class ListaDoble
{
  Nodo cabeza;
  Nodo cola;
  
  /**
  * Constructors for objects of class ListaDoble
  */
  public ListaDoble()
  {
    cabeza = null;
    cola = null;
  }

  public ListaDoble(Nodo cabeza, Nodo cola) {
    this.cabeza = cabeza;
    this.cola = cola;
  }
  
  /**
  * Adds at the end of the list.
  */
  public void add(int v) {
    if (cabeza == null)
    cabeza = cola = new Nodo(v);
    else {
      cola.next = new Nodo(v);
      cola.next.prev = cola;
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
      temp.prev = cabeza;
      cabeza.next = temp;
    }
  }
  
  /**
  * Returns all values in the List.
  */
  public String getValues() {
    return cabeza.getAllVal();
  }
  
  /**
  * Deletes a value.
  */
  public void delete(int v) {
    cabeza.deleteValue(v);
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
  * Returns a strings with values and it's repetitions in the list.
  */
  public String repetitions() {
    String rep = "";
    ListaDoble numeros = new ListaDoble();
    ListaDoble repeticiones = new ListaDoble();
    // We could decide not to order the list. Nevertheless, in this case we're doing it.
    // The order function could return a new List instead of this. 
    this.order();
    int currentCounter = 1;
    int size = this.size();
    for (int i = 0; i < size - 1; i++) {
      if(this.getValue(i) == this.getValue(i + 1)) {
        currentCounter += 1;
      }
      else {
        // Stores the values, just in case, for a future implementation.
        numeros.add(this.getValue(i));
        repeticiones.add(currentCounter);
        rep += "Valor: " + this.getValue(i) + ". Repetido: " + currentCounter + ".\n";
        currentCounter = 1;
      }
    }
    if (this.getValue(size - 1) != this.getValue(size - 2)) {
      rep += "Valor: " + this.getValue(size - 1) + ". Repetido: " + 1 + ".\n";
    }
    return rep;
  }
  
  /**
  * Return the ammount of values in list.
  */
  public int size() {
    return cabeza.getSize();
  }
  /**
  *  Returns a boolean if the node has a next value. For the iterator.
  */
  public boolean hasNext() {
    boolean hasNext = (this.cabeza.next == null ? false : true);
    return hasNext;
  }
  
  /**
  * Returns a boolean if the node has a previous value. For the iterator.
  */
  public boolean hasPrev() {
    boolean hasPrev = (this.cola.prev == null ? false : true);
    return hasPrev;
  }

  /**
   * Returns the value of the next node and removes it. This is for the iterator.
   */
  public int next() {
    int value = this.cabeza.x;
    this.cabeza = this.cabeza.next;
    return value;
  }

  /**
   * Returns the value of the next node and removes it. This is for the iterator (almost).
   */
  public int prev() {
    int value = this.cola.x;
    this.cola = this.cola.prev;
    return value;
  }
  
  /**
  * Given that we are using public variables. This could work as a backwards iterator (almost).
  */
  public ListaDoble backwardsIterator() {
    return new ListaDoble(cabeza, cola);
  }
  
  /**
  * Given that we are using public variables. This could work as a forward iterator.
  */
  public ListaDoble forwardsIterator() {
    return new ListaDoble(cabeza, cola);
  }
  
  /**
  * Cycles the array to test the backwards iterator.
  * Adds number to a String and returns it.
  * The fact that Java automatically initializes an int as a 0 is to blame here.
  * if it didn't one could check if x == null (or the likes). In prev().
  */
  public String getValuesBackwards() {
    String t = "";
    ListaDoble bkIterator = this.backwardsIterator();
    while (bkIterator.hasPrev()) {
      t += bkIterator.prev() + " ";
    }
    t += bkIterator.cola.x;
    return t;
  }
  
  /**
  * Main made to show the thing it working.
  */
  public static void main() {
    ListaDoble l = new ListaDoble();
    l.add(23);
    l.add(18);
    l.add(4);
    l.add(4);
    l.add(4);
    l.addToHead(100);
    l.addToHead(90);
    l.addToHead(90);
    System.out.println("Valores: " + l.getValues());
    System.out.println("Lista al revés: " + l.getValuesBackwards());
    System.out.println("Repeticiones: \n" + l.repetitions());
  }
}