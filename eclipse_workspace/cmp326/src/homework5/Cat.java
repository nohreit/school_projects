package homework5;

public class Cat extends Animal implements Speaker{
	@Override
	public double metabolizeAccumulatedCalories() {
		double pounds = this.caloriesAccumulator / 1000;
		this.gainWeight(pounds);
		this.caloriesAccumulator = 0;
		return pounds;
	}

	@Override
	public String speak() {
		return "meow";
	}

	@Override
	public String speak(int count) {
		String str = "";
		for(int i = 0; i < count; i++) {
			str += (i == count-1)? "meow" : "meow ";
		}
		return str;
	}
}
