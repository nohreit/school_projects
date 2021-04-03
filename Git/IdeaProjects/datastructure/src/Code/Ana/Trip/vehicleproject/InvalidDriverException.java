package Code.Ana.Trip.vehicleproject;

public class InvalidDriverException  extends Exception{

	public InvalidDriverException() {
		System.out.println("Cannot be driver");
	}
	
	public InvalidDriverException(String message) {
		System.out.println( message);
	}
}
