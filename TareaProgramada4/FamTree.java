
/**
 * Class intended to act as a Family Tree. Includes internal class Person, to
 * handle nodes in the family tree. This class will also act as a double list in
 * order to handle the siblings of the persons.
 * 
 * @author (Gloriana Mora Villalta & Edgar Barrantes Brais.)
 * @version (6/7/2018)
 */
public class FamTree {

    /**
     * Class made in order to handle people in the family tree. Acts as a node of a
     * tree and as one of a doubly linked list.
     */
    private class Person {
        public String name;
        public Person siblingPrev;
        public Person siblingNext;
        public Person siblingBySoulPrev;
        public Person siblingBySoulNext;
        public Person mother;
        public Person father;
        public Person directDescendants;

        public Person(String name) {
            this.name = name;
            siblingNext = siblingPrev = siblingBySoulNext = siblingBySoulPrev = null;
        }

        /**
         * Set both parents
         */
        public void setParents(String motherName, String fatherName) {
            this.mother = new Person(motherName);
            this.father = new Person(fatherName);
        }

        /**
         * Show the ancestry of the person.
         */
        public String muestreArbol(String t, int p) {
            String r = "";
            if (mother != null) {
                r += mother.muestreArbol(t, p + 1);
            }
            for (int i = 0; i < p; i++)
                r += "*" + t;
            r += name + "\n";
            if (father != null) {
                r += father.muestreArbol(t, p + 1);
            }
            return r;
        }
    }

    // Atributes of the FamTree class.
    private Person person;
    private Person firstSibling;
    private Person firstSiblingBySoul;

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
    public void setMother(String motherName) {
        person.mother = new Person(motherName);
        person.mother.directDescendants = person;
    }

    /**
     * Adds the father of the person.
     */
    public void setFather(String fatherName) {
        person.father = new Person(fatherName);
        person.father.directDescendants = person;
    }

    /**
     * Adds a sibling of both mother and father.
     */
    public void addSibling(Person p) {
        if (firstSibling == null) {
            firstSibling = p;
            person.siblingPrev = firstSibling;
            firstSibling.siblingNext = person;
            firstSibling.father = person.father;
            firstSibling.mother = person.mother;
        } else {
            Person temp = firstSibling;
            firstSibling = p;
            temp.siblingPrev = firstSibling;
            firstSibling.siblingNext = temp;
            firstSibling.father = person.father;
            firstSibling.mother = person.mother;
        }
    }

    /**
     * Adds siblings by name.
     */
    public void addSibling(String name) {
        Person p = new Person(name);
        addSibling(p);
    }

    /**
     * Adds a sibling of both mother and father.
     */
    public void addSiblingByFather(Person p) {
        if (firstSibling == null) {
            firstSibling = p;
            firstSibling.siblingNext = person;
            person.siblingPrev = firstSibling;
            firstSibling.father = person.father;
        } else {
            Person temp = firstSibling;
            firstSibling = p;
            temp.siblingPrev = firstSibling;
            firstSibling.siblingNext = temp;
            firstSibling.father = person.father;
        }
    }

    /**
     * Adds siblings by name.
     */
    public void addSiblingByFather(String name) {
        Person p = new Person(name);
        addSiblingByFather(p);
    }

    /**
     * Adds a sibling of both mother and father.
     */
    public void addSiblingByMother(Person p) {
        if (firstSibling == null) {
            firstSibling = p;
            person.siblingPrev = firstSibling;
            firstSibling.mother = person.mother;
        } else {
            Person temp = firstSibling;
            firstSibling = p;
            temp.siblingPrev = firstSibling;
            firstSibling.siblingNext = temp;
            firstSibling.mother = person.mother;
        }
    }

    /**
     * Adds siblings by name.
     */
    public void addSiblingByMother(String name) {
        Person p = new Person(name);
        addSiblingByMother(p);
    }

