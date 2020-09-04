package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;


import classes.Player;
import interfaces.IGameFrame;
import interfaces.IPlayer;
import javax.swing.JSeparator;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements IPlayer, IGameFrame, ActionListener{

	private int rows, cols, turn;
	private int[] tracker;
	private boolean menu, center, north, south, east, west;
	private JPanel contentPane, menuPane, centerPane, rightPane, gridRightPane, leftPane, 
					gridLeftPane, bottomPane;
	private JButton[] slots;
	private JLabel name1, symbol1, wins1, name2, symbol2, wins2;
	private JLabel name1Value, symbol1Value, wins1Value, name2Value, symbol2Value, wins2Value, 
					btmText, champName, lstWinName;
	private JLabel[][] gridLabel;
	private JSeparator eastSeparator, westSeparator;
	private JTextField player1Name, player2Name, player1Symbol, player2Symbol;
	private Player player1, player2, currentPlayer;
	private JButton newGame, gameLog, play, clear;
	private File file;
	private String source;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setMinimumSize(new Dimension(600, 700));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		
		rows = 6; cols = 7; turn = 1;
		tracker = new int[] {5, 5, 5, 5, 5, 5, 5};
		source = "src/resources/Connect4-Results.txt";
		
		menu = false; center = true; north = true; south = true; east = true; west = true;

		player1 = new Player(JOptionPane.showInputDialog(null,"Player 1 name"),null); 
		player1 = new Player(player1.getName().toUpperCase(),JOptionPane.showInputDialog(
				null,"Symbol?" ,null));
		
		player2 = new Player(JOptionPane.showInputDialog(null,"Player 2 name"),null); 		
		player2 = new Player(player2.getName().toUpperCase(),JOptionPane.showInputDialog(
				null,"Symbol?" ,null));
		currentPlayer = player1;
		
		// File creation
		file = new File(source);
		
		if(!file.exists()) { // If file does not exist then create a new one with new info
			createNewFile(file.getName());
		}
		
		setTitle("Connect 4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 660);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		display(menu, center, north, south, east, west);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for(int i = 0; i < slots.length; i++) {
			if(slots[i] == arg0.getSource()) {
				gridLabel[tracker[i]][i].setText(currentPlayer.equals(player1)? 
								player1.getSymbol() : player2.getSymbol());
				
				gridLabel[tracker[i]][i].setBackground(currentPlayer.equals(player1)? 
								Color.RED : Color.YELLOW);
				gridLabel[tracker[i]][i].setForeground(Color.BLACK);
				
				if(isWinner()) {
					if(currentPlayer.equals(player1)) {
						player1.addNumWins();
					} else {
						player2.addNumWins();
					}
					congratulation(currentPlayer);
					break;
				}else if(isBoardFull()) {
					 JOptionPane.showMessageDialog(null, "The board is full! It's a draw!");
					 appendToFile(source, "----------------------\n"
					 		+ "It is a tie\n----------------------\n");
					 replayReq();
				}
				
				// Look for the champion
				appendToFile(source, (player1.getNumWins() > player2.getNumWins())?
						player1.getName() : player2.getName());
				
				wins1Value.setText(String.valueOf(player1.getNumWins()));
				
				wins2Value.setText(String.valueOf(player2.getNumWins()));
				tracker[i]--;
				
				if(tracker[i] < 0) slots[i].setEnabled(false);
				btmText.setText(String.valueOf(turn));
				turn++;
				turnChange();				
			}
		}
		wins1Value.setText(String.valueOf(player1.getNumWins()));
		
		wins2Value.setText(String.valueOf(player2.getNumWins()));
	}
	
	public void northPanel(boolean north) {
		if(north) {
			{
				JPanel scoreBoard = new JPanel();
				contentPane.add(scoreBoard, BorderLayout.NORTH);
				{
					JPanel winChampBoard = new JPanel();
					scoreBoard.add(winChampBoard);
					winChampBoard.setLayout(new GridLayout(2, 2, 102, 20));
					winChampBoard.setBackground(new Color(110, 120, 130));
					{
						JLabel champLabel = new JLabel("Champion");
						champLabel.setFont(new Font("Arial", Font.PLAIN, 24));
						winChampBoard.add(champLabel);
					}
					{
						champName = new JLabel("-------------");
						champName.setFont(new Font("Arial", Font.PLAIN, 24));
						champName.setForeground(Color.GREEN);
						winChampBoard.add(champName);
					}
					{
						JLabel lstWinLabel = new JLabel("Last winner");
						lstWinLabel.setFont(new Font("Arial", Font.PLAIN, 24));
						winChampBoard.add(lstWinLabel);
					}
					{
						lstWinName = new JLabel("-------------");
						lstWinName.setFont(new Font("Arial", Font.PLAIN, 24));
						lstWinName.setForeground(Color.RED);
						winChampBoard.add(lstWinName);
					}
				}
			}
		}
	}
	
	public void mainMenu(boolean menu) {
		if(menu) {
			menuPane = new JPanel();
			menuPane.setLayout(new BoxLayout(menuPane, BoxLayout.Y_AXIS));
			
			{ // Menu button layout
				JPanel menuBtnPane = new JPanel();
				menuBtnPane.setLayout(new FlowLayout(BoxLayout.X_AXIS, 50, 25));
				
				{
				
					newGame = new JButton("New Game");
					newGame.addActionListener(this);
					newGame.setAlignmentX(CENTER_ALIGNMENT);
					menuBtnPane.add(newGame);
				}
				{
					gameLog = new JButton("Game Log");
					gameLog.addActionListener(this);
					gameLog.setAlignmentX(CENTER_ALIGNMENT);
					menuBtnPane.add(gameLog);
				}
				menuPane.add(menuBtnPane);
			}		
			
			
			{ // New game layout
				JPanel newGameMenu = new JPanel();
				newGameMenu.setLayout(new GridLayout(6,2, 5, 20));
				newGameMenu.setBorder(new LineBorder(Color.GRAY));
				
				{
					JLabel lblPlayersInfo = new JLabel("Players info");
					newGameMenu.add(lblPlayersInfo);
				}
				{
					JLabel emptyLabel = new JLabel("");
					newGameMenu.add(emptyLabel);
				}
				
				// Player 1 info input
				{
					name1 = new JLabel("Player 1:");
					newGameMenu.add(name1);
				}
				{
					player1Name = new JTextField(10);
					player1Name.setToolTipText("Enter player 1 name");
					newGameMenu.add(player1Name);
				}
				{
					symbol1 = new JLabel("Symbol:");
					newGameMenu.add(symbol1);
				}
				{
					player1Symbol = new JTextField(10);
					player1Symbol.setToolTipText("Enter player 1 symbol");
					newGameMenu.add(player1Symbol);
				}
				
				// Player 2 info input
				{
					name2 = new JLabel("Player 2:");
					newGameMenu.add(name2);
				}
				{
					player2Name = new JTextField(10);
					player2Name.setToolTipText("Enter player 2 name");
					newGameMenu.add(player2Name);
				}
				{
					symbol2 = new JLabel("Symbol:");
					newGameMenu.add(symbol2);
				}
				{
					player2Symbol = new JTextField(10);
					player2Symbol.setToolTipText("Enter player 2 symbol");
					newGameMenu.add(player2Symbol);
				}
				
				// Submission or clear fields
				{
					{
						play = new JButton("Play !");
						play.addActionListener(this);
						newGameMenu.add(play);
					}
					{
						clear = new JButton("Clear");
						clear.addActionListener(this);
						newGameMenu.add(clear);
					}
				}
				
				menuPane.add(newGameMenu);
			}
			centerPane.add(menuPane);
		}
	}
	
	public void centerPanel(boolean center, boolean menu) {
		centerPane = new JPanel();
		centerPane.setBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(100, 100, 100)));
		contentPane.add(centerPane, BorderLayout.CENTER);
		
		// Main menu
		mainMenu(menu);
		
		// Game board
		if(center) {
			centerPane.setLayout(new GridLayout(7, 7, 0, 0));
			
			// Top buttons
			slots = new JButton[7];
			for(int col = 0; col < slots.length; col++) {
				slots[col] = new JButton("CLICK");
				slots[col].addActionListener(this);
				centerPane.add(slots[col]);
			}
			
			// Connect 4 grid
			gridLabel = new JLabel[rows][cols];
			for(int row = 0; row < gridLabel.length; row++) {
				for(int col = 0; col < gridLabel[row].length; col++) {
					gridLabel[row][col] = new JLabel("");
					gridLabel[row][col].setOpaque(true);
					gridLabel[row][col].setBackground(Color.WHITE);
					gridLabel[row][col].setBorder(BorderFactory.createLineBorder(Color.GRAY));
					gridLabel[row][col].setHorizontalAlignment(SwingConstants.CENTER);
					centerPane.add(gridLabel[row][col]);
				}
			}
		}
	}
	
	public void eastPanel(boolean east) {
		if(east) {
			rightPane = new JPanel();
			contentPane.add(rightPane, BorderLayout.EAST);
			rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.Y_AXIS));
			
			gridRightPane = new JPanel();
			gridRightPane.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
			rightPane.add(gridRightPane);
			gridRightPane.setLayout(new GridLayout(3, 2, 0, 0));
			
			name2 = new JLabel("Player 2:");
			name2.setHorizontalAlignment(SwingConstants.CENTER);
			gridRightPane.add(name2);
			
			name2Value = new JLabel(player2.getName());
			name2Value.setHorizontalAlignment(SwingConstants.CENTER);
			gridRightPane.add(name2Value);
			
			symbol2 = new JLabel("Symbol:");
			symbol2.setHorizontalAlignment(SwingConstants.CENTER);
			gridRightPane.add(symbol2);
			
			symbol2Value = new JLabel(player2.getSymbol());
			symbol2Value.setHorizontalAlignment(SwingConstants.CENTER);
			gridRightPane.add(symbol2Value);
			
			wins2 = new JLabel("Wins:");
			wins2.setHorizontalAlignment(SwingConstants.CENTER);
			gridRightPane.add(wins2);
			
			wins2Value = new JLabel("0");
			wins2Value.setHorizontalAlignment(SwingConstants.CENTER);
			gridRightPane.add(wins2Value);
			
			eastSeparator = new JSeparator();
			rightPane.add(eastSeparator);
		}
	}
	
	public void southPanel(boolean south) {
		if(south) {
			bottomPane = new JPanel();
			contentPane.add(bottomPane, BorderLayout.SOUTH);
			
			btmText = new JLabel();
			bottomPane.add(btmText);
		}
	}
	
	public void westPanel(boolean west) {
		if(west) {
			leftPane = new JPanel();
			contentPane.add(leftPane, BorderLayout.WEST);
			leftPane.setLayout(new BoxLayout(leftPane, BoxLayout.Y_AXIS));
			
			gridLeftPane = new JPanel();
			gridLeftPane.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
			leftPane.add(gridLeftPane);
			gridLeftPane.setLayout(new GridLayout(3, 2, 5, 0));
			
			name1 = new JLabel("Player 1:");
			name1.setHorizontalAlignment(SwingConstants.CENTER);
			gridLeftPane.add(name1);
			
			name1Value = new JLabel(player1.getName());
			name1Value.setHorizontalAlignment(SwingConstants.CENTER);
			gridLeftPane.add(name1Value);
			
			symbol1 = new JLabel("Symbol:");
			symbol1.setHorizontalAlignment(SwingConstants.CENTER);
			gridLeftPane.add(symbol1);
			
			symbol1Value = new JLabel(player1.getSymbol());
			symbol1Value.setHorizontalAlignment(SwingConstants.CENTER);
			gridLeftPane.add(symbol1Value);
			
			wins1 = new JLabel("Wins:");
			wins1.setHorizontalAlignment(SwingConstants.CENTER);
			gridLeftPane.add(wins1);
			
			wins1Value = new JLabel("0");
			wins1Value.setHorizontalAlignment(SwingConstants.CENTER);
			gridLeftPane.add(wins1Value);
			
			westSeparator = new JSeparator();
			leftPane.add(westSeparator);
		}
	}
	
	public boolean isWinnerInRow() {
		int rowMatchCount = 0;
		for(int row = 0; row < gridLabel.length; row++) {
			rowMatchCount = 0;
			for(int col = 0; col < gridLabel[row].length; col++) {
				if(gridLabel[row][col].getText().equals(currentPlayer.getSymbol())) {
					rowMatchCount++;
					if(rowMatchCount == 4)
						return true;
				}else rowMatchCount = 0;
			}
		}
		return false;
	}
	
	public boolean isWinnerInCol() {
		int colMatchCount = 0;
		for(int col = 0; col < cols; col++) {
			colMatchCount = 0;
			for(int row = 0; row < rows; row++) {
				if(gridLabel[row][col].getText().equals(currentPlayer.getSymbol())) {
					colMatchCount++;
					if(colMatchCount == 4)
						return true;
				}else colMatchCount = 0;
			}
		}
		return false;
	}
	
	@Override
	public void display(boolean menu, boolean center, boolean north, boolean south, 
			boolean east, boolean west) {		
		
		// Center Panel and Menu Panel
		centerPanel(center, menu);
		
		// North Panel
		northPanel(north);
		
		// West Panel
		westPanel(west);
		
		// East Panel
		eastPanel(east);
		
		// South Panel		
		southPanel(south);		
	}

	public void congratulation(Player currentPlayer) {
		try {
			String str = "";
			str+= player1.getName()+"\n"+
					player1.getNumWins()+"\n"+
					player1.getNumGames()+"\n\n"+
					player2.getName()+"\n"+
					player2.getNumWins()+"\n"+
					player2.getNumGames()+"\n\n"+
					currentPlayer.getName();
			appendToFile(source, str);			
		}catch (Exception e) {
			e.getMessage();
		}
		
		JOptionPane.showMessageDialog(null, "CONGRATULATION\nTHE WINNER IS " + 
										currentPlayer.getName());
		lstWinName.setText(currentPlayer.getName());
		champName.setText(updateChamp(readFile(source)));
		replayReq();
	}
	
	public String updateChamp(String[] fileContent) {
		return fileContent[fileContent.length-1];
	}
	
	@Override
	public void clearBoard() {
		for(int row = 0; row<gridLabel.length; row++) {
			for (int col = 0 ; col<gridLabel[row].length; col++) {
				gridLabel[row][col].setText("");
				gridLabel[row][col].setBackground(Color.WHITE);
				gridLabel[row][col].setEnabled(true);
				
			}
		}
		for (int i =0; i<slots.length; i++) {
			tracker[i] = 5;
			slots[i].setEnabled(true);
		}
	}
	
	
	public void replayReq() {
		String[] options = {"No", "Yes"};
		int n = JOptionPane.showOptionDialog(null, "Do you want to play again?", " ",
	            	JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null,
	            	options, options[1]);
		turn = 1;
		turnChange();
		 if(n==0)
			 System.exit(0);
		 else
			 clearBoard();
	 
	}

	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBoardFull() {
		for (int row = 0; row<gridLabel.length; row++) {
			for (int col = 0; col<gridLabel[row].length; col++) {
				String cellContent = gridLabel[row][col].getText();
				if(cellContent.isEmpty()) {
					return false;
				}
			}
		}
			return true;
	}

	@Override
	public boolean isWinner() {
		return (isWinnerInRow() || isWinnerInCol()) ? true : false;
	}

	@Override
	public void turnChange() {
		currentPlayer = currentPlayer.equals(player1) ? player2 : player1;	
	}
	
	@Override
	public void createNewFile(String fileName) {
		PrintWriter outStream = null;
		
		try {
			outStream = new PrintWriter(fileName);
			
		} catch (FileNotFoundException e) {
			System.err.println("Could not create the file "+fileName);
		}
		finally{
			if(outStream !=null){
				outStream.close();
			}
		}
	}

	@Override
	public void writeToNewFile(String fileName, String text) {
		PrintWriter outStream = null;
		try {
			outStream  = new PrintWriter(fileName);
			outStream.println(text);//print the line of text to the file
		} catch (FileNotFoundException e) {
			System.err.println("Could not write to the file "+fileName);
		}
		finally{
			if(outStream !=null){
				outStream.close();
			}
		}		
	}

	@Override
	public void appendToFile(String fileName, String text) {
		PrintWriter outStream = null;
		try {
			outStream = new PrintWriter(new FileOutputStream(fileName, true));
			outStream.println(text);//print the line of text to the file
		} catch (FileNotFoundException e) {
			System.err.println("Could not write to the file "+fileName);
		}
		finally{
			if(outStream !=null){
				outStream.close();
			}
		}
	}

	@Override
	public String[] readFile(String fileName) {
//		Scanner inStream = null;
		String[] fileContents = {""};
////		try {
//
//			File theFileObject = new File(fileName);
//			inStream = new Scanner(theFileObject);
//			for(int i = 0; inStream.hasNextLine(); i++){
//				if(inStream.hasNextLine())
//					fileContents[i] = inStream.nextLine();
//			}
//			
//		} catch (FileNotFoundException e) {
//			e.getMessage();
//		}
//		finally{
//			if(inStream !=null){
//				inStream.close();
//			}
//			System.out.println("All Done with file "+fileName);
//		}
		return fileContents;
	}

	@Override
	public void readFileDisplayOnConsole(String fileName) {
		Scanner inStream = null;
		try {

			File theFileObject = new File(fileName);
			inStream = new Scanner(theFileObject);
			while(inStream.hasNextLine()){
				System.out.println(inStream.nextLine());
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Probelm in readFileDisplayOnConsole " +  e.getMessage());
		}
		finally{
			if(inStream !=null){
				inStream.close();
			}
//			System.out.println("All Done with file "+fileName);
		}
		
	}

}
