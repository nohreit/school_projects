package Code.Ana.Hospital;

public class Patient {

    private static int numPatients = 0;
    private String name;
    private int birthYear;
    private int patientNumber;
    private String ailment;

    public Patient(String name, int birthYear, String ailment) {
        patientNumber = ++numPatients;
        this.name = name;
        if (isValid(birthYear)) {
            this.birthYear = birthYear;
        } else {
            this.birthYear = 0;
        }
        this.ailment = ailment;
    }

    private boolean isValid(int by) {
        return by >= 0;
    }


    public static int getNumPatients() {
        return numPatients;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    public String getAilment() {
        return ailment;
    }


    @Override
    public String toString() {
        return String.format("Patient [name= %20s | birthYear= %04d | patient number= %06d | ailment= %20s\n",
                this.getName(), this.getBirthYear(), this.getPatientNumber(), this.getAilment());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient otherP = (Patient) o;
            if (this.name.equals(otherP.name)) {
                if (this.birthYear == otherP.birthYear) {
					return this.ailment.equals(otherP.ailment);
                }
            }
        }
        return false;
    }


}
