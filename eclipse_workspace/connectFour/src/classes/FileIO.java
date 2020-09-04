package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import interfaces.IFileIO;

public class FileIO implements IFileIO{

	@Override
	public void createNewFile(String fileName) {
		PrintWriter outStream = null;
		
		try {
			outStream = new PrintWriter(fileName);
			
		} catch (FileNotFoundException e) {
			System.err.println("Could not create the file "+fileName);
		}
		finally{
			if(outStream !=null){
				outStream.close();
			}
		}
	}

	@Override
	public void writeToNewFile(String fileName, String text) {
		PrintWriter outStream = null;
		try {
			outStream  = new PrintWriter(fileName);
			outStream.println(text);//print the line of text to the file
		} catch (FileNotFoundException e) {
			System.err.println("Could not write to the file "+fileName);
		}
		finally{
			if(outStream !=null){
				outStream.close();
			}
		}		
	}

	@Override
	public void appendToFile(String fileName, String text) {
		PrintWriter outStream = null;
		try {
			outStream = new PrintWriter(new FileOutputStream(fileName, true));
			outStream.println(text);//print the line of text to the file
		} catch (FileNotFoundException e) {
			System.err.println("Could not write to the file "+fileName);
		}
		finally{
			if(outStream !=null){
				outStream.close();
			}
		}
	}

	@Override
	public String readFile(String fileName) {
		Scanner inStream = null;
		String fileContents = "";
		try {

			File theFileObject = new File(fileName);
			inStream = new Scanner(theFileObject);
			while(inStream.hasNextLine()){
				fileContents += inStream.nextLine()+"\n";
			}
			
		} catch (FileNotFoundException e) {
			return (fileContents + e.getMessage());
		}
		finally{
			if(inStream !=null){
				inStream.close();
			}
			System.out.println("All Done with file "+fileName);
		}
		return fileContents;
	}

	@Override
	public void readFileDisplayOnConsole(String fileName) {
		Scanner inStream = null;
		try {

			File theFileObject = new File(fileName);
			inStream = new Scanner(theFileObject);
			while(inStream.hasNextLine()){
				System.out.println(inStream.nextLine());
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Probelm in readFileDisplayOnConsole " +  e.getMessage());
		}
		finally{
			if(inStream !=null){
				inStream.close();
			}
//			System.out.println("All Done with file "+fileName);
		}
		
	}

	@Override
	public boolean deleteFile(String fileName) {
		File theFile = new File(fileName);
		if(theFile.exists()){
			if(theFile.delete()){
				System.out.println("The file "+fileName+ " was successfully deleted");
				return true;
			}
			else{
				System.err.println("The file "+fileName+ " COULD NOT be deleted");
				return false;
			}
		}
		System.err.println("The file "+fileName+ " Does NOT exist");
		return false;
	}

	@Override
	public boolean copyFile(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean copyFile(String fileNameOrig, String fileNameCopiedVersion) {
		Scanner inStream = null;
		PrintWriter outStream = null;
		boolean status = false;
		try {
			inStream = new Scanner(new File(fileNameOrig)); //connect to original file
			outStream = new PrintWriter(new FileOutputStream(fileNameCopiedVersion, false));
			while(inStream.hasNextLine()){
				
				outStream.println(   inStream.nextLine()   ); //write the read line to the output file
			}
			status =  true;
		} catch (FileNotFoundException e) {
			System.err.println("Could not copy file from "+
					fileNameOrig+" to "+ fileNameCopiedVersion);
			status = false;
		}
		finally{
			if(inStream !=null){
				inStream.close();
			}
			if(outStream !=null){
				outStream.close();
			}
		}
		return status;
	}

	@Override
	public void writeToFileFromKeyboard(String fileName) {
		Scanner kb = new Scanner(System.in);
		PrintWriter outStream = null;
		String lineIn = "";
		
		try {
			outStream = new PrintWriter( new FileOutputStream(fileName , true)  );
			do{
				lineIn = kb.nextLine();
				outStream.println(lineIn);
				outStream.flush();
			}while(!lineIn.equalsIgnoreCase("STOP"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(kb != null){
				kb.close();
			}
			if(outStream !=null){
				outStream.close();
			}
		}
		
		
	}

	@Override
	public boolean findAndReplaceFileContent(String fileName, String textOrig, String textReplacement) {
		// TODO Auto-generated method stub
		return false;
	}
	
}