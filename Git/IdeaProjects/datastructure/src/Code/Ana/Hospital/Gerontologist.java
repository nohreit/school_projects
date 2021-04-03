package Code.Ana.Hospital;

public class Gerontologist extends Doctor {
	private boolean performsHouseCalls;//default
	private double visitFee;

	public Gerontologist(String name) {
		super(name);
		this.performsHouseCalls = true;
		this.visitFee = 0.0;
	}
	
	public Gerontologist(String name, boolean calls, double fee) {
		super(name);
		this.performsHouseCalls = calls;
		this.visitFee = fee;
	}
	
	public boolean performsHouseCalls() {
		return performsHouseCalls;
	}
	
	public double getVisitFee() {
		return visitFee;
	}
	
	public void setPerformsHouseCalls(boolean calls) {
		this.performsHouseCalls= calls;
	}
	
	public void setVisitFee(double fee) {
		this.visitFee=fee;
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
		s+= String.format("\nGerontologist: %s | visit fee= %02.2f", (performsHouseCalls ? "performs house calls": "no house calls"), visitFee);
		
		return s;
	}
	
	@Override
	public boolean equals(Object g) {
		if(g instanceof Gerontologist) {
			Gerontologist otherG= (Gerontologist)g;
			if(super.equals(otherG)) {
				if(Math.abs(this.visitFee- otherG.visitFee)<0.5){
					if(this.performsHouseCalls==otherG.performsHouseCalls) {
						return true;
					}
				}
			}
		} return false;
	}

	@Override
	public Patient[] getPatients() {
		return super.getPatients();
	}

	@Override
	public String getPatientsAsString() {
		return super.getPatientsAsString();
	}

	@Override
	public boolean isPatient(Patient p) {
		if((2020-p.getBirthYear())> 65) {
			return true;
		}else {
		return false;
		}
	}

}
