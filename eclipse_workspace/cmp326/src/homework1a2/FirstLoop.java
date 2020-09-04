package homework1a2;

public class FirstLoop {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	
	public static void display(int a, String str) {
		System.out.println( a + " is " + str);
	}
}
