package homework1a2;

import java.util.Scanner;

public class PatternTwo {
	static Scanner putIn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
	
	public static void prompt(String str) { //Display text 
		System.out.print(str);
	}
}
