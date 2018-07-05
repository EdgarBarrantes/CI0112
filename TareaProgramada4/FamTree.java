
/**
 * Write a description of class FamTree here.
 *
 * @author Edgar Barrantes
 * @version 0.0.1
 */
public class FamTree {

    Person person;
    Person firstSibling;
    Person firstSiblingBySoul;

    /**
     * Constructors for objects of class FamTree
     */
    public FamTree(Person person) {
        this.person = person;
        firstSibling = firstSiblingByFather = firstSiblingByMother = firstSiblingBySoul = null;
    }

    public FamTree(String name) {
        this.person = new Person(name);
        firstSibling = firstSiblingByFather = firstSiblingByMother = firstSiblingBySoul = null;
    }

    /**
     * Adds the mother of the person.
     */
    public void addMother(String motherName) {
        person.motherSide = new FamTree(motherName);
        // Recorrer a los hermanos del tipo indicado y añadirles la madre.
    }

    /**
     * Adds the father of the person.
     */
    public void addFather(String fatherName) {
        person.fatherSide = new FamTree(fatherName);
        // Recorrer a los hermanos del tipo indicado y añadirles el padre.
    }

    // Generic add sibling.
    public void addS(String v) {
        if (firstSibling == null) {
            firstSibling = new Person(v);
            person.siblingPrev = firstSibling;

        } else {
            Person temp = firstSibling;
            firstSibling = new Person(v);
            temp.prev = firstSibling;
            firstSibling.next = temp;
        }
    }

    /**
     * Adds a sibling of both mother and father.
     */
    public void addSibling(Person p) {
        // Recorrer a los hermanos del tipo indicado y añadirlo. Además, añadir a ese
        // hermano, padre y madre del actual.
        if (firstSibling == null) {
            firstSibling = new Person(v);
            person.siblingPrev = firstSibling;
            firstSibling.father = father;
            firstSibling.mother = mother;

        } else {
            Person temp = firstSibling;
            firstSibling = new Person(v);
            temp.prev = firstSibling;
            firstSibling.next = temp;
            firstSibling.father = father;
            firstSibling.mother = mother;
        }
    }

    /**
     * Adds a sibling of both mother and father.
     */
    public void addSiblingByFather(Person p) {
        // Recorrer a los hermanos del tipo indicado y añadirlo. Además, añadir a ese
        // hermano, padre del actual.
        if (firstSiblingByFather == null) {
            firstSiblingByFather = new Person(v);
            person.siblingPrev = firstSiblingByFather;
            firstSiblingByFather.father = father;
            firstSiblingByFather.mother = mother;

        } else {
            Person temp = firstSibling;
            firstSibling = new Person(v);
            temp.prev = firstSibling;
            firstSiblingByFather.next = temp;
            firstSiblingByFather.father = father;
            firstSiblingByFather.mother = mother;
        }
    }

    /**
     * Adds a sibling of both mother and father.
     */
    public void addSiblingByMother(Person p) {
        // Recorrer a los hermanos del tipo indicado y añadirlo. Además, añadir a ese
        // hermano, madre del actual.
    }

    /**
     * Adds a sibling of both mother and father.
     */
    public void addSiblingBySoul(Person p) {
        // Recorrer a los hermanos del tipo indicado y añadirlo.
    }

    /**
     * Show family tree.
     */
    public String muestreArbol(String t, int p) {
        String r = "";
        if (motherSide != null) {
            r += motherSide.muestreArbol(t, p + 1);
        }
        for (int i = 0; i < p; i++)
            r += "*" + t;
        r += person.name + "\n";
        if (fatherSide != null) {
            r += fatherSide.muestreArbol(t, p + 1);
        }
        return r;
    }

    public static void main(String[] args) {
        FamTree ft = new FamTree("Alice");
        ft.addFather("Bob");
        ft.addMother("Claudia");
        ft.fatherSide.addFather("Edsger");
        ft.fatherSide.addMother("Fatima");
        System.out.println(ft.muestreArbol("  ", 0));
    }
}
