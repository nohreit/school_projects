package homework1a2;

import java.util.Scanner;

public class Grades {
	static Scanner putIn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int g = 0, i = 0;
		
		int[] grade = {0,0,0,0,0,0,0,0,0,0};
		String[] gradeStr = {"A", "A-", "B+", "B", "B-", "C+", " C", "C-", "D", "F"};
		
		while(g >= 0) {
			prompt("Enter a grade: ");
			g = putIn.nextInt();
			
			if(g>=93)					//A
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
	
	public static void prompt(String str) {
		System.out.print(str);
	}
}
