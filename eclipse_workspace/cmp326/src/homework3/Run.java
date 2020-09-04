package homework3;

public class Run {

	public static void main(String[] args) {
		Farm farm = new Farm("Driver", 10);
		Animal a1 = new Animal("cow", 2012, 1000.5, 'f');
		Animal a2 = new Animal("pig", 2009, 550.5, 'm');
		Animal a3 = new Animal("donkey", 1999, 773.42, 'm');
		Animal a4 = new Animal("sheep", 2016, 164.23, 'f');
		Animal a5 = new Animal("goose", 2004, 10.75, 'f');
		
		farm.addAnimal(a1); //0
		farm.addAnimal(a2); //1
		farm.addAnimal(a3); //2
		farm.addAnimal(a4); //3
		farm.addAnimal(a5); //4
		
		farm.printAllDetails();
	}
}
