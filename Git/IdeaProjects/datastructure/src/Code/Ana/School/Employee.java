package Code.Ana.School;

public class Employee extends Person {

    private String deptName;
    private static int numEmployees;
    private int employeeID;

    public Employee() {
        this.deptName = "";
        numEmployees++;
        this.employeeID = numEmployees;
    }

    public Employee(String dn) {
        this.deptName = dn;
        numEmployees++;
        this.employeeID = numEmployees;
    }

    public Employee(String name, int birthYear, String deptName) {
        super(name, birthYear);
        this.deptName = deptName;
        numEmployees++;
        this.employeeID = numEmployees;
    }

    public String getDeptName() {
        return deptName;
    }

    public static int getNumEmployees() {
        return numEmployees;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setDeptName(String dept) {
        this.deptName = dept;
    }

    @Override
    public boolean equals(Object e) {
        if (e instanceof Employee) {
            Employee otherEmployee = (Employee) e;
            if (super.equals(otherEmployee)) {
                if (this.deptName == otherEmployee.deptName) {
                    if (this.employeeID == otherEmployee.employeeID) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s = super.toString() + String.format(" Employee: Department: %20s | Employee Number: %3d",
                getDeptName(), getEmployeeID());
        return s;
    }

    @Override
    public int compareTo(Person e) {
        int comp = 0;
        if (e instanceof Employee) {
            if (this.employeeID < ((Employee) e).employeeID) {
                comp = -1;
            } else if (this.employeeID > ((Employee) e).employeeID) {
                comp = 1;
            } else if (this.employeeID == ((Employee) e).employeeID) {
                comp = 0;
            }
        } else {
            comp = super.compareTo(e);
        }
        return comp;
    }
}
