package object;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;

public class Quadtree {
    private final int MAX_OBJECTS = 10;
    private final int MAX_LEVELS = 5;

    private int level;
    private ArrayList<Entity> entities;
    private Rectangle bounds;
    private Quadtree[] nodes;

    public Quadtree(int pLevel, Map map) {
	level = pLevel;
	entities = new ArrayList<Entity>();
	bounds = new Rectangle(0, 0, map.length(), map.depth());
	nodes = new Quadtree[4];
    }
}
