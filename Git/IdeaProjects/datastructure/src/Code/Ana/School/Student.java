package Code.Ana.School;

public class Student extends Person {

    private static int numStudents;
    private int studentID;
    private Course[] coursesTaken;
    private int numCoursesTaken; //controlled variable
    private boolean isGraduate;
    private String major;

    public Student() {
        super();
        coursesTaken = new Course[10];
        this.numCoursesTaken = 0;
        this.isGraduate = false;
        this.major = "undeclared";
        numStudents++;
        this.studentID = numStudents;
    }

    public Student(boolean graduate) {
        super();
        coursesTaken = new Course[10];
        this.numCoursesTaken = 0;
        setIsGraduate(graduate);
        this.major = "undeclared";
        numStudents++;
        this.studentID = numStudents;
    }

    public Student(String major, boolean graduate) {
        super();
        coursesTaken = new Course[10];
        this.numCoursesTaken = 0;
        setIsGraduate(graduate);
        setMajor(major);
        numStudents++;
        this.studentID = numStudents;
    }

    public Student(String name, int by, String major, boolean graduate) {
        super(name, by);
        coursesTaken = new Course[10];
        this.numCoursesTaken = 0;
        setIsGraduate(graduate);
        setMajor(major);
        numStudents++;
        this.studentID = numStudents;
    }

    //returns false it should have been true
    public boolean isGraduate() {
        return this.isGraduate;
    }

    //error return "0" it should have been equal to 0
    public int getNumCoursesTaken() {
        return this.numCoursesTaken;
    }

    public static int getNumStudents() {
        return numStudents;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getMajor() {
        return major;
    }

    public void setIsGraduate(boolean graduate) {
        this.isGraduate = graduate;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void addCourseTaken(Course course) {
        if (isValid(numCoursesTaken)) {
            coursesTaken[numCoursesTaken++] = course;
        }
    }

    public void addCoursesTaken(Course[] course) {
        for (int i = 0; i < course.length; i++) {
            if (isValid(numCoursesTaken)) {
                coursesTaken[numCoursesTaken++] = course[i];
            }
        }
    }

    public Course getCourseTaken(int index) {
        if (isValid(index)) {
            return coursesTaken[index];
        }
        return null;
    }

    public String getCourseTakenAsString(int index) {
        if (isValid(index)) {
            return coursesTaken[index].toString();
        }
        return null;
    }

    public String getAllCoursesTakenAsString() {
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < numCoursesTaken; i++) {
            t.append(getCourseTakenAsString(i)).append(i != numCoursesTaken ? "," : "");
        }
        return t.toString();
    }

    public boolean isValid(int index) {
        return index >= 0 && index < 10;
    }

    @Override
    public boolean equals(Object s) {
        if (s instanceof Student) {
            Student otherStudent = (Student) s;
            if (super.equals(otherStudent)) {
                if (this.studentID == otherStudent.studentID) {
                    if (this.numCoursesTaken == otherStudent.numCoursesTaken) {
                        if (this.isGraduate == otherStudent.isGraduate) {
                            if (this.major.equals(otherStudent.major)) {
                                return this.coursesTaken == otherStudent.coursesTaken;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s",
                studentID, major, (isGraduate() ? "Graduate" : "Undergraduate"), numCoursesTaken, getAllCoursesTakenAsString());
    }

    //FIX
    @Override
    public int compareTo(Person s) {
        int comp = 0;
        if (s instanceof Student) {
            if (this.getCourseTaken(0).getNumCredits() < ((Student) s).getCourseTaken(0).getNumCredits()) {
                comp = -1; //getCourseTaken(0).getNumCredits()
            } else if (this.getCourseTaken(0).getNumCredits() > ((Student) s).getCourseTaken(0).getNumCredits()) {
                comp = 1; //getCourseTaken(0).getNumCredits()
            } else if (this.getCourseTaken(0).getNumCredits() == ((Student) s).getCourseTaken(0).getNumCredits()) {
                comp = 0;
            }
        } else {
            comp = super.compareTo(s);
        }
        return comp;
    }

}
