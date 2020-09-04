package homework4;

public class Mammal extends Animal{
	
	// Properties
	
	protected double tailLength;
	protected int numLegs;
	
	public Mammal() {
		super();
		this.tailLength = 0;
		this.numLegs = 0;
	}
	
	//Inner class
	
	public class DogToy{
		protected String dogToyName;
		protected int dogToyRating;
		
		public DogToy() {}
		
		public DogToy(String toyName, int toyRating) {
			this.dogToyName = toyName;
			this.dogToyRating = toyRating;
		}
		
		public String getDogToyName() {
			return this.dogToyName;
		}
		
		public int getDogToyRating() {
			return this.dogToyRating;
		}
		
		@Override
		public String toString() {
			return String.format("DogToy: Toy Name: %20s | Rating %4d\n", this.dogToyName, this.dogToyRating);
		}
		
	}
	
	public Mammal(double tailLength, int numLegs) {
		super();
		this.tailLength = (tailLength < 0)? -1 : tailLength;
		this.numLegs = (numLegs < 0)? -1 : numLegs;
	}
	
	public Mammal(String name, int birthYear, double weight, double height, char gender, 
			double tailLength, int numLegs) {
		super(name, birthYear, (weight < 0.5)? -1 : weight, (height < 0.5)? -1 : height, gender);
		this.tailLength = (tailLength < 0)? -1 : tailLength;
		this.numLegs = (numLegs < 0)? -1 : numLegs;
	}
	
	// Getters
	
	public double getTailLength() {
		return tailLength;
	}
	
	public int getNumLegs() {
		return numLegs;
	}
	
	// Setters
	
	public void setTailLength(double tailLength) {
		this.tailLength = (tailLength < 0)? -1 : tailLength;
	}
	
	public void setNumLegs(int numLegs) {
		this.numLegs = (numLegs < 0)? -1 : numLegs;
	}
	
	// Methods
	
	@Override
	public void printDetails() {
		super.printDetails();
		System.out.printf("Mammal: Tail Length: %10.2f | Number of Legs: %4d\n", this.tailLength,
				this.numLegs);
	}
	
	@Override
	public String toString() {
		return super.toString() + 
				String.format("Mammal: Tail Length: %10.2f | Number of Legs: %4d\n", 
						this.tailLength, this.numLegs);
	}
	
	@Override
	public boolean equals(Object obj) {
		Mammal m = (Mammal) obj;
		if(super.equals(m)) {
			if(this.numLegs == m.numLegs && Math.abs(this.tailLength - m.tailLength) < 0.1)
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
