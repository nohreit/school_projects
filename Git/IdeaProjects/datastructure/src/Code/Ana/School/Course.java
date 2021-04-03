package Code.Ana.School;

public class Course {

    private boolean isGraduateCourse;
    private int courseNum;
    private String courseDept;
    private int numCredits;

    public Course(boolean graduate, int num, String dept, int credits) {
        this.isGraduateCourse = graduate;
        this.courseNum = num;
        this.courseDept = dept;
        this.numCredits = credits;
    }

    //
    public boolean isGraduateCourse() {
        return isGraduateCourse;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public String getCourseDept() {
        return courseDept;
    }

    public int getNumCredits() {
        return numCredits;
    }

    public String getCourseName() {
        String s = "";
        if (isGraduateCourse == true) {
            s += "G" + courseDept + courseNum;
            return s;
        } else {
            s += "U" + courseDept + courseNum;
            return s;
        }
    }
//	private String isGraduate(boolean isGradute) {
//		if(isGradute== true) {
//			return "Graduate";
//		}return "Undergraduate";
//	}

    public boolean equals(Object obj) {
        if (obj instanceof Course) {
            Course otherCourse = (Course) obj;
            if (this.isGraduateCourse == otherCourse.isGraduateCourse) {
                if (this.courseDept == otherCourse.courseDept) {
                    if (this.courseNum == otherCourse.courseNum) {
                        if (this.numCredits == otherCourse.numCredits) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        return String.format("Course: %3s-%3d | Number of Credits: %02d | " + (isGraduateCourse ? "Graduate" : "Undergraduate"),
                courseDept, courseNum, numCredits);
    }

    public int compareTo(Course c) {
        Course oCourse = (Course) c;
        if (this.courseNum > oCourse.courseNum) {
            return 1;
        }
        if (this.courseNum < oCourse.courseNum) {
            return -1;
        }
        return 0;
    }
}
