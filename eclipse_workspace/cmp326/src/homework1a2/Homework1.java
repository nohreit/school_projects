package homework1a2;

import java.util.Scanner;
public class Homework1{
	static Scanner putIn = new Scanner(System.in);
	
	public static void firstLoop() {
		int num = 1;
			
		while(num <= 30) {
			if(num % 2 == 0)
				display(num, "an even number");
			else
				display(num, "an odd number");
			
			if(num % 3 == 0)
				display(num, "divisible by 3");
			if(num % 5 == 0)
				display(num, "divisible by 5");
			if(num % 7 == 0)
				display(num, "divisible by 7");
			if(num % 9 == 0)
				display(num, "divisible by 9");
			
			num++;
		}
	}
		
	public static void grades() {
		int g = 0, i = 0;
		
		int[] grade = {0,0,0,0,0,0,0,0,0,0};
		String[] gradeStr = {"A", "A-", "B+", "B", "B-", "C+", " C", "C-", "D", "F"};
		
		prompt("Please enter a grade and press [Enter] key to submit\n"
				+ "Submit a negative value to end the input.\n");
		
		while(g >= 0) {
			prompt("Enter a grade: ");
			g = putIn.nextInt();
			
			if(g>=93)				//A
				grade[0]+=1;
			else if(g>=90)				//A-
				grade[1]+=1;
			else if(g>=87)				//B+
				grade[2]+=1;
			else if(g>=83)				//B
				grade[3]+=1;
			else if(g>=80)				//B-
				grade[4]+=1;
			else if(g>=77)				//C+
				grade[5]+=1;
			else if(g>=73)				//C
				grade[6]+=1;
			else if(g>=70)				//C-
				grade[7]+=1;
			else if(g>=60)				//D
				grade[8]+=1;
			else if(g>=0)				//F
				grade[9]+=1;
			i++;
		}
		
		prompt("Total number of grades = "+ (i-1)+"\n");
		
		for (int j = 0; j < grade.length; j++) {
			prompt("Number of "+gradeStr[j]+"'s = "+grade[j]+"\n");
		}
	}
		
	public static void patternOne() {
		prompt("Please enter a number 1...9 : \n");
		int n = putIn.nextInt();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j<=i; j++)
				prompt(" "+(j+1));
			prompt("\n");
		}
	}
	
	public static void patternTwo() {
		prompt("Please enter a number 1...9 : \n");
		int n = putIn.nextInt(); 
		
        for(int i=1; i<=n; i++){ 
  
            for(int j=2*(n-i); j>0; j--){
				prompt(" ");
            } 
             
            for(int j=0; j<i; j++){
				prompt(" "+(i-j));
            }
			prompt("\n");
        } 
	}
		
	public static void telephoneNumber() {
		String str = "", num = "";
		
		prompt("Please enter a telephone number using letters :\n");
		str = putIn.nextLine().toUpperCase(); //The input is directly upper cased

		for(int i=0; i < str.length(); i++) { //Loop to extract each character of str
			num += msgCode(str.charAt(i)); //Call a method and concat the result
		}
		
		prompt(num+"\n");
	}
	
	public static char msgCode(char key) { //Method that get a char form str and look of it equivalence in number.
		char k='0';
		switch (key) {
		case 'A':
		case 'B':
		case 'C':
			k='2';
			break;
		case 'D':
		case 'E':
		case 'F':
			k='3';
			break;
		case 'G':
		case 'H':
		case 'I':
			k='4';
			break;
		case 'J':
		case 'K':
		case 'L':
			k='5';
			break;
		case 'M':
		case 'N':
		case 'O':
			k='6';
			break;
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
			k='7';
			break;
		case 'T':
		case 'U':
		case 'V':
			k='8';
			break;
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
			k='9';
			break;
		default:
			k='-';
			break;
		}
		return k;
	}
	public static void display(int a, String str) { //Display text
		System.out.println( a + " is " + str);
	}
	
	public static void prompt(String str) { //Display text
		System.out.print(str);
	}
}
