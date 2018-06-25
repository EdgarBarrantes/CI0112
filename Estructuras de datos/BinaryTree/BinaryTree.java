
/**
 * A binary integer tree.
 *
 * @author Edgar Barrantes
 * @version 0.0.1
 */

public class BinaryTree {
    int x;
    boolean empty;
    BinaryTree iz;
    BinaryTree dr;

    /**
     * Constructors for objects of class BinaryTree
     */
    public BinaryTree() {
        empty = true;
        iz = dr = null;
    }

    public BinaryTree(int v) {
        x = v;
        empty = false;
        iz = dr = null;
    }

    public BinaryTree(BinaryTree t) {
        x = t.x;
        empty = t.empty;
        iz = t.iz;
        dr = t.dr;
    }

    /**
     * Adds an interger to the tree.
     */
    public void add(int v) {
        if (empty) {
            x = v;
            empty = false;
        } else {
            if (v < x) {
                if (iz == null) {
                    iz = new BinaryTree(v);
                } else {
                    iz.add(v);
                }
            }
            if (v > x) {
                if (dr == null) {
                    dr = new BinaryTree(v);
                } else {
                    dr.add(v);
                }
            }
        }
    }

    /**
     * Returns a boolean indicating if the integer is in the tree.
     */
    public boolean existe(int v) {
        if (!empty) {
            if (v == x) {
                return true;
            } else {
                if (v < x) {
                    if (iz == null) {
                        return false;
                    } else {
                        return iz.existe(v);
                    }
                }
                if (v > x) {
                    if (dr == null) {
                        return false;
                    } else {
                        return dr.existe(v);
                    }
                }
            }
        }
        return false;
    }

    /**
     * Returns a tree starting in the searched for number. Returns null if the
     * number is not on the tree.
     */
    public BinaryTree search(int v) {
        if (this != null) {
            if (v == x) {
                return this;
            } else {
                if (v < x) {
                    return iz.search(v);
                }
                if (v > x) {
                    return dr.search(v);
                }
            }
        }
        return null;
    }

    /**
     * Show tree in IPD order.
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
     * Show tree in PID order.
     */
    public String getPID() {
        String r = "";
        r += x + " ";
        if (iz != null) {
            r += iz.getPID();
        }
        if (dr != null) {
            r += dr.getPID();
        }
        return r;
    }

    /**
     * Show tree in a IPD fashion but rotated 270 degrees.
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
     * Returns number of nodes in the tree. P counts the ammount of nodes. If the
     * we're on the root, it adds 1 to count the root itself.
     */
    public int dePeso(boolean root) {
        int nodes = 0;
        if (iz != null) {
            nodes += 1 + iz.dePeso(false);
        }
        if (dr != null) {
            nodes += 1 + dr.dePeso(false);
        }
        if (root) {
            nodes += 1;
        }
        return nodes;
    }

    /**
     * Returns the depth of the tree.
     */
    public int deProfundidad(boolean root, int p) {
        int profundidadMax = 0;
        if (iz == dr && iz == null) {
            return p;
        } else {
            if (iz != null && dr == null) {
                return iz.deProfundidad(false, p + 1);
            }
            if (dr != null && iz == null) {
                return dr.deProfundidad(false, p + 1);
            }
            if (iz.deProfundidad(false, p + 1) > dr.deProfundidad(false, p + 1)) {
                profundidadMax = iz.deProfundidad(false, p + 1);
            } else {
                profundidadMax = dr.deProfundidad(false, p + 1);
            }
        }
        return profundidadMax;
    }

    /**
     * Returns the breadth of specific level.
     */
    public int deAnchuraNivel(int level) {
        if (level == 0) {
            return 1;
        } else {
            if (iz == null && dr == null) {
                return 0;
            }
            if (iz == null) {
                return dr.deAnchuraNivel(level - 1);
            }
            if (dr == null) {
                return iz.deAnchuraNivel(level - 1);
            }
            return iz.deAnchuraNivel(level - 1) + dr.deAnchuraNivel(level - 1);
        }
    }

    /**
     * Returns the max breadth of the tree.
     */
    public int[] deAnchura() {
        int[] a = { 0, 0 };
        int anchuraNivel;
        int profundidad = deProfundidad(true, 0);
        for (int i = 0; i <= profundidad; i++) {
            anchuraNivel = deAnchuraNivel(i);
            if (anchuraNivel > a[0]) {
                a[0] = anchuraNivel;
                a[1] = i;
            }
        }
        return a;
    }

    /**
     * Returns the greatest number of the numbers that are lower than the one in the
     * current node.
     */
    public int deMayorMenores(boolean root) {
        if (root) {
            return iz.deMayorMenores(false);
        }
        if (dr == null) {
            return x;
        } else {
            return dr.deMayorMenores(false);
        }
    }

    /**
     * Returns the lowest number of the numbers that are greater to the one in the
     * current node.
     */
    public int deMenorMayores(boolean root) {
        if (root) {
            return dr.deMenorMayores(false);
        }
        if (iz == null) {
            return x;
        } else {
            return iz.deMenorMayores(false);
        }
    }

    /**
     * Check if the tree is a leaf.
     */
    public boolean isLeaf() {
        if (iz == dr && iz == null) {
            return true;
        }
        return false;
    }

