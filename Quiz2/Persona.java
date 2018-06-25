import java.util.ArrayList;
/**
 * Pregunta 3.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Persona
{
    ArrayList<Auto> autos;
    int id;
    /**
     * Constructor for objects of class Persona
     */
    public Persona(int ident)
    {
        id = ident;
        autos = new ArrayList<>();
    }

    /**
     * Devuelve lista de autos.
     */
    public ArrayList<Auto> getAutos() {
        return autos;
    }

    /**
     * Annade un auto a la persona.
     */
    public void addAuto(Auto auto) {
        autos.add(auto);
    }
}
