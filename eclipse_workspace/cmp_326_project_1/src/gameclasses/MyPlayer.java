package gameclasses;

import gameinterfaces.Creature;
import gameinterfaces.Player;

public class MyPlayer extends MyCreature implements Player{
	
	private int healAmount;

	public MyPlayer(String name, String description, int hitPoints, int damage, int healAmount) {
		super(name, description, hitPoints, damage);
		this.healAmount = healAmount;
	}

	@Override
	public void attack(Creature creature) {
		super.attack(creature);		
	}

	@Override
	public void takeDamage(int damage) {
		super.takeDamage(damage);	
	}

	@Override
	public boolean isAlive() {
		return super.isAlive();
	}

	@Override
	public void heal() {
		this.setHitPoints(this.getHitPoints() + this.healAmount);
		sop(this.getName() + " is healed by " + this.healAmount + " HP");
	}

}
