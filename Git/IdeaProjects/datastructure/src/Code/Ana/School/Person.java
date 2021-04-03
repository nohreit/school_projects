package Code.Ana.School;

public class Person {

    private String name;
    private int birthYear;

    public Person() {
        this.name = "";
        this.birthYear = 0;
    }

    public Person(String n, int by) {
        this.name = n;
        this.birthYear = by;
    }

    public String getName() {
        return this.name;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setBirthYear(int by) {
        this.birthYear = by;
    }

    @Override
    public boolean equals(Object p) {
        if (p instanceof Person) {
            Person otherPerson = (Person) p;
            if (this.name == otherPerson.name) {
                if (this.birthYear == otherPerson.birthYear) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Person: Name: %30s | Birth Year: %4d", name, birthYear);
    }

    public int compareTo(Person p) {
        Person oPerson = (Person) p;
        int comp = 0;
        if (this.birthYear > oPerson.birthYear) { //if(this.year > ((Person)p.year...
            comp = 1;
        } else if (this.birthYear < oPerson.birthYear) {
            comp = -1;
        }
        return comp;
    }
}
