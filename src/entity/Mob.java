package entity;

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
	stats = st;
	inventory = i;
    }

    public int getHealth() {
	return health;
    }

    public int getEnergy() {
	return energy;
    }

}
