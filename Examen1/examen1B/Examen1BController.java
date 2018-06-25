import java.util.ArrayList;
/**
 * Controller class
 *
 * @author Edgar Barrantes
 * @version 0.0.1
 */
public class Examen1BController
{
    // Instances model and view variables.

    /**
     * Constructor for objects of class controller
     */
    public Examen1BController()
    {
        // Initialize model and view.
    }
    
    public static void main(String args[]) {
        Examen1BController controller = new Examen1BController();
        controller.imprimirNumerosDesc(50);
    }

    /**
     * Esto resuelve el requerimiento de toda la parte B.
     */
    public void imprimirNumerosDesc(int p) {
        boolean isDesc = false;
        int sum = 0;
        ArrayList<Integer> sumandos = new ArrayList<>();
        for (int i = 3; i < p; i++) {
            sum = 0;
            sumandos = new ArrayList<>();
            for (int j = 1; j < i; j++) {
                sum += j;
                sumandos.add(j);
                if (sum == i) {
                    isDesc = true;
                    break;
                }
            }
            if (isDesc) {
                String suma = "";
                for (int contador = 0; contador < sumandos.size() - 1; contador++) {
                    suma += sumandos.get(contador) + " + ";
                }
                suma += sumandos.get(sumandos.size() - 1);
                System.out.println ("Numero desc " + i + " equivale a " + suma);
                isDesc = false;
            }
        }
    }
 }
