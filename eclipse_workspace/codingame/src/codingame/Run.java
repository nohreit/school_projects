package codingame;

public class Run {

	public static void main(String[] args) {
		
		ChuckNorris cn = new ChuckNorris();
		
		System.out.println("C -> binary: "+cn.toBin("C"));
		System.out.println("C -> unary: "+cn.toUnary(cn.toBin("C")));
	}

}
