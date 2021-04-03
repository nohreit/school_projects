package Code.Ana.Hospital;


public class Pediatrician extends Doctor{
	 private boolean hasPrivatePractice;
	 private String hospitalName;
	 
	
	public Pediatrician(String name) {
		super(name);
		hospitalName = "";
		hasPrivatePractice = false;
	}
	
	public Pediatrician(String name, boolean practice, String hospital) {
		super(name);
		this.hasPrivatePractice=practice;
		setHospitalName(hospital);
	}
	public boolean hasPrivatePractice() {
		return hasPrivatePractice;
	}
	
	public String getHospitalName() {
		return hospitalName;
	}
	
	public void setHospitalName(String name) {
		this.hospitalName=name;
	}
	
	@Override
	//fix
	public void addPatient(Patient p) throws PatientException{
		if(isPatient(p)) {
			super.addPatient(p);
		} 
	}
	
	
	@Override
	//fix
	public String toString() {
		String s= super.toString();
		s += String.format("\nPediatrician: %s | hosputal name= %15s",(hasPrivatePractice ? "has private practice" : "does not have private practice"), hospitalName);
		
		return s;
	}
	
	@Override
	public boolean equals(Object p) {
		if(p instanceof Pediatrician) {
			Pediatrician otherP= (Pediatrician)p;
			if(super.equals(otherP)) {
				if(this.hasPrivatePractice== otherP.hasPrivatePractice) {
					return this.hospitalName.equals(otherP.hospitalName);
				}
			}
		}return false;
		
	}

	@Override
	public Patient[] getPatients() {
		return super.getPatients();
	}

	@Override
	public String getPatientsAsString(){
		return super.getPatientsAsString();
	}
		

	@Override
	public boolean isPatient(Patient p) {
		return (2020 - p.getBirthYear()) < 18;
	}
}
