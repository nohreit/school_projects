package classes;

public class Player {
	private String name, symbol;
	private int numGames, numWins;
	
	public Player(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
		this.numGames = 0;
		this.numWins = 0;
	}
	
	public void addNumWins() {
		numGames++;
		numWins++;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumGames() {
		return numGames;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public int getNumWins() {
		return numWins;
	}
}
