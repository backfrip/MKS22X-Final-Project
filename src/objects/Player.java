package objects;
import java.util.*;

public class Player {
	private int exp;
	private double xcor, ycor;
	private String name, type;
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
}
