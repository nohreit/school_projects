package Code.Ana.finalproject;


public class Person {

	private final String name;
	private final boolean hasDriverLicense;
	private final int age; //Years
	private final int height; //Inches
	
	public Person(String name, boolean driverLicense, int age, int height) {
		this.name= name;
		this.hasDriverLicense= driverLicense;
		this.age= age;
		this.height= height;
	}
	public String getName() {
		return name;
	}
	public boolean hasDriverLicense() {
		return hasDriverLicense;
	}
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}
	

	public Person clone() {
		//returns a copy of the Person with all the same values without revealing the original memory address
		return new Person(name, hasDriverLicense, age, height);
	}
	
	public boolean equals(Object p) {
		if(p instanceof Person) {
			Person otherPerson= (Person)p;
			if(this.name.equals(otherPerson.name)) {
				if(this.hasDriverLicense == otherPerson.hasDriverLicense) {
					if(this.age == otherPerson.age) {
						return this.height == otherPerson.height;
					}
				}
			}
		} return false;
	}
	
	public String toString() {
		String s= "";
		s += String.format("Person [name= %10s | age= %02d | height= %02d |"
				+ " %s]", name, age, height, (hasDriverLicense() ? "has license" : "no license"));
		return s;
	}
}
