package Code.Ana.ModFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadAndEditFile {

//    public static void main(String[] args) throws FileNotFoundException {
//
//        Scanner scnr = new Scanner(System.in);
//        String userFile = "";
//        Scanner in = null;
//        File f;
//
//        do {
//            System.out.println("What is the name of your file?");
//            userFile = scnr.next();
//            f = new File(userFile);
//
//            if (!(f.exists())) {
//                System.out.println("File Not Found " + userFile);
//            }
//
//        } while (!(f.exists()));
//
//        readFromFile(userFile);
//
////		if(f.canRead() && f.exists()) {
////			in= new Scanner(f);
////			PrintWriter out= new PrintWriter("src/text_files/HomeworkOutput6-2.txt"); //for eclipse
////		//	PrintWriter out= new PrintWriter("HomeworkOutput6-2.txt"); //for zybooks
////
////			while(in.hasNextLine()) {
////				String linesToPrint= "";
////				String linesOut="";
////				String lines= in.nextLine();
////				lines.replaceAll("()([A-Z][a-z])", "$1 $2"); //inserts a blank char before all capital char
////
////				String [] words= lines.split(" ");
////				for( String word: words) {
////					if(word.length() >0) {
////						linesToPrint += word + " ";
////					}
////				}
////				linesToPrint= linesToPrint.trim();
////
////				String [] sentences= linesToPrint.split("\\.");
////
////
////				for(String s: sentences) {
////					s= s.trim();
////				}
////				String[] linesText= linesToPrint.split("\n");
//////				for(int j=0; j< linesText.length; j++) {
//////				System.out.println(linesText[j]);
//////				}
////
////					for (int i=0; i<sentences.length; i++ ) {
////						if(sentences.length >0) {
////							if(i==0) {
////								linesOut += Character.toUpperCase(sentences[i].charAt(0))+ sentences[i].substring(1)+
////										(sentences[i].contains("!") || sentences[i].contains("\\") ? " ": ".");
////							}
////
////							else {
////								linesOut += " " + Character.toUpperCase(sentences[i].charAt(1))+ sentences[i].substring(2)+
////										(sentences[i].contains("!") || sentences[i].contains("\\") ? " ": ".");
////							}
////						}
////					}
////
////				out.println(linesOut);
////			}
////			out.close();
////			in.close();
////	}
//
//    }


    public static String readFromFile(String fileName) {
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

    public static void println(Object o) {
        System.out.println(o);
    }

    public static void print(Object o) {
        System.out.print(o);
    }

}
