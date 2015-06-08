package object;

/**
 * Abstract parent for objects with a graphic representation in the game.
 */
public abstract class Entity {
    private float xcor, ycor;
    private String name;

    // Mutators
    public float getX() {
	return xcor;
    }

    public float getY() {
	return ycor;
    }

    public void setX(float distance) {
	xcor = distance;
    }

    public void setY(float distance) {
	ycor = distance;
    }

    public String getName() {
	return name;
    }
}
