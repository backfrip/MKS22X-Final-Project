package object;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;

public class Quadtree {
    private final int MAX_OBJECTS = 10;
    private final int MAX_LEVELS = 25;

    private int level;
    private ArrayList<Rectangle> entities;
    private Rectangle bounds;
    private Quadtree[] nodes;

    public Quadtree(int pLevel, Rectangle rect) {
	level = pLevel;
	entities = new ArrayList<Rectangle>();
	bounds = rect;
	nodes = new Quadtree[4];
    }

    public void clear() {
	entities.clear();

	for (int i = 0; i < nodes.length; i++) {
	    if (nodes[i] != null) {
		nodes[i].clear();
		nodes[i] = null;
	    }
	}
    }

    private void split() {
	int subWidth = (int) (bounds.getWidth() / 2);
	int subHeight = (int) (bounds.getWidth() / 2);
	int x = (int) bounds.getX();
	int y = (int) bounds.getY();

	nodes[0] = new Quadtree(level + 1, new Rectangle(x + subWidth, y,
		subWidth, subHeight));
	nodes[1] = new Quadtree(level + 1, new Rectangle(x, y, subWidth,
		subHeight));
	nodes[2] = new Quadtree(level + 1, new Rectangle(x, y + subHeight,
		subWidth, subHeight));
	nodes[3] = new Quadtree(level + 1, new Rectangle(x + subWidth, y
		+ subHeight, subWidth, subHeight));
    }

    private int getIndex(Rectangle pRect) {
	int index = -1;
	double verticalMidpoint = bounds.getX() + (bounds.getWidth() / 2);
	double horizontalMidpoint = bounds.getY() + (bounds.getHeight() / 2);

	// Object can completely fit within the top quadrants
	boolean topQuadrant = (pRect.getY() < horizontalMidpoint && pRect
		.getY() + pRect.getHeight() < horizontalMidpoint);
	// Object can completely fit within the bottom quadrants
	boolean bottomQuadrant = (pRect.getY() > horizontalMidpoint);

	// Object can completely fit within the left quadrants
	if (pRect.getX() < verticalMidpoint
		&& pRect.getX() + pRect.getWidth() < verticalMidpoint) {
	    if (topQuadrant) {
		index = 1;
	    } else if (bottomQuadrant) {
		index = 2;
	    }
	}

	// Object can completely fit within the right quadrants
	else if (pRect.getX() > verticalMidpoint) {
	    if (topQuadrant) {
		index = 0;
	    } else if (bottomQuadrant) {
		index = 3;
	    }
	}

	return index;
    }

    public void insert(Rectangle pRect) {
	if (nodes[0] != null) {
	    int index = getIndex(pRect);

	    if (index != -1) {
		nodes[index].insert(pRect);

		return;
	    }
	}

	entities.add(pRect);

	if (entities.size() > MAX_OBJECTS && level < MAX_LEVELS) {
	    if (nodes[0] == null) {
		split();
	    }

	    int i = 0;
	    while (i < entities.size()) {
		int index = getIndex(entities.get(i));
		if (index != -1) {
		    nodes[index].insert(entities.remove(i));
		} else {
		    i++;
		}
	    }
	}
    }

    public ArrayList retrieve(ArrayList returnObjects, Rectangle pRect) {
	int index = getIndex(pRect);
	if (index != -1 && nodes[0] != null) {
	    nodes[index].retrieve(returnObjects, pRect);
	}

	returnObjects.addAll(entities);

	return returnObjects;
    }
}
