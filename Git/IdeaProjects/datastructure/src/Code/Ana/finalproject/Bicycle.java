package Code.Ana.finalproject;

public class Bicycle extends Vehicle implements Comparable<Bicycle>{

	private double weight;
	private static final int []arr= {1,1};
	private final double  ACCURACY_RANGE= 0.5;
	
	public Bicycle(){
		super(1,1);
		weight=0;
	}
	public Bicycle(Person driver) throws InvalidDriverException {
		super(driver, arr);
		weight=0;
	}
	public Bicycle(Person driver, double weight) throws InvalidDriverException{
		super(driver,arr);
		setWeight(weight);
	}
	public boolean equals(Object o) {
		if(o instanceof Bicycle) {
			Bicycle otherBicycle= (Bicycle)o;
			return Math.abs(this.weight - otherBicycle.weight) < ACCURACY_RANGE;
		}return false;
	}
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double w) {
		if(w>0) {
			this.weight=w;
		}
		else {
			this.weight=0;
		}
	}
	public void setDriver(Person p) throws InvalidDriverException {
		if( p!= null) {
			if(p.getAge() >= 3) {
				personsOnBoard[0][0]=p;
			}
			else {
				throw new InvalidDriverException();
			}
		}
	}
	public String toString() {
		String s="";
		s= "Bicycle [ rider= " + getDriver().getName() + " | weight= " + weight+ " ]";
		return s;
	}
	@Override
	public int compareTo(Bicycle o) {
		return Double.compare(Math.abs(this.weight - o.weight), ACCURACY_RANGE);
	}
	@Override
	public boolean loadPassenger(Person p) {
		/*
		 * This abstract method will be implemented by derived classes to load 
		 * the specified person into the vehicle at the first available seat. 
		 * Searching for an available seat must start in the first row, please note 
		 * that a person below the age of 5 or has a height less than 36 is not allowed 
		 * to sit in the first row. This method returns true if there is room for the 
		 * specified person, otherwise the method returns false.
		 * ------
		 * A Bicycle cannot have any passengers. (A driver is not a passenger)
		 */
		if(p != null) { //if person is not null
			for (Person[] people : personsOnBoard) {

				for (Person person : people) {

					if (person == null) {
						//personsOnBoard[row][col]=p; //placing person
						return false;
					}
				}
			}
		}
		
		return false; //no room for anyone but the driver
	}
	@Override
	public int loadPassengers(Person[] peeps) {
		/*
		 * This method attempts to load as many of the persons specified in the peeps
		 *  array as possible. This method returns the number of people that were loaded 
		 *  into the Vehicle.
		 *  -------
		 *  A Bicycle cannot have any passengers. (A driver is not a passenger)
		 */
		int count=0;

		for (Person[] people : personsOnBoard) {

			for (Person person : people) {

				for (int k = 0; k < peeps.length; k++) {

					if (person == null) {
						//	personsOnBoard[i][j]= peeps[k]; //placing person
						count += 0;
					}
				}
			}
		}
	
		return count;
	}
	
}
