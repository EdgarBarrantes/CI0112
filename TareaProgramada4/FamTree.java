
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
        firstSibling = firstSiblingBySoul = null;
    }

    public FamTree(String name) {
        this.person = new Person(name);
        firstSibling = firstSiblingBySoul = null;
    }

    /**
     * Adds the mother of the person.
     */
    public void addMother(String motherName) {
        person.setMother(motherName);
        // Recorrer a los hermanos del tipo indicado y añadirles la madre?
    }

    /**
     * Adds the father of the person.
     */
    public void addFather(String fatherName) {
        person.setFather(fatherName);
        // Recorrer a los hermanos del tipo indicado y añadirles el padre?
    }

    /**
     * Adds a sibling of both mother and person.father.
     */
    public void addSibling(Person p) {
        // Recorrer a los hermanos del tipo indicado y añadirlo. Además, añadir a ese
        // hermano, padre y madre del actual.
        if (firstSibling == null) {
            firstSibling = new Person(p);
            person.siblingPrev = firstSibling;
            firstSibling.father = person.father;
            firstSibling.mother = person.mother;
        } else {
            Person temp = firstSibling;
            firstSibling = new Person(p);
            temp.siblingPrev = firstSibling;
            firstSibling.siblingNext = temp;
            firstSibling.father = person.father;
            firstSibling.mother = person.mother;
        }
    }

    /**
     * Añade hermanos por nombre.
     */
    public void addSibling(String name) {
        Person p = new Person(name);
        addSibling(p);
    }

    /**
     * Adds a sibling of both mother and father.
     */
    public void addSiblingByFather(Person p) {
        // Recorrer a los hermanos del tipo indicado y añadirlo. Además, añadir a ese
        // hermano, padre del actual.
        if (firstSibling == null) {
            firstSibling = new Person(p);
            person.siblingPrev = firstSibling;
            firstSibling.father = person.father;
        } else {
            Person temp = firstSibling;
            firstSibling = new Person(p);
            temp.siblingPrev = firstSibling;
            firstSibling.siblingNext = temp;
            firstSibling.father = person.father;
        }
    }

    /**
     * Añade hermanos por nombre.
     */
    public void addSiblingByFather(String name) {
        Person p = new Person(name);
        addSiblingByFather(p);
    }

    /**
     * Adds a sibling of both mother and father.
     */
    public void addSiblingByMother(Person p) {
        // Recorrer a los hermanos del tipo indicado y añadirlo. Además, añadir a ese
        // hermano, madre del actual.
        if (firstSibling == null) {
            firstSibling = new Person(p);
            person.siblingPrev = firstSibling;
            firstSibling.mother = person.mother;
        } else {
            Person temp = firstSibling;
            firstSibling = new Person(p);
            temp.siblingPrev = firstSibling;
            firstSibling.siblingNext = temp;
            firstSibling.mother = person.mother;
        }
    }

    /**
     * Añade hermanos por nombre.
     */
    public void addSiblingByMother(String name) {
        Person p = new Person(name);
        addSiblingByMother(p);
    }

    /**
     * Adds a sibling of both mother and father.
     */
    public void addSiblingBySoul(Person p) {
        // Recorrer a los hermanos del tipo indicado y añadirlo.
        if (firstSiblingBySoul == null) {
            firstSiblingBySoul = new Person(p);
            person.siblingBySoulPrev = firstSiblingBySoul;
        } else {
            Person temp = firstSiblingBySoul;
            firstSiblingBySoul = new Person(p);
            temp.siblingBySoulPrev = firstSiblingBySoul;
            firstSiblingBySoul.siblingBySoulNext = temp;
        }
    }

    /**
     * Añade hermanos por nombre.
     */
    public void addSiblingBySoul(String name) {
        Person p = new Person(name);
        addSiblingBySoul(p);
    }

    /**
     * Añade hermanos a la lista de hermanos default.
     */
    public void addSiblingGeneric(Person p) {
        // Recorrer a los hermanos del tipo indicado y añadirlo.
        if (firstSibling == null) {
            firstSibling = new Person(p);
            person.siblingPrev = firstSibling;
        } else {
            Person temp = firstSibling;
            firstSibling = new Person(p);
            temp.siblingPrev = firstSibling;
            firstSibling.siblingNext = temp;
        }
    }

    /**
     * Devuelve un string con todos los hermanos de ambos padres.
     */
    public String getSiblings() {
        String t = "Hermanos por parte de ambos padres:\n";
        String s = "";
        Person iter = person;
        while (iter.siblingNext != null) {
            iter = iter.siblingNext;
            if (iter.father == person.father && iter.mother == person.mother) {
                s += iter.name + " ";
            }
        }
        iter = person;
        while (iter.siblingPrev != null) {
            iter = iter.siblingPrev;
            if (iter.father == person.father && iter.mother == person.mother) {
                s += iter.name + " ";
            }
        }
        if (s == "") {
            t = "Esta persona no tiene hermanos por parte de ambos padres.";
        } else {
            t += s;
        }
        return t;
    }

    /**
     * Devuelve un string con todos los hermanos de padre sólamente.
     */
    public String getSiblingsFather() {
        String t = "Hermanos por parte del padre:\n";
        String s = "";
        Person iter = person;
        while (iter.siblingNext != null) {
            iter = iter.siblingNext;
            if (iter.father == person.father && iter.mother != person.mother) {
                s += iter.name + " ";
            }
        }
        iter = person;
        while (iter.siblingPrev != null) {
            iter = iter.siblingPrev;
            if (iter.father == person.father && iter.mother != person.mother) {
                s += iter.name + " ";
            }
        }
        if (s == "") {
            t = "Esta persona no tiene hermanos por parte del padre.";
        } else {
            t += s;
        }
        return t;
    }

    /**
     * Devuelve un string con todos los hermanos de madre sólamente.
     */
    public String getSiblingsMother() {
        String t = "Hermanos por parte de la madre:\n";
        String s = "";
        Person iter = person;
        while (iter.siblingNext != null) {
            iter = iter.siblingNext;
            if (iter.father != person.father && iter.mother == person.mother) {
                s += iter.name + " ";
            }
        }
        iter = person;
        while (iter.siblingPrev != null) {
            iter = iter.siblingPrev;
            if (iter.father != person.father && iter.mother == person.mother) {
                s += iter.name + " ";
            }
        }
        if (s == "") {
            t = "Esta persona no tiene hermanos por parte de la madre.";
        } else {
            t += s;
        }
        return t;
    }

    /**
     * Devuelve un string con todos los hermanos del alma.
     */
    public String getSiblingsSoul() {
        String t = "Hermanos del alma:\n";
        String s = "";
        Person iter = person;
        while (iter.siblingBySoulNext != null) {
            iter = iter.siblingBySoulNext;
            s += iter.name + " ";
        }
        iter = person;
        while (iter.siblingBySoulPrev != null) {
            iter = iter.siblingBySoulPrev;
            s += iter.name + " ";
        }
        if (s == "") {
            t = "Esta persona no tiene hermanos del alma.";
        } else {
            t += s;
        }
        return t;
    }

    /**
     * Devuelve un string con todos los hermanos.
     */
    public String getAllSiblings() {
        return getSiblings() + "\n" + getSiblingsFather() + "\n" + getSiblingsMother() + "\n" + getSiblingsSoul();
    }

    /**
     * Cambia la persona de la cual se quiere usar el arbol.
     */
    public void changePersonToSibling(String name) {
        Person iter = firstSiblingBySoul;
        Person tempPerson = new Person();
        Person temp;
        while (iter.siblingBySoulNext != null) {
            iter = iter.siblingBySoulNext;
            if (iter.name == name) {
                tempPerson = iter;
                break;
            }
        }
        if (tempPerson.name == name) {
            temp = person;
            person = tempPerson;
            addSiblingBySoul(temp);
        } else {
            if (tempPerson.name != name) {
                iter = firstSibling;
                while (iter.siblingNext != null) {
                    iter = iter.siblingNext;
                    if (iter.name == name) {
                        tempPerson = iter;
                        break;
                    }
                }
                if (tempPerson.name != name) {
                    System.out.println("No hay ningún hermano con ese nombre.");
                } else {
                    temp = person;
                    person = tempPerson;
                    addSiblingGeneric(temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        FamTree ft = new FamTree("Alice");
        ft.addFather("Bob");
        ft.addMother("Claudia");
        ft.person.father.setFather("Edsger");
        ft.person.father.setMother("Fatima");
        ft.addSibling("Donald");
        ft.addSiblingByFather("Gerard");
        ft.addSiblingByFather("Jovanka");
        ft.addSiblingByMother("Helga");
        ft.addSiblingBySoul("Indira");
        // System.out.println(ft.person.muestreArbol(" ", 0));
        // ft.changePersonToSibling("Gerard");
        // ft.changePersonToSibling("Alice");
        System.out.println(ft.person.muestreArbol("  ", 0));
        System.out.println(ft.getAllSiblings());
    }
}

/**
 * Hay que corregir lo de que no aparezca la persona original como hermano de la
 * persona a la que se cambio.
 * 
 * Hay que arreglar este problema, está en un while infinito, fijo tiene que ver
 * con addSiblingGeneric o con la forma de cambiar hermano.
 * 
 * Y añadirle algo que diga que si no hay hermanos no se devuelva ningún string.
 * Done.
 */