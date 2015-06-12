package object;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class MovingEntity extends Entity {
    private Vector2 direction;

    public MovingEntity(String n, Rectangle b, Sprite sp) {
	super(n, b, sp);
    }

}
