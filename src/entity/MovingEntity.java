package entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class MovingEntity extends Entity {
    private Vector2 direction, velocity;
    private boolean primed;

    public MovingEntity(String n, Rectangle b, Sprite s) {
	this(n, b, s, new Vector2(0, 1), 0.05f);
    }

    public MovingEntity(String n, Rectangle b, Sprite s, Vector2 d, float v) {
	super(n, b, s);
	direction = d;
	velocity = new Vector2(v, 0);
	primed = false;
    }

    public Vector2 getDirection() {
	return direction.cpy();
    }

    public Vector2 getVelocity() {
	return velocity.cpy();
    }

    public void setDirection(float targetX, float targetY) {
	direction.set(targetX - x(), targetY - y());
	direction.setLength2(1);
    }

    public void prime() {
	velocity.setAngle(direction.angle());
	primed = true;
    }

    public void move() {
	if (primed) {
	    x(x() + velocity.x);
	    y(y() + velocity.y);
	    primed = false;
	}
    }

}
