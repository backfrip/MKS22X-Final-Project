package object;

public abstract class MovingEntity extends Entity {
    int hp, level;
    
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

    
}
