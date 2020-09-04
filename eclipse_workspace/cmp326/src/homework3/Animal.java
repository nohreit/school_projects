package homework3;

public class Animal {
	
	//Properties
	
	private String name;
	private int birthYear;
	private double weight;
	private char gender;
	
	public Animal() {
		this.name = "";
		this.birthYear = 1900;
		this.weight = 0.0;
		this.gender = 'u';
	}
	
	public Animal(String name, int birthYear, double weight, char gender) {
		this.name = name;
		this.birthYear = birthYear;
		this.weight = (weight < 0)? -1 : weight;
		this.gender = (gender != 'f' && gender != 'm')? 'u' : gender;
	}
	
	//Getters
	
	public String getName() {
		return name;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public char getGender() {
		return gender;
	}
	
	//Setters
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public void setWeight(double weight) {
		this.weight = (weight < 0)? -1 : weight;
	}
	
	public void setGender(char gender) {
		this.gender = (gender != 'f' && gender != 'm')? 'u' : gender;
	}
	
	//Methods
	
	public int calculateAge(int currentYear) {
		return (currentYear < this.birthYear)? -1 : currentYear-this.birthYear;
	}
	
	public boolean isMale() {
		return (this.gender == 'm')? true : false;
	}
	
	public boolean isFemale() {
		return (this.gender == 'f')? true : false;
	}
	
	public void printDetails() {
		System.out.printf("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Gender: %c\n",
				this.name, this.birthYear, this.weight, this.gender);
	}
	
	public void gainWeight() {
		this.weight +=1 ;
	}
	
	public void gainWeight(double weightGained) {
		this.weight += (weightGained < 0)? 0 : weightGained;
	}
	
	public void loseWeight() {
		setWeight((this.weight - 1 < 0)? 0 : this.weight - 1); 
	}
	
	public void loseWeight(double weightLost) {
		setWeight((this.weight - weightLost < 0)? 0 : this.weight - weightLost); 
	}

}
