package objects;
import java.util.*;

public class Player {
	private int exp;
	private double xcor, ycor;
	private final String name, type;
	private ArrayList<Integer> stats;
	//private Item heldItem;
	public Player(String name){
		this(name, "default");
	}
	public Player(String name, String type){
		exp = 0;
		xcor = 0;
		ycor = 0;
		this.name = name;
		this.type = type;
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
	public double getXcor(){
		return xcor;
	}
	public double getYcor(){
		return ycor;
	}
	public void moveXcor(double distance){
		xcor += distance;
	}
	public void moveYcor(double distance){
		ycor += distance;
	}
	public String getName(){
		return name;
	}
	public String getType(){
		return type;
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
	public int getAttack(){
		return stats.get(4);
	}
	public int getSpecial(){
		return stats.get(5);
	}
	public int getDexterity(){
		return stats.get(6);
	}
}
