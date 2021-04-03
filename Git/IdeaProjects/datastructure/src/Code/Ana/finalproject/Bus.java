package Code.Ana.finalproject;

public class Bus extends Car{

	public Bus(int[] numSeatsPerRow) {
		super(2,(2* numSeatsPerRow.length-1), numSeatsPerRow);
		numSeatsPerRow[0]=1;
	}
	public Bus(Person driver, int[] numSeatsPerRow) throws InvalidDriverException {
		super(2,(2*numSeatsPerRow.length-1),driver, numSeatsPerRow);
		numSeatsPerRow[0]=1;
	}
	
	public boolean canOpenDoor(Person p) {
		/*
		 * This method returns true if the Person is the driver, 
		 * or seated in the last populated row. 
		 * The Person must also be above the age of 5, and taller than 40 inches. It returns false otherwise.
		 */
		
		Person [][] bus= getPeopleOnBoard();
		if(p != null) {
			for (Person[] people : bus) {
				for (int j = 0; j < people.length; j++) {
					if (bus[0][0] == p || bus[bus.length - 1][j] == p) {
						if (p.getAge() > 5 && p.getHeight() > 40) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public boolean canOpenWindow(Person p) {
		/*
		 * This method returns true if it’s parent class’s 
		 * canOpenWindow method returns true, and the Person is above the age of 5.

		 */
		if(p != null) {
			if(super.canOpenWindow(p)) {
				return p.getAge() > 5;
			}
		 }
		return false;
	}
	
	public String toString() {
		return "Bus is an extension of" + super.toString();
	}
	
	@Override
	public String departure() {
		return super.departure() + "The Bus\n";
	}

	@Override
	public String arrival() {
		return super.arrival() + "Of The Bus\n";
	}

	@Override
	public String doNotDisturbTheDriver() {
		return super.doNotDisturbTheDriver() + "On The Bus\n";
	}
}
