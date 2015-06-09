package screen;

import object.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import main.OurGame;

public class DiagnosticII implements Screen {
    private OurGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer sr;
    private Map map;
    private float px, py, w, h;
    private BitmapFont text;
    private SpriteBatch batch;
    private SpriteCache cache;
    private int cid;
    private Texture space, wall;
    private Matrix4 m;

    public DiagnosticII(OurGame gameRef) {
	game = gameRef;
	camera = new OrthographicCamera();
	viewport = new ExtendViewport(320, 180, camera);
	sr = new ShapeRenderer();
	map = new Map("blankspace");
	px = map.getSpawn().x;
	py = map.getSpawn().y;
	batch = new SpriteBatch();
	cache = new SpriteCache();
	text = new BitmapFont();
	space = new Texture(new FileHandle("resource/img/stile.png"));
	wall = new Texture(new FileHandle("resource/img/wtile.png"));
	w = space.getWidth();
	h = space.getHeight();
	m = camera.combined.cpy();
	m.translate(-1, -1, 0);
	// loadMap();
    }

    private void loadMap() {
	w = space.getWidth();
	h = space.getHeight();
	cache.beginCache();
	/*
	 * for (int x = 0; x < 5; x++) { for (int y = 0; y < 5; y++) {
	 * cache.add(space, (w - 2) / 2.0f * (x - y - 1), (h - 1) / -2.0f (x + y
	 * + 2), w, h, 0, 0, space.getWidth(), space.getHeight(), false, false);
	 * } }
	 */
	for (int x = 0; x < map.length(); x++) {
	    for (int y = 0; y < map.depth(); y++) {
		if (map.getTile(x, y) == '#')
		    cache.add(wall, (w - 2) / 2.0f * (x - y - 1), (h - 1)
			    / -2.0f * (x + y + 2), w, h, 0, 0,
			    space.getWidth(), space.getHeight(), false, false);
		else
		    cache.add(space, (w - 2) / 2.0f * (x - y - 1), (h - 1)
			    / -2.0f * (x + y + 2), w, h, 0, 0,
			    space.getWidth(), space.getHeight(), false, false);
	    }
	}
	cid = cache.endCache();
    }

    @Override
    public void render(float delta) {
	Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	if (Gdx.input.isKeyJustPressed(Keys.ESCAPE))
	    Gdx.app.exit();

	m = camera.combined.cpy();
	m.translate((w - 2) / 2.0f * (px - py) - 1, (h - 1) / 2.0f * (px + py)
		- 1, 0);

	camera.update();

	/*
	 * cache.setProjectionMatrix(m); cache.begin();
	 * Gdx.gl.glEnable(GL20.GL_BLEND); Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA,
	 * GL20.GL_ONE_MINUS_SRC_ALPHA); cache.draw(cid); cache.end();
	 */

	batch.setProjectionMatrix(m);
	batch.begin();
	for (int x = 0; x < map.length(); x++) {
	    for (int y = 0; y < map.depth(); y++) {
		if (map.getTile(x, y) == '#')
		    batch.draw(wall, (w - 2) / 2.0f * (x - y - 1), (h - 1)
			    / -2.0f * (x + y + 2), w, h, 0, 0,
			    space.getWidth(), space.getHeight(), false, false);
		else
		    batch.draw(space, (w - 2) / 2.0f * (x - y - 1), (h - 1)
			    / -2.0f * (x + y + 2), w, h, 0, 0,
			    space.getWidth(), space.getHeight(), false, false);
	    }
	}
	batch.end();

	sr.setProjectionMatrix(camera.combined);
	sr.begin(ShapeType.Line);
	sr.setColor(0.2f, 0, 0.6f, 1);
	sr.circle(0, 0, 5f, 40);
	sr.end();

	movePlayer();

	if (Gdx.input.isKeyPressed(Keys.NUM_1))
	    game.setScreen(new Diagnostic(game));
    }

    private void movePlayer() { // Up/down movement reversed for reasons
	if (Gdx.input.isKeyPressed(Keys.UP)) { // Actually translates DOWN
	    px -= 0.1f;
	}
	if (Gdx.input.isKeyPressed(Keys.DOWN)) {// Actually translates UP

	    px += 0.1f;
	}
	if (Gdx.input.isKeyPressed(Keys.LEFT)) {

	    py -= 0.1f;
	}
	if (Gdx.input.isKeyPressed(Keys.RIGHT)) {

	    py += 0.1f;
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
	cache.dispose();
	text.dispose();
	space.dispose();
	wall.dispose();
    }

}
