package entity;

import object.Stats;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Mob extends MovingEntity {
    private int health, energy;
    private Stats stats;

    public Mob(String n, Rectangle b, Sprite sp, Stats st) {
	super(n, b, sp);
	stats = st;
    }

}
