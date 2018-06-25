import java.util.Scanner;
import java.util.ArrayList;
/**
 * View class.
 *
 * @author Edgar Barrantes
 * @version 0.0.1
 */
public class ConjuntosView
{
    // Instance Scanner
    private Scanner sc;

    /**
     * Constructor for objects of class view
     */
    public ConjuntosView() {
        sc = new Scanner(System.in);
    }

    /**
     * A method to read strings.
     */
    public String readString() {
        return sc.nextLine();
    }

    /**
     * A method to print strings.
     */
    public void printString(String string) {
        System.out.println(string);
    }

    /**
     * Prints arrays.
     */
    public void printArray(ArrayList<Integer> array) {
        for (int element : array) {
            System.out.println(element);
        }
    }
}
