import java.util.Scanner;
import java.util.ArrayList;
/**
* Write a description of class AutoView here.
*
* @author (your name)
* @version (a version number or a date)
*/
public class AutoView
{
    private static Scanner sc;
    /**
    * Constructor for objects of class AutoView
    */
    public AutoView() {
        sc = new Scanner(System.in);
    }
    
    /**
    * Leer persona.
    */
    public Persona readPersona() {
        int id;
        Persona persona;
        System.out.println("De el id de la persona.");
        id = Integer.parseInt(sc.nextLine());
        persona = new Persona(id);
        return persona;
    }
    
    /**
    * Leer auto.
    */
    public Auto readAuto() {
        int placa;
        int anno;
        double valor;
        Auto auto;
        System.out.println("De el numero de placa.");
        placa = Integer.parseInt(sc.nextLine());
        System.out.println("De el anno del auto.");
        anno = Integer.parseInt(sc.nextLine());
        System.out.println("De el valor fiscal.");
        valor = Double.parseDouble(sc.nextLine());
        auto = new Auto(placa, anno, valor);
        return auto;
    }

    /**
     * Muestre valor fiscal de una persona.
     */
    public void showValores(Persona persona) {
        ArrayList<Auto> autos = persona.getAutos();
        double valorFiscal;
        for (int i = 0; i < autos.size(); i++) {
            valorFiscal = autos.get(i).getValorFiscal();
            // Se podría aprovechar esta lectura para poner el valor fiscal.
            // autos.get(i).setImpuestoAnual(valorFiscal);
            System.out.println("El valor de fiscal de la placa " + autos.get(i).getNumPlaca() + " es: " + valorFiscal);
        }
    }
    
    /**
    * Menu.
    */
    public boolean repeatPersonas() {
        System.out.println("Si quiere dejar de leer personas, presione enter.\nSi quiere continuar presione cualquier otra cosa.");
        String toContinue = sc.nextLine();
        return (toContinue != null && !toContinue.isEmpty());
    }
    
    public boolean repeatAutos() {
        System.out.println("Si desea seguir añadiendo autos, digite cualquier cosa y presione enter.\nEn caso contrario, si quiere ver la lista de autos, presione enter.");
        String toContinue = sc.nextLine();
        return (toContinue != null && !toContinue.isEmpty());
    }
}
