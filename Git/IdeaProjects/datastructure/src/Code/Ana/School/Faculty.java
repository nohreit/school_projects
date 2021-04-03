package Code.Ana.School;

public class Faculty extends Employee {

    private Course[] coursesTaught;
    private int numCoursesTaught; //controlled variable
    private boolean isTenured;

    public Faculty() {
        super();
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        isTenured = false;
    }

    public Faculty(boolean t) {
        super();
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = t;
    }

    public Faculty(String deptName, boolean t) {
        super(deptName);
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = t;
    }

    public Faculty(String name, int by, String dn, boolean t) {
        super(name, by, dn);
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = t;
    }

    public boolean isTenured() {
        if (this.isTenured == true) {
            return true;
        }
        return false;
    }

    public int getNumCoursesTaught() {
        return numCoursesTaught;
    }

    public void setIsTenured(boolean isTenured) {
        this.isTenured = isTenured;
    }

    public void addCourseTaught(Course course) {
        if (isValid(numCoursesTaught)) {
            coursesTaught[numCoursesTaught++] = course;
        }
    }

    public void addCoursesTaught(Course[] course) {
        for (int i = 0; i < course.length; i++) {
            if (isValid(numCoursesTaught)) {
                coursesTaught[numCoursesTaught++] = course[i];
            }
        }
    }

    public Course getCourseTaught(int index) {
        if (isValid(index)) {
            return coursesTaught[index];
        }
        return null;
    }

    public String getCourseTaughtAsString(int index) {
        if (isValid(index)) {
            return coursesTaught[index].toString();
        }
        return null;
    }

    public String getAllCoursesTaughtAsString() {
        String t = "";
        for (int i = 0; i < numCoursesTaught; i++) {
            t += getCourseTaughtAsString(i) + (i != numCoursesTaught ? "," : "");
        }
        return t;
    }

    public boolean isValid(int index) {
        if (index >= 0 && index < 100) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object f) {
        if (f instanceof Faculty) {
            Faculty otherFaculty = (Faculty) f;
            if (super.equals(otherFaculty)) {
                if (this.coursesTaught == otherFaculty.coursesTaught) {
                    if (this.numCoursesTaught == otherFaculty.numCoursesTaught) {
                        if (this.isTenured == otherFaculty.isTenured) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += String.format(" Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s",
                (isTenured() ? "Is Tenured" : "Not Tenured"), getNumCoursesTaught(), getAllCoursesTaughtAsString());
        return s;
    }

    @Override
    public int compareTo(Person f) {
        int comp = 0;
        if (f instanceof Faculty) {
            if (this.numCoursesTaught < ((Faculty) f).numCoursesTaught) {
                comp = -1;
            } else if (this.numCoursesTaught > ((Faculty) f).numCoursesTaught) {
                comp = 1;
            } else if (this.numCoursesTaught == ((Faculty) f).numCoursesTaught) {
                comp = 0;
            }
        } else {
            comp = super.compareTo(f);
        }
        return comp;
    }

}
