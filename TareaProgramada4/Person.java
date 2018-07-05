public class Person {
  String name;
  Person siblingPrev;
  Person siblingNext;
  Person siblingBySoulPrev;
  Person siblingBySoulNext;
  Person mother;
  Person father;

  public Person(String name) {
    this.name = name;
    siblingNext = siblingPrev = siblingByFatherNext = siblingByFatherPrev = siblingByMotherNext = siblingByMotherPrev = siblingBySoulNext = siblingBySoulPrev = null;
  }
}