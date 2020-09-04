package homework3;

import java.util.Objects;

public class Farm {
	
	//Properties
	
	private Animal[] animals;
	private String farmName;
	private int numAnimals;
	
	//Constructors
	
	Farm(){
		this.farmName = "";
		this.numAnimals = 0;
		this.animals[10] = new Animal();
	}
	
	Farm(java.lang.String farmName){
		this.farmName = farmName;
		this.numAnimals = 0;
		this.animals[10] = new Animal();
	}
	
	Farm(int maxAnimals){
		this.farmName = "";
		this.numAnimals = 0;
		this.animals = new Animal[(maxAnimals < 0)? 0 : maxAnimals];
	}
	
	Farm(java.lang.String farmName, int maxAnimals){
		this.farmName = farmName;
		this.numAnimals = 0;
		this.animals = new Animal[(maxAnimals < 0)? 0 : maxAnimals];
	}
	
	//Getters
	
	public java.lang.String getFarmName() {
		return farmName;
	}
	
	public Animal getAnimal(int index) {
		return (Objects.isNull(this.animals))? null : animals[index];
	}
	
	public Animal[] getAnimals() {
		Animal[] a = new Animal[numAnimals];
		for(int i = 0; i < animals.length; i++) {
			a[i] = animals[i];
			if(Objects.isNull(animals[i+1]))
				break;
		}
		return a;
	}
	
	public int getNumAnimals() {
		return numAnimals;
	}
	
	//Setters
	
	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}
	
	public void setAnimals(Animal[] animals) {
		this.animals = animals;
	}
	
	//Methods
	
	public void addAnimal(Animal a) {
		if(Objects.isNull(animals)) {
			animals = new Animal[1];
		}
		for(int i = 0; i < animals.length; i++) {
			if(i+1 >= animals.length) {
				resizeAnimalArray();
			}
			if(Objects.isNull(animals[i])) {
				animals[i] = a;
				numAnimals = i+1;
				break;
			}
		}
	}
	
	public void resizeAnimalArray() {
		Animal[] buffer = new Animal[animals.length]; // Create buffer array
		System.arraycopy(animals, 0, buffer, 0, animals.length); // Copy animals array to buffer
		animals = new Animal[animals.length*2]; // Double size of animal array
		System.arraycopy(buffer, 0, animals, 0, buffer.length); // Copy back data from buffer array to animals
	}
	
	public void printAllDetails() {
		if(!Objects.isNull(animals)) {
			System.out.printf("FarmName: %20s | Number of Animals: %4d | Farm Size: %4d\n" ,
				farmName, numAnimals, animals.length);
			for(int i=0; i < animals.length; i++) {
				if(!Objects.isNull(animals[i])) {
					System.out.printf("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Gender: %c\n", 
							animals[i].getName(), animals[i].getBirthYear(), animals[i].getWeight(), 
							animals[i].getGender());
				}
			}
		}else {
			System.out.printf("FarmName: %20s | Number of Animals: %4d | Farm Size: %4d\n" ,
					farmName, numAnimals, 0);
		}
	}
	
	public Animal getFistAnimal() {
		return (Objects.isNull(animals))? null : animals[0]; //Check existence of array animal
	}														 //If not exist return null
	
	public Animal getLastAnimal() {
		Animal animal = new Animal();
		for(int i = 0; i < animals.length; i++) {
			if(Objects.isNull(animals[i+1])) {
				animal = this.animals[i];
				break;
			}
		}
		return animal;
	}
	
	public Animal removeAnimal(int index) {
		Animal rm = null;
		if(index >= 0 && index < animals.length) {
			rm = animals[index];			//Assign the removed animal to rm
			for(int i = index; i < animals.length; i++) {
				if(i+1 < animals.length)
					animals[i] = animals[i+1];	//Assign value from next element to current element
			}
			animals[animals.length-1] = null;	//Assign last element null to avoid duplicate
			numAnimals-=1;
			return rm;							//return removed animal
		}
		return null;		
	}
	
	public void removeAllAnimals() {
		animals = null;
		numAnimals = 0;
	}
	
	public double getTotalWeightOfAllAnimals() {
		double weight = 0;
		
		for(int i = 0; i < animals.length; i++) {
			weight += animals[i].getWeight();
			if(Objects.isNull(animals[i+1]))
				break;
		}
		
		return weight;
	}
	
	public double getAverageWeightOfAllAnimals() {
		return getTotalWeightOfAllAnimals() / numAnimals;
	}
	
	public int getNumberOfAnimalsAboveWeight(double weight) {
		int over = 0;
		for(int i = 0; i < animals.length; i++) {
			over+= (animals[i].getWeight() > weight)? 1 : 0; // If animal is above weight add 1 else add 0
			if(Objects.isNull(animals[i+1]))
				break;
		}
		return over;
	}
	
	public int getNumberOfAnimalsBelowWeight(double weight) {
		int below = 0;
		for(int i = 0; i < animals.length; i++) {
			below+= (animals[i].getWeight() < weight)? 1 : 0; // If animal is below weight add 1 else add 0
			if(Objects.isNull(animals[i+1]))
				break;
		}													 
		return below;
	}
	
	public void increaseWeightOfAllAnimals(){
		for(int i = 0; i < animals.length; i++) {
			animals[i].gainWeight();
			if(Objects.isNull(animals[i+1]))
				break;
		}
	}
	
	public void increaseWeightOfAllAnimals(double weight){
		for(int i = 0; i < animals.length; i++) {
			animals[i].gainWeight(weight);
			if(Objects.isNull(animals[i+1]))
				break;
		}
	}

}
