package Code.Ana.School;

import java.util.ArrayList;

public class Run extends Driver_SchoolDB {

    private static final String RIGHT_PATH = "../../Git/IdeaProjects/datastructure/src/resources/";
    private static final String MY_FILE_NAME = RIGHT_PATH+"SchoolDB_Initial.txt";

    //public static void main(String[] args) {
 //       execute();
//    }

    public static void execute() {
        Driver_SchoolDB myDriver = new Driver_SchoolDB();
        ArrayList<Course> courses= new ArrayList<>();

//        displayConsole(new Driver_SchoolDB());
        myDriver.readAndCreateFromFile(MY_FILE_NAME);
    }

    public static void displayConsole(Driver_SchoolDB driver) {
        driver.readFileDisplayOnConsole(MY_FILE_NAME);
    }

    public static void print(Object o) {
        System.out.print(o);
    }
}
