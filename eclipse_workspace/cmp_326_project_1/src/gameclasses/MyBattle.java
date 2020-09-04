package gameclasses;

import java.util.Scanner;

import gameinterfaces.Battle;
import gameinterfaces.Monster;
import gameinterfaces.Player;

public class MyBattle implements Battle{
	
	Scanner cin = new Scanner(System.in);
	
	private Player player;
	private Monster monster;
	
	public MyBattle(Player player, Monster monster) {
		this.player = player;
		this.monster = monster;
	}
	
	@Override
	public void run() {
		MyPlayer player = (MyPlayer) this.player;
		MyMonster monster = (MyMonster) this.monster;
		
		char key=0;
		
		while(true) {
			//Player turn
			MyCreature.sop(player.getName() + ": " + player.getHitPoints() + " HP");
			MyCreature.sop(monster.getName() + ": " + monster.getHitPoints()+ " HP");
			
			// Choose to [A] attack or [H] heal
			
			do {
				MyCreature.sop("Press key:\n[A] -> Attack\n[H] -> Heal\n");
				key = cin.next().toUpperCase().charAt(0);
				if(key != 'A' && key != 'H')
					MyCreature.sop("Invalid key. Try again");
			}while(key != 'A' && key != 'H');
			
			switch(key) {	//Player choose whether to attack or heal
			case 'A':
				player.attack(monster);
				monster.takeDamage(player.getDamage());
				break;
			case 'H':
				player.heal();
				break;
			}
			
			if(!monster.isAlive()) break; //If monster is dead get out of loop
			
			//Monster turn			
			if(monster.canEnrage()) //Auto rage if hp < threshold 
				monster.enrage();
			monster.attack(player);
			player.takeDamage(monster.getDamage());
			
			if(!player.isAlive()) break; //If player is dead get out of loop
		}
	}
}
