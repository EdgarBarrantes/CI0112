import java.util.ArrayList;

/**
 * Write a description of class AutoModel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AutoModel
{
    ArrayList<Persona> personas;

    /**
     * Constructor for objects of class AutoModel
     */
    public AutoModel()
    {
        personas = new ArrayList<>();
    }

    /**
     * Annade personas.
     */
    public void addPersona(Persona persona) {
        personas.add(persona);
    }

    /**
     * Devuelve personas.
     */
    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    /**
     * Get persona by id.
     */
    public Persona getPersona(int i) {
        return personas.get(i);
    }

    /**
     * Calcule impuesto.
     * Pregunta 2.
     */
    public static double calculeImpuesto(Auto auto) {
        double impuesto = 0;
        int autoAnno = auto.getAnnoAuto();
        if (autoAnno >= 2008) {
            auto.setImpuestoAnual(0.05);
        } else {
            if (autoAnno < 1998) {
                auto.setImpuestoAnual(0.20);
            }
            // Para mayores o iguales a 1998 pero menores a 2008
            else {
                auto.setImpuestoAnual(0.15);
            }
        }
        return impuesto;
    }
}
