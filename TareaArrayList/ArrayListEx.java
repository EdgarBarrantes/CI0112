import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
import java.util.Collections;
/**
* Practice about ArrayList
* CI0112 / UCR / 1st semester 2018
*
* @author Edgar Barrantes
* @version 26/04/18
*/

public class ArrayListEx {
    // Instance Variables.
    private ArrayList<Integer> arr;
    private int n;
    /**
    * Constructor for objects of class ArrayListEx
    */
    public ArrayListEx() {
        arr = new ArrayList<>();
        n = 0;
    }
    
    /**
    * Setters.
    */
    private void setN(int num) {
        n = num;
    }
    
    private void setArr(ArrayList<Integer> array) {
        arr = array;
    }
    
    /**
    * Getters.
    */
    private int getN() {
        return n;
    }
    
    private ArrayList<Integer> getArr() {
        return arr;
    }
    
    /**
    * Main method.
    */
    public static void main (String args []) {
        ArrayListEx arrayExercise = new ArrayListEx();
        arrayExercise.setN(arrayExercise.readNumberOfLines());
        // Generate a new array (arrayList) with n elements.
        arrayExercise.setArr(arrayExercise.generateRandomArray(arrayExercise.n));
        // Print the newly generated array.
        arrayExercise.printArrayList(arrayExercise.getArr());
        // Prints the average of all the elements in the array.
        System.out.println("The average of the numbers is: " + arrayExercise.average(arrayExercise.arr));
        // Prints the standard deviation of all the elements in the array.
        System.out.println("The standard deviation of the numbers is: " + arrayExercise.stdDev(arrayExercise.arr));
        // Orders the array, set it, since the original array (arrayList) won't be needed again.
        arrayExercise.setArr(arrayExercise.orderArrayList(arrayExercise.getArr()));
        // Print the array (arrayList) with a legend.
        System.out.println("The ordered array (arrayList) is:");
        arrayExercise.printArrayList(arrayExercise.getArr());
        // No need to make a method to get the highest value. Since the array (arrayList) is ordered, the highest value is the last value.
        System.out.println("The largest value in the array (arrayList) is: " + arrayExercise.getArr().get(arrayExercise.getN() - 1));
        // Print the array with the most common values. 
        System.out.println(arrayExercise.givesModeString(arrayExercise.getMode(arrayExercise.getArr())));
    }
    
    /**
    * Read number n from user.
    */
    private int readNumberOfLines() {
        Scanner sc = new Scanner(System.in);
        String stringN = sc.nextLine();
        return Integer.parseInt(stringN);
    }
    
    /**
    * Generates new random n numbers from 1 to 10. 
    * It also prints them, why waste a cycle?
    */
    private ArrayList<Integer> generateRandomArray(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        Random rng = new Random();
        System.out.println("Generated random numbers:");
        for (int i = 0; i < n; i++) {
            arr.add((int) Math.ceil(rng.nextDouble()*10));
        }
        return arr;
    }
    
    /**
    * Prints an arrayList.
    */
    private void printArrayList(ArrayList<Integer> toPrintArray) {
        String stringArray = "{";
        int maxI = toPrintArray.size() - 1;
        for (int i = 0; i < maxI; i++) {
            stringArray += toPrintArray.get(i) + ", ";
        }
        stringArray += toPrintArray.get(maxI) + "}";
        System.out.println(stringArray);
    }
    
    /**
    * Returns average of a number arrayList.
    */
    private double average(ArrayList<Integer> toAverageArray) {
        double average = 0;
        int size = toAverageArray.size();
        for (int i = 0; i < size ; i++) {
            average += toAverageArray.get(i);
        }
        average /= size;
        return average;
    }
    
    /**
    * Returns standard deviation of a number arrayList.
    */
    private double stdDev(ArrayList<Integer> toStdDevArray) {
        double avg = average(toStdDevArray);
        double std2 = 0;
        int size = toStdDevArray.size();
        for (int number:toStdDevArray) {
            std2 += Math.pow(number - avg, 2)/ size;
        }
        std2 = Math.sqrt(std2);
        return std2;
    }
    
    /**
    * Orders arrayList values and returns a new ordered arrayList.
    */
    private ArrayList<Integer> orderArrayList(ArrayList<Integer> toOrderArray) {
        // Uses collections, why reinvent the wheel?
        Collections.sort(toOrderArray);
        return toOrderArray;
    }
    
    /**
    * Returns the most repeated value in an array (mode).
    */
    private ArrayList<Integer>  getMode(ArrayList<Integer> toGetModeArray) {
        // Amount of times the most common values are repeated.
        int repeated = 0;
        // Array to store the most common values (with repeated values if any).
        ArrayList<Integer> modes = new ArrayList<>();
        // Array to remove repeated values in final modes array if any.
        ArrayList<Integer> modesNonRepeated = new ArrayList<>();
        // Variable to store size of arrays. It is used several times.
        int size = toGetModeArray.size();
        // Cycle the array and count the ammount of times the most repeated value is found.
        for (int i = 0; i < size; i++) {
            int insideForRepeated = 0;
            for (int j = 0; j < size; j++) {
                insideForRepeated += (toGetModeArray.get(j) == toGetModeArray.get(i)) ? 1 : 0;
            }
            if (insideForRepeated > repeated) {
                repeated = insideForRepeated;
            }
        }
        System.out.println("The mode(s) are repeated: " + repeated + " times.");
        // Cycle the array and compare the amount of times a number is repeated and 
        // if it matches the number of the most repeated value, then adds it to the
        // array of "modes".
        for (int i = 0; i < size; i++) {
            int insideForRepeated = 0;
            for (int j = 0; j < size; j++) {
                insideForRepeated += (toGetModeArray.get(j) == toGetModeArray.get(i)) ? 1 : 0;
            }
            if (insideForRepeated == repeated) {
                modes.add(toGetModeArray.get(i));
            }
        }
        // Cycle the array and compares if a values is already in the final arrayList.
        for (int mode:modes) {
            if (!modesNonRepeated.contains(mode)) {
                modesNonRepeated.add(mode);
            }
        }
        return modesNonRepeated;
    }
    /**
    * Prints a string with the mode or the most common values.
    */
    private String givesModeString(ArrayList<Integer> toStringModeArray) {
        String modeString = "";
        int size = toStringModeArray.size();
        if (size > 1) {
            modeString = "The most common values are: ";
            for (int i = 0; i < size - 1; i++) {
                modeString += toStringModeArray.get(i) + ", ";
            }
            modeString += toStringModeArray.get(size - 1) + ".";
        }
        else {
            modeString = "The most common value (mode) is: " + toStringModeArray.get(0);
        }
        return modeString;
    }
}
