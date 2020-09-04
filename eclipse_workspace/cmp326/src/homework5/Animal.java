package homework5;

public abstract class Animal implements Eater{
	
	//Properties
	
	protected String name;
	protected int birthYear;
	protected double weight;
	protected double height;
	protected char gender;
	protected int caloriesConsumed;
	protected int caloriesAccumulator;
	
	public Animal() {
		this.name = "";
//		this.birthYear = 1900;
		this.weight = 0.0;
		this.height = 0.0;
		this.gender = 'u';
		this.caloriesConsumed = 0;
		this.caloriesAccumulator = 0;
	}
	
	public Animal(String name, int birthYear, double weight, char gender) {
		this.name = name;
		this.birthYear = birthYear;
		this.weight = (weight < 0.01)? -1 : weight;
		this.gender = (gender != 'f' && gender != 'm')? 'u' : gender;
	}
	
	public Animal(String name, int birthYear, double weight, double height, char gender) {
		this.name = name;
		this.birthYear = birthYear;
		this.weight = (weight < 0.01)? -1 : weight;
		this.height = (height < 0.01)? -1 : height;
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
	
	public double getHeight() {
		return height;
	}
	
	public int getCaloriesConsumed() {
		return caloriesConsumed;
	}
	
	public int getCaloriesAccumulator() {
		return caloriesAccumulator;
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
	
	public void setHeight(double height) {
		this.height = (height < 0)? -1 : height;
	}
	
	public void setCaloriesAccumulator(int caloriesAccumulator) {
		this.caloriesAccumulator = caloriesAccumulator;
	}
	
	public void setCaloriesConsumed(int caloriesConsumed) {
		this.caloriesConsumed = caloriesConsumed;
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
		System.out.printf("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Height: %10.2f |"
				+ " Gender: %c\n", this.name, this.birthYear, this.weight, this.height, this.gender);
	}
	
	@Override
	public String toString() {
		return String.format("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Height: %10.2f |"
				+ " Gender: %c\n", this.name, this.birthYear, this.weight, this.height, this.gender);
	}
	
	@Override
	public boolean equals(Object obj) {
		Animal a = (Animal) obj;
		if(this.name == a.name && this.birthYear == a.birthYear && this.gender == a.gender) {
				if(Math.abs(this.height - a.height) < 0.5 && Math.abs(this.weight - a.weight) < 0.5)
					return true;
		}
		return false;
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
	public double calculateBMI() {
		return this.weight / (Math.pow(height, 2)) * 703;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	public abstract double metabolizeAccumulatedCalories();
	
	public void eat(Food food) {
		this.caloriesConsumed += food.getCalories();
		this.caloriesAccumulator += food.getCalories();
	}

	public void eat(Food[] foods) {
		for(int i=0; i<foods.length; i++) {
			this.caloriesConsumed += foods[i].getCalories();
			this.caloriesAccumulator += foods[i].getCalories();
		}
	}
}
