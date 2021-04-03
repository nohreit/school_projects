package Code.Ana.finalproject;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

public class RecursionQuestion {

	public static void main(String[]args) {

		Car [] cars = new Car[10];

		int [][] seatConfigurations = {new int[]{2,2}, new int[]{2,3},
				new int[]{2,2,3}, new int[]{2,3,3}, new int[]{2,3,4}, new int[]{2,4,3},
				new int[]{2,3,5}, new int[]{2,4,4}, new int[]{2,4,5}, new int[]{3,4,5}};

		for(int i=0; i<cars.length; i++){
			cars[i] = new Car(2, 4, seatConfigurations[i]);
		}
		Scanner kb = new Scanner(System.in);
//		System.out.print("enter seat info");

		String [] input = kb.nextLine().split(" ");
		int [] rowSeats = new int[input.length];

		for(int i=0; i<input.length; i++){
			rowSeats[i] = Integer.parseInt(input[i]);
		}

		Car c1= new Car(2,4,rowSeats);

		binarySearch(cars, c1);

	}

	public static int binarySearch(Car[] cars, Car c) {

		Arrays.sort(cars.);

		System.out.println("Looking for " + c.toString());
		int s=0;
		int e= cars.length-1;

//		System.out.println("NOT Found");
		return betterBS(cars, c, s, e);
	}

	@Test
	public void run(){
		int[] a = new int[]{1,2,1};
		int[] b = new int[]{1,2};
		pln(Arrays.compare(a, b));
	}

	public static void p(Object o){
		System.out.print(o);
	}
	public static void pln(Object o){
		System.out.println(o);
	}

	private static int betterBS(Car[] cars, Car c, int s, int e) {
		if(s<=e) {
			int mid= (s+e)/2;
			System.out.println("s=" + s + ", e=" + e + ", mid=" + mid);
			if(Arrays.compare(c.numSeatsPerRow, cars[mid].numSeatsPerRow) == 0) {
				System.out.println("FOUND at " + mid);
				return mid;
			}
			else if(Arrays.compare(c.numSeatsPerRow, cars[mid].numSeatsPerRow) < 0 ) {//left
				System.out.println("go left");
				return betterBS(cars, c, s, mid-1);
			}
			else if(Arrays.compare(c.numSeatsPerRow, cars[mid].numSeatsPerRow) > 0) {
				System.out.println("go right");
				return betterBS(cars, c, mid+1, e);
			}
		}
		System.out.println("NOT Found");
		return -1;
	}
}