    /**
    * Deletes a leaf in the tree.
    * This is done less efficiently.
    * 
    * If node is leaf: then just erase it. Else: if it only has one subtree, use
    * the closest number in that subtree to replace it. If it has 2 subtrees, then
    * compare weights. Use the heaviest. And use the closest number in that sub-
    * tree to replace it. After that, search for the number it was used to replace
    * it in the corresponding subtree (because if not, it will find it self), and
    * call the erase fuction again
    */
    public void erase2(int v) {
        // Search for the subtree with the element.
        if (this != null) {
            if (x != v) {
                this.search(v).erase2(v);
            } else {
                // If the node is a leaf, then set empty to true. cleanUp() will deal with it.
                if (this.isLeaf()) {
                    empty = true;
                } else {
                    // If it has 2 subtrees, then search for the heaviest subtree.
                    if (this.iz != null && this.dr != null) {
                        // If the left subtree is the heaviest, or of equal weight value. Then use the
                        // highest value in that subtree. Then search for the subtree with that
                        // highest value. And erase the node.
                        if (this.iz.dePeso(true) >= this.iz.dePeso(true)) {
                            this.x = this.deMayorMenores(true);
                            this.iz.erase2(this.x);
                        } else {
                            this.x = this.deMenorMayores(true);
                            this.dr.erase2(this.x);
                        }
                        
                    } else {
                        if (this.iz != null) {
                            this.x = this.deMayorMenores(true);
                            this.iz.erase2(this.x);
                        } else {
                            this.x = this.deMenorMayores(true);
                            this.dr.erase2(this.x);
                        }
                    }
                }
            }
            
        }
    }

    /**
     * Cleans up the tree, every leaf with empty = true gets deleted.
     */
    public void cleanUp() {
        if (iz != null) {
            if (iz.iz == null && iz.dr == null) {
                if (iz.empty == true) {
                    iz = null;
                }
            } else {
                iz.cleanUp();
            }
        }
        if (dr != null) {
            if (dr.iz == null && dr.dr == null) {
                if (dr.empty == true) {
                    dr = null;
                }
            } else {
                dr.cleanUp();
            }
        }
    }

    /**
     * Erase efficient.
     */
    public BinaryTree erase(int v) {
        BinaryTree t = new BinaryTree(this);
        if (t.x == v) {
            if (t.isLeaf()) {
                return null;
            } else {
                if (t.iz != null && t.dr != null) {
                    if (iz.dePeso(true) > dr.dePeso(true)) {
                        t.x = t.deMayorMenores(true);
                        t.iz = t.iz.erase(t.x);
                    } else {
                        t.x = t.deMenorMayores(true);
                        t.dr = t.dr.erase(t.x);
                    }
                } else {
                    if (t.iz != null) {
                        t.x = t.deMayorMenores(true);
                        t.iz = t.iz.erase(t.x);
                    } else {
                        t.x = t.deMenorMayores(true);
                        t.dr = t.dr.erase(t.x);
                    }
                }
            }
        } else {
            if (v < t.x) {
                if (t.iz != null) {
                    t.iz = t.iz.erase(v);
                } else {
                    return this; // Revisar esto.
                }
            } else {
                if (t.dr != null) {
                    t.dr = t.dr.erase(v);
                } else {
                    return this;
                }
            }
        }
        return t;
    }

    /**
     * Testing of the tree.
     */
    public static void main(String[] args) {
        // Creates tree and adds values.
        BinaryTree ar = new BinaryTree();
        ar.add(50);
        ar.add(40);
        ar.add(60);
        ar.add(45);
        ar.add(49);
        ar.add(70);
        // ar.add(55);
        ar.add(30);
        // ar.add(39);
        // ar.add(34);
        // ar.add(36);
        ar.add(80);
        // ar.add(15);
        // ar.add(37);
        // ar.add(10);
        // ar.add(54);
        // ar.add(52);
        // ar.add(53);
        ar.add(51);
        // Shows the tree integers.
        System.out.println("IPD: " + ar.getIPD());
        System.out.println("PID: " + ar.getPID());
        // Searches for a value in the tree.
        int valor = 10;
        System.out.println("La existencia del valor " + valor + " es: " + ar.existe(valor));
        valor = 104;
        System.out.println("La existencia del valor " + valor + " es: " + ar.existe(valor));
        // Shows the tree in a nice way.
        System.out.println("El arbol en PID:");
        System.out.println(ar.muestreArbol("  ", 0));
        // Gives info of the tree.
        System.out.println("Cantidad de nodos: " + ar.dePeso(true));
        System.out.println("El considera el nivel de la raiz como 0.");
        System.out.println("Profundidad: " + ar.deProfundidad(true, 0));
        int[] anchura = ar.deAnchura();
        System.out.println("Anchura: " + anchura[0] + ". En el nivel: " + anchura[1] + ".");
        System.out.println("El menor número mayor a " + ar.x + ": " + ar.deMenorMayores(true));
        System.out.println("El mayor número menor a " + ar.x + ": " + ar.deMayorMenores(true));
        // Test search feature. Searches for a number and shows the corresponding tree.
        // System.out.println(ar.search(54).muestreArbol(" ", 0));
        // Test the erasing feature.
        valor = 40;
        // ar.erase(valor);
        // ar.cleanUp();
        System.out.println("El arbol luego de borrar el " + valor);
        BinaryTree ar2;
        long startTime;
        startTime = System.nanoTime();
        ar2 = ar.erase(valor);
        long time = System.nanoTime() - startTime;
        System.out.println("Tiempo para borrar eficiente: " + time / 1000000.0 + " milisegundos.");
        System.out.println(ar2.muestreArbol("  ", 0));
        startTime = System.nanoTime();
        ar.erase2(valor);
        ar.cleanUp();
        time = System.nanoTime() - startTime;
        System.out.println("Tiempo para borrar no eficiente: " + time / 1000000.0 + " milisegundos.");
        System.out.println(ar.muestreArbol("  ", 0));
    }
}