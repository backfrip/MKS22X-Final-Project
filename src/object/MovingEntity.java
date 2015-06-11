package object;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public abstract class MovingEntity extends Entity {
    private int health, energy;
    private float direction;
    private Stats stats;

    public MovingEntity(String n, Rectangle b, Sprite sp, Stats st) {
	super(n, b, sp);
	stats = st;
    }

    public int getHealth() {
	return health;
    }

    public void setHealth(int health) {
	this.health = health;
    }

    public int getEnergy() {
	return energy;
    }

    public void setEnergy(int energy) {
	this.energy = energy;
    }
}
