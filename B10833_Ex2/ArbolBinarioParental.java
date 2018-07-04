import java.util.ArrayList;

/**
 * Respuesta a la pregunta B.
 *
 * @author B10833
 * @version 0.0.1
 */
public class ArbolBinarioParental {
    int x;
    boolean empty;
    ArbolBinarioParental iz;
    ArbolBinarioParental dr;
    ArbolBinarioParental up;

    /**
     * Constructores.
     */
    public ArbolBinarioParental() {
        empty = true;
        iz = dr = up = null;
    }

    public ArbolBinarioParental(int v) {
        x = v;
        empty = false;
        iz = dr = up = null;
    }

    public ArbolBinarioParental(ArbolBinarioParental t) {
        x = t.x;
        empty = t.empty;
        iz = t.iz;
        dr = t.dr;
        up = t.up;
    }

    /**
     * Añade un elemento al árbol. 
     * Esto responde la pregunta B5.
     */
    public void add(int v) {
        if (empty) {
            x = v;
            empty = false;
        } else {
            if (v < x) {
                if (iz == null) {
                    iz = new ArbolBinarioParental(v);
                    iz.up = this;
                } else {
                    iz.add(v);
                }
            } else {
                if (v > x) {
                    if (dr == null) {
                        dr = new ArbolBinarioParental(v);
                        dr.up = this;
                    } else {
                        dr.add(v);
                    }
                }
            }
        }
    }

    /**
     * Muestra el arbol en notacion IPD. 
     * Esto responde la pregunta B6.
     */
    public String getIPD() {
        String r = "";
        if (iz != null) {
            r += iz.getIPD();
        }
        r += x + " ";
        if (dr != null) {
            r += dr.getIPD();
        }
        return r;
    }

    /**
     * Muestra el arbol en IPD pero en posicion vertical, ordenado.
     * Esto responde la pregunta B6.
     */
    public String muestreArbol(String t, int p) {
        String r = "";
        if (iz != null) {
            r += iz.muestreArbol(t, p + 1);
        }
        for (int i = 0; i < p; i++)
            r += "*" + t;
        r += x + "\n";
        if (dr != null) {
            r += dr.muestreArbol(t, p + 1);
        }
        return r;
    }

    /**
     * Devuelve todas las hojas del arbol. 
     * Esto responde la pregunta B7.
     */
    public ArrayList<ArbolBinarioParental> halleHoja(ArrayList<ArbolBinarioParental> hojas) {
        if (iz != null) {
            iz.halleHoja(hojas);
        }
        if (iz == null && dr == null) {
            hojas.add(this);
        }
        if (dr != null) {
            dr.halleHoja(hojas);
        }
        return hojas;
    }

    /**
     * Muestre la ruta desde una hoja hasta la raiz. 
     * Esto responde la pregunta B8.
     */
    public void deRuta() {
        // Get it? Iter / Eater... Anyway...
        ArbolBinarioParental treeEater = this;
        System.out.print(x);
        while (treeEater.up != null) {
            System.out.print(" -> " + treeEater.up.x);
            treeEater = treeEater.up;
        }
        System.out.println();
    }

    /**
     * Pruebas de la funcionalidad del programa.
     */
    public static void main(String[] args) {
        ArbolBinarioParental a = new ArbolBinarioParental();
        a.add(50);
        a.add(60);
        a.add(40);
        a.add(45);
        a.add(35);
        a.add(55);
        a.add(65);
        a.add(30);
        System.out.println("El arbol impreso en IPD plano: ");
        System.out.println(a.getIPD());
        System.out.println("El arbol impreso en IPD dibujado: ");
        System.out.println(a.muestreArbol("  ", 0));
        ArrayList<ArbolBinarioParental> hojas = new ArrayList();
        hojas = a.halleHoja(hojas);
        System.out.println("Las hojas son: ");
        System.out.print(hojas.get(0).x);
        for (int i = 1; i < hojas.size(); i++) {
            System.out.print(", " + hojas.get(i).x);
        }
        System.out.println("\nLa ruta de la hoja con el num " + hojas.get(0).x + " es:");
        hojas.get(0).deRuta();
    }
}
