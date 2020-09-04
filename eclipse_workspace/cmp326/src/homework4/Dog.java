package homework4;

import java.util.Objects;

public class Dog extends Mammal{
	
	protected DogToy[] toys;
	protected int numDogToys;
	
	public Dog() {
		super();
		this.toys = new DogToy[10];
		this.numDogToys = 0;		
	}
	
	public Dog(double tailLength, int numLegs) {
		super(tailLength, numLegs);
		this.toys = new DogToy[10];
		this.numDogToys = 0;
	}
	
	public Dog(String name, int birthYear, double weight, double height, 
			char gender, double tailLength, int numLegs) {
		super(name, birthYear, weight, height, gender, tailLength, numLegs);
		this.toys = new DogToy[10];
		this.numDogToys = 0;
	}
	
	public void addDogToy(String name, int rating) {
		DogToy dToy = new DogToy(name, rating);
		
		if(this.numDogToys == this.toys.length)
			System.out.println("toys has reached capacity of 10");
		else {
			if(Objects.isNull(this.toys[numDogToys])) {
				this.toys[numDogToys] = dToy;
				this.numDogToys += 1;
			}
		}
	}
	
	public String getDogToyAsString(int index) {
		if(index >=0 && index < toys.length) {
			if(!Objects.isNull(toys[index]))
				return toys[index].toString();
		}
		return "invalid index "+ index;
	}
	
	public String getDogToyName(int index) {
		if(index >=0 && index < toys.length) {
			if(!Objects.isNull(toys[index]))
				return toys[index].getDogToyName();
		}
		return "invalid index "+ index;
	}
	
	public int getDogToyRating(int index) {
		if(index >=0 && index < toys.length) {
			if(!Objects.isNull(toys[index]))
				return toys[index].getDogToyRating();
		}
		return -1;
	}
	
	public int getHighestDogToyRating() {
		int topRate = 0;
		for(int i = 0; i < this.toys.length; i++) {
			topRate = Math.max(topRate, this.toys[i].getDogToyRating());
			if(Objects.isNull(this.toys[i+1]))
				break;
		}
		
		return topRate;
	}
	
	public int getNumDogToys() {
		return numDogToys;
	}
	
	@Override
	public void printDetails() {
		super.printDetails();
		
		System.out.printf("Dog: Number of Toys: %4d | Dog Toys:\n", this.numDogToys); 
		for(int i = 0; i < this.toys.length; i++) {
			if(!Objects.isNull(toys[i]))
				System.out.printf("DogToy: Toy Name: %20s | Rating %4d\n", 
						toys[i].getDogToyName(), toys[i].getDogToyRating());
			if(Objects.isNull(toys[i+1]))
				break;
		}
	}
	
	
	@Override
	public String toString() {
		String str = super.toString() + String.format("Dog: Number of Toys: %4d | Dog Toys:\n", 
				this.numDogToys);
		for(int i = 0; i < toys.length; i++) {
			if(!Objects.isNull(toys[i]))
				str += String.format("DogToy: Toy Name: %20s | Rating %4d\n", 
						toys[i].getDogToyName(), toys[i].getDogToyRating());
		}
		return str;		
	}
}
