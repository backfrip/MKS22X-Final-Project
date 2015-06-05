package object;

import java.util.ArrayList;

public abstract class MovingEntity extends Entity {
    private int hp, level;
    private ArrayList<Integer> stats;
    //accessors
    public int getHP(){
    	return hp;
    }
    
    public int getLevel(){
    	return level;
    }
    
    //mutators
    public void setHP(int hp){
    	this.hp = hp;
    }
    
    public void setLevel(int level){
    	this.level = level;
    }
    
    //movement
    public void moveX(double distance) {
    	setX(getX() + distance);
    }

    public void moveY(double distance) {
    	setY(getY() + distance);
    }

    //stats
    public abstract void setStats();
    
    public int getMaxHP(){
		return stats.get(1);
	}
	
    public int getMaxEnergy(){
		return stats.get(2);
	}
    
    public int getAttack(){
		return stats.get(3);
	}
    
	public int getSpecial(){
		return stats.get(4);
	}
	
	public int getDexterity(){
		return stats.get(5);
	}
}
