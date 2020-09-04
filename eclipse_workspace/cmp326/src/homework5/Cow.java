package homework5;

public class Cow extends Animal implements Speaker{

	@Override
	public double metabolizeAccumulatedCalories() {
		double pounds = this.caloriesAccumulator / 500;
		this.gainWeight(pounds);
		this.caloriesAccumulator = 0;
		return pounds;
	}

	@Override
	public String speak() {
		return "moo";
	}

	@Override
	public String speak(int count) {
		String str = "";
		for(int i = 0; i < count; i++) {
			str += (i == count-1)? "moo" : "moo ";
		}
		return str;
	}

}
