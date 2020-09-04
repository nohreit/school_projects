package homework4;

public class Runner {

	public static void main(String[] args) {
		
		Dog dog = new Dog("Alex", 2015, 100.1, 120.5, 'm', 10.3, 4);
		Dog defDog = new Dog();
		
		dog.addDogToy("Sadalsut", 4);
		dog.addDogToy("Holo", 5);
		dog.addDogToy("Naugty", 3);
		dog.addDogToy("Borken", 9);
		
		sop(dog.toString());
		
		sop(""+dog.getHighestDogToyRating());
		
		
	}
	
	public static void sop(String str) {
		System.out.println(str);
	}

}
