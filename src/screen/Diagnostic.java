package screen;

import object.Map;
import main.OurGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Diagnostic implements Screen {
    private final String[] filenames = { "blankspace", "test", "test2", "test3" };

    private OurGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer sr;
    private Map map;
    private float pX, pY;
    private BitmapFont text;
    private SpriteBatch batch;
    private int sel;

    public Diagnostic(OurGame gameRef, int s) {
	sel = s;
	game = gameRef;
	camera = new OrthographicCamera();
	viewport = new ExtendViewport(80, 45, camera);
	sr = new ShapeRenderer();
	map = new Map(filenames[sel]);
	pX = map.getSpawn().x;
	pY = map.getSpawn().y;
	batch = new SpriteBatch();
	text = new BitmapFont();
    }

    public Diagnostic(OurGame gameRef) {
	this(gameRef, 0);
    }

    @Override
    public void render(float delta) {
	Gdx.gl.glClearColor(1, 1, 1, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	if (Gdx.input.isKeyJustPressed(Keys.ESCAPE))
	    Gdx.app.exit();
	if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
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
	if (Gdx.input.isKeyJustPressed(Keys.R))
	    game.setScreen(new Diagnostic(game));
	if (Gdx.input.isKeyJustPressed(Keys.M)) {
	    sel = (sel + 1) % 4;
	    game.setScreen(new Diagnostic(game, sel));
	}

	camera.update();

	batch.begin();
	text.setColor(0.7f, 0.2f, 0.2f, 1);
	text.draw(batch, "resource/map/" + filenames[sel] + ".omap", 10,
		viewport.getScreenHeight() - 10);
	text.draw(batch, "" + Gdx.graphics.getFramesPerSecond() + " FPS", 10,
		viewport.getScreenHeight() - 25);
	text.draw(batch, "player-X = " + pX, 10,
		viewport.getScreenHeight() - 40);
	text.draw(batch, "player-Y = " + pY, 10,
		viewport.getScreenHeight() - 55);
	text.draw(batch, "Press ESC to exit   Press M to toggle maps", 10, 40);
	text.draw(
		batch,
		"Press SPACE to toggle fullscreen   Move with the arrow keys   Press R to reset",
		10, 25);
	batch.end();

	sr.setProjectionMatrix(camera.combined);
	sr.begin(ShapeType.Line);
	sr.setColor(0, 0.1f, 0.5f, 1);
	sr.rect(-1, -1, 2, 2);
	sr.setColor(0.7f, 0, 0, 1);
	sr.circle(0, 0, 0.3f, 10);
	sr.setColor(0.9f, 0, 0, 1);

	movePlayer();

	char tile;
	for (int x = 0; x < map.length(); x++) {
	    for (int y = 0; y < map.depth(); y++) {
		tile = map.getTile(x, y);
		if (tile == '#')
		    sr.rect((x - pX) * 2 - 1, (y - pY) * -2 - 1, 2, 2);
		if (tile == 's')
		    sr.circle((x - pX) * 2, (y - pY) * -2, 1, 10);
	    }
	}

	sr.end();

	if (Gdx.input.isKeyJustPressed(Keys.NUM_1))
	    game.setScreen(new DiagnosticII(game));
    }

    private void movePlayer() { // Up/down movement reversed for reasons
	if (Gdx.input.isKeyPressed(Keys.UP)) { // Actually translates DOWN
	    if (map.getTile(pX + 0.01f, pY - 0.01f) != '#'
		    && map.getTile(pX + 0.99f, pY - 0.01f) != '#')
		pY -= 0.1f;
	}
	if (Gdx.input.isKeyPressed(Keys.DOWN)) {// Actually translates UP
	    if (map.getTile(pX + 0.01f, pY + 1.01f) != '#'
		    && map.getTile(pX + 0.99f, pY + 1.01f) != '#')
		pY += 0.1f;
	}
	if (Gdx.input.isKeyPressed(Keys.LEFT)) {
	    if (map.getTile(pX - 0.01f, pY + 0.01f) != '#'
		    && map.getTile(pX - 0.01f, pY + 0.99f) != '#')
		pX -= 0.1f;
	}
	if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
	    if (map.getTile(pX + 1.01f, pY + 0.01f) != '#'
		    && map.getTile(pX + 1.01f, pY + 0.99f) != '#')
		pX += 0.1f;
	}
    }

    @Override
    public void show() {
	// TODO Auto-generated method stub

    }

    @Override
    public void resize(int width, int height) {
	viewport.update(width, height);
	batch = new SpriteBatch();
    }

    @Override
    public void pause() {
	// TODO Auto-generated method stub

    }

    @Override
    public void resume() {
	// TODO Auto-generated method stub

    }

    @Override
    public void hide() {
	// TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
	game.dispose();
	sr.dispose();
	batch.dispose();
	text.dispose();
    }

}
