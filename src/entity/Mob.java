package entity;

import main.OurGame;
import object.Inventory;
import object.Stats;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Mob extends MovingEntity {
    private int health, energy;
    private Stats stats;
    private Inventory inventory;

    public Mob(String n, Rectangle b, Sprite sp, Stats st, Inventory i) {
	super(n, b, sp);
	inventory = i;
	OurGame.playerStats.loadStats(OurGame.playerName);
    }

    public int getHealth() {
	return health;
    }

    public int getEnergy() {
	return energy;
    }

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stat){
		setStats(OurGame.playerName, stat.getMaxHealth(), stat.getMaxEnergy(), stat.getATK(), stat.getINT(), stat.getDEX(), stat.getExp());
	}
	
	public void setStats(String name, int maxHealth, int maxEnergy, int ATK, int INT, int DEX, int Exp) {
		stats.setMaxHealth(maxHealth);
		stats.setMaxEnergy(maxEnergy);
		stats.setATK(ATK);
		stats.setINT(INT);
		stats.setDEX(DEX);
		stats.setExp(Exp);
		
	}
}
