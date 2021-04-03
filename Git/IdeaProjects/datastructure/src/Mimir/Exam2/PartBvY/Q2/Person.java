package Mimir.Exam2.PartBvY.Q2;


public class Person extends KeyedItem<String> implements Comparable<Person> {
    //KeyedItem type is <String> because we are using the fName as the key
    //could use any other Object or Primitive Type as long as
    //it will be passed to the super constructor to be set as the key
    private final String fName;
    private final int age;
    private final String id;

    public Person(String id, int age, String fName) {
        super(fName);//make the fName the key...could use id, name or age...
        this.age = age;
        this.id = id;
        this.fName = fName;
    }

    public String toString() {
//		return getKey() + ", name: "+fName+ " age: "+age;
        return "name: " + getKey() + ", id: " + id + " age: " + age;
    }

    public int compareTo(Person p) {
        if (this.getKey().compareTo(p.getKey()) < 0) {
            return -1;
        }
        if (this.getKey().compareTo(p.getKey()) > 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
