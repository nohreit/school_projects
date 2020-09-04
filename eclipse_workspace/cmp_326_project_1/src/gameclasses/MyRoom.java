package gameclasses;

import gameinterfaces.Creature;
import gameinterfaces.Monster;
import gameinterfaces.Player;
import gameinterfaces.Room;

public class MyRoom implements Room{
	
	private int roomIndex;
	private String description;
	protected Monster monster;

	public MyRoom(int roomIndex, String description, Monster monster) {
		this.roomIndex = roomIndex;
		this.description = description;
		this.monster = monster;
	}

	@Override
	public boolean isComplete() {
		return !monster.isAlive() ? true : false;
	}

	@Override
	public void enter(Player player) {
		MyPlayer p = (MyPlayer) player;
		MyCreature.sop(p.getName() + "\nThis Room is " + this.description+", and has...\n" + this.monster);		
	}
	
	@Override
	public String toString() {
		MyMonster m = (MyMonster) monster;
		return String.format("Room index: %2d, Description: %20s, Monster name: %20s", 
				this.roomIndex, this.description, m.getName());
	}

	@Override
	public void heal() {
		
	}

	@Override
	public void attack(Creature creature) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void takeDamage(int damage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}		

}
