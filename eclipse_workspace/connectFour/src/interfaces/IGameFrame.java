package interfaces;

public interface IGameFrame{
	
	public void display(boolean menu, boolean center, boolean north, boolean south, 
			boolean east, boolean west);
	public void clearBoard();	
	public boolean isEmpty();
	boolean isBoardFull();
	void readFileDisplayOnConsole(String fileName);
	String[] readFile(String fileName);
	void appendToFile(String fileName, String text);
	void writeToNewFile(String fileName, String text);
	void createNewFile(String fileName);
}
