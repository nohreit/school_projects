package Code.Ana.finalproject;

public abstract class Vehicle {

	protected Person [][] personsOnBoard;
	protected int numberOfRows;
	protected int maxSeatsPerRow;
	protected int [] numSeatsPerRow;
	
	public Vehicle(int numRows, int numSeatsPearRow) {
		numberOfRows= numRows;
		
		maxSeatsPerRow= numSeatsPearRow;
		
		numSeatsPerRow= new int[maxSeatsPerRow];
		
		personsOnBoard= new Person [numberOfRows][maxSeatsPerRow];
	}
	
	public Vehicle(int[] numSeatsPerRow) {
	
		this.numSeatsPerRow= numSeatsPerRow;
		
		maxSeatsPerRow= findingMax(numSeatsPerRow);
		numberOfRows= numSeatsPerRow.length;
		
		setRowsLength(numSeatsPerRow);		
	}
	
	public Vehicle( Person driver, int [] numSeatsPerRow ) {
		this.numSeatsPerRow= numSeatsPerRow;
		
		maxSeatsPerRow= findingMax(numSeatsPerRow);
		numberOfRows= numSeatsPerRow.length;
		
		setRowsLength(numSeatsPerRow);	
		
		try {
			setDriver(driver);
		}
		catch(InvalidDriverException e){
			System.out.println(e.getMessage());
		}
		
		
	}
	
	private int findingMax(int[]arr) {
		return Math.max(arr[0], arr[1]);
	}
	
	//*********\\
	private Person[][] setRowsLength(int [] seatsPerRow) {
		personsOnBoard= new Person[seatsPerRow.length][]; //[row][column]
		
		for(int i=0; i< seatsPerRow.length; i++) {
			personsOnBoard[i]= new Person[seatsPerRow[i]];
			
		}
		return personsOnBoard;
	}
	
	//**********\\
	public abstract boolean loadPassenger(Person p);
	public abstract int loadPassengers(Person[] peeps);
	
		
	public void setDriver(Person p) throws InvalidDriverException{
		if(p != null) {
			if(p.hasDriverLicense()) {
				personsOnBoard[0][0]= p;
			}
		}
		else {
			throw new InvalidDriverException();
		}
		
	}
	
	public Person getDriver() {
		if(personsOnBoard[0][0] != null) {
			return personsOnBoard[0][0];
		}
		return null;
	}
	
	public boolean hasDriver() {
		if(personsOnBoard[0][0] != null) {
			return true;
		}
		return false;
	}
	

	
	public int getNumberOfAvailableSeats() { 
		int seats= 0;
		
		for(int row=0; row<numberOfRows;row++) {
			for(int col=0; col< personsOnBoard[row].length; col++) {
				
				if(personsOnBoard[row][col] == null) {
					
					seats +=1;
				}
			}
			
		}
		return seats;
	}
	
	public int getNumberOfAvailableSeatsInRow(int row) { 
		int count=0;
		
		if(row < numberOfRows && row >= 0) {
			
			for(int col=0; col< personsOnBoard[row].length; col++) {
				
				if(personsOnBoard[row][col] == null) {
					
					count +=1;
				}
			}
			
		}else {
		
			count= -1;
		
		}
		return count;
	}
	
	public int getNumberOfPeopleOnBoard() { 
		int count=0;
		for(int i=0; i<personsOnBoard.length;i++) {
			for(int j=0; j< personsOnBoard[i].length; j++) {
				if(personsOnBoard[i][j] != null) {
					count +=1;
				}
			}
			
		}
		return count;
	}
	
	public int getNumberOfPeopleInRow(int row) { 
		int count= 0;
		if(row <= numberOfRows && row >= 0) {
			for(int i=0; i< numSeatsPerRow.length;i++) {
				if(personsOnBoard[row][i] != null) {
					count +=1;
				}
			}
			
		}
		else {
			count= -1;
		}
		
		return count;
	
	}
	
	public Person getPersonInSeat(int row, int col) {
		if(row< numberOfRows && row >=0) {
			if(col < numSeatsPerRow.length && col>=0) {
				return personsOnBoard[row][col];
			}
		}
		return null;
	}
	
	public int[] getLocationOfPersonInVehicle(Person p) { 
		/*
		 * returns the location of the person in the vehicle by returning and
		 * int array [row,seat] please note that if the person is not seated in 
		 * the vehicle the method will return [-1,-1]
		 */
		int[] location= new int[2];
		if(p!= null) {
			for(int i=0; i<personsOnBoard.length; i++) {
				for(int j=0; j<personsOnBoard[i].length; j++) {
						if(personsOnBoard[i][j] == p) {
							location[0]= i;
							location[1]= j;
							//return location;
							
						}
					}
				}
		}
		else {
			return new int[]{-1,-1};
		}
		System.out.println(location[0] + ", "+ location[1]);
		return location;
		
	}
	
	public Person[] getPeopleInRow(int row) {  
		/*
		 * return a Person array containing a clone of all the persons in
		 * the row. the populated Person array will not contain empty index
		 * locations. if the specified row has no one, or the specified row is invalid 
		 * return null;
		 */
		Person [] peopleInRow= new Person[numSeatsPerRow.length];
		
		if(row<= numberOfRows && row >= 0) {

			for(int col=0; col<numSeatsPerRow[row]; col++) {
				if(personsOnBoard[row][col] != null) {
					peopleInRow[col]= personsOnBoard[row][col].clone();
				}
				else {
					return null;
				}
			}
	//		printingArray(peopleInRow);
			return peopleInRow;
		}
		return null;
	}

//	private boolean isSeatEmpty(int row){
//		for (Person p :
//				) {
//
//		}
//	}
	private void printingArray(Person [] arr) {
		for (Person person : arr) {
			System.out.print(person + " ");
		}
	}
	
	public Person[][] getPeopleOnBoard(){ //returning address location
		/**
		 * returns a full clone of the personsOnBoard array with clones of the
		 * Person objects contained within. Please note that the personsOnBoard.clone() is not
		 * Sufficient to clone a 2D array.
		 */
		Person[][] pCopy= new Person[personsOnBoard.length][];
		setRows(pCopy,numSeatsPerRow );
		
		for(int row=0; row<personsOnBoard.length;row++) {
			for(int col=0; col<personsOnBoard[row].length; col++) {
				
				pCopy[row][col]= personsOnBoard[row][col]; //.clone();
			}
		}
		printingArray(pCopy);
		return pCopy;
	}
	private Person [][] setRows(Person [][] copy, int [] seatsRow){
		//copy= new Person[seatsRow.length][];
		for(int i=0; i<seatsRow.length; i++) {
			copy[i]= new Person[seatsRow[i]];
		}
		return copy;
	}
	
	private void printingArray(Person [][] arr) {
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}
	public boolean isPersonInVehicle(Person p) { 
		if(p != null) {
			for(int i=0; i<personsOnBoard.length;i++) {
				for(int j=0; j<personsOnBoard[i].length;j++) {
					if(personsOnBoard[i][j] == p) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean isPersonDriver(Person p) {  
		if(p != null) {
			if(personsOnBoard[0][0] ==p) {
				return true;
			}
		}
		return false;
	}
	

}
