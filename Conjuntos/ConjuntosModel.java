import java.util.ArrayList;
/**
 * Model class.
 *
 * @author Edgar Barrantes
 * @version 0.0.1
 */
public class ConjuntosModel
{
    // Instance variables.

    /**
     * Constructor for objects of class model
     */
    public ConjuntosModel()
    {
        // Initialise instance variables
    }

    /**
     * Implementa la unión de conjuntos
     */
    public ArrayList<Integer> unionConjuntos(ArrayList<Integer> array1, ArrayList<Integer> array2) {
        ArrayList<Integer> finalArray1 = array1;
        ArrayList<Integer> repeated = new ArrayList<>();
        for(int i = 0; i < getCardinality(array2); i++) {
            if (array1.contains(array2.get(i))) {
                repeated.add(i);
            }
        }
        for(int i = 0; i < getCardinality(array2); i++) {
            if(!repeated.contains(i)) {
                finalArray1.add(array2.get(i));
            }
        }
        return finalArray1;
    }

    /**
     * Implementa la intersección de conjuntos
     */
    public ArrayList<Integer> interseccionConjuntos(ArrayList<Integer> array1, ArrayList<Integer> array2) {
        ArrayList<Integer> finalArray2 = new ArrayList<>();
        int number;
        for(int i = 0; i < getCardinality(array1); i++) {
            number = array1.get(i);
            if (array2.contains(number)) {
                finalArray2.add(number);
            }
        }
        return finalArray2;
    }

    /**
     * Implementa el complemento de la interjeccion de conjuntos
     */
    public ArrayList<Integer> complementoIntejeccionConjuntos(ArrayList<Integer> array1, ArrayList<Integer> array2) {
        ArrayList<Integer> finalArray3 = new ArrayList<>();
        ArrayList<Integer> repeated1 = new ArrayList<>();
        ArrayList<Integer> repeated2 = new ArrayList<>();
        for(int i = 0; i < getCardinality(array1); i++) {
            if (array2.contains(array1.get(i))) {
                repeated1.add(i);
            }
        }
        for(int i = 0; i < getCardinality(array2); i++) {
            if (array1.contains(array2.get(i))) {
                repeated2.add(i);
            }
        }
        for(int i = 0; i < getCardinality(array1); i++) {
            if(!repeated1.contains(i)) {
                finalArray3.add(array1.get(i));
            }
        }
        for(int i = 0; i < getCardinality(array2); i++) {
            if(!repeated2.contains(i)) {
                finalArray3.add(array2.get(i));
            }
        }
        return finalArray3;
    }
    
    /**
     * Implementa la diferencia de conjuntos
     */
    public ArrayList<Integer> diferenciaConjuntos(ArrayList<Integer> array1, ArrayList<Integer> array2) {
        ArrayList<Integer> finalArray3 = new ArrayList<>();
        ArrayList<Integer> repeated1 = new ArrayList<>();
        ArrayList<Integer> repeated2 = new ArrayList<>();
        for(int i = 0; i < getCardinality(array1); i++) {
            if (array2.contains(array1.get(i))) {
                repeated1.add(i);
            }
        }
        for(int i = 0; i < getCardinality(array1); i++) {
            if(!repeated1.contains(i)) {
                finalArray3.add(array1.get(i));
            }
        }
        return finalArray3;
    }

    /**
     * Devuelve la cardinalidad del conjunto.
     */
    public int getCardinality(ArrayList<Integer> array) {
        return array.size();
    }

    /**
     * Crea y devuelve el array1.
     */
    public ArrayList<Integer> array1() {
        ArrayList<Integer> array1 = new ArrayList<>();
        array1.add(1);
        array1.add(2);
        array1.add(3);
        array1.add(4);
        array1.add(5);
        return array1;
    }

    /**
    * Crea y devuelve el array2.
    */
    public ArrayList<Integer> array2() {
        ArrayList<Integer> array2 = new ArrayList<>();
        array2.add(1);
        array2.add(2);
        array2.add(6);
        array2.add(7);
        array2.add(8);
        return array2;
    }
}
