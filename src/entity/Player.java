package entity;

import java.util.*;

import main.OurGame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import object.Item;
import object.Stats;

public class Player extends Mob {
    private int exp, level;

    public Player(Rectangle rectangle) {
    	super(OurGame.playerName, rectangle, OurGame.playerSprite, OurGame.playerStats, OurGame.playerInventory);
    	loadExp();
    	calcLevel();
	
    }
    public void loadExp(){
    	exp = OurGame.playerStats.getExp();
    }
    
    public void calcLevel(){
    	setLevel(exp / 10);
    }
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
    

}
