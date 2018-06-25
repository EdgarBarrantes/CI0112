
/**
 * Write a description of class FamTree here.
 *
 * @author Edgar Barrantes
 * @version 0.0.1
 */
public class FamTree {
    public class Person {
        String name;
        Person siblingPrev;
        Person siblingNext;
        Person siblingFatherPrev;
        Person siblingFatherNext;
        Person siblingMotherPrev;
        Person siblingMotherNext;
        Person siblingSoulPrev;
        Person siblingSoulNext;

        public Person(String name) {
            this.name = name;
        }
    }

    FamTree motherSide;
    FamTree fatherSide;
    Person person;

    /**
     * Constructors for objects of class FamTree
     */
    public FamTree(Person person) {
        this.person = person;
    }

    public FamTree(String name) {
        this.person = new Person(name);
    }

    /**
     * Adds the mother of the person.
     */
    public void addMother(String motherName) {
        motherSide = new FamTree(motherName);
    }

    /**
     * Adds the father of the person.
     */
    public void addFather(String fatherName) {
        fatherSide = new FamTree(fatherName);
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
