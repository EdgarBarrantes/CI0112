import java.util.ArrayList;
/**
 * Controller class
 *
 * @author Edgar Barrantes
 * @version 0.0.1
 */
public class ConjuntosController
{
    // Instances model and view variables.
    private ConjuntosModel model;
    private ConjuntosView view;

    /**
     * Constructor for objects of class controller
     */
    public ConjuntosController()
    {
        // Initialize model and view.
        model = new ConjuntosModel();
        view = new ConjuntosView();
    }
    
    public static void main(String args[]) {
        ConjuntosController controller = new ConjuntosController();
        // You can access model and view public methods (or variables),
        // in the following way. You are free to erase this.
        // To follow MVC you should limit mostly to call model and view
        // methods.
        // controller.model.method();
        // controller.view.method();
        controller.view.printString("Array 1:");
        controller.view.printArray(controller.model.array1());
        controller.view.printString("Array 2:");
        controller.view.printArray(controller.model.array2());
        controller.view.printString("Union de conjuntos:");
        controller.view.printArray(controller.model.unionConjuntos(controller.model.array1(), controller.model.array2()));
        controller.view.printString("Intesección de conjuntos:");
        controller.view.printArray(controller.model.interseccionConjuntos(controller.model.array1(), controller.model.array2()));
        controller.view.printString("Diferencia de conjuntos:");
        controller.view.printArray(controller.model.diferenciaConjuntos(controller.model.array1(), controller.model.array2()));
        controller.view.printString("complemento de la interjeccion de conjuntos");
        controller.view.printArray(controller.model.complementoIntejeccionConjuntos(controller.model.array1(), controller.model.array2()));
    }
}
