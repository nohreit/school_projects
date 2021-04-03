package Code.Ana.School;

public class GeneralStaff extends Employee{

	private String duty;
	
	public GeneralStaff() {
		super();
		this.duty="";
	}
	
	public GeneralStaff(String duty) {
		super();
		this.duty=duty;
	}
	
	public GeneralStaff(String dn, String duty) {
		super(dn);
		this.duty=duty;
	}
	
	public GeneralStaff(String name, int by, String dn, String duty) {
		super(name, by, dn);
		this.duty=duty;
	}
	
	public String getDuty() {
		return duty;
	}
	
	@Override
	public boolean equals(Object e) {
		if(e instanceof GeneralStaff) {
			GeneralStaff otherStaff= (GeneralStaff)e;
			if(super.equals(otherStaff)) {
				if(this.duty == otherStaff.duty) {
						return true;
				}
			}
		} return false;
	}
	
	@Override
	public String toString() {
		String s= super.toString() + String.format(" GeneralStaff: Duty: %10s" ,
				getDuty());
		return s;
	}
}
