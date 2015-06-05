package object;
import java.util.*;

public class Player extends MovingEntity{
	private int exp;
	
	//private Item heldItem;
	public Player(String name){
		this(name, "default");
	}
	public Player(String name, String type){
		exp = 0;
		stats = new ArrayList<Integer>(10);
		setBaseStats();
	}
	public int getLevel(){
		//Calculation to get level
		return 0;
	}
	public void addExp(int increment){
		exp += increment; 
	}
	
	public void setBaseStats(){
		//Will be determined by Player type but putting a default for now
		stats.set(0, 10); //Max HP
		stats.set(1, 10); //Current HP
		stats.set(2, 10); //Max Source of power
		stats.set(3, 10); //Source of power (ie Mana for Mages)
		stats.set(4, 10); //Attack
		stats.set(5, 10); //Special
		stats.set(6, 10); //Dexterity
		stats.set(7, 10); //Miscellaneous stat 
	}
	public int getHP(){
		return stats.get(0);
	}
	public void changeHP(int change){
		if (stats.get(1) + change > stats.get(0)){
			stats.set(1, stats.get(0));
		}
		else if (stats.get(1) + change < 0){
			stats.set(1, 0);
		}
		else {
			stats.set(1, stats.get(1) + change);
		}
	}
	public void changeEnergy(int change){
		if (stats.get(3) + change > stats.get(2)){
			stats.set(3, stats.get(2));
		}
		else if (stats.get(3) + change < 0){
			stats.set(3, 0);
		}
		else {
			stats.set(3, stats.get(3) + change);
		}
	}
	
}
