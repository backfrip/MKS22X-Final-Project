package screen;

import java.util.LinkedList;

import object.Map;
import object.Quadtree;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import entity.Entity;
import entity.MovingEntity;
import entity.Player;
import main.*;

public class GameScreen implements Screen {
    private final float w, h;
    private Game game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Map map;
    private ShapeRenderer sr;
    private SpriteBatch batch;
    private Texture space, wall, templayer;
    private Matrix4 m;
    private Player player;
    private BitmapFont text;
    private String coords;
    private Quadtree collider;
    private LinkedList<Entity> entities, collisions;
    private LinkedList<MovingEntity> mobs;


    public GameScreen(Game gameRef) {
	game = gameRef;

	// Render setup
	camera = new OrthographicCamera();
	viewport = new ExtendViewport(320, 180, camera);
	sr = new ShapeRenderer(); // For debugging purposes
	batch = new SpriteBatch();
	m = camera.combined.cpy(); // Translation matrix
	text = new BitmapFont();

	// Map setup
	map = new Map("blankspace");
	space = new Texture(new FileHandle("resource/img/stile.png"));
	wall = new Texture(new FileHandle("resource/img/wtile.png"));
	templayer = new Texture(new FileHandle("resource/img/ptile.png"));
	w = space.getWidth();
	h = space.getHeight();
	collider = new Quadtree(0, new Rectangle(0, 0, map.length(),
		map.depth()));

	// Entity setup
	player = new Player(new Rectangle(map.getSpawn().x, map.getSpawn().y,
		1, 1));
	entities = new LinkedList<Entity>();
	mobs = new LinkedList<MovingEntity>();
	mobs.add(player);
	mobs.add(new Player(new Rectangle(4, 6, 1, 1)));
	mobs.add(new Player(new Rectangle(5, 3, 1, 1)));
	mobs.add(new Player(new Rectangle(4, 5, 1, 1)));
	mobs.add(new Player(new Rectangle(5, 5, 1, 1)));
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
	// Clear the screen
	Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	// Get player input
	getInput();

	// Move mobs
	moveEntities();

	// Check collisions
	checkCollisions();

	// Set up translation matrix
	camera.update();
	m = camera.combined.cpy();
	m.translate((w - 2) / -2.0f * (player.x() - player.y()) - 1, (h - 1)
		/ 2.0f * (player.x() + player.y() + 1) - 1, 0);

	// Draw map and entities
	batch.setProjectionMatrix(m);
	batch.begin();

	drawMap();
	drawPlayer();

	batch.end();

	// Draw text
	batch.getProjectionMatrix().setToOrtho2D(0, 0, Gdx.graphics.getWidth(),
		Gdx.graphics.getHeight());
	batch.begin();

	text.setColor(0.7f, 0.2f, 0.2f, 1);
	text.draw(batch, coords, 10, Gdx.graphics.getHeight() - 10);
	text.draw(batch,
		"Name: " + OurGame.playerName + " Max Health:"
			+ OurGame.playerStats.getMaxHealth() + " Max Energy:"
			+ OurGame.playerStats.getMaxEnergy() + " Attack:"
			+ OurGame.playerStats.getATK() + " Intelligence:"
			+ OurGame.playerStats.getINT() + " Dexterity:"
			+ OurGame.playerStats.getDEX() + " XP:"
			+ OurGame.playerStats.getExp(), 10, 20);

	batch.end();

	// Draw origin debug
	sr.setProjectionMatrix(camera.combined);
	sr.begin(ShapeType.Line);
	sr.setColor(0.2f, 0, 0.6f, 1);
	sr.circle(0, 0, 5, 40);
	sr.end();
    }

    private void moveEntities() {
	for (MovingEntity mob : mobs)
	    mob.move();
    }

