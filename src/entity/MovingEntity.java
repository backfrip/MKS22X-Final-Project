package entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class MovingEntity extends Entity {
    private Vector2 direction;
    public float velocity;

    public MovingEntity(String n, Rectangle b, Sprite s) {
	this(n, b, s, new Vector2(0, 1), 0);
    }

    public MovingEntity(String n, Rectangle b, Sprite s, Vector2 d, float v) {
	super(n, b, s);
	direction = new Vector2(0, 1);
	velocity = 0;
    }

    public Vector2 getDirection() {
	return direction.cpy();
    }

    public void setDirection(float targetX, float targetY) {
	direction = new Vector2(getBounds().x, getBounds().y);
    }

}
