
/**
 * Pregunta 1.
 */
public class Auto
{
    // instance variables - replace the example below with your own
    private int numPlaca;
    private int annoAuto;
    private double valorFiscal;
    private double impuestoAnual;

    /**
     * Constructor for objects of class Auto
     */
    public Auto(int placa, int anno, double valor) {
        numPlaca = placa;
        annoAuto = anno;
        valorFiscal = valor;
    }
    /**
     * Getters y setters necesarios.
     */
    public int getNumPlaca() {
        return numPlaca;
    }

    public int getAnnoAuto() {
        return annoAuto;
    }
    
    public double getValorFiscal() {
        return valorFiscal;
    }

    public void setImpuestoAnual(double impuesto) {
        impuestoAnual = impuesto;
    }
}
