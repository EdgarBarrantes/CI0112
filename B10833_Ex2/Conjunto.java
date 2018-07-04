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
     * Devuelve la cantidad de valores en la lista. 
     * Respuesta a la pregunta A2.
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
            iter = iter.next;
            if (conjuntoAComparar.exists(iter.x)) {
                conjuntoFinal.add(iter.x);
            }
        }
        return conjuntoFinal;
    }

    public static void main(String[] args) {
        Conjunto a = new Conjunto();
        a.add(3);
        a.add(1);
        a.add(7);
        // Se trata de añadir un número que ya está en la lista, esto no funciona, como es pedido.
        a.add(3);
        a.add(11);
        a.add(77);
        Conjunto b = new Conjunto();
        b.add(3);
        b.add(88);
        b.add(11);
        b.add(1);
        b.add(77);
        b.add(24);
        b.add(8);
        b.add(23);
        System.out.println("Conjunto A:");
        System.out.println(a.getValues());
        System.out.println("Conjunto B:");
        System.out.println(b.getValues());
        System.out.println("Tamaño del conjunto A:");
        System.out.println(a.size());
        System.out.println("Tamaño del conjunto B:");
        System.out.println(b.size());
        int alpha = 7;
        System.out.println("Booleano que indica si " + alpha + " está en el conjunto A:");
        System.out.println(a.exists(alpha));
        alpha = 10;
        System.out.println("Booleano que indica si " + alpha + " está en el conjunto A:");
        System.out.println(a.exists(alpha));
        System.out.println("La intersección de los conjuntos A y B es: " + a.interseccion(b).getValues());
    }
}
