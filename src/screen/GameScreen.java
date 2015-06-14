package screen;

import object.Map;

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
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

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
    private BitmapFont test;
    private FreeTypeFontGenerator gen;
    private FreeTypeFontParameter par;
    

    public GameScreen(Game gameRef) {
	game = gameRef;

	// Render setup
	camera = new OrthographicCamera();
	viewport = new ExtendViewport(320, 180, camera);
	sr = new ShapeRenderer(); // For debugging purposes
	batch = new SpriteBatch();
	m = camera.combined.cpy(); // Translation matrix
	text = new BitmapFont();
	test = new BitmapFont();
	// Map setup
	map = new Map("blankspace");
	space = new Texture(new FileHandle("resource/img/stile.png"));
	wall = new Texture(new FileHandle("resource/img/wtile.png"));
	templayer = new Texture(new FileHandle("resource/img/ptile.png"));
	w = space.getWidth();
	h = space.getHeight();

	// Entity setup
	player = new Player(new Rectangle(map.getSpawn().x, map.getSpawn().y,
		1, 1));
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
	Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


	getInput();


	camera.update();
	m = camera.combined.cpy();
	m.translate((w - 2) / -2.0f * (player.getX() - player.getY()) - 1,
		(h - 1) / 2.0f * (player.getX() + player.getY() + 1) - 1, 0);


	batch.setProjectionMatrix(m);
	batch.begin();

	drawMap();
	drawPlayer();

	batch.end();
	batch.getProjectionMatrix().setToOrtho2D(0, 0, Gdx.graphics.getWidth(),
		Gdx.graphics.getHeight());
	batch.begin();

	text.setColor(0.7f, 0.2f, 0.2f, 1);
	text.draw(batch, coords, 10, Gdx.graphics.getHeight() - 10);
	test.setColor(0.7f, 0.2f, 0.2f, 1);
	test.draw(batch, "Name: " + OurGame.playerName + " Max Health:" + OurGame.playerStats.getMaxHealth()
			+ " Max Energy:" + OurGame.playerStats.getMaxEnergy() + " Attack:" + OurGame.playerStats.getATK()
			+ " Intelligence:" + OurGame.playerStats.getINT() + " Dexterity:" + OurGame.playerStats.getDEX()
			+ " XP:" + OurGame.playerStats.getExp(), 10, 10);
	
	batch.end();


	sr.setProjectionMatrix(camera.combined);
	sr.begin(ShapeType.Line);
	sr.setColor(0.2f, 0, 0.6f, 1);
	sr.circle(0, 0, 5, 40);
	sr.end();
    }

    private void getInput() {
	if (Gdx.input.isKeyJustPressed(Keys.ESCAPE))
	    Gdx.app.exit();
	if (Gdx.input.isKeyJustPressed(Keys.F11))
	    fullScreen();
	if (Gdx.input.isKeyPressed(Keys.UP)) {
	    player.setX(player.getX() + player.getDirection().x / 10);
	    player.setY(player.getY() + player.getDirection().y / 10);
	}
	if (Gdx.input.isKeyPressed(Keys.DOWN)) {
	    player.setX(4);
	    player.setY(5);
	}
    }

    private void fullScreen() {
	if (!Gdx.graphics.isFullscreen()) {
	    Gdx.graphics.setDisplayMode(
		    Gdx.graphics.getDesktopDisplayMode().width,
		    Gdx.graphics.getDesktopDisplayMode().height, true);
	    Gdx.input.setCursorCatched(true);
	} else {
	    Gdx.graphics.setDisplayMode(1280, 720, false);
	    Gdx.input.setCursorCatched(false);
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
	if (map.getTile(player.getX(), player.getY()) == '#')
	    System.out.println("Colliding!" + Math.random());
	Vector3 mouse = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
	camera.unproject(mouse);
	float c = mouse.x;
	float s = mouse.y;
	float x = (s / (1 - h)) + (c / (w - 2)) + player.getX();
	float y = (s / (1 - h)) - (c / (w - 2)) + player.getY();
	coords = player.getX() + ", " + player.getY();
	player.setDirection(x, y);
	player.getDirection();
	batch.draw(templayer, (w - 2) / 2.0f
		* (player.getX() - player.getY() - 1), (h - 1) / -2.0f
		* (player.getX() + player.getY() + 2), w, h, 0, 0, (int) w,
		(int) h, false, false);
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
