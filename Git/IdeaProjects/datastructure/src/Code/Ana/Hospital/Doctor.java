package Code.Ana.Hospital;

   public class Doctor implements SeesPatients{

	private static int numDoctors=0; //increment inside the constructor
	private String name;
	private int licenseNumber;
	private Patient[] patients;
	private int numOfPatients;
	
	public Doctor(String name) {
		this.name= name;
		numDoctors++;
		licenseNumber=numDoctors;
		patients= new Patient[MAX_PATIENTS];
		numOfPatients = 0;
	}
	
	public static int getNumDoctors() {
		return numDoctors;
	}

	public int getLicenseNumber() {
		return licenseNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumberOfPatients() {
		return numOfPatients;
	}
	
	@Override
	//fix
	public String toString() {
		return String.format("Doctor= name= %20s | license number= %06d | %s", name, licenseNumber, getPatientsAsString());
	}
	
	@Override
	public boolean equals(Object d) {
		if(d instanceof Doctor){
			Doctor otherD = (Doctor)d;
			if(this.name == otherD.name) {
				if(this.getNumberOfPatients() == otherD.getNumberOfPatients()) {
					return true;
				}
			 }
		
	    } return false;
    }
	//FIX- returns 0 instead of -1
	public int compareTo(Doctor d) {
		Doctor oDoctor= (Doctor)d;
		int comp=0;
		if(this.getNumberOfPatients() > oDoctor.getNumberOfPatients()) {
			comp=1;
		} 
		else if(this.getNumberOfPatients() < oDoctor.getNumberOfPatients()) {
			comp=-1;
		}
		return comp;
	}

	@Override
	//fix
	public void addPatient(Patient p) throws PatientException {
		if(numOfPatients <= patients.length)
			patients[numOfPatients++] = p;
		else{
			throw new PatientException("Cannot add more patient");
		}
	}

	@Override
	//fix
	public Patient[] getPatients() {
		return patients;
	}

	@Override
	//fix
	public String getPatientsAsString() {
		String s= "patients= \n";
		for(int i=0; i<this.getNumberOfPatients(); i++) {
			s+= patients[i].toString()+ (i != this.numOfPatients-1 ? ", " : "");
		}
		return s;
	}

	@Override
	public boolean isPatient(Patient p) {
		int i = 0;
		boolean found = false;
		while(!found && i < patients.length){
			if(patients[i].equals(p)){
				found = true;
			}
			i++;
		}
		return found;
	}
	
}