    private void getInput() {
	if (Gdx.input.isKeyJustPressed(Keys.ESCAPE))
	    Gdx.app.exit();
	if (Gdx.input.isKeyJustPressed(Keys.F11))
	    fullScreen();
	if (Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.W)) {
	    player.prime();
	}
    }

    private void checkCollisions() {
	collider.clear();

	for (Entity ent : entities)
	    collider.insert(ent);

	for (Entity mob : mobs)
	    collider.insert(mob);

	collisions = new LinkedList<Entity>();
	for (MovingEntity mob : mobs) {
	    collisions.clear();
	    collider.retrieve(collisions, mob);

	    for (Entity other : collisions) {
		if (mob.getBounds().overlaps(other.getBounds()) && mob != other)
		    if (mob.getVelocity().angle() >= 0)
			if (mob.getVelocity().angle() >= 90)
			    if (mob.getVelocity().angle() >= 180)
				if (mob.getVelocity().angle() >= 270)
				    if (mob.x() + mob.width() - other.x() > other
					    .y() + other.height() - mob.y())
					mob.y(other.y() + other.height());
				    else
					mob.x(other.x() - mob.width());
				else if (other.x() + other.width() - mob.x() > other
					.y() + other.height() - mob.y())
				    mob.y(other.y() + other.height());
				else
				    mob.x(other.x() + other.width());
			    else if (other.x() + other.width() - mob.x() > mob
				    .y() + mob.height() - other.y())
				mob.y(other.y() - mob.height());
			    else
				mob.x(other.x() + other.width());
			else if (mob.x() + mob.width() - other.x() > mob.y()
				+ mob.height() - other.y())
			    mob.y(other.y() - mob.height());
			else
			    mob.x(other.x() - mob.width());
	    }
	}
    }

    private void fullScreen() {
	if (!Gdx.graphics.isFullscreen()) {
	    Gdx.graphics.setDisplayMode(
		    Gdx.graphics.getDesktopDisplayMode().width,
		    Gdx.graphics.getDesktopDisplayMode().height, true);
	} else {
	    Gdx.graphics.setDisplayMode(1280, 720, false);
	}
    }

    private void drawMap() {
	float c, s;
	for (int x = 0; x < map.length(); x++) {
	    for (int y = 0; y < map.depth(); y++) {
		c = (w - 2) / 2.0f * (x - y - 1);
		s = (h - 1) / -2.0f * (x + y + 2);
		if (map.getTile(x, y) == '#')
		    batch.draw(wall, c, s, w, h, 0, 0, (int) w, (int) h, false,
			    false);
		else
		    batch.draw(space, c, s, w, h, 0, 0, (int) w, (int) h,
			    false, false);
	    }
	}
    }

    private void drawPlayer() {
	Vector3 mouse = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
	camera.unproject(mouse);
	float c = mouse.x;
	float s = mouse.y;
	float x = (s / (1 - h)) + (c / (w - 2)) + player.x();
	float y = (s / (1 - h)) - (c / (w - 2)) + player.y();
	coords = player.x() + ", " + player.y();
	player.setDirection(x, y);
	player.getDirection();
	// batch.draw(templayer, (w - 2) / 2.0f
	// * (player.getX() - player.getY() - 1), (h - 1) / -2.0f
	// * (player.getX() + player.getY() + 2), w, h, 0, 0, (int) w,
	// (int) h, false, false);

	// draw entities
	for (Entity ent : entities) {
	    batch.draw(templayer, (w - 2) / 2.0f * (ent.x() - ent.y() - 1),
		    (h - 1) / -2.0f * (ent.x() + ent.y() + 2), w, h, 0, 0,
		    (int) w, (int) h, false, false);
	}
	for (Entity mob : mobs) {
	    batch.draw(templayer, (w - 2) / 2.0f * (mob.x() - mob.y() - 1),
		    (h - 1) / -2.0f * (mob.x() + mob.y() + 2), w, h, 0, 0,
		    (int) w, (int) h, false, false);
	}
    }

    @Override
    public void resize(int width, int height) {
	viewport.update(width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }


}
