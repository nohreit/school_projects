package homework5;

public class Food {
	
	private String name;
	private int calories;
	
	public Food(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	public int getCalories() {
		return calories;
	}
	
	@Override
	public String toString() {
		return String.format("Food - name: %10s | calories: %4d", 
				this.getName(), this.getCalories());
	}
	
	@Override
	public boolean equals(Object obj) {
		Food fd = (Food) obj;
		return (this.getName() == fd.getName() && 
				this.getCalories() == fd.getCalories())? true : false;
	}

}
