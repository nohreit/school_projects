package gameclasses;

import gameinterfaces.Creature;
import gameinterfaces.Monster;

public class MyMonster extends MyCreature implements Monster{
	
	private boolean isEnraged;
	private int enrageThreshold;

	public MyMonster(String name, String description, int hitPoints, int damage, int enrageThreshold) {
		super(name, description, hitPoints, damage);
		this.enrageThreshold = enrageThreshold;
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
	public void enrage() {
		this.isEnraged = this.canEnrage();
		if(this.isEnraged) {
			this.setDamage(this.getDamage()*2);
			sop(this.getName() + " has been enraged");
		}		
	}

	@Override
	public boolean canEnrage() {
		return this.getHitPoints() < this.enrageThreshold ? true : false;
	}

}
