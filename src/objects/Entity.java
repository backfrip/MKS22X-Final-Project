package objects;

/**
 * Abstract parent for objects with a graphic representation in the game.
 */
public abstract class Entity {
    private double xcor, ycor;
    private String name;

    public Entity() {

    }


    // Mutators
    public double getX() {
	return xcor;
    }

    public double getY() {
	return ycor;
    }

    public void moveX(double distance) {
	xcor += distance;
    }

    public void moveY(double distance) {
	ycor += distance;
    }

    public void setX(double distance) {
	xcor = distance;
    }

    public void setY(double distance) {
	ycor = distance;
    }

    public String getName() {
	return name;
    }
}
