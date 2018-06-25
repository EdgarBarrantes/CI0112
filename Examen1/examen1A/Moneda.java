import java.util.ArrayList;

/**
 * Implementa la clase Moneda. 
 *
 * @author Edgar Barrantes
 * @version 0.0.1
 */
public class Moneda {
    // Instance variables.
    private String nombreMoneda;
    private double tipoCambio;
    private double cantidad;
    // Esta variable sirve para almacenar en todas las instancias
    // la misma lista de monedas.
    private static ArrayList<Moneda> listaMonedasEmpresa = new ArrayList<>();

    /**
     * Esto responde al requerimiento #1.
     * Constructor for objects of class Moneda.
     */
    public Moneda(String nMoneda, double tCambio, double cMonedas) {
        nombreMoneda = nMoneda;
        tipoCambio = tCambio;
        cantidad = cMonedas;
        listaMonedasEmpresa.add(this);
    }

    /**
     * Almacena la moneda en la lista de monedas.
     */
    public void almacenarMoneda(Moneda moneda) {
        listaMonedasEmpresa.add(moneda);
    }

    /**
     * Getters.
     */
    public String getNombre() {
        return nombreMoneda;
    }
    public double getTipoCambio() {
        return tipoCambio;
    }
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Esto responder al requerimiento #2
     * Recibe cantidad de monedas a intercambiar.
     * Devuelve cantidad de dolares equivalentes segun tipo de cambio.
     * Hace el cambio: suma la cantidad de monedas a la cantidad de monedas
     * existentes.
     */
    public double getDolares(double cMonedas) {
        double dolares = 0;
        if (cantidad >= cMonedas) {
            dolares = cMonedas * tipoCambio;
            cantidad += cMonedas;
            // Esto responder al requerimiento #7
            imprimeAlerta(dolares);
        }
        return dolares;
    }

    /**
     * Esto responder al requerimiento #2
     * Recibe cantidad de dolares a intercambiar.
     * Devuelve cantidad de monedas equivalentes segun tipo de cambio.
     * Hace el cambio: resta la cantidad de monedas a la cantidad de monedas
     * existentes.
     */
    public double getMonedas(double cDolares) {
        double cMonedas = 0;
        // Esto responder al requerimiento #7
        imprimeAlerta(cDolares);
        if (cMonedas >= cantidad) {
            cMonedas = cDolares/tipoCambio;
            cantidad -= cMonedas;
        }
        return cMonedas;
    }

    /**
     * Esto responder al requerimiento #4
     * Devuelve el listado de las monedas que se manejan.
     */
    public void imprimirListaMonedasEmpresa() {
        imprimirListaMonedas(listaMonedasEmpresa);
    }

    /**
     * Imprime una lista de monedas.
     */
    public void imprimirListaMonedas(ArrayList<Moneda> listaMonedas) {
        for (Moneda moneda : listaMonedas) {
            System.out.print(moneda.getNombre() + ' ' + moneda.getTipoCambio() + '\n');
        }
    }

    /**
     * Esto responder al requerimiento #6
     * Imprime la lista ordenada de monedas. 
     */
    public void imprimirListaMonedasEmpresasOrdenadas() {
        imprimirListaMonedas(ordenarMonedas(listaMonedasEmpresa));
    }

    /**
     * Esto responder al requerimiento #6
     * Ordena la lista de monedas segun el tipo de cambio y la devuelve.
     */
    public ArrayList<Moneda> ordenarMonedas(ArrayList<Moneda> listaMonedas) {
        int sizeListaMonedas = listaMonedas.size();
        double tcActual;
        double tcCiclo;
        Moneda monedaTemporal;
        for (int i = 0; i < sizeListaMonedas; i++) {
            tcActual = listaMonedas.get(i).getTipoCambio();
            for (int j = 0; j < sizeListaMonedas; j++) {
                tcCiclo = listaMonedas.get(j).getTipoCambio();
                if (tcCiclo < tcActual) {
                    monedaTemporal = listaMonedas.get(j);
                    listaMonedas.set(j, listaMonedas.get(i));
                    listaMonedas.set(i, monedaTemporal);
                }
            }
        }
        return listaMonedas;
    }


    /**
     * Esto responder al requerimiento #7
     * Método imprime alertas si el usuario cambia más de cierto monto.
     */
    public void imprimeAlerta(double cDolares) {
        if (nombreMoneda == "Yenes" 
        || nombreMoneda == "Yuanes" 
        || nombreMoneda == "Rublos" 
        || nombreMoneda == "Euros" 
        || nombreMoneda == "Dólares" 
        || nombreMoneda == "Libras") {
            if (cDolares > 10000) {
                System.out.println("ALERTA, monto excede límite.");
            }
        }
        else {
            if (cDolares > 8000) {
                System.out.println("ALERTA, monto excede límite.");
            }
        }
    }

    /**
     * Esto devuelve un arraylist de monedas ordenado por tipo de cambio.
     */
    public ArrayList<Moneda> ordenarListaMonedas() {
        ArrayList<Moneda> listaOrdenada = new ArrayList<>();
        return listaOrdenada;
    }
    
    /**
     * Añade al monto total de monedas.
     */
    public void addCantidadMonedas (double cantidadToAdd) {
        cantidad += cantidadToAdd;
    }

    /**
     * Quita al monto total de monedas.
     */
    public void removeCantidadMonedas (double cantidadToAdd) {
        cantidad -= cantidadToAdd;
    }

    /**
     * Main method. For testing purposes.
     */
    public static void main(String args[]) {
        listaMonedasEmpresa = new ArrayList<>();
        Moneda m1 = new Moneda("Colones", 0.001774, 500000);
        Moneda m2 = new Moneda("Euros", 1.19, 500000);
        Moneda m3 = new Moneda("Rublos", 0.01595, 500000);
    }
}
