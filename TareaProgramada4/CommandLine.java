import java.util.Scanner;

/**
 * Class intended for interaction with the user. Allows the reading and
 * decomposition of commands, which control the flow of the program.
 * 
 * @author (Gloriana Mora Villalta & Edgar Barrantes Brais.)
 * @version (6/7/2018)
 */
public class CommandLine {
    private Scanner input;

    /**
     * Constructor for objects of class CommandLine.
     */
    public CommandLine() {
        input = new Scanner(System.in);
    }

    /**
     * Method to read and store in an array a command entered by the user, dividing
     * it by regular expressions.
     * 
     * @return An array of Strings, that contains a divided command, so that the
     *         first cell contains the action that the user wants to execute and
     *         then the necessary parameters to perform it.
     */
    public String[] getCommand() {
        return input.next().split("[\\s,->]+");
    }

}
