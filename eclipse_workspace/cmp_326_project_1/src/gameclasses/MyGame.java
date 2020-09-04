package gameclasses;

import gameinterfaces.Game;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class MyGame implements Game {
	static Scanner cin = new Scanner(System.in);
	
	private MyPlayer player;
	protected MyRoom[] dungeon;
	
	public MyGame() {
		// Read PlayerInfo.txt and assign values to player		
		/* Open file */
		Scanner sin = null; // Will read the file and get a value.
		File file = null;

		try {
			sop("Hello world!\nWelcome to this text-based RPG game");
			String fileName = prompt("What is the player's name?", cin.nextLine()+"Info.txt");
			file = new File("src/sourcefiles/"); //assign file location
			
			if(!file.exists()) { // If file does not exist then create a new one with new info
				sop("The file does not exists. Please wait...");
				
				createANewFile(file.getName());
				
				Thread.sleep(3000); // Pause the process for 3s (well just for fun)
				
				sin = new Scanner(file);
				sop("Set info of your character");
				this.player = new MyPlayer( //Get input info of the character from the player and assign it
						prompt("Name:", cin.nextLine()), // directly to player object.
						prompt("Description:", cin.nextLine()), 
						prompt("Hit Points:", cin.nextInt()), 
						prompt("Damage:", cin.nextInt()),
						prompt("Heal Amount", cin.nextInt())
				);
				writeToFile(file.getName(), String.format("%15s\n%20s\n%03d\n%02d\n%02d",
						player.getName(), player.getDescription(), player.getHitPoints(), 
						player.getDamage())); //Write those data in the file
				Thread.sleep(3000); // To be honest it is just to simulate todays game loadings (trying...)
			}
			
		}catch (FileNotFoundException e) {
			sep(player.toString() + e.getMessage());
		}catch (IOException e) {
			e.getMessage();
		}catch (InterruptedException e) {
			e.getMessage();
		}finally {
			sop(sin);
			if(sin != null)
				sin.close();
		}	
		/* End of file reading */
		
		this.dungeon = new MyRoom[3];
		
		MyMonster monster1 = new MyMonster("Orc", "Covered with green blood", 20, 5, 0);
		MyRoom room1 = new MyRoom(0, "A room with an unbearable smell", monster1);
		MyMonster monster2 = new MyMonster("Skeleton", "Funny how it moves", 40, 10, 10);
		MyRoom room2 = new MyRoom(1, "Dark and cold", monster2); 
		MyMonster monster3 = new MyMonster("Fire Dragon", "Spout fire with each breath", 100, 20, 40);
		MyTreasureRoom room3 = new MyTreasureRoom(2, "A giant hall with something shiny on the other end", 
				monster3, "A large pile of gold");
		
		this.dungeon[0] = room1;
		this.dungeon[1] = room2;
		this.dungeon[2] = room3;
	}
	
	@Override
	public void play() {
		/* file open */
		MyBattle fight;
		MyTreasureRoom tr = (MyTreasureRoom) dungeon[dungeon.length-1];
		File file = null;
		
		try {
			file = new File("src/sourcefiles/GameLog.txt");
			String str = ""; // Concatenates all strings that need to be written in file
			
			if(!file.exists()) // Check if file exists
				createANewFile(prompt("What is the player's name?", file.getName()));
			
			str+=player.getName()+"\n"; // Write player's name on file
			
			for(int i = 0; i < this.dungeon.length; i++){
				if(!dungeon[i].isComplete()) {
					if(i == dungeon.length-1) {
						sop("room 3");
						tr.enter(player);
						fight = new MyBattle(player, tr.monster);
					}else {
						sop("room "+(i+1));
						dungeon[i].enter(player);
						fight = new MyBattle(player, dungeon[i].monster);
					}
					fight.run();
				}
				
				if(dungeon[i].isComplete())
					str+="Room " + (i+1)+ " cleared\n";
				
				if(!player.isAlive()) {
					str+=player.getName() + " died...\n";
					sop(player.getName() + " died...");
					break;
				}
				if(tr.isComplete()) {
					str+="Treasure room " + (i+1)+ " cleared\n";
					tr.enter(player);
				}
			}
			
			str+="THE END\n";
			
			writeToFile(file.getName(), str);
			
		} catch (FileNotFoundException e) {
			sep(e.getMessage());
		}catch (IOException e){
			sep(e.getMessage());
		}finally {
			sop("THE END");
		}
		/* file close */
	}
	
	public static void sep(Object obj) {
		System.err.println(obj);
	}
	
	public static void sop(Object obj) {
		System.out.println(obj);
	}
	
	public int prompt(String str, int value) {
		sop(str);
		return value;
	}
	
	public static String prompt(String str, String value) {
		sop(str);
		return value;
	}
	
	public static void createANewFile(String fileName) {
		File file = null;		
		try {											/*if the fileName has "." then add nothing*/
			file = new File("src/sourcefiles/"+fileName+(fileName.indexOf('.') == -1 ? ".txt":""));
			if(!file.exists()) { //First time run
				file.createNewFile();
			}else {
				sop(file.getName()+" already exists");
				createANewFile(prompt("Set a different name", cin.nextLine())); // Here we go again
			}
		}catch (IOException e) {
			sep(e.getMessage());
		}finally {
			if(!file.exists()) { // Well in case it fails to create the file 
				sep(file.getName()+" creation failed. Try again.");
				createANewFile(prompt("Set a name of the file", cin.nextLine())); // And again
			}
		}
	}
	
	public static void writeToFile(String fileName, String text) throws FileNotFoundException, IOException{
		File file = null;
		PrintWriter sout = null;
		char key = 0;
		try {
			file = new File("src/sourcefiles/"+fileName+(fileName.indexOf('.') == -1 ? ".txt":""));
			sout = new PrintWriter(new FileOutputStream(file));
			if(!file.exists())
				createANewFile(fileName); //
//				sep(file.getName()+" does not exists");
			sout.println(text);
			do {
				key = prompt("Press key: [S] -> Save character\t [R] -> Recreate your character", 
						cin.next()).charAt(0);
				if(key != 'S' && key != 'R')
					sop("Invalid key. Try again");
				if(key == 'S') break;
				if(key == 'R') writeToFile(fileName, text);
			}while(key != 'S' && key != 'R');
		}catch (FileNotFoundException e) {
			sep(e.getMessage());
		}catch (IOException e) {
			sep(e.getMessage());
		}finally {
			if(sout != null)
				sout.close();
		}
	}
	
	public static void main(String[] args) throws NullPointerException, IOException {
		MyGame game = new MyGame();
		game.play();
	}

}
