package entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Abstract parent for objects with a graphic representation in the game.
 */
public abstract class Entity {
    private String name;
    private Rectangle bounds;
    private Sprite sprite;

    /**
     * Creates a new Entity.
     * 
     * @param n
     *            The name of the Entity.
     * @param b
     *            The location and dimensions of the Entity.
     * @param s
     *            The sprite that represents this Entity.
     */
    public Entity(String n, Rectangle b, Sprite s) {
	name = n;
	bounds = b;
	sprite = s;
    }

    public void setName(String n) {
	name = n;
    }

    public String getName() {
	return name;
    }

    public Rectangle getBounds() {
	return new Rectangle(bounds);
    }

    public float x() {
	return bounds.x;
    }

    public void x(float x) {
	bounds.x = x;
    }

    public float y() {
	return bounds.y;
    }

    public void y(float y) {
	bounds.y = y;
    }

    public float width() {
	return bounds.width;
    }

    public float height() {
	return bounds.height;
    }

    public Sprite getSprite() {
	return new Sprite(sprite);
    }

}
