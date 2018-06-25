
/**
 * Quiz 2
 *
 * @author Edgar Barrantes
 * @version 03/05/2018
 */
public class AutoController
{
    private AutoModel model;
    private AutoView view;
    /**
     * Constructor for objects of class AutoController
     */
    public AutoController()
    {
        model = new AutoModel();
        view = new AutoView();
    }

    /**
     * Main
     * Pregunta 4.
     */
    public static void main(String args[]) {
        AutoController controller = new AutoController();
        // Annade persona.
        controller.model.addPersona(new Persona(0));
        Persona personaEspecifica = controller.model.getPersona(0);
        do{
            // Pregunta 5. Pregunta 6.
            personaEspecifica.addAuto(controller.view.readAuto());
        } while (controller.view.repeatAutos());
        // Pregunta 7.
        for (Auto autos : personaEspecifica.getAutos()) {
            controller.view.showValores(personaEspecifica);
        }
    }
}