    /**
     * Adds a sibling of both mother and father.
     */
    public void addSiblingBySoul(Person p) {
        if (firstSiblingBySoul == null) {
            firstSiblingBySoul = p;
            person.siblingBySoulPrev = firstSiblingBySoul;
        } else {
            Person temp = firstSiblingBySoul;
            firstSiblingBySoul = p;
            temp.siblingBySoulPrev = firstSiblingBySoul;
            firstSiblingBySoul.siblingBySoulNext = temp;
        }
    }

    /**
     * Adds siblings by name.
     */
    public void addSiblingBySoul(String name) {
        Person p = new Person(name);
        addSiblingBySoul(p);
    }

    /**
     * Returns a string with the siblings from both parents.
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
     * Returns a string with the sibligs with whom the person shares father but not
     * mother.
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
     * Returns a string with the sibligs with whom the person shares mother but not
     * father.
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
     * Returns a String with all the soul siblings.
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
     * Returns a string with all the siblings.
     */
    public String getAllSiblings() {
        return getSiblings() + "\n" + getSiblingsFather() + "\n" + getSiblingsMother() + "\n" + getSiblingsSoul();
    }

    /**
     * Changes the main person in the tree to a sibling.
     */
    public void changePersonToSibling(String name) {
        Person iter = firstSiblingBySoul;
        Person tempPerson = null;
        Person temp;
        while (iter.siblingBySoulNext != null) {
            iter = iter.siblingBySoulNext;
            if (iter.name == name) {
                tempPerson = iter;
                break;
            }
        }
        if (tempPerson == null) {
            iter = firstSibling;
            while (iter.siblingNext != null) {
                iter = iter.siblingNext;
                if (iter.name == name) {
                    tempPerson = iter;
                    break;
                }
            }
            if (tempPerson == null) {
                System.out.println("No hay ningún hermano con ese nombre.");
            } else {
                temp = person;
                person = tempPerson;
            }
        } else {
            temp = person;
            person = tempPerson;
        }
    }

    /**
     * Changes the main person to an ascestor.
     */
    public void changePersonToAncestor(String name) {
        Person newRoot = searchPersonInTree(name, person);
        if (newRoot != null) {
            person = newRoot;
        } else {
            System.out.println("Esa persona no existe en los antepasados.");
        }
    }

    /**
     * Searches for a person in a family tree by name.
     */
    public Person searchPersonInTree(String name, Person person) {
        if (person != null) {
            if (person.name.equals(name)) {
                return person;
            } else {
                Person foundPerson = searchPersonInTree(name, person.mother);
                if (foundPerson == null) {
                    foundPerson = searchPersonInTree(name, person.father);
                }
                return foundPerson;
            }
        } else {
            return null;
        }
    }

    /**
     * Change person to descendant.
     */
    public void changePersonToDescendant(String name) {
        Person iter = person.directDescendants;
        if (iter.name == name) {
            person = iter;
        } else {
            while (iter.siblingNext != null) {
                iter = iter.siblingNext;
                if (iter.name == name) {
                    person = iter;
                    break;
                }
            }
            if (person != iter) {
                iter = person.directDescendants;
                while (iter.siblingPrev != null) {
                    iter = iter.siblingPrev;
                    if (iter.name == name) {
                        person = iter;
                        break;
                    }
                }
                if (iter.name != name) {
                    System.out.println("No hay descendientes con ese nombre");
                }
            }
        }
    }

    public static void main(String[] args) {
        FamTree ft = new FamTree("Alice");
        ft.setFather("Bob");
        ft.setMother("Claudia");
        ft.addSibling("Donald");
        ft.addSiblingByFather("Gerard");
        ft.addSiblingByFather("Jovanka");
        ft.addSiblingByMother("Helga");
        ft.addSiblingBySoul("Indira");
        ft.changePersonToSibling("Gerard");
        ft.changePersonToSibling("Alice");
        ft.changePersonToAncestor("Bob");
        ft.setFather("Edsger");
        ft.setMother("Fatima");
        ft.changePersonToDescendant("Gerard");
        ft.setMother("Wilhemina");
        System.out.println(ft.person.muestreArbol("  ", 0));
        System.out.println(ft.getAllSiblings());
    }
}
