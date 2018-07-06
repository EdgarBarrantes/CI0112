public class Person {
  String name;
  Person siblingPrev;
  Person siblingNext;
  Person siblingBySoulPrev;
  Person siblingBySoulNext;
  Person mother;
  Person father;
  Person directDescendants;

  public Person() {
    this.name = "";
    siblingNext = siblingPrev = siblingBySoulNext = siblingBySoulPrev = null;
  }

  public Person(String name) {
    this.name = name;
    siblingNext = siblingPrev = siblingBySoulNext = siblingBySoulPrev = null;
  }

  public Person(Person p) {
    this.name = p.name;
    siblingPrev = p.siblingPrev;
    siblingNext = p.siblingNext;
    siblingBySoulNext = p.siblingBySoulNext;
    siblingBySoulPrev = p.siblingBySoulPrev;
    mother = p.mother;
    father = p.father;
  }

  public void setFather(String name) {
    father = new Person(name);
  }

  public void setMother(String name) {
    mother = new Person(name);
  }

  /**
   * Show family tree.
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