public class NodoLista {
  // Variables del Nodo de la lista.
  int x;
  boolean empty;
  NodoLista next;

  /**
   * Constructor con valor.
   */
  public NodoLista(int v) {
    x = v;
    next = null;
    empty = false;
  }

  /**
   * Constructor sin valor.
   */
  public NodoLista() {
    next = null;
    empty = true;
  }

  /**
   * Devuelve la cantidad de nodos en la lista. Respuesta a la pregunta A2.
   */
  public int getSize() {
    int index = 1;
    NodoLista iter = this;
    if (!empty) {
      while (iter.next != null) {
        index += 1;
        iter = iter.next;
      }
    } else {
      return 0;
    }
    return index;
  }

  /**
   * Busca una valor en el conjunto. Respuesta a la pregunta A2.
   */
  public boolean searchValue(int v) {
    NodoLista iter = this;
    while (iter.x != v && iter.next != null) {
      iter = iter.next;
    }
    if (iter.x != v) {
      return false;
    }
    return true;
  }

  /**
   * Devuelve un string con todos los valores del conjunto.
   */
  public String getAllVal() {
    String t = "";
    NodoLista iter = this;
    if (!empty) {
      while (iter.next != null) {
        t += iter.x + " ";
        iter = iter.next;
      }
      t += iter.x + " ";
    }
    return t;
  }
}