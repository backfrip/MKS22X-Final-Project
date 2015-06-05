package object;

import java.util.*;

public abstract class NonMovingEntity extends Entity {
	private boolean held = false;
	private boolean used = false;
	private ArrayList<Integer> boost = new ArrayList<Integer>();
	
	public abstract void setBoost();
	
	public void changeStatus(){
		held = !held;
	}
	
	public void use(){
		used = true;
	}
	
	public ArrayList<Integer> getBoost(){
		return boost;
	}
	
	public abstract void giveBoost();
	
	
}
