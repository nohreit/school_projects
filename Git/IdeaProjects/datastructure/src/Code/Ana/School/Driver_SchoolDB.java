package Code.Ana.School;

//Youtube video: https://youtu.be/DSwa-TPFy58


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver_SchoolDB {

    public Driver_SchoolDB() {
    }

    public String readFromFile(String fileName) {
        Scanner inStream = null;
        StringBuilder fileContents = new StringBuilder();

        try {
            File file = new File(fileName);
//            if (file.exists() && file.canRead()) {
            inStream = new Scanner(file);
            while (inStream.hasNextLine()) {
                fileContents.append(inStream.nextLine()).append("\n");
            }
//            }
        } catch (FileNotFoundException e) {
            System.err.println("Cannot read from file " + fileName);
            e.printStackTrace();
        } finally {
            if (inStream != null) {
                inStream.close();
            }
        }
        return fileContents.toString();
    }

    public void readAndCreateFromFile(String fileName) {
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Faculty> faculties = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<GeneralStaff> generalStaffs = new ArrayList<>();
        ArrayList<Person> persons = new ArrayList<>();

        Scanner inStream = null;
        try {
            File file = new File(fileName);
            if (file.exists() && file.canRead()) {
                inStream = new Scanner(file);
                while (inStream.hasNextLine()) {
                    String line = inStream.nextLine();
                    if (line.contains("Course")) {
                        createCourse(line, courses);
                    } else if (line.contains("Student")) {
                        createStudent(line, students);
                    } else if (line.contains("Faculty")) {
                        createFaculty(line, faculties);
                    } else if (line.contains("Employee")) {
                        createEmployee(line, employees);
                    } else if (line.contains("GeneralStaff")) {
                        createGeneralStaff(line, generalStaffs);
                    } else if (line.contains("Person")) {
                        createPerson(line, persons);
                    } else {
                        Run.print(line);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Cannot read from file " + fileName);
            e.printStackTrace();
        } finally {
            if (inStream != null) {
                inStream.close();
            }
        }
        printSchoolDB(courses, persons, employees, generalStaffs, faculties, students);
    }

    private void printSchoolDB(ArrayList<Course> courses, ArrayList<Person> persons, ArrayList<Employee> employees,
                               ArrayList<GeneralStaff> generalStaffs, ArrayList<Faculty> faculties,
                               ArrayList<Student> students) {

        Run.print("**************************************************************\n");
		Run.print("SCHOOL DATABASE INFO:\n");
		Run.print("**************************************************************\n");

        Run.print("COURSES:\n");
        for (int i = 0; i < courses.size(); i++) {
            Run.print(courses.get(i) + "\n");
        }
        Run.print("**************************************************************\n" +
                "**************************************************************\n");

        Run.print("PERSONS:\n");
        for (int i = 0; i < persons.size(); i++) {
            Run.print(persons.get(i) + "\n");
        }
        Run.print("**************************************************************\n" +
                "**************************************************************\n");

        Run.print("EMPLOYEES:\n");
        for (int i = 0; i < employees.size(); i++) {
            Run.print(employees.get(i) + "\n");
        }
        Run.print("**************************************************************\n" +
                "**************************************************************\n");

        Run.print("GENERAL STAFFS:\n");
        for (int i = 0; i < generalStaffs.size(); i++) {
            Run.print(generalStaffs.get(i) + "\n");
        }
        Run.print("**************************************************************\n" +
                "**************************************************************\n");

        Run.print("FACULTY:\n");
        for (int i = 0; i < faculties.size(); i++) {
            Run.print(faculties.get(i) + "\n");
        }
        Run.print("**************************************************************\n" +
                "**************************************************************\n");

        Run.print("STUDENTS:\n");
        for (int i = 0; i < students.size(); i++) {
            Run.print(students.get(i) + "\n");
        }
        Run.print("**************************************************************\n" +
                "**************************************************************\n");
    }

    public void createCourse(String line, ArrayList<Course> courses) {
        String courseLine = line.substring(8);
        String splitter = "";
        if(courseLine.contains(", ")){
            splitter = ", ";
        }else if(courseLine.contains(",")){
            splitter = ",";
        }

        String[] splitedCourse = courseLine.split(splitter);
        boolean isGraduate = Boolean.parseBoolean(splitedCourse[0]);
        int numberCourse = Integer.parseInt(splitedCourse[1]);
        String nameCourse = splitedCourse[2];
        int credit = Integer.parseInt(splitedCourse[3]);

        Course course = new Course(isGraduate, numberCourse, nameCourse, credit);

        courses.add(course); // add a course in the list
    }

    public void createStudent(String line, ArrayList<Student> students) {
//        Run.print(line);
    }

    public void createFaculty(String line, ArrayList<Faculty> faculties) {
        String facultyLine = line.substring(8);
        String[] splittedFaculty = facultyLine.split(",");
        int numParameters = splittedFaculty.length;

        if (numParameters == 1 && splittedFaculty[0].length() == 0) {
            faculties.add(new Faculty());
        } else if (numParameters == 1) {
            boolean isTenured = Boolean.parseBoolean(splittedFaculty[0]);
            faculties.add(new Faculty(isTenured));
        } else if (numParameters == 2) {
            String depName = splittedFaculty[0];
            boolean isTenured = Boolean.parseBoolean(splittedFaculty[1]);
            faculties.add(new Faculty(depName, isTenured));
        } else if (numParameters == 4) {
            String name = splittedFaculty[0];
            int birthYear = Integer.parseInt(splittedFaculty[1]);
            String depName = splittedFaculty[2];
            boolean isTenured = Boolean.parseBoolean(splittedFaculty[3]);
            faculties.add(new Faculty(name, birthYear, depName, isTenured));
        }
    }

    public void createEmployee(String line, ArrayList<Employee> employees) {
//        Run.print(line);
    }

    public void createGeneralStaff(String line, ArrayList<GeneralStaff> generalStaffs) {
//        Run.print(line);
    }

    public void createPerson(String line, ArrayList<Person> persons) {
//        Run.print(line);
    }

    /**/
    public void readFileDisplayOnConsole(String fileName) {
        Scanner inStream = null;
        try {
            File file = new File(fileName);
            if (file.exists() && file.canRead()) {
                inStream = new Scanner(file);
                while (inStream.hasNextLine()) {
                    Run.print(inStream.nextLine());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Cannot read from file " + fileName);
            e.printStackTrace();
        } finally {
            if (inStream != null) {
                inStream.close();
            }
            Run.print("All done!");
        }
    }

//	public static void readFileCreate(String fileName)throws FileNotFoundException{
//		arraylist= new ArrayList<Course>();
//		File school= new File(fileName);
//		Scanner sc= new Scanner(school);
//
//		while(sc.hasNextLine()) {
//			try {
//				String [] line= sc.nextLine().split(",");
//
//			}
//		}
//	}

//	public static void main(String[]args) {
//
//		File f1= new File(MY_FILE_NAME);
//		readFileDisplayOnConsole(MY_FILE_NAME);
//
//		Run.print();
//		Run.print("**************************************************************");
//		Run.print("SCHOOL DATABASE INFO:");
//		Run.print();
//		Run.print("**************************************************************");
//		Run.print();
//
//		Run.print(readFile(MY_FILE_NAME));
//
//	}
//
}



