package objects;
import java.util.*;

public class Player {
	private int exp;
	private double xcor, ycor;
	private final String name, type;
	private ArrayList<Integer> stats;
	public Player(String name){
		this(name, "default");
	}
	public Player(String name, String type){
		exp = 0;
		xcor = 0;
		ycor = 0;
		this.name = name;
		this.type = type;
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
	
}
