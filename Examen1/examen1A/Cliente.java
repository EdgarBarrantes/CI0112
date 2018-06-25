import java.util.ArrayList;
/**
 * Implementa la clase Cliente.
 *
 * @author Edgar Barrantes
 * @version 0.0.1
 */
public class Cliente {
    // Instance variables.
    String nombre;
    double montoDolaresCambiados;
    ArrayList<Moneda> listaMonedas;

    /**
     * Esto responde al requerimiento #3
     * Constructor for objects of class Cliente
     */
    public Cliente(String n)
    {
        // Initialise instance variables
        nombre = n;
        montoDolaresCambiados = 0;
    }

    /**
     * Esto responde al requerimiento #6.
     * Imprime la lista de monedas que tiene el cliente.
     */
    public void imprimeBalanceMonedas() {
        for (Moneda moneda :listaMonedas) {
            System.out.print(moneda.getNombre() + ' ' + moneda.getCantidad());
        }
    }

    /**
     * Permiten al cliente hacer cambios de moneda y guardarlos.
     * Sin embargo, esto no es un requerimiento en este examen.
     * Así que se puede obviar.
     */
    public void realizarCambioMonedaADolar(Moneda m, double monto) {
        double montoDolares = m.getDolares(monto);
        if (tieneMoneda(m.getNombre())) {
            m.removeCantidadMonedas(monto);
            montoDolaresCambiados += montoDolares;
        }
        else {
            System.out.println("Usted no puede cambiar esa moneda pues no tiene.");
        }
    }

    public void realizarCambioMonedaAMoneda(Moneda m, double monto) {
        double montoMoneda = m.getMonedas(monto);
        montoDolaresCambiados += monto;
        if (tieneMoneda(m.getNombre())) {
            m.addCantidadMonedas(monto);
        }
        else {
            listaMonedas.add(new Moneda(m.getNombre(), m.getTipoCambio(), montoMoneda));
        }
    }

    /**
     * Devuelve si el cliente tiene la moneda o no.
     */
    public boolean tieneMoneda(String nombreMoneda) {
        boolean tieneLaMoneda = false;
        for (Moneda moneda : listaMonedas) {
            if (moneda.getNombre() == nombreMoneda) {
                tieneLaMoneda = tieneLaMoneda || true;
            }
        }
        return tieneLaMoneda;
    }
}
