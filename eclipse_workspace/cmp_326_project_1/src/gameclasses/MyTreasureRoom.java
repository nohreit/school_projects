package gameclasses;

import gameinterfaces.Monster;
import gameinterfaces.Player;
import gameinterfaces.TreasureRoom;

public class MyTreasureRoom extends MyRoom implements TreasureRoom{
	
	private String treasure;
	
	public MyTreasureRoom(int roomIndex, String description, Monster monster, String treasure) {
		super(roomIndex, description, monster);
		this.treasure = treasure;
	}

	@Override
	public void enter(Player player) {
		if(!this.isComplete()) {
			super.enter(player); //If monster.isAlive == true;
			// Battle run
		}
		
		if(this.isComplete()) {
			MyCreature.sop("You explored the room and found the hidden treasure!\n\t\t*" + this.treasure.toUpperCase() + "*");
		}
	}
	
}
