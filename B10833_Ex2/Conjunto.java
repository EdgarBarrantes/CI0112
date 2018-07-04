import java.util.ArrayList;

/**
 * Respuesta a la pregunta A.
 *
 * @author B10833
 * @version 0.0.1
 */
public class Conjunto {
    NodoLista cabeza;
    NodoLista cola;

    /**
     * Constructor for objects of class Conjunto
     */
    public Conjunto() {
        cabeza = null;
        cola = null;
    }

    /**
     * Añadir en orden. Hay que cuidar que un mismo número no se pueda repetir.
     * Respuesta a la pregunta 1A.
     */
    public void add(int elementoConjunto) {
        if (cabeza == null) {
            cabeza = cola = new NodoLista(elementoConjunto);
        } else {
            NodoLista temp;
            if (cabeza.x > elementoConjunto) {
                temp = new NodoLista(elementoConjunto);
                temp.next = cabeza;
                cabeza = temp;
            } else {
                if (cola.x < elementoConjunto) {
                    cola.next = new NodoLista(elementoConjunto);
                    cola = cola.next;
                } else {
                    // Sólo se itera si realmente se necesita.
                    NodoLista iter = cabeza;
                    while (iter.next.x < elementoConjunto) {
                        iter = iter.next;
                    }
                    if (iter.next.x != elementoConjunto) {
                        temp = iter.next;
                        iter.next = new NodoLista(elementoConjunto);
                        iter.next.next = temp;
                    }
                }
            }
        }
    }

    /**
     * Devuelve la cantidad de valores en la lista. Respuesta a la pregunta A2.
     */
    public int size() {
        return cabeza.getSize();
    }

    /**
     * Devuelve un booleando indicando la existencia del número buscado en el array.
     * Respuesta a la pregunta A3.
     */
    public boolean exists(int v) {
        return cabeza.searchValue(v);
    }

    /**
     * Devuelve todos los valores de la lista.
     */
    public String getValues() {
        return cabeza.getAllVal();
    }

    /**
     * Encuentra la intersección entre el conjunto actual y uno que recibe.
     * Respuesta a la pregunta A4.
     */
    public Conjunto interseccion(Conjunto conjuntoAComparar) {
        Conjunto conjuntoFinal = new Conjunto();
        NodoLista iter = cabeza;
        // Para el caso en el que la cabeza y la cola sean iguales.
        if (conjuntoAComparar.exists(iter.x)) {
            conjuntoFinal.add(iter.x);
        }
        while (iter.next != null) {
            if (conjuntoAComparar.exists(iter.x)) {
                conjuntoFinal.add(iter.x);
            }
            iter = iter.next;
        }
        return conjuntoFinal;
    }

    public static void main(String[] args) {
        Conjunto a = new Conjunto();
        a.add(3);
        a.add(1);
        a.add(7);
        a.add(3);
        a.add(11);
        a.add(77);
        System.out.println(a.size());
        System.out.println(a.exists(7));
        System.out.println(a.exists(10));
        Conjunto b = new Conjunto();
        b.add(3);
        b.add(8);
        b.add(10);
        System.out.println(a.getValues());
        System.out.println(b.getValues());
        System.out.println("La intersección es: " + a.interseccion(b).getValues());
    }
}
