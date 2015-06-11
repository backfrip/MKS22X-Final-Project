package object;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Abstract parent for objects with a graphic representation in the game.
 */
public abstract class Entity {
    private Rectangle bounds;
    private String name;
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
	bounds = b;
	name = n;
	sprite = s;
    }

    public Rectangle getBounds() {
	return bounds;
    }

    public String getName() {
	return name;
    }
}
