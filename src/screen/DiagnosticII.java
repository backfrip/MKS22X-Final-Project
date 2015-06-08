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
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import main.OurGame;

public class DiagnosticII implements Screen {
    private OurGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer sr;
    private Map map;
    private float px, py;
    private BitmapFont text;
    private SpriteBatch batch;
    private SpriteCache cache;
    private int cid;
    private Texture space, wall;

    public DiagnosticII(OurGame gameRef) {
	game = gameRef;
	camera = new OrthographicCamera();
	viewport = new ExtendViewport(80, 45, camera);
	sr = new ShapeRenderer();
	map = new Map("blankspace");
	px = map.getSpawn().x;
	py = map.getSpawn().y;
	batch = new SpriteBatch();
	cache = new SpriteCache();
	text = new BitmapFont();
	space = new Texture(new FileHandle("resource/img/stile.png"));
	wall = new Texture(new FileHandle("resource/img/wtile.png"));
	loadMap();
    }

    private void loadMap() {
	cache.beginCache();
	cache.add(space, 0, 0, 34.0f / 4, 17.0f / 4, 0, 0, 34, 17, false, false);
	cache.add(space, (34.0f - 1) / 8, (17.0f - 1) / 8, 34.0f / 4,
		17.0f / 4, 0, 0, 34, 17, false, false);
	cid = cache.endCache();
    }

    @Override
    public void render(float delta) {
	Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	if (Gdx.input.isKeyJustPressed(Keys.ESCAPE))
	    Gdx.app.exit();

	camera.update();

	cache.setProjectionMatrix(camera.combined);
	cache.begin();
	Gdx.gl.glEnable(GL20.GL_BLEND);
	Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
	cache.draw(cid);
	cache.end();
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
