package gameclasses;

import gameinterfaces.Creature;
import gameinterfaces.Room;

public class MyCreature implements Creature{

	//Attributes
	
	private String name;
	private String description;
	private int hitPoints;
	private int damage;
	private Room room;
	
	
	//Constructor
	public MyCreature (String name, String description, int hitPoints, int damage) {
		this.name = name;
		this.description = description;
		this.hitPoints = hitPoints < 0 ? 0 : hitPoints;
		this.damage = damage;
		this.room = null;
	}
	
	//Getters and Setters
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getHitPoints() {
		return hitPoints;
	}
	
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints < 0 ? 0 : hitPoints;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	//Actions
	
	@Override
	public void attack(Creature creature) {
		MyCreature c = (MyCreature) creature;
		sop(this.getName() + " attacks " + c.getName() + ", dealing " + this.getDamage() + " damage(s)");
	}

	@Override
	public void takeDamage(int damage) {
		this.setHitPoints(this.getHitPoints()-damage);
		if(this.getHitPoints() < 0) this.setHitPoints(0);		
	}

	@Override
	public boolean isAlive() {
		return this.getHitPoints() > 0 ? true : false ;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %15s, Description: %20s, HitPoints: %03d, Damage(s): %02d", 
				this.getName(), this.getDescription(), this.getHitPoints(), this.getDamage());
	}
	
	//The following method is because I am too lazy to type System.out.println() (>w<)
	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
