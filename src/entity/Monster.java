package entity;

import java.util.*;

import object.Inventory;
import object.Stats;
import main.OurGame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;


public class Monster extends Mob {
	private int level;
	private Stats stats;
    private Inventory inventory;
    public Monster(String n, Rectangle b, Sprite s) {
	super(n, b, s);
	calcLevel();
	setStats();
	// TODO Auto-generated constructor stub
    }
    public void calcLevel(){
    	int playerLevel =OurGame.playerStats.getExp() / 10;
    	Random rand = new Random();
    	int min = rand.nextInt(5);
    	level = playerLevel - min;
    }
    
    public void setStats(){
    	super.setStats(super.getStats().getMaxHealth() + 2 * level, super.getStats().getMaxEnergy() + 2 * level, 
    			super.getStats().getATK() + 2 * level, super.getStats().getINT() + 2 * level, 
    					super.getStats().getDEX() + 2 * level, super.getStats().getExp() + 2 * level);
    }
    
}
